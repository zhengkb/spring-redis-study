package com.zkb.springredisstudy.designmodel.strategymodel.exp1;

public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        return price * n;
    }
}
