package com.projSpring1.repository;

import org.springframework.data.repository.CrudRepository;

import com.projSpring1.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
//Representa tudo que existe no jdbc (update, insert, select, delete)
//Na linha <Conta, Long> o Long é o tipo da chave primário id
}
