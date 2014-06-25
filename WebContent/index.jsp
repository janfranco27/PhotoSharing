<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.unsa.PhotoSharing.Controller.*" %>
<%@ page import="com.unsa.PhotoSharing.persistence.entity.*" %>
<%@ page import="com.unsa.PhotoSharing.Business.*" %>
<%@ page import="java.util.*" %>

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
			<form name="Login" id="login" action="LoginController" method="post" onsubmit="return checkform1();">
	       		<p><input type="text" id="nickname" name="nickname" value=""  placeholder="Username"></p>
	        	<p><input type="password" id="password" name="password" value=""  placeholder="Password"></p>
		        <p class="submit"><input type="submit" id="submit" value="Log in"></p>
	      </form>
	   </div>
	</section>

	<section class="container">
		<div class="login">
			<h1>Nuevo usuario? Registrate!</h1>
			<form name="NewUser" id="register" action="NewUserController" method="post" onsubmit="return checkform2(this)zz">
		
				<p> <input type="text" name="nombre" id="nombre" placeholder="Nombres"/> </p>
				<p> <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" /> </p>
				<p> <input type="text" name="email" id="email" placeholder="Email"/> </p>
				<p> <input type="text" name="nickname" id="nickname" placeholder="Nickname" /> </p>
				<p> <input type="password" name="password" id="password" placeholder="Password" /> </p>
				<p class="submit"> <input type="submit" value="Registrar" /> </p>
	
			</form>
		</div>
	</section>
<%
	}
%>
</body>
</html>