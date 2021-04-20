
package br.com.bank.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/deleteServlet")

public class DeleteServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private ClientServiceImpl service;

		public DeleteServlet() {
			this.service = new ClientServiceImpl();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().append("Response to client").append(request.getContextPath());
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			long id = Long.parseLong(request.getParameter("id"));
			service.deleteById(id);
			RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
			rd.forward(request, response);
			
			
		


		}

	}



