package com.zkb.springredisstudy.designmodel.strategymodel.exp1;

public class Exp1Test {
    public static void main(String[] args) {
        PrimaryMemberStrategy primaryMemberStrategy = new PrimaryMemberStrategy();
        MiddleMemberStrategy middleMemberStrategy = new MiddleMemberStrategy();
        HighMemberStrategy highMemberStrategy = new HighMemberStrategy();
        MemberContext memberContext = new MemberContext(primaryMemberStrategy);
        MemberContext memberContext1 = new MemberContext(middleMemberStrategy);
        MemberContext memberContext2 = new MemberContext(highMemberStrategy);
        System.out.println("普通会员：" + memberContext.quotePrice(300, 1));
        System.out.println("中级会员：" + memberContext1.quotePrice(300, 1));
        System.out.println("高级会员：" + memberContext2.quotePrice(300, 1));
    }
}
