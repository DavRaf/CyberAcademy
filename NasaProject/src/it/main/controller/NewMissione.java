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


@WebServlet("/NewMissione")
public class NewMissione extends HttpServlet{
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaAstronauti", dao.getAstronauti());
		request.setAttribute("listaCapiProgetto", dao.getCapiProgetto());
		request.setAttribute("listaMete", dao.getMete());
		request.setAttribute("listaMezzi", dao.getMezzi());
		request.getRequestDispatcher("/WEB-INF/newMissione.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isAggiornamento = Boolean.parseBoolean(request.getParameter("aggiornamento"));
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String[] idAstronauti = request.getParameterValues("astronauti");
		Set<Astronauta> astronauti = new HashSet<>();
		for (String idAstronauta : idAstronauti){
			Astronauta astronauta = dao.findAstronauta(Integer.parseInt(idAstronauta));
			astronauti.add(astronauta);
		}
		String idCapoProgetto = request.getParameter("capo_progetto");
		String idMeta = request.getParameter("meta");
		String idMezzo = request.getParameter("mezzo");
		CapoProgetto capoProgetto = dao.findCapoProgetto(Integer.parseInt(idCapoProgetto));
		Meta meta = dao.findMeta(Integer.parseInt(idMeta));
		Mezzo mezzo = dao.findMezzo(Integer.parseInt(idMezzo));
		if (isAggiornamento == true){
			System.out.println("yes");
			int missioneId = Integer.parseInt(request.getParameter("missioneId"));
			Missione missione = dao.findMissione(missioneId);
			missione.setNome(nome);
			missione.setDescrizione(descrizione);
			missione.setAstronauti(astronauti);
			missione.setCapoProgetto(capoProgetto);
			missione.setMeta(meta);
			missione.setMezzo(mezzo);
			dao.updateMissione(missione);
		}
		else {
			Missione missione = new Missione(nome, descrizione);
			missione.setAstronauti(astronauti);
			missione.setCapoProgetto(capoProgetto);
			missione.setMeta(meta);
			missione.setMezzo(mezzo);
			try {
				dao.newMissione(missione);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//request.setAttribute("listaMissioni", dao.getMissioni());
		//request.setAttribute("listaMissioni", dao.getMissioniWhereMetaEqualsToGivenMetaAndCapo(idMeta, idCapoProgetto));
		request.setAttribute("listaMissioni", dao.getMissioni());
		request.getRequestDispatcher("/WEB-INF/viewMissioni.jsp").forward(request, response);
	}
}