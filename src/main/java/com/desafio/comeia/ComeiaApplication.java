package com.desafio.comeia;

import com.desafio.comeia.enums.Type;
import com.desafio.comeia.pojo.Client;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		clientRepository.update(new Client("2", Type.PJ,"123.627.134-32",
				"ClienteNovo","Caruaru","81 883146584"));




		SpringApplication.run(ComeiaApplication.class, args);
	}

}
