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
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientServiceImpl service;

	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Response to client").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);

		if (this.service.save(client) == true) {
			RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
			request.setAttribute("user", email);
			rd.forward(request, response);

		} 
		else {

			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "Não foi posssível cadastrar, email ou telefone já cadastrados.");
			rd.forward(request, response);
		}
		
		
	


	}

}
