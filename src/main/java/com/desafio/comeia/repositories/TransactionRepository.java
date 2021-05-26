package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.BankTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TransactionRepository implements TransactionRecorder{



    @Override
    public BankTransaction save(BankTransaction bankTransaction) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        BankTransaction a = null;

        try{
            tx.begin();
            em.persist(bankTransaction);
            tx.commit();
            a = this.getByID(bankTransaction.getId());
            System.out.println("Transação que vai ser retornada: " + a.getId());
        }catch (Exception e){
            e.printStackTrace();
            a = null;
        }
        finally {
            em.close();
        }
        return a;
    }

    public void delete(BankTransaction bankTransaction) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            bankTransaction = em.find(BankTransaction.class,bankTransaction.getId());
            em.remove(bankTransaction);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public BankTransaction getByID(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        BankTransaction aux = null;

        try{
            tx.begin();
            aux = em.find(BankTransaction.class,id);
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
    public List<BankTransaction> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<BankTransaction> allClient = null;

        try{
            tx.begin();
            allClient = em.createQuery("select a from BankTransaction a",BankTransaction.class).getResultList();
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            allClient = null;
        }
        finally {
            em.close();
        }
        return allClient;
    }

    @Override
    public BankTransaction update(BankTransaction bankTransaction) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<BankTransaction> allClient = null;
        BankTransaction a = null;
        try{
            tx.begin();
            em.find(BankTransaction.class,bankTransaction.getId()).getId();
            em.merge(bankTransaction);
            a = em.find(BankTransaction.class,bankTransaction.getId());
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
