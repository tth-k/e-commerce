package project.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.ecommerce.domain.User;
import project.ecommerce.dto.UserDTO;
import project.ecommerce.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor // UserRepository의 생성자를 쓰지 않기 위해서

public class UserService {
    private final UserRepository userRepository;

    // 회원가입 DB 저장
    public UserDTO joinUser(UserDTO userDTO) {
        User user = new User();
        User saveOfUser = userRepository.save(user);
        return UserDTO.ofUser(saveOfUser);
    }

    // 아이디 중복 체크
    public String userIdCheck(String userId) {
        Optional<User> byUserId = userRepository.findByUserId(userId);
        if (byUserId.isPresent()){
            // 조회 결과가 있으면 사용할 수 없다.
            return null;
        } else {
            // 조회 결과가 없으면 사용할 수 있다.
            return "ok";
        }
    }
}

