package project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecommerce.domain.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
