<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
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
	<body>
		<h2>Home Page</h2><br>
		<table>
		    <thead>
		        <tr>
		        	<th>Operazioni</th>
		        </tr>
		    </thead>
		   	<tbody>
	       		<tr>
			        <td><form action="NewMissione" method="get"><input type="submit" value="Nuova missione"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="newAstronauta.jsp" method="get"><input type="submit" value="Nuovo astronauta"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="newCapoProgetto.jsp" method="get"><input type="submit" value="Nuovo capo progetto"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="newMezzo.jsp" method="get"><input type="submit" value="Nuovo mezzo"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="NewAstronauta" method="get"><input type="submit" value="Mostra astronauti"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="NewCapoProgetto" method="get"><input type="submit" value="Mostra capi progetto"></form></td>
	       		</tr>
	       		<tr>
			        <td><form action="NewMezzo" method="get"><input type="submit" value="Mostra mezzi"></form></td>
	       		</tr>
		    </tbody>
		</table>
	</body>
</html>