package project.ecommerce.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import project.ecommerce.Service.SellerService;
import project.ecommerce.domain.Seller;
import project.ecommerce.dto.SellerDTO;
import project.ecommerce.repository.SellerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class SellerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @MockBean
    private SellerService sellerService;

    @MockBean
    private SellerRepository sellerRepository;

    @AfterEach
    public void afterEach() {
        SellerRepository.clearSeller();
    }


    @Test
    void joinSeller() {
        // given
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setSellerId("테스트1");
        sellerDTO.setSellerPassword("aa");
        sellerDTO.setBrandName("aa");
        sellerDTO.setSellerContact("01234567890");

        // when
        Optional<Seller> bySellerId = sellerRepository.findBySellerId(sellerDTO.getSellerId());

        // then
        if (bySellerId.isPresent()){
            System.out.println(sellerDTO.getSellerId() + "는 이미 있습니다.");
        } else {
            System.out.println("새로운 유저: " + sellerDTO);
        }
    }

    @Test
    void sellerIdCheck() {
        // given
        SellerDTO seller1 = new SellerDTO();
        seller1.setSellerId("상점1");

        SellerDTO seller2 = new SellerDTO();
        seller2.setSellerId("상점1");

        // when
        Optional<Seller> bySellerId1 = sellerRepository.findBySellerId(seller1.getSellerId());
        Optional<Seller> bySellerId2 = sellerRepository.findBySellerId(seller2.getSellerId());

        // then
        if (bySellerId1 == bySellerId2){
            System.out.println("이미 사용되고 있는 ID입니다.");
        }
    }
}