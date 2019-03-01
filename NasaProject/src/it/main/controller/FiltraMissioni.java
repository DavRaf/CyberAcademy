package it.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Missione;
import it.main.utils.UtilsDAONasa;

/**
 * Servlet implementation class FiltraMissioni
 */
@WebServlet("/FiltraMissioni")
public class FiltraMissioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltraMissioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/filterMissioni.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeMissione = request.getParameter("nome_missione");
		String nomeMezzo = request.getParameter("nome_mezzo");
		String nomeMeta = request.getParameter("nome_meta");
		String cognomeAstronauta = request.getParameter("cognome_astronauta");
		String cognomeCapoProgetto = request.getParameter("cognome_capo_progetto");
		request.setAttribute("listaMissioni", dao.getMissioniFilterBy(nomeMissione, nomeMezzo, nomeMeta, cognomeAstronauta, cognomeCapoProgetto));
		request.getRequestDispatcher("/WEB-INF/filterMissioni.jsp").forward(request, response);
		
	}

}
