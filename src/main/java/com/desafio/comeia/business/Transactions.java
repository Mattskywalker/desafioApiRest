package com.desafio.comeia.business;

import com.desafio.comeia.enums.TransactionType;
import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.BankTransaction;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.repositories.*;

/**
 * @author Mattskywalker
 *
 * Classe que realiza os calculos de debito e credito, a classe tambem
 * realiza a transferencia de uma conta para a outra;
 */

public class Transactions {

    private TransactionRecorder transactionRecorder = new TransactionRepository();
    private ClientRepositoryInterface clientRepository = new ClientRepository();
    private BankAccountRepositoryInterface bankAccountRepository = new BankAccountRepository();

    public boolean transfer(double transferValue,Account debit, Account credit){

        if(this.debit(debit,transferValue)){//passando daqui a transação pode ser feita;
            this.credit(credit,transferValue);//credita o valor;
            System.out.println("debitado e creditado: " + debit.getBalance() + " e " + credit.getBalance());


            Client debitOwner = debit.getOwner();
            Client creditOwner = credit.getOwner();

            this.bankAccountRepository.update(debit);
            this.bankAccountRepository.update(credit);

            transactionRecorder.save(new BankTransaction(transferValue, TransactionType.TEF,
                    debitOwner,creditOwner,0));

            this.clientRepository.update(debitOwner);
            this.clientRepository.update(creditOwner);

            return true;
        }else{
            System.out.println("Erro, saldo insuficiente");
            return false;
        }

    }

    public void credit(Account account, double value){

        double accoutnValue = account.getBalance();
        account.setBalance(accoutnValue + value);

        new TransactionClientRegister().saveCreditTransaction(account);

    }


    public boolean debit(Account account, double value){
        double accountValue = account.getBalance();

        if(accountValue >= value){
            account.setBalance(account.getBalance() - value);

            new TransactionClientRegister().saveDebitTransaction(account);

            return true;
        }else{
            return false;
        }

    }

}
