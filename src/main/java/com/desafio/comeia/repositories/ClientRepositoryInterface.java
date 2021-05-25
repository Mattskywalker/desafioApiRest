package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Client;

import java.util.List;

public interface ClientRepositoryInterface{

    public Client save(Client client);

    public void delete(Client client);

    public Client getByID(String id);

    public List<Client> getAll();

    public Client update(Client client);


}
