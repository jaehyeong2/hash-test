package jjafact.hash.equals.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Payment extends BaseTimeEntity{

    @Id @GeneratedValue
    private Long id;

    private String calculateCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private Method method;

    private LocalDate payDate;

    private int price;

    @Builder
    public Payment(String calculateCode, User user, Method method, LocalDate payDate, int price) {
        this.calculateCode = calculateCode;
        this.user = user;
        this.method = method;
        this.payDate = payDate;
        this.price = price;
    }

    public enum Method{
        MOBILE("휴대폰"),
        CREDIT_CARD("신용카드"),
        CASH("현금");

        private String text;

        Method(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
