package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Item;
import jjafact.hash.equals.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {
}
