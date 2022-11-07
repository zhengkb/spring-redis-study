package com.zkb.springredisstudy.designmodel.strategymodel.exp1;

public class MemberContext {

    private MemberStrategy memberStrategy;

    public MemberContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double quotePrice(double price, int n) {
        return memberStrategy.calcPrice(price, n);
    }
}
