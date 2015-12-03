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
    private User user;
    private Account account;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Transaction> transactionItems;
    
    private Double transactionAmt;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();
    
    public Transaction(){}

    public Transaction(User user, Account account, Double transactionAmt, Date date) {
        this.user = user;
        this.account = account;
        this.transactionAmt = transactionAmt;
        this.date = date;
    }

    // Getters/Setters
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<Transaction> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(List<Transaction> transactionItems) {
        this.transactionItems = transactionItems;
    }

    public Double getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(Double transactionAmt) {
        this.transactionAmt = transactionAmt;
    } 
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    } 
}
