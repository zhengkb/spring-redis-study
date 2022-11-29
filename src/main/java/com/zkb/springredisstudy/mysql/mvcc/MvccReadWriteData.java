package com.zkb.springredisstudy.mysql.mvcc;

import java.util.*;

public class MvccReadWriteData {

    private static Map<String, Table> rollPtrAndTableMap = new HashMap<>();

    private static Table nowTable;

    private static int now_row_id = 0;


    private static Set<Integer> activityTrxIds = new HashSet<>();

    private static int upLimitId = Integer.MAX_VALUE;

    //最大活跃事务id
    private static int lowLimitId;

    public static synchronized void updateTable(int trxId) {
        now_row_id++;
        if (nowTable == null) {
            nowTable = new Table(0, 0, trxId, null);
        } else {
            String rollPtr = nowTable.getRow_id() + "aaax";
            rollPtrAndTableMap.put(rollPtr, nowTable);
            nowTable = new Table(now_row_id, 0, trxId, "rollPtr");
        }
    }

    public static synchronized void addActivityTrx(int trxId) {
        activityTrxIds.add(trxId);
        if (upLimitId > trxId) {
            upLimitId = trxId;
        }
    }

    public static synchronized ReadView getReadView(int trxId) {
        return new ReadView(trxId, activityTrxIds, upLimitId, lowLimitId);
    }

    public static synchronized int getTrxId() {
        int id = lowLimitId;
        lowLimitId += 1;
        return id;
    }

    public static Table getTable(ReadView readView) {
        int nowTableTrx_id = nowTable.getTrx_id();
        //获取readView中的创建者事务id，如果等于当前表中最近更新的事务id那么代表创建ReadView和修改行数据的事务是同一个可以获取新值
        if (nowTableTrx_id == readView.getCreator_trx_id()) {
            return nowTable;
        } else {
            //不同那么先判断当前事务id是否小于视图中的最小活跃id，如果小于那么代表在快照创建前就已经结束更新并且提交了事务，可以拿到新值
            if (nowTableTrx_id < readView.getUp_limit_id()) {
                return nowTable;
            } else {
                //如果当前行中的更新事务id大于等于需要分配的下一个事务id，那么代表这个更新事务是在更新事务查询操作进行之后开启的事务，那么这个值时无法读取到的
                if (nowTableTrx_id >= readView.getLow_limit_id()) {
                    String roll_ptr = nowTable.getRoll_ptr();
                    return getRollTable(roll_ptr, nowTableTrx_id);
                } else {
                    //如果活跃事务中包含更新事务id，那么代表在执行查询操作时这个事务仍未提交，那么值无法读到
                    if (readView.getTrx_ids().contains(nowTableTrx_id)) {
                        String roll_ptr = nowTable.getRoll_ptr();
                        return getRollTable(roll_ptr, nowTableTrx_id);
                    } else {
                        //代表已经提交，那么可以拿到最小值
                        return nowTable;
                    }
                }
            }
        }
    }

    public static Table getRollTable(String roll_ptr, int trx_id) {
        if (roll_ptr == null) {
            return null;
        }
        Table table = rollPtrAndTableMap.get(roll_ptr);
        if (table == null) {
            return null;
        }
        if (table.getTrx_id() == trx_id) {
            return table;
        }
        return getRollTable(table.getRoll_ptr(), trx_id);
    }
}
