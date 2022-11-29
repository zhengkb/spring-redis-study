package com.zkb.springredisstudy.mysql.mvcc;

public class TestMVCC {
    public static void main(String[] args) {
        //事务1开始
        int trxId = MvccReadWriteData.getTrxId();
        MvccReadWriteData.addActivityTrx(trxId);
        //事务1执行一次更新操作
        MvccReadWriteData.updateTable(trxId);
        //事务2开始
        int trxId1 = MvccReadWriteData.getTrxId();
        MvccReadWriteData.addActivityTrx(trxId1);
        //事务2执行查询
        ReadView readView = MvccReadWriteData.getReadView(trxId1);
        Table table = MvccReadWriteData.getTable(readView);
        System.out.printf(table.getRow_id() + "");
    }
}
