package toba.account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import toba.data.DBUtil;

public class AccountDB {
    
    public static void insert(Account acct) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(acct);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
}
