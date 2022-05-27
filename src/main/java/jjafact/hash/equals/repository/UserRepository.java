package jjafact.hash.equals.repository;

import jjafact.hash.equals.entity.Item;
import jjafact.hash.equals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
