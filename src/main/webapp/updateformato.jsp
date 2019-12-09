<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.FormatoDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Formato Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Formato</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/formato/getall">Formato</a>
  <a href="/formato/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%FormatoDTO u = (FormatoDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/formato/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="formato">Formato</label>
    </div>
    <div class="col-75">
      <input type="text" id="formato" name="tipoformato" value=<%=u.getTipoFormato()%>>
    </div>
    <input type="hidden" name="id" value =<%=u.getId() %>>
  </div>
      	
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>