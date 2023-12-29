package project.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import project.ecommerce.dto.UserDTO;

import java.time.LocalDateTime;

@Entity
@Data // getter와 setter
@Builder // DTO -> Entity화
@AllArgsConstructor // 모든 컬럼 생성자 생성
@NoArgsConstructor // 기본 생성자
@Table(name = "user")

public class User {
    @Id // Pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    private Long id;

    @Column(nullable = false, unique = true)
    private String user_id;

    @Column(nullable = false)
    private String user_password;

    @Column
    private String user_name;

    @Column
    private String user_contact;

    @Column
    private String user_address;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public static User toUser(UserDTO userDTO){
        User user = new User();

        user.setUser_id(userDTO.getUser_id());
        user.setUser_password(userDTO.getUser_password());
        user.setUser_name(userDTO.getUser_name());
        user.setUser_contact(userDTO.getUser_contact());
        user.setUser_address(userDTO.getUser_address());

        return user;
    }
}
