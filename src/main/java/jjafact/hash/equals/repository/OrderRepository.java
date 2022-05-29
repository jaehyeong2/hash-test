package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
