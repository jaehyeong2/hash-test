package jjafact.hash.equals.entity;

import jjafact.hash.equals.dto.ShopDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Shop extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phone;
    private String location;

    @Builder
    public Shop(String name, String phone, String location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    public static Shop create(ShopDto dto){
        return Shop.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .location(dto.getLocation())
                .build();
    }
}
