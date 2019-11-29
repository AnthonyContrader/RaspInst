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
  <a  href="homeadmin.jsp">Home</a>
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
			<td><a href=PrezzoServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=PrezzoServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="PrezzoServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="costo">Costo</label>
    </div>
    <div class="col-75">
      <input type="text" id="costo" name="costo" placeholder="inserisci costo">
    </div>
  </div>
       <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>