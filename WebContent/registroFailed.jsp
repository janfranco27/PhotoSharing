<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<f:view>
	<section class="container">
	    <div class="login">
	      <h1>Error en el registro</h1>   
	      <h:form>
	      <h:outputText value="Un usuario con su email o nickname ya existe!" />
	      </h:form>	   		
	    </div>
	  </section>
</f:view>
</body>
</html>