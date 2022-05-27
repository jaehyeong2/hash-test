package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Category;
import jjafact.hash.equals.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
