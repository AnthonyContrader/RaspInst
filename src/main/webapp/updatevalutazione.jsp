<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ValutazioneDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Valutazione Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Valutazione</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/valutazione/getall">Valutazione</a>
  <a href="/valutazione/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ValutazioneDTO u = (ValutazioneDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/valutazione/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="valutazione">Media voto</label>
    </div>
    <div class="col-75">
      <input type="text" id="valutazione" name="mediavoto" value=<%=u.getMediaVoto()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Voto</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="voto">
  				<option value="UNO" <%if(u.getVoto().toString().equals("UNO")) {%>selected<%}%>>UNO</option>
  				<option value="DUE" <%if(u.getVoto().toString().equals("UNO")) {%>selected<%}%>>DUE</option>
  				<option value="TRE" <%if(u.getVoto().toString().equals("UNO")) {%>selected<%}%>>TRE</option>
  				<option value="QUATTRO" <%if(u.getVoto().toString().equals("UNO")) {%>selected<%}%>>QUATTRO</option>
  				<option value="CINQUE" <%if(u.getVoto().toString().equals("UNO")) {%>selected<%}%>>CINQUE</option>
  			</select>
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