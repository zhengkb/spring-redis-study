package com.zkb.springredisstudy.designmodel.decoratormodel.exp1;

public class AutoDriverDecorator extends PengDecorator {

    public AutoDriverDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加自动驾驶");
    }
}
