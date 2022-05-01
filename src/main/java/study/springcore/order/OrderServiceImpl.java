package study.springcore.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.springcore.discount.DiscountPolicy;
import study.springcore.discount.annotation.MainDiscountPolicy;
import study.springcore.member.Member;
import study.springcore.member.MemberRepository;

@Component
//@RequiredArgsConstructor contructor를 자동으로 만들어서 생성자 주입을 해줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    생성자 없이 필드 주입. 외부에서 변경이 불가능하기 때문에 추천하지 않는 방법.(테스트가 힘들다)
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;


    @Autowired // 생성자가 1개일 경우는 Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
