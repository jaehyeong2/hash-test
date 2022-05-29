package jjafact.hash.business.repository;

import jjafact.hash.business.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
