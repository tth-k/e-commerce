package project.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.ecommerce.Service.UserService;
import project.ecommerce.dto.UserDTO;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입폼
    @GetMapping("/user/join")
    public String createUserForm(){
        return "userJoin";
    }

    // 회원가입
    @PostMapping("/user/join")
    public String joinUser(UserDTO userDTO){
        userService.joinUser(userDTO);
        return "home"; // 회원가입 후 홈페이지로 돌아감
    }

    @PostMapping("/user/userId-check") // 아이디 중복 체크
    public @ResponseBody String userIdCheck(@RequestParam("userId") String userId){
        String checkResult = userService.userIdCheck(userId);
        return checkResult;
    }
}
