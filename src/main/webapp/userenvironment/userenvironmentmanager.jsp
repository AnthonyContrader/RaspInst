<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Environment Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="EnvironmentServlet?mode=environmentlist">Environment</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EnvironmentDTO> list = (List<EnvironmentDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Nome</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (EnvironmentDTO u : list) {
		%>
		<tr>
			<td><a href=EnvironmentServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getNome()%>
			</a></td>

		</tr>
		<%
			}
		%>
	</table>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>