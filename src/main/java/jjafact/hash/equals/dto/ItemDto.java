package jjafact.hash.equals.dto;

import jjafact.hash.equals.entity.Item;
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
