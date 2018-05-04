package br.com.rest.resala;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/json")
public class JSONSala {
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public Sala getProductInJSON() {
		
		Sala s = new Sala();
		s.setId(1);
		s.setDescricao("Sala 1, 200 lugares");
		s.setDataCadastro("03/05/2018");
		s.setDataReserva("10/05/2018");
		s.setHora("19:45");
		
		return s;
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createPessoaInJSON(Sala sala) {
		
		String result = "Product created : " + sala;
		return Response.status(201).entity(result).build();
	}

}
