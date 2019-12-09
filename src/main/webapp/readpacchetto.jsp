<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.PacchettoDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Pacchetto Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Pacchetto</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/pacchetto/getall">Pacchetto</a> <a href="/pacchetto/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			PacchettoDTO u = (PacchettoDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Versione</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getNome()%></td>
				<td><%=u.getCategoria()%></td>
				<td><%=u.getVersione()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>