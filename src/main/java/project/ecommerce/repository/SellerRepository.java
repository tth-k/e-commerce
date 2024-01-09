package project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecommerce.domain.Seller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findBySellerId(String sellerId);
    Map<Long, Seller> clearSeller = new HashMap<>();

    public static void clearSeller() {
        clearSeller.clear();
    }
}
