package study.springcore.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.springcore.discount.FixDiscountPolicy;
import study.springcore.member.Grade;
import study.springcore.member.Member;
import study.springcore.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
