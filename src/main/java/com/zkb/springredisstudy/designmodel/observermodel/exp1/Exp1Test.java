package com.zkb.springredisstudy.designmodel.observermodel.exp1;

public class Exp1Test {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        concreteSubject.addObserver(observer1);
        concreteSubject.addObserver(observer2);
        concreteSubject.doSomething();
    }
}
