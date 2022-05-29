package jjafact.hash.business.repository;

import jjafact.hash.business.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
