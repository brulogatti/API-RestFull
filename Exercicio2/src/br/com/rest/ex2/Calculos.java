package br.com.rest.ex2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/calculos")
public class Calculos {
	
//http://localhost:8080/Exercicio2/rest/tabuada/2
//http://localhost:8080/Exercicio2/rest/perimetro/5/10/9
//http://localhost:8080/Exercicio2/rest/perimetro/1/0/9
	
	
	@GET
	@Path("tabuada/{param}")
	public String tabuada(@PathParam ("param") int x) {
		String saida="";
		for(int i=0;i<=10;i++) {
			String out = String.valueOf(x*i);
			saida = saida + out + "\n";
		}
		return saida;
	}
	
	@GET
	@Path("perimetro/{param1}/{param2}/{param3}")
	public String perimetro(@PathParam("param1") int a, @PathParam ("param2") int b, @PathParam ("param3") int c) {
		/*Verificar se é um triângulo
		| b - c | < a < b + c
		| a - c | < b < a + c
		| a - b | < c < a + b*/
		int cont=0;

		if(Math.abs(b-c)<a && a<b+c)
		{
			cont=cont+1;
		}
		
		if(Math.abs(a-c)<b && b<a+c)
		{
			cont=cont+1;
		}
		
		if(Math.abs(a-b)<c && c<a+b)
		{
			cont=cont+1;
		}
		
		if(cont<3) {
			return "Não é um triângulo";
		}
		else {
			String out = String.valueOf(a+b+c);
			return out;
		}
	}

}
