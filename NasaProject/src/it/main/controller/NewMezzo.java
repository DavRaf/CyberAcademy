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

import it.main.model.Mezzo;
import it.main.utils.UtilsDAONasa;


@WebServlet("/NewMezzo")
public class NewMezzo extends HttpServlet{
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaMezzi", dao.getMezzi());
		request.getRequestDispatcher("/WEB-INF/viewMezzi.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome= request.getParameter("nome");
		String descrizione= request.getParameter("descrizione");
		Mezzo mezzo = new Mezzo(nome, descrizione);
		try {
			dao.newMezzo(mezzo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaMezzi", dao.getMezzi());
		request.getRequestDispatcher("/WEB-INF/viewMezzi.jsp").forward(request, response);

	}
}
