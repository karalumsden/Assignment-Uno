package toba.account;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import toba.account.Account.AccountType;
import toba.business.User;
import toba.transaction.Transaction;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-04T17:53:33")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Date> date;
    public static volatile SingularAttribute<Account, Long> accountId;
    public static volatile SingularAttribute<Account, Double> balance;
    public static volatile SingularAttribute<Account, AccountType> accountType;
    public static volatile ListAttribute<Account, Transaction> transactions;
    public static volatile SingularAttribute<Account, User> user;

}