package com.zkb.springredisstudy.dynamic.jdk.exp2;

public class Test {

    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter iPrinter = (IPrinter) proxyHandler.newInstance(new Printer());
        iPrinter.print();
    }
}
