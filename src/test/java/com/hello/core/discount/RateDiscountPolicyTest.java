package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        Member member = new Member(1L, "memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member,10000);

        Assertions.assertEquals(discount,1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        Member member = new Member(2L, "memberB", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member,10000);

        Assertions.assertEquals(discount,0);
    }

}
