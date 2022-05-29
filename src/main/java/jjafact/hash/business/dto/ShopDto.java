package jjafact.hash.business.dto;

import jjafact.hash.business.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShopDto {
    private String name;
    private String location;
    private String phone;

    public ShopDto(Shop shop) {
        this.name = name;
        this.location = location;
        this.phone = phone;
    }
}
