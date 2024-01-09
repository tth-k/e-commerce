package project.ecommerce.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import project.ecommerce.Service.UserService;
import project.ecommerce.domain.User;
import project.ecommerce.dto.UserDTO;
import project.ecommerce.repository.UserRepository;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @AfterEach
    public void afterEach(){
        UserRepository.clearUser();
    }

    @Test
    void joinUser() {
        // given
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("테스트1");
        userDTO.setUserPassword("aa");
        userDTO.setUserName("aa");
        userDTO.setUserContact("01234567890");
        userDTO.setUserAddress("서울시");

        // when
        Optional<User> byUserId = userRepository.findByUserId(userDTO.getUserId());

        // then
        if (byUserId.isPresent()) {
            // 사용자가 이미 존재하는 경우에 대한 처리
            System.out.println(userDTO.getUserId() + "는 이미 있습니다.");
        } else {
            // 사용자가 존재하지 않는 경우에 대한 처리
            System.out.println("새로운 유저: " + userDTO);
        }
    }

    @Test
    void userIdCheck () {
        // given
        UserDTO user1 = new UserDTO();
        user1.setUserId("테스트1"); // 전체 목록과 비교

        UserDTO user2 = new UserDTO();
        user2.setUserId("테스트1");

        // when
        Optional<User> byUserId1 = userRepository.findByUserId(user1.getUserId());
        Optional<User> byUserId2 = userRepository.findByUserId(user2.getUserId());

        // then
        if (byUserId1 == byUserId2){
            System.out.println("이미 사용되고 있는 ID입니다.");
        }
    }
}