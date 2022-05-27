package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Item;
import jjafact.hash.equals.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
