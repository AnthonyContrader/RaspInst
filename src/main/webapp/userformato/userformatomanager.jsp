<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.FormatoDTO"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Formato Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="FormatoServlet?mode=formatolist">Formati</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<FormatoDTO> list = (List <FormatoDTO>) request.getAttribute("list");
    %>
	<br>

	<table>
		<tr>
			<th>tipoFormato</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (FormatoDTO u : list) {
		%>
		<tr>
			<td><a href=FormatoServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTipoFormato()%>
			</a></td>
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