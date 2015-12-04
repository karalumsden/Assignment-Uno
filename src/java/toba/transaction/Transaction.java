package toba.transaction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.Id;

import toba.business.User;
import toba.account.Account;

@Entity
public class Transaction implements Serializable {
    
    public enum TransactionTypes {
        CREDIT,
        DEBIT,
        TRANSFER
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Double transactionAmt;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private TransactionTypes type;
    
    public Transaction(){}

    public Transaction(Double transactionAmt, TransactionTypes type) {
        this.transactionAmt = transactionAmt;
        this.date = new Date();
        this.type = type;
    }

    // Getters/Setters
    
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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
