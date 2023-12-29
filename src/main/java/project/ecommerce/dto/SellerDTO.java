package project.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private String seller_id;
    private String seller_password;
    private String brand_name;
    private String seller_contact;
}
