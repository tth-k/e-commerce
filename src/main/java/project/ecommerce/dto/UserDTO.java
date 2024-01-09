package project.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ecommerce.domain.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userId;
    private String userPassword;
    private String userName;
    private String userContact;
    private String userAddress;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static UserDTO ofUser(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserContact(user.getUserContact());
        userDTO.setUserAddress(user.getUserAddress());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setModifiedAt(user.getModifiedAt());

        return userDTO;
    }

}
