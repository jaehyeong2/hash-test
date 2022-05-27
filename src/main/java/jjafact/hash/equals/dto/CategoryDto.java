package jjafact.hash.equals.dto;

import jjafact.hash.equals.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryDto {
    private String name;

    public CategoryDto(Category category) {
        this.name = name;
    }
}
