package project.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_contact;
    private String user_address;
}
