package cen4010.UserManagement.Model;

import org.springframework.data.annotation.Id;

public class UserCreation {
    @Id
    private String userName;

    private String password;

    // optional fields

    private String name;

    private String email;

    private String homeAddress;

    private CreditCard creditCard;


    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }


    @Override
    public String toString() {
        return "UserCreation{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress;
    }
}
