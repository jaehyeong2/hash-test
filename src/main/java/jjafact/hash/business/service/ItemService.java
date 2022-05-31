package jjafact.hash.business.service;

import jjafact.hash.business.dto.ItemDto;
import jjafact.hash.business.entity.item.Item;
import jjafact.hash.business.repository.ItemRepository;
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
