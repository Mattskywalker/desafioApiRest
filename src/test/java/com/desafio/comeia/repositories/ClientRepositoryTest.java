package com.desafio.comeia.repositories;

import com.desafio.comeia.enums.Type;
import com.desafio.comeia.pojos.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    ClientRepositoryInterface clientRepository = new ClientRepository();
    Client clientMock = new Client(Type.PF,"123.123.123-54",
            "Elon Musk","Caruaru - PE","81 9994448876");

    @Test
    void save() {

        assertNotNull(clientRepository.save(clientMock));

    }

    @Test
    void delete() {

    }

    @Test
    void getByID() {

    }
}