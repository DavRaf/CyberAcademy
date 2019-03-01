package it.main.controller;
import java.io.IOException;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.CapoProgetto;
import it.main.utils.UtilsDAONasa;


@WebServlet("/NewCapoProgetto")
public class NewCapoProgetto extends HttpServlet{
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaCapiProgetto", dao.getCapiProgetto());
		request.getRequestDispatcher("/WEB-INF/viewCapiProgetto.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		CapoProgetto capoProgetto = new CapoProgetto(nome, cognome);
		try {
			dao.newCapoProgetto(capoProgetto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaCapiProgetto", dao.getCapiProgetto());
		request.getRequestDispatcher("/WEB-INF/viewCapiProgetto.jsp").forward(request, response);	}
	
	
	

}
