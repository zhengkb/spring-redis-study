package com.zkb.springredisstudy.designmodel.decoratormodel.exp1;

public class PengSpeakerDecorator extends PengDecorator {
    public PengSpeakerDecorator(PengCar pengCar) {
        super(pengCar);
    }

    @Override
    void run() {
        super.run();
        System.out.println("增加音响");
    }
}
