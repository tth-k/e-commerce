package project.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import project.ecommerce.dto.SellerDTO;
import java.time.LocalDateTime;

@Entity
@Data // getter와 setter
@Builder // DTO -> Entity화
@AllArgsConstructor // 모든 컬럼 생성자 생성
@NoArgsConstructor // 기본 생성자
@Table(name = "seller")

public class Seller {
    @Id // Pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    private Long id;

    @Column(nullable = false, unique = true)
    private String sellerId;

    @Column(nullable = false)
    private String sellerPassword;

    @Column
    private String brandName;

    @Column
    private String sellerContact;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public static Seller toSeller(SellerDTO sellerDTO){
        Seller seller = new Seller();

        seller.setSellerId(sellerDTO.getSellerId());
        seller.setSellerPassword(sellerDTO.getSellerPassword());
        seller.setBrandName(sellerDTO.getBrandName());
        seller.setSellerContact(sellerDTO.getSellerContact());

        return seller;
    }
}
