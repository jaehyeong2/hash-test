package jjafact.hash.business.service;

import jjafact.hash.business.dto.OrderDto;
import jjafact.hash.business.entity.Order;
import jjafact.hash.business.entity.Shop;
import jjafact.hash.business.entity.User;
import jjafact.hash.business.repository.OrderRepository;
import jjafact.hash.business.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShopRepository shopRepository;

    public String createOrder(OrderDto dto, User user){
        Shop shop = shopRepository.findById(dto.getShopId()).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });
        Order order = Order.create(dto, user,shop);
        orderRepository.save(order);
        return "Y";
    }

    public String cancelOrder(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("조회실패");
        });
        order.cancelOrder();
        return "Y";
    }
}
