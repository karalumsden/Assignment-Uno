package toba.account;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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

    public static List<Account> findByUserId(Long userId, String accountType){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                         "WHERE a.user.userId = :userId ";
        
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("userId", userId);
        List<Account> results = null;
        try { 
            results = q.getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return results;
    }
    
     public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

