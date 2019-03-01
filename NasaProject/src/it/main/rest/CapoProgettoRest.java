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

import it.main.model.CapoProgetto;
import it.main.utils.UtilsDAONasa;

@Path("/capoProgetto")
public class CapoProgettoRest {
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@POST
	@Path("/postCapoProgetto")
	@Consumes("application/json")
	public Response newCapoProgetto(CapoProgetto capoProgetto) {
		try {
			dao.newCapoProgetto(capoProgetto);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getCapiProgetto")
	@Consumes("application/json")
	public Response getCapiProgetto() {
		try {
			ArrayList<CapoProgetto> capiProgetto =  (ArrayList<CapoProgetto>) dao.getCapiProgetto();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(capiProgetto);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@PUT
	@Path("/putCapoProgetto")
	@Consumes("application/json")
	public Response updateCapoProgetto(CapoProgetto capoProgetto) {
		try {
			dao.updateCapoProgetto(capoProgetto);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@DELETE
	@Path("/deleteCapoProgetto")
	@Consumes("application/json")
	public Response deleteCapoProgetto(CapoProgetto capoProgetto) {
		try {
			dao.deleteCapoProgetto(capoProgetto);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	

}
