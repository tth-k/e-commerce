package project.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.ecommerce.Service.SellerService;
import project.ecommerce.dto.SellerDTO;

@Controller
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    // 회원가입폼
    @GetMapping("/seller/join")
    public String createSellerForm() {
        return "sellerJoin";
    }

    // 회원가입
    @PostMapping("/seller/join")
    public String joinSeller(SellerDTO sellerDTO) {
        System.out.println("SellerController.save");
        System.out.println("sellerDTO = " + sellerDTO);
        sellerService.joinSeller(sellerDTO);
        return "home"; // 회원가입 후 홈페이지로 돌아감
    }

    // 아이디 중복 체크
    @PostMapping("/seller/sellerId-check")
    public @ResponseBody String sellerIdCheck(@RequestParam("sellerId") String sellerId) {
        String checkResult = sellerService.sellerIdCheck(sellerId);
        return checkResult;
    }
}
