<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.PacchettoDTO"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Pacchetto Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="PacchettoServlet?mode=pacchettolist">Pacchetti</a>
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
			<td><a href=PacchettoServlet?mode=read&update=true&id=<%=p.getId()%>>Edit</a>
			</td>
			<td><a href=PacchettoServlet?mode=delete&id=<%=p.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
<form id="floatright" action="PacchettoServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" placeholder="inserisci username">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="categoria">Categoria</label>
    </div>
    <div class="col-75">
      <input type="text" id="categoria" name="categoria" placeholder="inserisci categoria"> 
    </div>
  </div>
  	  <div class="row">
    <div class="col-25">
      <label for="versione">Versione</label>
    </div>
    <div class="col-75">
      <input type="text" id="versione" name="versione" placeholder="inserisci versione">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="data">Data</label>
    </div>
    <div class="col-75">
      <input type="text" id="data" name="data" placeholder="inserisci data"> 
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>