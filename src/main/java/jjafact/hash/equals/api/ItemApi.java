package jjafact.hash.equals.api;

import jjafact.hash.equals.dto.CreateShopReq;
import jjafact.hash.equals.dto.ItemDto;
import jjafact.hash.equals.dto.ShopDto;
import jjafact.hash.equals.service.ItemService;
import jjafact.hash.equals.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ItemApi {
    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> findShop(@PathVariable Long id){
        return new ResponseEntity(itemService.findItem(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createShop(@RequestBody ItemDto dto){
        return new ResponseEntity(itemService.createItem(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id){
        return new ResponseEntity(itemService.deleteItem(id), HttpStatus.OK);
    }
}
