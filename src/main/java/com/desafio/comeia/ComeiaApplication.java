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

		ClientRepositoryInterface clientRepository = new ClientRepository();

		Client client = new Client("1", Type.PF,"123.627.134-31",
				"Mattskywalker","Caruaru","81 993146584");

		Client client1 = new Client("2", Type.PJ,"123.627.134-32",
				"Cliente 1","Caruaru","81 883146584");

		clientRepository.save(client);
		clientRepository.save(client1);

		List<Account> accounts = new ArrayList<>();

		accounts.add(new Account("1",client,"12345",1000));
		accounts.add(new Account("2",client,"123",1000));


		/*clientRepository.save(new Client("3", Type.PJ,"908.227.174-32",
				"Lewis Hamilton","England","81 883146864",));*/


		clientRepository.update(new Client("1", Type.PJ,"123.627.134-32",
				"ClienteNovo","Caruaru","81 883146584",accounts));

		BankAccountRepositoryInterface bankAccountRepository = new BankAccountRepository();

		accounts.stream().forEach(account -> {bankAccountRepository.save(account);});




		SpringApplication.run(ComeiaApplication.class, args);
	}

}
