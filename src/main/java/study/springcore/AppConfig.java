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

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
