package jjafact.hash.business.dto;

import jjafact.hash.business.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDto {
    private int price;
    private Long shopId;

    public OrderDto(Order order) {
        this.price = order.getPrice();
        this.shopId = order.getShop().getId();
    }
}
