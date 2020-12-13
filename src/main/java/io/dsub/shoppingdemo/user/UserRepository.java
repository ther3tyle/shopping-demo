package io.dsub.shoppingdemo.user;

import io.dsub.shoppingdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Declarative Interface
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    User findByEmail(String email);
}
