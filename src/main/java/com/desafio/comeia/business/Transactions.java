package com.desafio.comeia.business;

import com.desafio.comeia.pojos.Account;

public class Transactions {


    public boolean transfer(double transferValue,Account debit, Account credit){

        if(this.debit(debit,transferValue)){
            this.credit(credit,transferValue);
            return true;
        }else{
            System.out.println("Erro, saldo insuficiente");
            return false;
        }

    }

    public void credit(Account account, double value){

        double accoutnValue = account.getBalance();
        account.setBalance(accoutnValue + value);

    }

    public boolean debit(Account account, double value){
        double accountValue = account.getBalance();

        if(accountValue >= value){
            account.setBalance(account.getBalance() - value);
            return true;
        }else{
            return false;
        }

    }

}
