package jjafact.hash.business.entity.item;

import jjafact.hash.business.dto.ItemDto;
import jjafact.hash.business.entity.BaseTimeEntity;
import jjafact.hash.business.entity.Category;
import jjafact.hash.business.entity.Shop;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private String name;
    private int price;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<ItemImage> images = new ArrayList<>();

    @Builder
    public Item(Long id,Category category, Shop shop, String name, int price) {
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

    public void addImage(ItemImage image) {
        this.images.add(image);
    }
}
