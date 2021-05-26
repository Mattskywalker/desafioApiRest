package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientRepository implements ClientRepositoryInterface{

    @Override
    public Client save(Client client) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Client a = null;

        try{
            tx.begin();
            em.persist(client);
            tx.commit();
            a = this.getByID(client.getId());


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
    public void delete(Client client) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            client = em.find(Client.class,client.getId());
            em.remove(client);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }

    }

    @Override
    public Client getByID(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Client aux = null;

        try{
            tx.begin();
            aux = em.find(Client.class,id);
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
    public List<Client> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Client> allClient = null;

        try{
            tx.begin();
             allClient = em.createQuery("select a from Client a",Client.class).getResultList();
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
    public Client update(Client client) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Client> allClient = null;
        Client a = null;
        try{
            tx.begin();
            em.find(Client.class,client.getId()).getId();
            em.merge(client);
            a = em.find(Client.class,client.getId());
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
