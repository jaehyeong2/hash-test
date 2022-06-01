package jjafact.hash.business.repository.item;

import jjafact.hash.business.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
