package cen4010.UserManagement.Model;

import org.springframework.data.annotation.Id;

public class CreditCard {
    @Id

    private Long id;

    private String cardNum;
    private String expirationDate;
    private String cvv;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
