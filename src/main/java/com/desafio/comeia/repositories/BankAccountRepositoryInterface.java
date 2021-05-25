package com.desafio.comeia.repositories;

import com.desafio.comeia.pojos.Account;

import java.util.List;

public interface BankAccountRepositoryInterface {

    public Account save(Account account);

    public void delete(Account account);

    public Account getByID(String id);

    public List<Account> getAll();

    public Account update(Account account);


}
