package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BankAccountRepository implements BankAccountRepositoryInterface{

    @Override
    public Account getByAccountNumber(String accountNumber) {

        List<Account> accountList = this.getAll();

        for(Account a: accountList){
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }

        return null;
    }

    @Override
    public Account save(Account account) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Account a = null;

        try{
            tx.begin();
            em.persist(account);
            tx.commit();
            a = this.getByID(account.getId());


        }catch (Exception e){
            e.printStackTrace();
            a = null;
        }
        finally {
            em.close();
        }
        return a;
    }

    @Override
    public void delete(Account account) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            account = em.find(Account.class,account.getId());
            em.remove(account);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public Account getByID(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Account aux = null;

        try{
            tx.begin();
            aux = em.find(Account.class,id);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            em.close();
        }

        return aux;
    }

    @Override
    public List<Account> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Account> allAccount = null;

        try{
            tx.begin();
            allAccount = em.createQuery("select a from Account a",Account.class).getResultList();
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            allAccount = null;
        }
        finally {
            em.close();
        }
        return allAccount;
    }

    @Override
    public Account update(Account account) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Account> allAccount = null;
        Account a = null;
        try{
            tx.begin();
            em.find(Account.class,account.getId()).getId();
            em.merge(account);
            a = em.find(Account.class,account.getId());
            tx.commit();


        }catch (Exception e){
            e.printStackTrace();
            a = null;
        }
        finally {
            em.close();
        }
        return a;
    }
}
