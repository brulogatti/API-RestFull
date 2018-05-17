package com.projJogo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogo {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

private String tipojogo;
private int qtdjogadores;
private String dataJogo;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTipojogo() {
	return tipojogo;
}
public void setTipojogo(String tipojogo) {
	this.tipojogo = tipojogo;
}
public int getQtdjogadores() {
	return qtdjogadores;
}
public void setQtdjogadores(int qtdjogadores) {
	this.qtdjogadores = qtdjogadores;
}
public String getDataJogo() {
	return dataJogo;
}
public void setDataJogo(String dataJogo) {
	this.dataJogo = dataJogo;
}


}
