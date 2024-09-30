package com.hello.core.beanfind;

import com.hello.core.discount.DiscoutPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

class ApplicationContextExtendsFindTest {

    @Configuration
    static class TestConfig{
        @Bean
        public DiscoutPolicy rateDiscoutPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscoutPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscoutPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘 이상있으면 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeBeanName(){
        DiscoutPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscoutPolicy.class);
        Assertions.assertInstanceOf(RateDiscountPolicy.class,rateDiscountPolicy);
    }

    @Test
    @DisplayName("특정 하위타입으로 조회")
    void findAllBeanBySubType(){
        RateDiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
        Assertions.assertInstanceOf(RateDiscountPolicy.class,rateDiscountPolicy);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscoutPolicy> beanOfType = ac.getBeansOfType(DiscoutPolicy.class);

        Assertions.assertEquals(beanOfType.size(),2);
        for(String key : beanOfType.keySet()){
            System.out.println("key =" + key + " beanOfType =" + beanOfType.get(key));
        }
     }

}
