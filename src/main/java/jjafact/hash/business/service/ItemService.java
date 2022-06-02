package jjafact.hash.business.service;

import jjafact.hash.business.dto.ItemDto;
import jjafact.hash.business.entity.Shop;
import jjafact.hash.business.entity.item.Category;
import jjafact.hash.business.entity.item.Item;
import jjafact.hash.business.entity.item.ItemImage;
import jjafact.hash.business.repository.CategoryRepository;
import jjafact.hash.business.repository.ShopRepository;
import jjafact.hash.business.repository.item.ItemImageRepository;
import jjafact.hash.business.repository.item.ItemRepository;
import jjafact.hash.business.repository.item.ItemRepositorySupport;
import jjafact.hash.global.error.exception.BusinessException;
import jjafact.hash.global.error.model.ErrorCode;
import jjafact.hash.global.utils.ResourceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemImageRepository itemImageRepository;
    private final ItemRepositorySupport itemRepositorySupport;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    @Transactional(readOnly = true)
    public ItemDto findItem(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });

        return new ItemDto(item);
    }
    @Transactional(readOnly = true)
    public Page<ItemDto> findItemPaging(Pageable pageable){
        return itemRepositorySupport.findItems(pageable);
    }

    public String createItem(ItemDto dto, List<MultipartFile> images){
        Long categoryId = dto.getCategoryId();
        Long shopId = dto.getShopId();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        Shop shop = shopRepository.findById(shopId).orElse(null);

        Item item = Item.create(dto,category,shop);
        itemRepository.save(item);

        List<ItemImage> imageList = new ArrayList<>();
        images.forEach(i -> {
            String folderPath = "/images/items/" +item.getId() + "/";
            String filePath = folderPath + i.getOriginalFilename();

            ItemImage itemImage = new ItemImage("");
            try {
                itemImage = ItemImage.create(item, ResourceUtil.saveFile(i,filePath,folderPath));
            } catch (IOException ioException) {
//                throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
                log.info("파일 등록 에러");
            }
            imageList.add(itemImage);
            item.addImage(itemImage);
        });
        itemImageRepository.saveAll(imageList);
        return "Y";
    }

    public String deleteItem(Long id){
        itemRepository.deleteById(id);
        return "Y";
    }
}
