package com.desafio.comeia.repository;

import com.desafio.comeia.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepositoryInterface{

    public void save(Client client);

    public void delete(Client client);

    public Client getByID(String id);

    public List<Client> findAll();


}
