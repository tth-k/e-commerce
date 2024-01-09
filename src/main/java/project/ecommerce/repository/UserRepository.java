package project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecommerce.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    Map<Long, User> clearUser = new HashMap<>();

    public static void clearUser(){
         clearUser.clear();
    }
}
