package com.zkb.springredisstudy.designmodel.decoratormodel.exp1;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PengDecorator extends PengCar {

    private PengCar pengCar;

    public PengDecorator(PengCar pengCar) {
        this.pengCar = pengCar;
    }

    @Override
    void run() {
        pengCar.run();
    }
}
