<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="katugallup.model.Kysymys"%>
<jsp:useBean id="kysymykset" type="java.util.ArrayList<Kysymys>" scope="request" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Katugalluptyylit.css" type="text/css"/>

<title>Listaa kysymykset</title>
</head>
<body>

<div class="ylapalkki">
	<h1>Maailman hienoin katugallup</h1>
</div>

<div class="kysymyspalkki">
	<h2>Valitse kysymys, johon haluat vastata.</h2>
	<table>
		<%for(int i = 0; i < kysymykset.size(); i++) {%>
		<tr>
			<td><%=kysymykset.get(i).getId()%></td><td><a href="LisaaVastaus"><%=kysymykset.get(i).getKysymysteksti()%></a></td>
		</tr>
		<%}%>
	</table>
	
</div>

</body>
</html>