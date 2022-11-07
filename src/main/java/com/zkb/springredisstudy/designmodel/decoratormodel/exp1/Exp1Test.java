package com.zkb.springredisstudy.designmodel.decoratormodel.exp1;

public class Exp1Test {

    public static void main(String[] args) {
        PengFiveCar pengFiveCar = new PengFiveCar();
        AutoDriverDecorator autoDriverDecorator = new AutoDriverDecorator(pengFiveCar);
        PengDoorDecorator pengDoorDecorator = new PengDoorDecorator(autoDriverDecorator);
        PengSpeakerDecorator pengSpeakerDecorator = new PengSpeakerDecorator(pengDoorDecorator);
        pengSpeakerDecorator.run();
    }
}
