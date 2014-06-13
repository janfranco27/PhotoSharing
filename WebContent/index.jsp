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
 
 <script type="text/javascript">

function checkform1 ( )
{
	var x = document.forms["Login"]["nickname"].value;
	var y = document.forms["Login"]["password"].value;

	if (x == null || x =="" || y == null || y == "") {
    alert( "Debes llenar los campos para logearte" );
    return false ;
  }
  else return true;
}

function checkform2 ( form )
{
  if (form.nickname.value == "" || form.password.value == "" || form.nombre.value == "" || form.apellidos.value == "" || form.email.value == "") {
    alert( "Debes llenar todos los campos para registrarte" );
    form.email.focus();
    return false ;
  }
  else return true;

}

</script>

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
			<form name="Login" action="LoginController" method="post" onsubmit="return checkform1();">
	       		<p><input type="text" name="nickname" value="" placeholder="Username"></p>
	        	<p><input type="password" name="password" value="" placeholder="Password"></p>
		        <p class="submit"><input type="submit" id="submit" value="Log in"></p>
	      </form>
	   </div>
	</section>

	<section class="container">
		<div class="login">
			<h1>Nuevo usuario? RegÃ­strate!</h1>
			<form name="NewUser" action="NewUserController" method="post" onsubmit="return checkform2(this);">
		
				<p> <input type="text" name="nombre" placeholder="Nombres"/> </p>
				<p> <input type="text" name="apellidos" placeholder="Apellidos" /> </p>
				<p> <input type="text" name="email" placeholder="Email"/> </p>
				<p> <input type="text" name="nickname" placeholder="Nickname" /> </p>
				<p> <input type="password" name="password" placeholder="Password" /> </p>
				<p class="submit"> <input type="submit" value="Registrar" /> </p>
	
			</form>
		</div>
	</section>
<%
	}
%>
</body>
</html>