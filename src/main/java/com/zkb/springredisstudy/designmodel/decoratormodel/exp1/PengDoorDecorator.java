package com.zkb.springredisstudy.designmodel.decoratormodel.exp1;

public class PengDoorDecorator extends PengDecorator {

    public PengDoorDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加自动门");
    }
}
