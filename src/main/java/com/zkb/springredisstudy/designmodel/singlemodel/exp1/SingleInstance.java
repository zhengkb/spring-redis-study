package com.zkb.springredisstudy.designmodel.singlemodel.exp1;

/**
 * 单例模式+双重检查
 */
public class SingleInstance {

    private volatile static SingleInstance singleInstance;

    private SingleInstance() {

    }

    /**
     * @return
     */
    public static SingleInstance singleInstance() {
        if (singleInstance == null) {
            //加锁
            synchronized (SingleInstance.class) {
                //A、B线程同时创建单例对象由于第一层没有加锁，此时可能A线程已经完成创建但是B判断完成之后让渡CPU由A执行
                //那么此时单例已经创建所以需要内部在判断一次
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}
