package com.desafio.comeia.controllers;

import com.desafio.comeia.business.Transactions;
import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.pojos.RequestTransaction;
import com.desafio.comeia.repositories.BankAccountRepository;
import com.desafio.comeia.repositories.BankAccountRepositoryInterface;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST clients")
@CrossOrigin(origins = "*")
public class RestControllerClient {

    ClientRepositoryInterface clientRepository = new ClientRepository();
    BankAccountRepositoryInterface bankAccountRepository = new BankAccountRepository();

    @GetMapping("/clients")
    @ResponseBody
    @ApiOperation(value = "Este metodo retorna uma lista de clientes do banco de dados")
    public List<Client> index(){
        List<Client> a = clientRepository.getAll();
        return a;
    }

    @GetMapping("/clients/{id}")
    @ApiOperation(value = "Este metodo retorna um cliente do BD através do seu id")
    public Client show(@PathVariable(value = "id") Integer id){
        return clientRepository.getByID(id);
    }

    @PostMapping("/clients")
    @ApiOperation(value = "Este metodo salva clientes no banco de dados e depois disso o retorna")
    public Client create(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients")
    @ApiOperation(value = "Este metodo deleta clientes do banco de dados")
    public void destroy(@RequestBody Client client){
        clientRepository.delete(client);
    }

    @PutMapping("/clients")
    @ApiOperation(value = "Este metodo faz alterações nos dados dos clientes do banco de dados")
    public Client update(@RequestBody Client client){

       return clientRepository.update(client);

    }

    //=======================

    @GetMapping("/bank-accounts")
    @ResponseBody
    @ApiOperation(value = "Este metodo retorna uma lista de Contas do banco de dados")
    public List<Account> indexAccounts(){
        List<Account> a = bankAccountRepository.getAll();
        return a;
    }

    @GetMapping("/bank-accounts/{id}")
    @ApiOperation(value = "Este metodo retorna uma Conta do BD através do seu id")
    public Account showAccounts(@PathVariable(value = "id") String id){
        return bankAccountRepository.getByID(id);
    }

    @PostMapping("/bank-accounts")
    @ApiOperation(value = "Este metodo salva Contas no banco de dados e depois disso o retorna")
    public Account createAccounts(@RequestBody Account account){
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bank-accounts")
    @ApiOperation(value = "Este metodo deleta Contas do banco de dados")
    public void destroyAccounts(@RequestBody Account account){
        bankAccountRepository.delete(account);
    }

    @PutMapping("/bank-accounts")
    @ApiOperation(value = "Este metodo faz alterações nos dados dos Contas do banco de dados")
    public Account updateAccounts(@RequestBody Account account){

        return bankAccountRepository.update(account);

    }

    @PostMapping("/bank-accounts/transactions")
    @ApiOperation(value = "através desse metodo é possível transferir valores entre contas")
    public List<Account> transferTransaction(@RequestBody RequestTransaction requestTransaction){

        double transferValue = requestTransaction.getTransferValue();
        String creditAccountNumber = requestTransaction.getAccountCreditNumber();
        String debitAccountNumber = requestTransaction.getAccountDebitNumber();

        Account creditAccount = bankAccountRepository.getByAccountNumber(creditAccountNumber);
        Account debitAccount = bankAccountRepository.getByAccountNumber(debitAccountNumber);

        Transactions tx = new Transactions();

        if(tx.transfer(transferValue,debitAccount, creditAccount)){

            bankAccountRepository.update(creditAccount);
            bankAccountRepository.update(debitAccount);


            List<Account> updated = new ArrayList<>();
            updated.add(creditAccount);
            updated.add(debitAccount);

            return updated;

        }else{
            return null;
        }

    }

    @GetMapping("/bank-accounts/transactions")
    @ApiOperation(value = "Este metodo retorna uma Conta do BD através do seu id")
    public RequestTransaction indexRequest(){
        return new RequestTransaction("123","12345",500);
    }






}
