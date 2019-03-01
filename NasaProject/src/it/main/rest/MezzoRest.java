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

import it.main.model.Mezzo;
import it.main.utils.UtilsDAONasa;

@Path("/mezzo")
public class MezzoRest {
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@POST
	@Path("/postMezzo")
	@Consumes("application/json")
	public Response newMezzo(Mezzo mezzo) {
		try {
			dao.newMezzo(mezzo);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getMezzi")
	@Consumes("application/json")
	public Response getMezzi() {
		try {
			ArrayList<Mezzo> mezzi =  (ArrayList<Mezzo>) dao.getMezzi();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(mezzi);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@PUT
	@Path("/putMezzo")
	@Consumes("application/json")
	public Response updateMezzo(Mezzo mezzo) {
		try {
			dao.updateMezzo(mezzo);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@DELETE
	@Path("/deleteMezzo")
	@Consumes("application/json")
	public Response deleteMezzo(Mezzo mezzo) {
		try {
			dao.deleteMezzo(mezzo);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	

}
