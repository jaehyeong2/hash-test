package jjafact.hash.equals.service;

import jjafact.hash.equals.dto.CategoryDto;
import jjafact.hash.equals.dto.CreateCategoryReq;
import jjafact.hash.equals.dto.CreateShopReq;
import jjafact.hash.equals.dto.ShopDto;
import jjafact.hash.equals.entity.Category;
import jjafact.hash.equals.entity.Shop;
import jjafact.hash.equals.repository.CategoryRepository;
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

    public String createCategory(CreateCategoryReq dto){
        Category category = Category.create(dto);
        categoryRepository.save(category);
        return "Y";
    }

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Y";
    }
}
