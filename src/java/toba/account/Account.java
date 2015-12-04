package toba.account;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import toba.business.User;
import toba.transaction.Transaction;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    public enum AccountType {
        CHECKING, SAVINGS
    }
    
    private AccountType accountType;
    private Double balance;
    private User user;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Transaction> transactions;
    
    public Account() {
    }

    public Account(User user, AccountType type, double startingBalance) {
        this.balance = startingBalance;
        this.accountType = type;
        this.user = user;
    }

    public void credit(double amt) {
        this.balance += amt;
        this.transactions.add(new Transaction(amt, Transaction.TransactionTypes.CREDIT));
    }

    public void debit(double amt) {
        this.balance -= amt;
        this.transactions.add(new Transaction(amt, Transaction.TransactionTypes.CREDIT));
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
