package com.zkb.springredisstudy.designmodel.strategymodel.exp1;

public class HighMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        return price * n * 0.8;
    }
}
