package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
    private final DiscountPolicy discoutPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discoutPolicy){
         this.memberRepository = memberRepository;
         this.discoutPolicy = discoutPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discoutPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
