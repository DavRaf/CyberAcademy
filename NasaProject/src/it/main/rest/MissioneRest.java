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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.main.model.Missione;
import it.main.utils.UtilsDAONasa;

@Path("/missione")
public class MissioneRest {
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@POST
	@Path("/postMissione")
	@Consumes("application/json")
	public Response newMissione(Missione missione) {
		try {
			dao.newMissione(missione);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getMissioni")
	@Consumes("application/json")
	public Response getMissioni() {
		try {
			ArrayList<Missione> missioni =  (ArrayList<Missione>) dao.getMissioni();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(missioni);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getMissioniWhereMetaEqualsToGivenMeta/{idMeta}/{idCapoProgetto}")
	@Consumes("application/json")
	public Response getMissioniWhereMetaEqualsToGivenMetaAndCapo(@PathParam("idMeta") String idMeta, @PathParam("idCapoProgetto") String idCapoProgetto) {
		try {
			ArrayList<Missione> missioni =  (ArrayList<Missione>) dao.getMissioniWhereMetaEqualsToGivenMetaAndCapo(idMeta, idCapoProgetto);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(missioni);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@PUT
	@Path("/putMessione")
	@Consumes("application/json")
	public Response updateAstronauta(Missione missione) {
		try {
			dao.updateMissione(missione);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@DELETE
	@Path("/deleteMissione")
	@Consumes("application/json")
	public Response deleteMissione(Missione missione) {
		try {
			dao.deleteMissione(missione);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	

}
