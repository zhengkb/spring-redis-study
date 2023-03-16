package com.zkb.springredisstudy.algorithm.singleton;

public class SingleCreate {

    private static volatile SingleCreate singleCreate;


    private SingleCreate() {

    }

    public static SingleCreate getInstance() {
        if (singleCreate == null) {
            synchronized (singleCreate) {
                if (singleCreate == null) {
                    singleCreate = new SingleCreate();
                }
            }
        }
        return singleCreate;
    }

    public static void main(String[] args) {
    }
}
