<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PacchettoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Pacchetto Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="PacchettoServlet?mode=pacchettolist">Pacchetto</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<PacchettoDTO> list = (List<PacchettoDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>nome</th>
			<th>categoria</th>
			<th>versione</th>
			<th>data</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PacchettoDTO p : list) {
		%>
		<tr>
			<td><a href=PacchettoServlet?mode=read&id=<%=p.getId()%>>
					<%=p.getNome()%>
			</a></td>
			<td><%=p.getCategoria()%></td>
			<td><%=p.getVersione()%></td>
			<td><%=p.getData()%></td>
			

		</tr>
		<%
			}
		%>
	</table>
	</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>