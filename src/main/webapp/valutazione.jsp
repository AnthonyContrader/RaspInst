<%@ page import="it.contrader.dto.ValutazioneDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Valutazione Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Valutazione Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/valutazione/getall">Valutazione</a> <a href="/valutazione/logout" id="logout">Logout</a>
			 <a href=/category/getall>Categorie</a>
		 <a href=/pacchetto/getall>Pacchetto</a>
		 <a href=/environment/getall>Environment</a>
		 <a href=/formato/getall>Formato</a>	
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ValutazioneDTO> list = (List<ValutazioneDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>mediaVoto</th>
				<th>valutazione</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ValutazioneDTO u : list) {
			%>
			<tr>
				<td><a href="/valutazione/read?id=<%=u.getId()%>"> <%=u.getMediaVoto()%>
				</a></td>
				<td><%=u.getVoto()%></td>
				
				<td><a href="/valutazione/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/valutazione/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/valutazione/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="mediavoto">mediaVoto</label>
				</div>
				<div class="col-75">
					<input type="text" id="mediavoto" name="mediavoto"
						placeholder="inserisci media voto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Voto</label>
				</div>
				<div class="col-75">
					<select id="type" name="voto">
						<option value="UNO">UNO</option>
						<option value="DUE">DUE</option>
						<option value="TRE">TRE</option>
						<option value="QUATTRO">QUATTRO</option>
						<option value="CINQUE">CINQUE</option>
					</select>
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

		
	</div>	
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>