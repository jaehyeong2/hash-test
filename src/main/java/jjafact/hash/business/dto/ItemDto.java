package jjafact.hash.business.dto;

import jjafact.hash.business.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDto {
    private Long id;
    private String name;
    private int price;
    private Long categoryId;
    private Long shopId;

    public ItemDto(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.categoryId = item.getCategory().getId();
    }
}
