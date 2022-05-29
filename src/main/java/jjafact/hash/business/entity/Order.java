package jjafact.hash.business.entity;

import jjafact.hash.business.dto.OrderDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Order extends BaseTimeEntity{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private int price;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public void cancelOrder() {
        this.orderState = OrderState.CANCELED;
    }

    public enum OrderState{
        ORDERED,CANCELED
    }

    @Builder
    public Order(User user, Shop shop, int price,OrderState orderState) {
        this.user = user;
        this.shop = shop;
        this.price = price;
        this.orderState = orderState;
    }

    public static Order create(OrderDto dto,User user,Shop shop){
        return Order.builder()
                .shop(shop)
                .user(user)
                .price(dto.getPrice())
                .orderState(OrderState.ORDERED)
                .build();
    }
}
