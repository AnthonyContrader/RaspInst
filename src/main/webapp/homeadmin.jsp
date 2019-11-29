<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.PacchettoDTO"
	import="it.contrader.dto.EnvironmentDTO"
	import="it.contrader.dto.PrezzoDTO"
	import="it.contrader.dto.FormatoDTO"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="EnvironmentServlet?mode=environmentlist">Environments</a>    <!--   per mettere il pulsante environment nella pagina principale-->
  <a href="PacchettoServlet?mode=pacchettolist">Pacchetti</a>
  <a href="PrezzoServlet?mode=prezzolist">Prezzi</a>
  <a href="FormatoServlet?mode=formatolist">Formati</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>

" benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst "
" benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst "
" benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst  benvenuto in raspinst "
</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>