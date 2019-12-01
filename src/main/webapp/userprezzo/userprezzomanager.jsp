<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PrezzoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Prezzo Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeuser.jsp">Home</a>
  <a class="active" href="PrezzoServlet?mode=prezzolist">Prezzo</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<PrezzoDTO> list = (List<PrezzoDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Costo</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (PrezzoDTO u : list) {
		%>
		<tr>
			<td><a href=PrezzoServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getCosto()%>
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