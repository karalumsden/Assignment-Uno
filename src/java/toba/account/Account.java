package toba.account;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import toba.business.User;
import toba.transaction.Transaction;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    
    public enum AccountType {
        CHECKING, 
        SAVINGS
    }
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Double balance;
    
    @ManyToOne
    private User user;
      
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private ArrayList<Transaction> transactions;
    
    public Account() {
    }

    public Account(User user, AccountType type, double startingBalance) {
        this.balance = startingBalance;
        this.accountType = type;
        this.user = user;
        this.transactions = new ArrayList<Transaction>();
    }

    public void credit(double amt) {
        this.balance += amt;
        this.transactions.add(new Transaction(amt, Transaction.TransactionTypes.CREDIT));
    }

    public void debit(double amt) {
        this.balance -= amt;
        this.transactions.add(new Transaction(amt, Transaction.TransactionTypes.DEBIT));
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

    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getBalanceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getBalance());
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    public ArrayList<Transaction> getList() {
        return transactions;
    }
    
}
