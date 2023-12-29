package project.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import project.ecommerce.domain.Seller;
import project.ecommerce.dto.SellerDTO;
import project.ecommerce.repository.SellerRepository;

@org.springframework.stereotype.Service
@RequiredArgsConstructor // SellerRepository의 생성자를 쓰지 않기 위해서

public class SellerService {
    private final SellerRepository sellerRepository;

    public void save(SellerDTO sellerDTO) {
        Seller seller = Seller.toSeller(sellerDTO);
        sellerRepository.save(seller);
    }
}

