package jjafact.hash;

import jjafact.hash.business.entity.Payment;
import jjafact.hash.business.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Equal {

    private static List<Payment> payments;

    @BeforeAll
    static void setUp(){
        User lee = new User("lee", "01012341234","dasdasdasd2");
        User kim = new User("lee", "01012341234", "dasdas  211 ");

        payments = Arrays.asList(Payment.builder()
                        .user(lee)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C001")
                        .price(20000)
                        .method(Payment.Method.MOBILE)
                        .build(),
                Payment.builder()
                        .user(lee)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C001")
                        .price(10000)
                        .method(Payment.Method.CREDIT_CARD)
                        .build(),
                Payment.builder()
                        .user(kim)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C001")
                        .price(5000)
                        .method(Payment.Method.CASH)
                        .build(),
                Payment.builder()
                        .user(lee)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C002")
                        .price(20000)
                        .method(Payment.Method.MOBILE)
                        .build(),
                Payment.builder()
                        .user(kim)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C001")
                        .price(15000)
                        .method(Payment.Method.CREDIT_CARD)
                        .build(),
                Payment.builder()
                        .user(kim)
                        .payDate(LocalDate.of(2022, 5, 25))
                        .calculateCode("C002")
                        .price(30000)
                        .method(Payment.Method.MOBILE)
                        .build()
        );
    }

    @Test
    void equalTest(){

    }

}


