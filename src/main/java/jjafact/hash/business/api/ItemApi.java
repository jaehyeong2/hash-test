package jjafact.hash.business.api;

import jjafact.hash.business.dto.ItemDto;
import jjafact.hash.business.dto.ShopDto;
import jjafact.hash.business.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ItemApi {
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<Page<ItemDto>> findItems(Pageable pageable){
        return new ResponseEntity(itemService.findItemPaging(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItem(@PathVariable Long id){
        return new ResponseEntity(itemService.findItem(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createItem(@RequestPart ItemDto dto,
                                             @RequestPart(required = false) List<MultipartFile> images){
        return new ResponseEntity(itemService.createItem(dto,images), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        return new ResponseEntity(itemService.deleteItem(id), HttpStatus.OK);
    }
}
