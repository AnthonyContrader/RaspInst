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
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="FormatoServlet?mode=formatolist">Formati</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<FormatoDTO> list = (List<FormatoDTO>) request.getAttribute("list");
    %>
	<br>

	<table>
		<tr>
			<th>tipoFormato</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (FormatoDTO p : list) {
		%>
		<tr>
			<td><a href=FormatoServlet?mode=read&id=<%=p.getId()%>>
					<%=p.getTipoFormato()%>
			</a></td>
			<td><a href=FormatoServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=FormatoServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="FormatoServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tipoformato">tipoFormato</label>
    </div>
    <div class="col-75">
      <input type="text" id="tipoformato" name="tipoformato" placeholder="inserisci il tipo del formato">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>