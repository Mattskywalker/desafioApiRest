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


		Client empresa = new Client(Type.PJ,"23.456.213/0001-04","XPTO",
				"Caruaru, PE","81 98989898");

		//conta da empresa é criada com um numero estatico padrão;
		Account xptoAccount = new Account(empresa,"000",0);

		try{

			Client encontrado = new ClientRepository().getByDocument(empresa.getDocument());
			encontrado.equals(null);

		}catch (Exception e){
			System.err.println("ERRO" + e.getMessage());
			new ClientRepository().save(empresa);
			new BankAccountRepository().save(xptoAccount);
		}

		SpringApplication.run(ComeiaApplication.class, args);
	}

}
