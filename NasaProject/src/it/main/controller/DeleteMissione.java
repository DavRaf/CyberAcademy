package it.main.controller;
import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Missione;
import it.main.utils.UtilsDAONasa;


@WebServlet("/DeleteMissione")
public class DeleteMissione extends HttpServlet{
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMissione = Integer.parseInt(request.getParameter("idMissione"));
		Missione missione = dao.findMissione(idMissione);
		dao.deleteMissione(missione);
	}
}