package toba.transaction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.transaction.Transaction.TransactionTypes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-04T17:53:33")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Date> date;
    public static volatile SingularAttribute<Transaction, Double> transactionAmt;
    public static volatile SingularAttribute<Transaction, TransactionTypes> type;
    public static volatile SingularAttribute<Transaction, Long> transactionId;

}