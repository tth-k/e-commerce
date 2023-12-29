package project.ecommerce.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.ecommerce.domain.User;
import project.ecommerce.dto.UserDTO;
import project.ecommerce.repository.UserRepository;

@Service
@RequiredArgsConstructor // UserRepository의 생성자를 쓰지 않기 위해서

public class UserService {
    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        User user = User.toUser(userDTO);
        userRepository.save(user);
    }
}

