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
<h2>Tabella Capi Progetto</h2><br>
<table>
    <thead>
        <tr>
        	<th>Nome</th>
        	<th>Cognome</th>
        </tr>
    </thead>
   	<tbody>
        <c:forEach items="${listaCapiProgetto}" var="current">
        		<tr>
			        <td><c:out value="${current.getNome()}" /></td>
			        <td><c:out value="${current.getCognome()}" /></td>
        		</tr>
      </c:forEach>
    </tbody>
</table>
<br><br>
<h2>Tabella Capi Progetto - Missioni</h2><br>
<table>
    <thead>
        <tr>
        	<th>Nome Capo Progetto</th>
        	<th>Cognome Capo Progetto</th>
        	<th>Nome Missione</th>
        	<th>Descrizione Missione</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listaCapiProgetto}" var="current">
        	<c:forEach items="${current.getMissioni()}" var="missione">
        		<tr>
			        <td><c:out value="${current.getNome()}" /></td>
			        <td><c:out value="${current.getCognome()}" /></td>
		          	<td><c:out value="${missione.getNome()}" /></td>
		            <td><c:out value="${missione.getDescrizione()}" /></td>
        		</tr>
         	</c:forEach>
      </c:forEach>
    </tbody>

</table>

    
</body>
</html>