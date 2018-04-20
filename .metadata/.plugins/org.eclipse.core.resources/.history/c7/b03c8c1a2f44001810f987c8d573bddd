package br.com.rest.ex3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/imc")
public class Imc {
	
	@GET
	@Path("calcular/{param1}/{param2}/{param3}/{param4}")
	public void calcular(@PathParam ("param1") String nome,  @PathParam ("param2") int idade, @PathParam ("param3") double peso, @PathParam ("param4") double altura) {
		double imcd = peso/(altura*altura);
		
		
	}
	
	@GET
	@Path("mostrar")
	public String mostrar() {
		
		
	}

}
