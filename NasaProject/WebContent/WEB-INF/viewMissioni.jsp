<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>Tabella Missioni</h2><br>
<table id="myTable">
    <thead>
        <tr>
        	<th>Nome</th>
        	<th>Descrizione</th>
        	<th>Astronauta</th>
        	<th>Capo Progetto</th>
        	<th>Meta</th>
        	<th>Mezzo</th>
        </tr>
    </thead>
    <tbody>
	        <c:forEach items="${listaMissioni}" var="missione">
	        	<c:forEach items="${missione.getAstronauti()}" var="astronauta">
	        		<tr>
				        <td><c:out value="${missione.getNome()}" /></td>
				        <td><c:out value="${missione.getDescrizione()}" /></td>
				        <td><c:out value="${astronauta.getNome()} ${astronauta.getCognome()}" /></td>
			          	<td><c:out value="${missione.getCapoProgetto().getNome()} ${missione.getCapoProgetto().getCognome()}" /></td>
			            <td><c:out value="${missione.getMeta().getNome()}" /></td>
			            <td><c:out value="${missione.getMezzo().getNome()}" /></td>
			            <td><form action="UpdateMissione" method="post">
			            <input type="hidden" name="idMissione" value="${missione.getId()}"/>
			            <input type="submit" value="Update"></form></td>
			            <td><form action="DeleteMissione" method="post">
			            <input type="hidden" name="idMissione" value="${missione.getId()}"/>
			            <input type="submit" value="Delete"></form></td>
        			</tr>
         	</c:forEach>
      </c:forEach>
    </tbody>

</table>
</body>
</html>