<%@ page import="it.contrader.dto.PacchettoDTO" 
import="java.util.*"
import="it.contrader.dto.CategoryDTO"
import="it.contrader.dto.FormatoDTO"
import="it.contrader.dto.ValutazioneDTO"
import="it.contrader.dto.EnvironmentDTO"
%>
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
			 <a href=/category/getall>Categorie</a>
		 <a href=/pacchetto/getall>Formato</a>
		 <a href=/environment/getall>Environment</a>
		 <a href=/valutazione/getall>Valutazione</a>	
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<PacchettoDTO> list = (List<PacchettoDTO>) request.getSession().getAttribute("list");
			List<CategoryDTO> listCategory=(List<CategoryDTO>) request.getSession().getAttribute("category");
			List<FormatoDTO> listFormato=(List<FormatoDTO>) request.getSession().getAttribute("formato");
			List<ValutazioneDTO> listValutazione=(List<ValutazioneDTO>) request.getSession().getAttribute("valutazione");
			List<EnvironmentDTO> listEnvironment=(List<EnvironmentDTO>) request.getSession().getAttribute("environment");
		%>

		<br>
		
		<table>
			<tr>
				<th>Nome</th>
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
     				<label for="versione">Versione</label>
    			</div>
    			<div class="col-75">
      		<input type="text" id="versione" name="versione"
					placeholder="inserisci versione">
    			</div>
    		</div>
    		<div class="row">
				<div class="col-25">
					<label for="environment">Environment</label>
				</div>
				<div class="col-75">
					<select id="environment" name="environment">
						<%for(EnvironmentDTO e: listEnvironment){ %>
								<option value='<%=e.getId()%>'><%=e.getNome()%></option>
								<%} %>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="formato">Formato</label>
				</div>
				<div class="col-75">
					<select id="formato" name="formato">
						<%for(FormatoDTO f: listFormato){ %>
								<option value='<%=f.getId()%>'><%=f.getTipoFormato()%></option>
								<%} %>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="type">Category</label>
				</div>
				<div class="col-75">
					<select id="category" name="category">
						<%for(CategoryDTO c:listCategory){ %>
								<option value='<%=c.getId()%>'><%=c.getCategoria()%></option>
								<%} %>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="valutazione">Valutazione</label>
				</div>
				<div class="col-75">
					<select id="valutazione" name="valutazione">
						<%for(ValutazioneDTO v: listValutazione){ %>
								<option value='<%=v.getId()%>'><%=v.getVoto()%></option>
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