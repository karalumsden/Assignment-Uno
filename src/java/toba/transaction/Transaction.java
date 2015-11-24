package toba.transaction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;

import toba.business.User;
import toba.account.Account;

@Entity
public class Transaction implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    
    @ManyToOne
    private Account account;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Transaction> transactionItems;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
    

    // Getters/Setters
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(List<Transaction> transactionItems) {
        this.transactionItems = transactionItems;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    } 
}
