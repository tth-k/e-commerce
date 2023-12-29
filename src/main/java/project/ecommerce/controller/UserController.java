package project.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.ecommerce.dto.UserDTO;

@Controller
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/user/join") // 일반유저 회원가입폼
    public String createUserForm(){
        return "userJoin";
    }

    @PostMapping("/user/join")
    public String createUser(UserDTO userDTO){

        return "home"; // 회원가입 후 홈페이지로 돌아감
    }
}
