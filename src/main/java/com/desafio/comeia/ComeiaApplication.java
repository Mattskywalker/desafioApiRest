package com.desafio.comeia;

import com.desafio.comeia.enums.Type;
import com.desafio.comeia.pojos.Account;
import com.desafio.comeia.pojos.Client;
import com.desafio.comeia.repositories.BankAccountRepository;
import com.desafio.comeia.repositories.BankAccountRepositoryInterface;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ComeiaApplication {

	public static void main(String[] args) {



		try{

			Client empresa = new Client(Type.PJ,"23.456.213/0001-04","XPTO",
					"Caruaru, PE","81 98989898");

			Account xptoAccount = new Account(empresa,"000",0);

			new ClientRepository().save(empresa);
			new BankAccountRepository().save(xptoAccount);


		}catch (Exception e){
			System.err.println("ERRO" + e.getMessage());
		}

		SpringApplication.run(ComeiaApplication.class, args);
	}

}
