package project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecommerce.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
