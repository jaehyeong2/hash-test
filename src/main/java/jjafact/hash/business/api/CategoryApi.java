package jjafact.hash.business.api;

import jjafact.hash.business.dto.CategoryDto;
import jjafact.hash.business.dto.ShopDto;
import jjafact.hash.business.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryApi {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> findShop(@PathVariable Long id){
        return new ResponseEntity(categoryService.findCategory(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createShop(@RequestBody CategoryDto dto){
        return new ResponseEntity(categoryService.createCategory(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id){
        return new ResponseEntity(categoryService.deleteCategory(id), HttpStatus.OK);
    }
}
