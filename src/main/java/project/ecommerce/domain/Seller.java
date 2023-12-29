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
    private String seller_id;

    @Column(nullable = false)
    private String seller_password;

    @Column
    private String brand_name;

    @Column
    private String seller_contact;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public static Seller toSeller(SellerDTO sellerDTO){
        Seller seller = new Seller();

        seller.setSeller_id(sellerDTO.getSeller_id());
        seller.setSeller_password(sellerDTO.getSeller_password());
        seller.setBrand_name(sellerDTO.getBrand_name());
        seller.setSeller_contact(sellerDTO.getSeller_contact());

        return seller;
    }
}
