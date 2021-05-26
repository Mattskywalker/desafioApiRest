package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Account;

import java.util.List;

public interface BankAccountRepositoryInterface {

    public Account save(Account account);

    public void delete(Account account);

    public Account getByID(Integer id);

    public Account getByAccountNumber(String accountNumber);

    public List<Account> getAll();

    public Account update(Account account);


}
