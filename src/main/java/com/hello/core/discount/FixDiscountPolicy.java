package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class FixDiscountPolicy implements DiscoutPolicy {

    private int dicountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return dicountFixAmount;
        } else {
            return 0;
        }
    }
}