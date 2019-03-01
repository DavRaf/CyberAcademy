package it.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.main.model.Missione;
import it.main.utils.UtilsDAONasa;

/**
 * Servlet implementation class ViewMissioniAstronauti
 */
@WebServlet("/ViewMissioniAstronauti")
public class ViewMissioniAstronauti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMissioniAstronauti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaMissioni", dao.getMissioniJoinAstronauti());
		request.getRequestDispatcher("/WEB-INF/viewMissioniAstronauti.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
