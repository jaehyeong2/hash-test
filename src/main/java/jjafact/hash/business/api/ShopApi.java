package jjafact.hash.business.api;

import jjafact.hash.business.dto.ShopDto;
import jjafact.hash.business.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/shops")
@RequiredArgsConstructor
@RestController
public class ShopApi {
    private final ShopService shopService;

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> findShop(@PathVariable Long id){
        return new ResponseEntity(shopService.findShop(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createShop(@RequestBody ShopDto dto){
        return new ResponseEntity(shopService.createShop(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id){
        return new ResponseEntity(shopService.deleteShop(id), HttpStatus.OK);
    }
}
