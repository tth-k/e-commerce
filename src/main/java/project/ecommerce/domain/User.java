package project.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String userName;

    @Column
    private String userContact;

    @Column
    private String userAddress;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

}
