package jjafact.hash.equals.entity;

import jjafact.hash.equals.dto.CreateCategoryReq;
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
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public static Category create(CreateCategoryReq req){
        return Category.builder()
                .name(req.getName())
                .build();
    }
}
