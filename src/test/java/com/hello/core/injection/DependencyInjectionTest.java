package com.hello.core.injection;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
//    }
}
