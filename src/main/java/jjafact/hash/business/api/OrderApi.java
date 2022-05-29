package jjafact.hash.business.api;

import jjafact.hash.business.dto.OrderDto;
import jjafact.hash.business.entity.User;
import jjafact.hash.business.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RequiredArgsConstructor
@RestController
public class OrderApi {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<String> createOrder(@RequestBody OrderDto dto, @AuthenticationPrincipal User user){
        return new ResponseEntity(orderService.createOrder(dto,user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id){
        return new ResponseEntity(orderService.cancelOrder(id), HttpStatus.OK);
    }
}
