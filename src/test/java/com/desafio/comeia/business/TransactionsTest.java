package com.desafio.comeia.business;

import com.desafio.comeia.enums.Type;
import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.repositories.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    Client debitOwner = new Client(Type.PF,"123.123.123-54",
            "Elon Musk","Caruaru - PE","81 9994448876");

    Client creditOwner = new Client(Type.PF,"654,987,354-78",
            "Bill Gates","Caruaru - PE","81 9994448876");

    double initialValue = 350;

    Account debitAccount = new Account(debitOwner,"55810",initialValue);

    Account creditAccount = new Account(creditOwner,"5510",initialValue);

    BankAccountRepositoryInterface bankAccountRepository = new BankAccountRepository();
    ClientRepositoryInterface clientRepository = new ClientRepository();

    TransactionRecorder transactionRecorder = new TransactionRepository();
    Transactions transactionsOperation = new Transactions();


    @Test
    void transfer() {

        this.clientRepository.save(creditOwner);
        this.bankAccountRepository.save(creditAccount);
        this.clientRepository.save(debitOwner);
        this.bankAccountRepository.save(debitAccount);

        this.transactionsOperation.transfer(190,debitAccount,creditAccount);// da conta de elon, vai sair 190 para a conta de gates

        assertNotNull(this.bankAccountRepository.getByID(2));

    }

    /*@Test
    void credit() {
        this.clientRepository.save(creditOwner);
        this.bankAccountRepository.save(creditAccount);

        this.transactionsOperation.credit(creditAccount,200);

        this.bankAccountRepository.update(creditAccount);

        Account updated = this.bankAccountRepository.getByID(creditAccount.getId());

        double valueUpdated = updated.getBalance();

        assertTrue((valueUpdated > initialValue));


    }*/

    @Test
    void debit() {



    }
}