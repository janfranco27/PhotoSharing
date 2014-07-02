<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.unsa.PhotoSharing.Controller.*" %>
<%@ page import="com.unsa.PhotoSharing.persistence.entity.*" %>
<%@ page import="com.unsa.PhotoSharing.Business.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
<head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login PhotoSharing</title>
 <link rel="stylesheet" href="css/login.css">
 
 <script src="js/jquery-2.1.1.min.js"></script> 
      <script src="js/jquery.validate.min.js"></script>
      <script> $(document).ready(function () {
		 
		 $("#login").validate({
			 rules: {
		         nickname: { required: true },
         		password: { required: true }
			 },
		         messages: {
		        	nickname: "Nickname es requerido",
					password: "Password es requerida",
		         }
		     });


		 $("#register").validate({
			 rules: {
		        nickname: { required: true, minlength:5 },
         		password: { required: true, minlength:5 },
         		nombre:{ required: true },
             	apellidos:{ required: true },
                email:{ required: true, email:true }
			 },
		         messages: {
		        	nickname: "Nickname es requerido (5+ caracteres)",
					password: "Password es requerida (5+ caracteres)",
					nombre: "Ingresa tu nombre",
	             	apellidos: "Ingresa tus apellidos",
	                email: "Ingresa un email valido"
		         }
		     });
	     
	 });
	 </script>
	 
	 
<style type="text/css">
.login input.error {
border:1px solid red;
}

.register input.error {
border:1px solid red;
}

</style>

</head>

<body>
<f:view>
	<h:panelGrid columns="2"> 
		Language : 
		<h:selectOneMenu value="#{languageBean.localeCode}" onchange="submit()"
			valueChangeListener="#{languageBean.countryLocaleCodeChanged}">
   			<f:selectItems value="#{languageBean.countries}" /> 
   		</h:selectOneMenu>
 
	</h:panelGrid>



<%
	Usuario logedUser = (Usuario)request.getSession().getAttribute("user");
	if (logedUser != null)
	{
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp?user_id=" + logedUser.getIdUsuario());
        rd.forward(request, response);
	}
	else
	{
	
%>
	<section class="container">
	  	<div class="login">
	        <h1>Log-in en PhotoSharing</h1>	        
	        
	        <h:messages></h:messages>
	        <h:form>
	        <h:panelGrid border="1" columns="2">
			<h:outputText value="#{msg.nickname}" />
			<h:inputText value="#{loginBeanController.nickname}" />
			<h:outputText value="#{msg.password}" />
			<h:inputSecret value="#{loginBeanController.password}">
			<f:validator validatorId="com.unsa.PhotoSharing.Controller.validatePassword" />
			</h:inputSecret>
		
			</h:panelGrid>
		<h:commandButton value="Login" action="#{loginBeanController.login}" ></h:commandButton>
	</h:form>
	
	        
	        

	   </div>
	</section>

	<section class="container">
		<div class="login">
			<h1>Nuevo usuario? Registrate!</h1>
		
			<h:form>
			
			 <h:panelGrid border="1" columns="2">
				<h:outputText value="#{msg.nombre}" />
				<h:inputText value="#{newUserBeanController.nombre}" />
				<h:outputText value="#{msg.apellido}" />
				<h:inputText value="#{newUserBeanController.apellidos}" />
				<h:outputText value="#{msg.email}" />
				<h:inputText value="#{newUserBeanController.email}" />
				<h:outputText value="#{msg.nickname}" />
				<h:inputText value="#{newUserBeanController.nickname}" />
				<h:outputText value="#{msg.password}" />
				<h:inputSecret  value="#{newUserBeanController.password}" />	
			</h:panelGrid>
			<h:commandButton value="Registrar" action="#{newUserBeanController.registrar}"></h:commandButton>
			</h:form>
		
		</div>
	</section>
<%
	}
%>
	</f:view>
</body>
</html>