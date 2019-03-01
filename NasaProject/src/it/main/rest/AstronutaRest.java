package it.main.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.main.model.Astronauta;
import it.main.utils.UtilsDAONasa;

@Path("/astronauta")
public class AstronutaRest {
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@POST
	@Path("/postAstronauta")
	@Consumes("application/json")
	public Response newAstronauta(Astronauta astronauta) {
		try {
			dao.newAstronauta(astronauta);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getAstronauti")
	@Consumes("application/json")
	public Response getAstronauti() {
		try {
			ArrayList<Astronauta> astronauti =  (ArrayList<Astronauta>) dao.getAstronauti();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(astronauti);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@PUT
	@Path("/putAstronauta")
	@Consumes("application/json")
	public Response updateAstronauta(Astronauta astronauta) {
		try {
			dao.updateAstronauta(astronauta);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@DELETE
	@Path("/deleteAstronauta")
	@Consumes("application/json")
	public Response deleteAstronauta(Astronauta astronauta) {
		try {
			dao.deleteAstronauta(astronauta);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	

}
