<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EnvironmentDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Environment</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="EnvironmentServlet?mode=environmentlist">Environment</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%EnvironmentDTO u = (EnvironmentDTO) request.getAttribute("dto");%>


<form id="floatleft" action="EnvironmentServlet?mode=update&id=<%=u.getId()%>" method="post" >
  <div class="row">
    <div class="col-25">
      <label for="nome">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="nome" name="nome" value=<%=u.getNome()%>>
    </div>
  </div>
  
      <button type="submit" >Edit</button>

</form>
	

<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>