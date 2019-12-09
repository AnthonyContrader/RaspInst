<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.PacchettoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Pacchetto Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Pacchetto</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/pacchetto/getall">Pacchetto</a>
  <a href="/pacchetto/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%PacchettoDTO u = (PacchettoDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/pacchetto/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="pacchetto">Nome</label>
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
      <label for="Versione">Versione</label>
    </div>
   		 <div class="col-75">
    	<input 
    		type="text" id="versione" name="versione" value =<%=u.getVersione() %>>
   	</div>
   </div>
    
      <button type="submit" >Edit</button>
	</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>