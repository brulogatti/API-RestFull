package br.com.rest.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/imc")
public class Imc {
	
	//http://localhost:8080/Exercicio3/rest/imc/calcular/Bruna/22/60/1.60
	//http://localhost:8080/Exercicio3/rest/imc/mostrar
	
	@GET
	@Path("calcular/{param1}/{param2}/{param3}/{param4}")
	public String calcular(@PathParam ("param1") String nome,  @PathParam ("param2") int idade, @PathParam ("param3") double peso, @PathParam ("param4") double altura) {
		double imc = peso/(altura*altura);
		String imce="";
		imce=String.valueOf(imc);
		
		try {
		Connection con = new Imc().getConnection();
		
        String sql = "INSERT INTO IMC" +
                " (nome,idade,peso,altura,imc)" +
                " VALUES (?,?,?,?,?);";
        PreparedStatement stmt = con.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, nome);
        stmt.setInt(2, idade);
        stmt.setDouble(3, peso);
        stmt.setDouble(4, altura);
        stmt.setDouble(5, imc);

        // executa
        stmt.execute();
        stmt.close();
        
        System.out.println("Gravado!");
        
		con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Seu IMC e de " + imce;
		
	}
	
	@GET
	@Path("mostrar")
	public List<String> mostrar() {
		List<String> lstIMC = new ArrayList<>();
		PreparedStatement ps;
		ResultSet rs;
		Connection con = new Imc().getConnection();
		try {
			ps = con.prepareStatement("SELECT nome, idade, peso, altura, imc FROM IMC");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstIMC.add("Nome:"+rs.getString("nome") +" Idade:" + rs.getInt("idade")+"anos  Peso:" + rs.getDouble("peso")+"kg  Altura:" + rs.getDouble("altura")+"m  IMC:" +rs.getDouble("imc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstIMC;
	}
	
	public Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/bdimc", "root", "cfdd4405");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
			e.printStackTrace();
        }	
        return null;
    }
}

