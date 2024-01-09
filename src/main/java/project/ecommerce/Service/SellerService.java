package project.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.ecommerce.domain.Seller;
import project.ecommerce.dto.SellerDTO;
import project.ecommerce.repository.SellerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor // SellerRepository의 생성자를 쓰지 않기 위해서

public class SellerService {
    private final SellerRepository sellerRepository;

    // 회원가입 DB 저장
    public SellerDTO joinSeller(SellerDTO sellerDTO) {
        Seller seller = Seller.toSeller(sellerDTO);
        Seller saveOfSeller = sellerRepository.save(seller);
        return SellerDTO.ofSeller(saveOfSeller);
    }

    // 아이디 중복 체크
    public String sellerIdCheck(String sellerId) {
        Optional<Seller> bySellerId = sellerRepository.findBySellerId(sellerId);
        if (bySellerId.isPresent()){
            // 조회 결과가 있으면 사용할 수 없다.
            return null;
        } else {
            // 조회 결과가 없으면 사용할 수 있다.
            return "ok";
        }
    }
}