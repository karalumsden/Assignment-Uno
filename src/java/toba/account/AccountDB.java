package toba.account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import toba.data.DBUtil;

public class AccountDB {
    
    public static void insert(Account checking, Account savings) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(checking);
            em.persist(savings);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
}
