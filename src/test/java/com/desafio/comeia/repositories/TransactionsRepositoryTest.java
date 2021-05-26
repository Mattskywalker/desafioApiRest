package com.desafio.comeia.repositories;

import com.desafio.comeia.enums.TransactionType;
import com.desafio.comeia.pojos.BankTransaction;
import com.desafio.comeia.pojos.Client;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsRepositoryTest {

    TransactionRecorder transactionRecorder = new TransactionsRepository();
    BankTransaction bankTransactionMock =
            new BankTransaction(500D, TransactionType.DEBIT,1D);

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
            System.out.println("se for null, é por que já existe!");

            transactionRecorder.delete(bankTransactionMock);
        }

        assertNull(transactionRecorder.getByID(bankTransactionMock.getId()));

    }
}