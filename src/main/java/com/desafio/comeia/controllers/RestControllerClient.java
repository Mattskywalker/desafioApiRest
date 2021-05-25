package com.desafio.comeia.controllers;

import com.desafio.comeia.pojo.Client;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestControllerClient {

    ClientRepositoryInterface clientRepository = new ClientRepository();

    @GetMapping("/clientes")
    @ResponseBody
    public List<Client> index(){
        List<Client> a = clientRepository.getAll();
        return a;
    }

    @GetMapping("/cliente/{id}")
    public Client show(@PathVariable(value = "id") String id){
        return clientRepository.getByID(id);
    }

    @PostMapping("/cliente")
    public Client create(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/cliente")
    public void destroy(@RequestBody Client client){
        clientRepository.delete(client);
    }

    @PutMapping("/cliente")
    public Client update(@RequestBody Client client){

       return clientRepository.update(client);

    }



}
