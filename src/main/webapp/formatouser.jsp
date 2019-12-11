<%@ page import="it.contrader.dto.FormatoDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Formato Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Formato Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeuser.jsp">Home</a> <a class="active"
			href="/formatouser/getall">Formato</a> <a href="/formatouser/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<FormatoDTO> list = (List<FormatoDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>tipoFormato</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (FormatoDTO u : list) {
			%>
			<tr>
				<td><a href="/formato/read?id=<%=u.getId()%>"> <%=u.getTipoFormato()%>
				</a></td>
				
			</tr>
			<%
				}
			%>
		</table>



		
	</div>	
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>