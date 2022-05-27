package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
