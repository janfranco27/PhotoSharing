<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="css/login.css">

<title>PhotoSharing </title>
</head>
<body>
	<center>
		
	<section class="container">
    <div class="login">
      <h1>Log-in en PhotoSharing</h1>
	<s:form action="LoginUserAction" method="get">
        <p><s:textfield name="nickname" value="" placeholder="Username"/></p>
        <p><s:password name="password" value="" placeholder="Password" /></p>
        
        <p class="submit"><s:submit value="Log in"/></p>
      </s:form>
    </div>
  </section>
		
	
	</center>
</body>
</html>