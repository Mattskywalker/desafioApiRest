package com.desafio.comeia.business;

import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.BankTransaction;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import com.desafio.comeia.repositories.TransactionRecorder;
import com.desafio.comeia.repositories.TransactionRepository;

/**
 * @author Mattskywalker
 * Classe responsavel por atualizar os dados dos objetos conta;
 */

public class TransactionClientRegister {

    private ClientRepositoryInterface clientRepository = new ClientRepository();
    private TransactionRecorder transactionRecorder = new TransactionRepository();


    /**
     * Metodo responavél por atualizar a debitada e a creditada;
     *
     * @param debitAccount conta debitada;
     * @param creditAccount conta creditada;
     */

    public void saveFullTransaction(Account debitAccount, Account creditAccount){

        this.saveDebitTransaction(debitAccount);
        this.saveCreditTransaction(creditAccount);

    }

    public void saveDebitTransaction(Account debitAccount){

        Client debitOwner = debitAccount.getOwner();// pegando o dono da conta;

        double debitTransactionNumber = debitOwner.getDebitTransations();

        //atualiza o numero de transações dos clientes envolvidos na transação;
        debitOwner.setDebitTransations(debitTransactionNumber + 1);
    }

    public void saveCreditTransaction(Account creditAccount){

        Client creditOwner = creditAccount.getOwner();

        double creditTransactionNumber = creditOwner.getCreditTransations();

        //atualiza o numero de transações dos clientes envolvidos na transação;
        creditOwner.setCreditTransations(creditTransactionNumber + 1);

    }




}
