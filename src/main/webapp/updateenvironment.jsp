<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Environment Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Environment</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/environment/getall">Environment</a>
  <a href="/environment/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%EnvironmentDTO u = (EnvironmentDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/environment/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="environment">Environment</label>
    </div>
    <div class="col-75">
      <input type="text" id="environment" name="nome" value=<%=u.getNome()%>>
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