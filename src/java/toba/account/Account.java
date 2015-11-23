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

    public enum accountType {CHECKING, SAVINGS};
    private accountType aName;
    private Double balance;

    public Account() {
        User user;
        balance = 0.00;
        this.aName = aName;
    }

    public Account(User user, Double balance, accountType aName) {
        this.balance = balance;
        this.aName = aName;
    }

    public static double credit(double balance) {
        this.balance + balance = balance;
        return balance;
    }

    public static void debit(double balance) {
        this.balance - balance = balance;
        return balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public accountType getaName() {
        return aName;
    }

    public void setaName(accountType aName) {
        this.aName = aName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
