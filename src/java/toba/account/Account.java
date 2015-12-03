package toba.account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import toba.business.User;


@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    public enum AccountType {CHECKING, SAVINGS};
    private AccountType aName;
    private Double balance;
    private User user;

    public Account(){}

    public Account(User user, AccountType type, double startingBalance) {
        this.balance = startingBalance;
        this.aName = type;
        this.user = user;
    }

    public void credit(double amt) {
        this.balance += amt;
    }

    public void debit(double amt) {
        this.balance -= amt;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return aName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
