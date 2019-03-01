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

import it.main.model.Astronauta;
import it.main.model.CapoProgetto;
import it.main.model.Meta;
import it.main.model.Mezzo;
import it.main.model.Missione;
import it.main.utils.UtilsDAONasa;


@WebServlet("/UpdateMissione")
public class UpdateMissione extends HttpServlet{
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMissione = Integer.parseInt(request.getParameter("idMissione"));
		Missione missione = dao.findMissione(idMissione);
		request.setAttribute("missione", missione);
		request.setAttribute("listaAstronauti", dao.getAstronauti());
		request.setAttribute("listaCapiProgetto", dao.getCapiProgetto());
		request.setAttribute("listaMete", dao.getMete());
		request.setAttribute("listaMezzi", dao.getMezzi());
		request.getRequestDispatcher("/WEB-INF/newMissione.jsp").forward(request, response);
	}
}