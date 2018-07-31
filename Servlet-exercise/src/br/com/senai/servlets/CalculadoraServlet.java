package br.com.senai.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculadoraServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse rep) {

		Integer n1 = Integer.parseInt(req.getParameter("n1"));
		Integer n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("operacao");
		Integer result;

		switch (op) {

		case "soma":
			result = n1 + n2;
			System.out.println(result);
			break;

		case "subtração":
			result = n1 - n2;
			System.out.println(result);
			break;

		case "divisão":
			result = n1 / n2;
			System.out.println(result);
			break;

		case "multiplicacao":
			result = n1 * n2;
			System.out.println(result);
			break;

		}

	}

}
