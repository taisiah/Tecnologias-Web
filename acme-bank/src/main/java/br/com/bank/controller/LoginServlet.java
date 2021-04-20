package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.dao.ClientDao;
import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;
import br.com.bank.service.ClientService;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		if(email.equals("taisiahonorio@gmail.com") && pass.equals("123")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
			request.setAttribute("user",email);
			rd.forward(request, response);
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("erroLogin.jsp");
			request.setAttribute("error", "Erro, login ou senha inválidos");
			rd.forward(request, response);
		}
		
	}

}
