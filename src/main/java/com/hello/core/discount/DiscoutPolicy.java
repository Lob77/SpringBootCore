package com.hello.core.discount;

import com.hello.core.member.Member;

public interface DiscoutPolicy {
   int discount(Member member,int price);
}
