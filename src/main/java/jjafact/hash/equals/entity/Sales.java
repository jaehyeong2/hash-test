package jjafact.hash.equals.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Sales extends BaseTimeEntity{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate payDate;

    private int totalCount;
    private int mobileAmount;
    private int creditCardAmount;
    private int cashAmount;

    @Builder
    public Sales(User user, LocalDate payDate, int totalCount, int mobileAmount, int creditCardAmount, int cashAmount) {
        this.user = user;
        this.payDate = payDate;
        this.totalCount = totalCount;
        this.mobileAmount = mobileAmount;
        this.creditCardAmount = creditCardAmount;
        this.cashAmount = cashAmount;
    }

    public void add(int amount, Payment.Method paymentMethod){
        if(paymentMethod == Payment.Method.MOBILE)  mobileAmount = amount;
        else if(paymentMethod == Payment.Method.CREDIT_CARD) creditCardAmount = amount;
        else if(paymentMethod == Payment.Method.CASH) cashAmount = amount;
    }
}
