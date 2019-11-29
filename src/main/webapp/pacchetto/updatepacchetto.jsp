<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.contrader.dto.PacchettoDTO"%>%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Pacchetto</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="PacchettoServlet?mode=Pacchettolist">Pacchetti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">

<%PacchettoDTO u = (PacchettoDTO) request.getAttribute("dto");%>


<form id="floatleft" action="PacchettoServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" value=<%=u.getNome()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="categoria">Categoria</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="categoria" name="categoria" value=<%=u.getCategoria()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="versione">Versione</label>
    </div>
   		  <div class="col-75">
      <input
			type="text" id="versione" name="versione" value=<%=u.getVersione()%>> 
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label for="data">Data</label>
    </div>
   		  <div class="col-75">
      <input
			type="text" id="data" name="data" value=<%=u.getData()%>> 
    </div>
  </div>
   <button type="submit" >Edit</button>
</form>
 </div>
 
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>