package com.hello.core;

import com.hello.core.discount.DiscoutPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discoutPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscoutPolicy discoutPolicy (){
        return new FixDiscountPolicy();
    }

}
