package jjafact.hash.equals.service;

import jjafact.hash.equals.dto.CreateItemReq;
import jjafact.hash.equals.dto.CreateShopReq;
import jjafact.hash.equals.dto.ItemDto;
import jjafact.hash.equals.dto.ShopDto;
import jjafact.hash.equals.entity.Item;
import jjafact.hash.equals.entity.Shop;
import jjafact.hash.equals.repository.ItemRepository;
import jjafact.hash.equals.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public ItemDto findItem(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });

        return new ItemDto(item);
    }

    public String createItem(ItemDto dto){
        Item item = Item.create(dto);
        itemRepository.save(item);
        return "Y";
    }

    public String deleteItem(Long id){
        itemRepository.deleteById(id);
        return "Y";
    }
}
