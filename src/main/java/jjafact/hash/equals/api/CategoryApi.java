package jjafact.hash.equals.api;

import jjafact.hash.equals.dto.CreateCategoryReq;
import jjafact.hash.equals.dto.CreateShopReq;
import jjafact.hash.equals.dto.ShopDto;
import jjafact.hash.equals.service.CategoryService;
import jjafact.hash.equals.service.ShopService;
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
    public ResponseEntity<String> createShop(@RequestBody CreateCategoryReq req){
        return new ResponseEntity(categoryService.createCategory(req), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id){
        return new ResponseEntity(categoryService.deleteCategory(id), HttpStatus.OK);
    }
}
