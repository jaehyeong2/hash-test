package jjafact.hash.business.repository;

import jjafact.hash.business.entity.item.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
