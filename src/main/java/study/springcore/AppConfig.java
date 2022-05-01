package study.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springcore.discount.DiscountPolicy;
import study.springcore.discount.RateDiscountPolicy;
import study.springcore.member.MemberRepository;
import study.springcore.member.MemberService;
import study.springcore.member.MemberServiceImpl;
import study.springcore.member.MemoryMemberRepository;
import study.springcore.order.OrderService;
import study.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemeberRepository()
    // @Bean orderServjce -> new MemoryMemeberRepository()


    // 예측
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    // 실제
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
