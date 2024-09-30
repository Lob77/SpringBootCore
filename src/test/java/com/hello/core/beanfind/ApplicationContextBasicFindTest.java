package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertInstanceOf(MemberServiceImpl.class,memberService);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxxx", MemberService.class));
    }
}
