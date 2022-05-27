package jjafact.hash.equals.entity;

import jjafact.hash.equals.dto.ItemDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item extends BaseTimeEntity{

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private String name;
    private int price;

    @Builder
    public Item(Category category, Shop shop, String name, int price) {
        this.category = category;
        this.shop = shop;
        this.name = name;
        this.price = price;
    }

    public static Item create(ItemDto dto){
        return Item.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
