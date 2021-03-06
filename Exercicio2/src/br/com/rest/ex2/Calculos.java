package br.com.rest.ex2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/calculos")
public class Calculos {

	// http://localhost:8080/Exercicio2/rest/calculos/tabuada/2
	// http://localhost:8080/Exercicio2/rest/calculos/perimetro/4/3/5/3
	// http://localhost:8080/Exercicio2/rest/calculos/perimetro/1/0/9/4
	// http://localhost:8080/Exercicio2/rest/calculos/perimetro/8/4/3/4

	@GET
	@Path("tabuada/{param}")
	public String tabuada(@PathParam("param") int x) {
		String saida = "";
		for (int i = 0; i <= 10; i++) {
			String out = String.valueOf(x * i);
			saida = saida + x + "*" + i + "=" + out + "<br>";
		}
		return saida;
	}

	@GET
	@Path("perimetro/{param1}/{param2}/{param3}/{param4}")
	public String perimetro(@PathParam("param1") double a, @PathParam("param2") double b, @PathParam("param3") double c, @PathParam("param4") double h) {
		/*
		 *        /\        |  
		 *       /  \       |  
		 *  b   /    \  a   |  h
		 *     /      \     | 
		 *    /        \    | 
		 *    ----------    |
		 *        c    
		 */
		
		
		
		/*
		 * Verificar se é um triângulo 
		 * | b - c | < a < b + c 
		 * | a - c | < b < a + c 
		 * | a - b | < c < a + b
		 */
		int cont = 0;

		if (Math.abs(b - c) < a && a < b + c) {
			cont = cont + 1;
		}

		if (Math.abs(a - c) < b && b < a + c) {
			cont = cont + 1;
		}

		if (Math.abs(a - b) < c && c < a + b) {
			cont = cont + 1;
		}

		if (cont < 3 || a==0 || b==0 || c==0 ) {
			return "Nao e um triangulo";
		} else {
			String out1 = String.valueOf(a + b + c);
			String out2 = String.valueOf((c*h)/2);
			return "O triangulo de lados("+a+", "+b+", "+c+ ") possui o perimetro " + out1 + " e a area " + out2;
		}
	}

}
