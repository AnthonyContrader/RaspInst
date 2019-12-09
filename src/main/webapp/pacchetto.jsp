<%@ page import="it.contrader.dto.PacchettoDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Pacchetto Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Pacchetto Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/pacchetto/getall">Pacchetto</a> <a href="/pacchetto/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<PacchettoDTO> list = (List<PacchettoDTO>) request.getSession().getAttribute("list");
		%>

		<br>
		
		<table>
			<tr>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Versione</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (PacchettoDTO u : list) {
			%>
			<tr>
				<td><a href="/pacchetto/read?id=<%=u.getId()%>"> <%=u.getNome()%>
				</a></td>
				<td><%=u.getCategoria()%></td>
				<td><%=u.getVersione()%></td>
				<td><a href="/pacchetto/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/pacchetto/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>
		
		<form id="floatright" action="/pacchetto/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="nome">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="pacchetto" name="nome"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="categoria">Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="categoria" name="categoria"
						placeholder="inserisci categoria">
				</div>
			</div>
			
			<div class="row">
   				 <div class="col-25">
     				<label for="versione">Versione</label>
    			</div>
    			<div class="col-75">
      		<input type="text" id="versione" name="versione"
					placeholder="inserisci versione">
    			</div>
    		</div>
    		
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>

		
