package com.projMusica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musica {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

private String nome;
private String genero;
private int anolancamento;
private String cantor;
private int nota;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}
public int getAnolancamento() {
	return anolancamento;
}
public void setAnolancamento(int anolancamento) {
	this.anolancamento = anolancamento;
}
public String getCantor() {
	return cantor;
}
public void setCantor(String cantor) {
	this.cantor = cantor;
}
public int getNota() {
	return nota;
}
public void setNota(int nota) {
	this.nota = nota;
}



}
