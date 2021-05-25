package com.desafio.comeia.controllers;

import com.desafio.comeia.pojo.Client;
import com.desafio.comeia.repositories.ClientRepository;
import com.desafio.comeia.repositories.ClientRepositoryInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST clients")
@CrossOrigin(origins = "*")
public class RestControllerClient {

    ClientRepositoryInterface clientRepository = new ClientRepository();

    @GetMapping("/clients")
    @ResponseBody
    @ApiOperation(value = "Este metodo retorna uma lista de clientes do banco de dados")
    public List<Client> index(){
        List<Client> a = clientRepository.getAll();
        return a;
    }

    @GetMapping("/clients/{id}")
    @ApiOperation(value = "Este metodo retorna um cliente do BD através do seu id")
    public Client show(@PathVariable(value = "id") String id){
        return clientRepository.getByID(id);
    }

    @PostMapping("/clients")
    @ApiOperation(value = "Este metodo salva clientes no banco de dados e depois disso o retorna")
    public Client create(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients")
    @ApiOperation(value = "Este metodo deleta clientes do banco de dados")
    public void destroy(@RequestBody Client client){
        clientRepository.delete(client);
    }

    @PutMapping("/clients")
    @ApiOperation(value = "Este metodo faz alterações nos dados dos clientes do banco de dados")
    public Client update(@RequestBody Client client){

       return clientRepository.update(client);

    }

}
