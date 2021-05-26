package com.desafio.comeia.controllers;

import com.desafio.comeia.business.Transactions;
import com.desafio.comeia.enums.TransactionType;
import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.BankTransaction;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.pojos.RequestTransaction;
import com.desafio.comeia.repositories.*;
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
    TransactionRecorder transactionRecorder = new TransactionRepository();

    @GetMapping("/clients")
    @ResponseBody
    @ApiOperation(value = "Este método retorna uma lista de clientes do banco de dados")
    public List<Client> index(){
        List<Client> a = clientRepository.getAll();
        return a;
    }

    @GetMapping("/clients/{id}")
    @ApiOperation(value = "Este método retorna um cliente do BD através do seu id")
    public Client show(@PathVariable(value = "id") Integer id){
        return clientRepository.getByID(id);
    }

    @PostMapping("/clients")
    @ApiOperation(value = "Este método salva clientes no banco de dados e depois disso o retorna")
    public Client create(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients")
    @ApiOperation(value = "Este método deleta clientes do banco de dados")
    public void destroy(@RequestBody Client client){
        clientRepository.delete(client);
    }

    @PutMapping("/clients")
    @ApiOperation(value = "Este método faz alterações nos dados dos clientes do banco de dados")
    public Client update(@RequestBody Client client){

       return clientRepository.update(client);

    }

    //=======================

    @GetMapping("/bank-accounts")
    @ResponseBody
    @ApiOperation(value = "Este método retorna uma lista de Contas do banco de dados")
    public List<Account> indexAccounts(){
        List<Account> a = bankAccountRepository.getAll();
        return a;
    }

    @GetMapping("/bank-accounts/{id}")
    @ApiOperation(value = "Este método retorna uma Conta do BD através do seu id")
    public Account showAccounts(@PathVariable(value = "id") Integer id){
        return bankAccountRepository.getByID(id);
    }

    @GetMapping("/bank-accounts/number/{id}")
    @ApiOperation(value = "Este método retorna uma Conta do BD através do seu numero de conta")
    public Account showAccountsByNumber(@PathVariable(value = "id") String id){
        return bankAccountRepository.getByAccountNumber(id);
    }

    @PostMapping("/bank-accounts")
    @ApiOperation(value = "Este método salva Contas no banco de dados e depois disso o retorna")
    public Account createAccounts(@RequestBody Account account){
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bank-accounts")
    @ApiOperation(value = "Este método deleta Contas do banco de dados")
    public void destroyAccounts(@RequestBody Account account){
        bankAccountRepository.delete(account);
    }

    @PutMapping("/bank-accounts")
    @ApiOperation(value = "Este método faz alterações nos dados dos Contas do banco de dados")
    public Account updateAccounts(@RequestBody Account account){

        return bankAccountRepository.update(account);

    }

    @PostMapping("/bank-accounts/transactions")
    @ApiOperation(value = "através desse método é possível transferir valores entre contas")
    public List<Account> transferTransaction(@RequestBody RequestTransaction requestTransaction){
        /*
        * Coletando dados da requisição
        */
        double transferValue = requestTransaction.getTransferValue();
        String creditAccountNumber = requestTransaction.getAccountCreditNumber();
        String debitAccountNumber = requestTransaction.getAccountDebitNumber();
        /*
        * Acessando as contas no banco de dados;
        */
        Account creditAccount = bankAccountRepository.getByAccountNumber(creditAccountNumber);
        Account debitAccount = bankAccountRepository.getByAccountNumber(debitAccountNumber);

        Transactions transactionOperation = new Transactions();

        if(transactionOperation.transfer(transferValue,debitAccount, creditAccount)){//realiza a transferencia;

            List<Account> updated = new ArrayList<>();
            updated.add(creditAccount);
            updated.add(debitAccount);

            return updated;

        }else{
            return null;
        }

    }

    @GetMapping("/bank-accounts/transactions")
    @ApiOperation(value = "Este método retorna apenas o formato da requisição, para fins de teste")
    public RequestTransaction indexRequest(){
        return new RequestTransaction("123","12345",500);
    }

    @GetMapping("/bank-accounts/transactions-history")
    @ApiOperation("Este método retorna uma lista com o historico de todas as transações já feitas")
    public List<BankTransaction> indexBankTransactions(){

        return transactionRecorder.getAll();
    }







}
