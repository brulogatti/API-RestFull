package br.com.rest.resala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/json")
public class JSONSala {
	
	@GET
	@Path("/incluir")
	@Produces("application/json")
	public Sala getProductInJSON() {
		
		Sala s = new Sala();
		
		s.setId(1);
		s.setDescricao("Sala 1, 200 lugares");
		s.setDataCadastro("03/05/2018");
		s.setDataReserva("10/05/2018");
		s.setHora("19:45");
		
		try {
		Connection con = new JSONSala().getConnection();
		
        String sql = "INSERT INTO SALA" +
                " (id,descricao,datacadastro,datareserva,hora)" +
                " VALUES (?,?,?,?,?);";
        PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,s.getId());
		stmt.setString(2,s.getDescricao());
		stmt.setString(3,s.getDataCadastro());
		stmt.setString(4,s.getDataReserva());
		stmt.setString(5,s.getHora());
		
		stmt.execute();
	    stmt.close();
	        
	     System.out.println("Gravado!");
	      
	     con.close();
	     
	        
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		return s;
	}
	
	@POST
	@Path("/consultar")
	@Consumes("application/json")
	public Response createSalaInJSON(Sala sala) {
		
		String result = "Product created : " + sala;
		
		List<String> lstSala = new ArrayList<>();
		PreparedStatement ps;
		ResultSet rs;
		Connection con = new JSONSala().getConnection();
		try {
			ps = con.prepareStatement("SELECT id,descricao,datacadastro,datareserva,hora FROM SALA");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstSala.add("ID:"+rs.getInt("id") +" Descricao:" + rs.getString("descricao")+"  Data cadastro:" + rs.getString("datacadastro")+"  Data reserva:" + rs.getString("datareserva")+"  Hora:" +rs.getString("hora"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 System.out.println(lstSala);
		 
		 return Response.status(201).entity(result).build();
	}

	public Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/bdsala", "root", "cfdd4405");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
			e.printStackTrace();
        }	
        return null;
}
}
