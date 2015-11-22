package toba.account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import toba.business.User;
import toba.data.DBUtil;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private enum accountType {
        CHECKING, SAVINGS
    };
    private Double balance;
    private Double checking;
    private Double savings;

    public Account() {
        User user;
        balance = 0.00;
        checking = 0.00;
        savings = 0.00;
    }

    public Account(User user, Double balance, Double checking, Double savings) {
        this.balance = balance;
        this.checking = checking;
        this.savings = savings;
    }

    public static void credit(balance) {
        
    }

    public static void debit(balance) {
 
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
