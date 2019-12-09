<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ValutazioneDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Valutazione Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Valutazione</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/valutazione/getall">Valutazione</a> <a href="/valutazione/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
		ValutazioneDTO u = (ValutazioneDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>mediaVoto</th>
				<th>voto</th>
				<th></th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getMediaVoto()%></td>
				<td><%=u.getVoto()%></td>
				</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>