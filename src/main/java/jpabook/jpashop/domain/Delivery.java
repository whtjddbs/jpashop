package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    //EnumType.ORDINAL을 사용할 경우 순차적으로 번호를 부여하기 때문에 나중에 상태가 추가되면 문제가 생긴다.
    //반드시 EnumType.STRING를 사용하자.
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //배송상태 [READY, COMP]
}
