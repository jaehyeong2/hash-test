package jjafact.hash.business.entity;

import jjafact.hash.business.dto.CategoryDto;
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
public class Category extends BaseTimeEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public static Category create(CategoryDto dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}
