package project.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.ecommerce.dto.SellerDTO;
import project.ecommerce.dto.UserDTO;

@Controller
@RequiredArgsConstructor
public class SellerController {


    @GetMapping("/seller/join") // 판매사 회원가입폼
    public String createSellerForm(){
        return "sellerJoin";
    }

    @PostMapping("/seller/join")
    public String createSeller(SellerDTO sellerDTO){

        return "home"; // 회원가입 후 홈페이지로 돌아감
    }
}
