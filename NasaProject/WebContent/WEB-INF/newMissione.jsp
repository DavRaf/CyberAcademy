<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.main.model.Missione" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Missione missione = (Missione) request.getAttribute("missione"); 
   boolean isAggiornamento = false;
   int missioneId = 0;
   if (missione != null){
	   isAggiornamento = true;
	   missioneId = missione.getId();
   }
   %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Missione</title>
<style>
$("#capo_progetto").val(${capo_progetto.getNome()} ${capo_progetto.getCognome()});
</style>
</head>
<body>
<form action="NewMissione" method="post">
  <p><label>INSERIRE DATI MISSIONE<br /><br/></label></p>
  <label>NOME<br></label><input type="text" name="nome" value="${missione.getNome()}"/><br />
  <label>DESCRIZIONE<br></label><input type="text" name="descrizione" value="${missione.getDescrizione()}" /><br />
  <label>ASTRONAUTI<br></label>
  <select name = "astronauti" id="astronauti" multiple>
  	  <c:forEach items="${listaAstronauti}" var="astronauta">
	  	<option value="${astronauta.getId()}" <c:forEach items="${missione.getAstronauti()}" var="astronauti_missione"><c:if test="${astronauta.getId() == astronauti_missione.getId()}">selected</c:if></c:forEach>>${astronauta.getNome()} ${astronauta.getCognome()}</option>
	  </c:forEach>
  </select><br />
  <label>CAPO PROGETTO<br></label>
  <select name = "capo_progetto" id="capo_progetto">
  	<c:forEach items="${listaCapiProgetto}" var="capo_progetto">
	  <option value="${capo_progetto.getId()}" <c:if test="${capo_progetto.getId() == missione.getCapoProgetto().getId()}">selected</c:if>><c:out value="${capo_progetto.getNome()} ${capo_progetto.getCognome()}" /></option>
	</c:forEach>
  </select><br />
  <label>META<br></label>
  <select name = "meta" id="meta">
  	  <c:forEach items="${listaMete}" var="meta">
	  	<option value="${meta.getId()}" <c:if test="${meta.getId() == missione.getMeta().getId()}">selected</c:if>>${meta.getNome()}</option>
	  </c:forEach>
  </select><br />
  <label>MEZZO<br></label>
  <select name = "mezzo" id="mezzo">
  	  <c:forEach items="${listaMezzi}" var="mezzo">
	  	<option value="${mezzo.getId()}" <c:if test="${mezzo.getId() == missione.getMezzo().getId()}">selected</c:if>>${mezzo.getNome()}</option>
	  </c:forEach>
  </select><br />
  <input type="hidden" name="aggiornamento" value="<%= isAggiornamento %>"/>
  <input type="hidden" name="missioneId" value="<%= missioneId %>"/>
  <input type="submit" value="Salva">
</form>
</body>
</html>
