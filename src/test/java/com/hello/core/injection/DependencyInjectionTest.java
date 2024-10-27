package com.hello.core.injection;

import com.hello.core.annotation.MainDiscountPolicy;
import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DependencyInjectionTest {

//    NoUniqueBeanDefinitionException
//    @Autowired
//    private DiscountPolicy discountPolicy;

//    빈 이름으로 구분
//    @Autowired
//    private DiscountPolicy rateDiscountPolicy;

//    Qualifier 사용
//    @Autowired
//    @Qualifier("mainDiscountPolicy")
//    private DiscountPolicy discountPolicy;

//  Primary 사용
//    @Autowired
//    private DiscountPolicy discountPolicy;
//    @Test
//    void beanInjectionByPrimary(){
//        Assertions.assertInstanceOf(RateDiscountPolicy.class,discountPolicy);
//        Assertions.assertNotSame(FixDiscountPolicy.class,discountPolicy);

//   annotation 직접 정의
//    @Test
//    void Test(@Autowired DiscountPolicy discountPolicy){
//        System.out.println(discountPolicy);
//       Assertions.assertInstanceOf(RateDiscountPolicy.class,discountPolicy);
//    }
}
