package project.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ecommerce.domain.Seller;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private String sellerId;
    private String sellerPassword;
    private String brandName;
    private String sellerContact;

    public static SellerDTO ofSeller(Seller seller){

        SellerDTO sellerDTO = new SellerDTO();

        sellerDTO.setSellerId(seller.getSellerId());
        sellerDTO.setSellerPassword(seller.getSellerPassword());
        sellerDTO.setBrandName(seller.getBrandName());
        sellerDTO.setSellerContact(seller.getSellerContact());

        return sellerDTO;
    }

}
