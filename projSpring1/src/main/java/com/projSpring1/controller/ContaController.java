package com.projSpring1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projSpring1.model.Conta;
import com.projSpring1.repository.ContaRepository;

@RestController
public class ContaController {
	
	@Autowired
	ContaRepository repository;
	//É uma interface -> persiste informações no bd
	
	//http://localhost:8080/api/save	
	/*
	 * INSERIR
	   {
	    "numConta": 10,
	    "descricao": "Conta Corrente",
	    "valor": 1500
	   }
	 * 
	 * ALTERAR
	   {
	    "id" : 1
	    "numConta": 10,
	    "descricao": "Conta Poupança",
	    "valor": 1500
	   }
	 * */
	@PostMapping("api/save")//Chama o método
	public Conta save(@RequestBody Conta conta){
		return repository.save(conta);
	}
	//método que insere e altera registros no banco de dados
	
	//http://localhost:8080/api/all
	@GetMapping("api/all")//Chama o método
	public List<Conta> all(){
		return (List<Conta>) repository.findAll();
	}
	//retorna uma lista de contas (select)
	
	//http://localhost:8080/api/delete/2
	@GetMapping("api/delete/{id}")//Chama o método
	public boolean delete(@PathVariable("id") Long id) {
		try {
			repository.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//deleta um registro do banco de dados
}
