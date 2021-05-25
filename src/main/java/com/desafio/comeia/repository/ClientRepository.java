package com.desafio.comeia.repository;

import com.desafio.comeia.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientRepository implements ClientRepositoryInterface{

    @Override
    public void save(Client client) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.persist(client);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }
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
    public Client getByID(String id) {
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
             allClient = (List<Client>) em.createQuery("select a from Client a",Client.class);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();
            return allClient;
        }
        finally {
            em.close();
        }
        return allClient;
    }

    @Override
    public void update(Client client) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Client> allClient = null;

        try{
            tx.begin();
            em.find(Client.class,client.getId());
            em.merge(client);
            tx.commit();

        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            em.close();
        }
    }
}
