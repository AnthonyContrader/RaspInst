<%@ page import="it.contrader.dto.EnvironmentDTO" 
import="it.contrader.dto.UserDTO"
import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Environment Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Environment Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/environment/getall">Environment</a> <a href="/environment/logout" id="logout">Logout</a>
			 <a href=/category/getall>Categorie</a>
		 <a href=/pacchetto/getall>Pacchetto</a>
		 <a href=/environment/getall>Formato</a>
		 <a href=/valutazione/getall>Valutazione</a>	
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<EnvironmentDTO> list = (List<EnvironmentDTO>) request.getSession().getAttribute("list");
			List<UserDTO> listUser=(List<UserDTO>) request.getSession().getAttribute("user");
		%>

		<br>

		<table>
			<tr>
				<th>Nome</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (EnvironmentDTO u : list) {
			%>
			<tr>
				<td><a href="/environment/read?id=<%=u.getId()%>"> <%=u.getNome()%>
				</a></td>
				<td><a href="/environment/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/environment/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		
		<form id="floatright" action="/environment/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="environment">Environment</label>
				</div>
				<div class="col-75">
					<input type="text" id="environment" name="nome"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">User</label>
				</div>
				<div class="col-75">
					<select id="user" name="user">
						<%for(UserDTO v: listUser){ %>
								<option value='<%=v.getId()%>'><%=v.getUsername()%></option>
						<%} %>
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