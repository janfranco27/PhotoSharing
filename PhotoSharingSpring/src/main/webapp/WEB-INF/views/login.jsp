<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
 <c:url var="estiloscss" value="/resource/css/login.css"></c:url>
 <link rel="stylesheet" type="text/css" href="${estiloscss}">
 
 
<title>PhotoSharing </title>
</head>
<body>
	<center>
		
	<section class="container">
    <div class="login">
      <h1>Log-in en PhotoSharing</h1>
	<form action="login" method="get">
        <p><input type='text' name="nickname" value="" placeholder="Username"/></p>
        <p><input type='password' name="password" value="" placeholder="Password" /></p>        
        <p><input type="submit" value="Login"/></p>
      </form>
    </div>
  </section>
		
	
	</center>
</body>
</html>