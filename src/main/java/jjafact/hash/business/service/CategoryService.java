package jjafact.hash.business.service;

import jjafact.hash.business.dto.CategoryDto;
import jjafact.hash.business.entity.item.Category;
import jjafact.hash.business.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoryDto findCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });

        return new CategoryDto(category);
    }

    public String createCategory(CategoryDto dto){
        Category category = Category.create(dto);
        categoryRepository.save(category);
        return "Y";
    }

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Y";
    }
}
