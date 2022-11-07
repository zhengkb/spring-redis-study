package com.zkb.springredisstudy.designmodel.observermodel.exp1;

public class ConcreteSubject extends Subject {

    public void doSomething() {
        System.out.println("具体目标发生改变");
        System.out.println("-----------------------");
        super.notifyObserver();
    }
}
