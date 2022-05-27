package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Item;
import jjafact.hash.equals.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
