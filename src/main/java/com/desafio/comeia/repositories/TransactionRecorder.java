package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.BankTransaction;

import java.util.List;

public interface TransactionRecorder {

    public BankTransaction save(BankTransaction bankTransaction);

    public void delete(BankTransaction bankTransaction);

    public BankTransaction getByID(Integer id);

    public List<BankTransaction> getAll();

    public BankTransaction update(BankTransaction bankTransaction);

}
