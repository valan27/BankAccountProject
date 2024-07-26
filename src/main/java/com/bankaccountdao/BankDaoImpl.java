package com.bankaccountdao;

import com.bankaccountdto.BankAccount;
import com.bankaccountutil.EntityUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;

public class BankDaoImpl implements BankDao{
    @Override
    public void create(BankAccount bankAccount) {
        EntityManager em = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(bankAccount);
        et.commit();
        em.close();


    }

    @Override
    public void remove(BankAccount bankAccount) {
    EntityManager em = EntityUtil.getEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();
    BankAccount temp = em.find(BankAccount.class, bankAccount.getActNumber());
    em.remove(temp);
    et.commit();
    em.close();
    }



    @Override
    public void update(BankAccount bankAccount) {
        EntityManager em  = EntityUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        BankAccount temp = em.find(BankAccount.class, bankAccount.getActNumber());
        temp.setActNumber(bankAccount.getActNumber());
        temp.setCustomerName(bankAccount.getCustomerName());
        temp.setCity(bankAccount.getCity());
        temp.setActBalance(bankAccount.getActBalance());
        temp.setBranchCode(bankAccount.getBranchCode());
        et.commit();




    }

    @Override
    public List<BankAccount> read() {
        EntityManager em = EntityUtil.getEntityManager();

        Query q = em.createQuery("SELECT b FROM BankAccount b");
        List<BankAccount> bank = q.getResultList();
        em.close();
        return bank;
    }

    @Override
    public List<BankAccount> byId(int a) {
        EntityManager em = EntityUtil.getEntityManager();

        Query q = em.createQuery("SELECT b FROM BankAccount as b WHERE b.id=:val");
        q.setParameter("val",a);
        return q.getResultList();

    }

    @Override
    public List<BankAccount> byName(String a) {
        EntityManager em = EntityUtil.getEntityManager();

        Query q = em.createQuery("SELECT b FROM BankAccount as b WHERE b.CustomerName=:val");
        q.setParameter("val",a);
        return q.getResultList();

    }

    @Override
    public List<BankAccount> byBid(int a) {
        EntityManager em = EntityUtil.getEntityManager();

        Query q = em.createQuery("SELECT b FROM BankAccount as b WHERE b.BranchCode=:val");
        q.setParameter("val",a);
       List<BankAccount> bank = q.getResultList();
         return bank;

    }

    @Override
    public List<Object[]> getAllBankAccGroupByCity() {
        EntityManager em = EntityUtil.getEntityManager();
        em = EntityUtil.getEntityManager();
        List<Object[]> allBankAccountsGroupByCity = em.createQuery("SELECT b.City,b.BranchCode FROM BankAccount b GROUP BY b.City,b.BranchCode").getResultList();
        em.close();
        return allBankAccountsGroupByCity;

    }


}
