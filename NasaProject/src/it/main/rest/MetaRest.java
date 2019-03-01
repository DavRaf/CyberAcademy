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

import it.main.model.Meta;
import it.main.utils.UtilsDAONasa;

@Path("/meta")
public class MetaRest {
	
	private UtilsDAONasa dao = UtilsDAONasa.getInstance();
	
	@POST
	@Path("/postMeta")
	@Consumes("application/json")
	public Response newMeta(Meta meta) {
		try {
			dao.newMeta(meta);
			return Response.status(200).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@GET
	@Path("/getMete")
	@Consumes("application/json")
	public Response getMete() {
		try {
			ArrayList<Meta> mete =  (ArrayList<Meta>) dao.getMete();
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(mete);
			return Response.status(200).entity(jsonInString).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@PUT
	@Path("/putMeta")
	@Consumes("application/json")
	public Response updateMeta(Meta meta) {
		try {
			dao.updateMeta(meta);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	@DELETE
	@Path("/deleteMetta")
	@Consumes("application/json")
	public Response deleteMeta(Meta meta) {
		try {
			dao.deleteMeta(meta);
			return Response.status(200).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(405).build();
	}
	
	

}
