package jjafact.hash.business.dto;

import jjafact.hash.business.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDto {
    private String name;
    private int price;

    public ItemDto(Item item) {
        this.name = name;
        this.price = price;
    }
}
