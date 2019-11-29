<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PacchettoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Pacchetto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="PacchettoServlet?mode=pacchettolist">Pacchetti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%PacchettoDTO p = (PacchettoDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>nome</th>
		<th>categoria</th>
		<th>versione</th>
		<th>data</th>
	</tr>
	<tr>
		<td><%=p.getNome()%></td>
		<td> <%=p.getCategoria()%></td>
		<td> <%=p.getVersione()%></td>
		<td> <%=p.getData()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>
<%@ include file="../css/footer.jsp" %>
</body>
</html>