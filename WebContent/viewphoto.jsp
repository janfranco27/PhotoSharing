<%@page import="com.unsa.PhotoSharing.Business.ViewPhotoManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.unsa.PhotoSharing.Controller.*" %>
<%@ page import="com.unsa.PhotoSharing.persistence.entity.*" %>
<%@ page import="com.unsa.PhotoSharing.Business.*" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/ventanas-modales.css">

</head>
<body>
<%

ViewPhotoManager manager = new ViewPhotoManager();
Set<Comentario> comentarios =manager.getComentarios(0);

Foto foto = manager.getFoto(0);
%>

<table>
<tr>
<td rowspan="3">
	<figure> <img src="<%=foto.getPhotoUrl()%>"/>
	</figure>

</td>
<td>
	<ul>
	
<% 
										

for (Comentario c : comentarios)
{
%>
	
    <li> 
   		<table>
   		<tr>
		<td rowspan="3">  
   			<figure> <img src="<%=c.getUsuario().getProfilePhoto()%>"/>
   			</figure>
   		</td>
   		<td>
   			<h1><%=c.getComentario() %></h1>
   		</td>
   			
   		</table>
        
    </li>
    
<%} %>    
</ul>

<form action="SubmitComentController" method="post">

<p> <input type="text" name="comentario" placeholder="Comentarios"/> </p>
<p class="submit"> <input type="submit" value="comentar" /> </p>

</form>

</td>
</tr>

</table>
<script type="text/javascript" src="js/ext/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/ventanas-modales.js"></script>





</body>
</html>