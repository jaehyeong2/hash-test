package jjafact.hash.equals.service;

import jjafact.hash.equals.dto.ShopDto;
import jjafact.hash.equals.entity.Shop;
import jjafact.hash.equals.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional(readOnly = true)
    public ShopDto findShop(Long id){
        Shop shop = shopRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });

        return new ShopDto(shop);
    }

    public String createShop(ShopDto dto){
        Shop shop = Shop.create(dto);
        shopRepository.save(shop);
        return "Y";
    }

    public String deleteShop(Long id){
        shopRepository.deleteById(id);
        return "Y";
    }
}
