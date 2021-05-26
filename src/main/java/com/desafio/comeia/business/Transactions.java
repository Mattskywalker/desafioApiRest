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

    private Account xptoAccount = bankAccountRepository.getByAccountNumber("000");

    public boolean transfer(double transferValue,Account debit, Account credit){

        Double operationCost = this.debit(debit,transferValue);

        if(operationCost > 0){//passando daqui a transação pode ser feita;
            this.credit(credit,transferValue);//credita o valor;
            System.out.println("debitado e creditado: " + debit.getBalance() + " e " + credit.getBalance());

            Client debitOwner = debit.getOwner();
            Client creditOwner = credit.getOwner();

            this.bankAccountRepository.update(debit);
            this.bankAccountRepository.update(credit);

            this.clientRepository.update(debitOwner);
            this.clientRepository.update(creditOwner);

            BankTransaction registro = new BankTransaction(transferValue, TransactionType.TEF,
                    debitOwner,creditOwner,operationCost);

            transactionRecorder.save(registro);

            Double currentValue = xptoAccount.getBalance();
            xptoAccount.setBalance(currentValue + operationCost);
            this.bankAccountRepository.update(xptoAccount);

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


    public double debit(Account account, double value){
        double accountValue = account.getBalance();
        double debitTransactionsNumber = account.getOwner().getDebitTransations();
        /*
        * Até 10 movimentações o cliente irá pagar R$ 1,00 por movimentação;
        * De 10 a 20 movimentações o cliente irá pagar R$ 0,75 por movimentação;
        * Acima de 20 movimentações o cliente irá pagar R$ 0,50 por movimentação;
        */

        double operationCost;

        if(debitTransactionsNumber <= 10){
            //Até 10 movimentações o cliente irá pagar R$ 1,00 por movimentação;
            operationCost = 1;
            value = value + operationCost;
            System.out.println("valor final" + value);

        }else if(debitTransactionsNumber <= 20){
            //De 10 a 20 movimentações o cliente irá pagar R$ 0,75 por movimentação;
            operationCost = 0.75;
            value = value + operationCost;
            System.out.println("valor final" + value);
        }else{
            //Acima de 20 movimentações o cliente irá pagar R$ 0,50 por movimentação;
            operationCost = 0.50;
            value = value + operationCost;
            System.out.println("valor final" + value);
        }


        if(accountValue >= value){
            account.setBalance(account.getBalance() - value);

            new TransactionClientRegister().saveDebitTransaction(account);

            return operationCost;
        }else{
            return 0;
        }

    }

}
