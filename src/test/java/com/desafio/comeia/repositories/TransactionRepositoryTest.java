package com.desafio.comeia.repositories;

import com.desafio.comeia.enums.TransactionType;
import com.desafio.comeia.pojos.BankTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    TransactionRecorder transactionRecorder = new TransactionRepository();
    BankTransaction bankTransactionMock =
            new BankTransaction();

    @Test
    void save() {

        assertNotNull(transactionRecorder.save(bankTransactionMock).getId());

    }

    @Test
    void delete() {

        if((transactionRecorder.save(bankTransactionMock) == null)){

            transactionRecorder.save(bankTransactionMock);
            transactionRecorder.delete(bankTransactionMock);

        }else{
            //System.out.println("se for null, é por que já existe!");

            transactionRecorder.delete(bankTransactionMock);
        }

        assertNull(transactionRecorder.getByID(bankTransactionMock.getId()));

    }
}