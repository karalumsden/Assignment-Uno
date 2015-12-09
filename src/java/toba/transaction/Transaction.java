package toba.transaction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.Id;

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

    public TransactionTypes getType() {
        return type;
    }

    public void setType(TransactionTypes type) {
        this.type = type;
    }
    
    public void setTransactionAmount(double val){
        this.transactionAmt = val;
    }
    
    public double getTransactionAmount(){
        return this.transactionAmt;
    }
    
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
