<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.unsa.PhotoSharing.Controller.*" %>
<%@ page import="com.unsa.PhotoSharing.persistence.entity.*" %>
<%@ page import="com.unsa.PhotoSharing.Business.*" %>
<%@ page import="java.util.*" %>

<html>
	<head>
		<title>Página de inicio</title>
		
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300italic,600|Source+Code+Pro" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
		<!--[if lte IE 8]><script src="html5shiv.js" type="text/javascript"></script><![endif]-->
		<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>		
		<script src="skel.min.js">
		{
			prefix: 'css/style',
			preloadStyleSheets: true,
			resetCSS: true,
			boxModel: 'border',
			grid: { gutters: 30 },
			breakpoints: {
				wide: { range: '1200-', containers: 1140, grid: { gutters: 50 } },
				narrow: { range: '481-1199', containers: 960 },
				mobile: { range: '-480', containers: 'fluid', lockViewport: true, grid: { collapse: true } }
			}
		}
		</script>
		<script>
			$(function() {

				// Note: make sure you call dropotron on the top level <ul>
				$('#main-nav > ul').dropotron({ 
					offsetY: -10 // Nudge up submenus by 10px to account for padding
				});

			});
		</script>
		<script>
			// DOM ready
			$(function() {
    
			// Create the dropdown base
			$("<select />").appendTo("nav");
   
			// Create default option "Go to..."
			$("<option />", {
				"selected": "selected",
				"value"   : "",
				"text"    : "Menu"
			}).appendTo("nav select");
   
			// Populate dropdown with menu items
			$("nav a").each(function() {
			var el = $(this);
			$("<option />", {
				"value"   : el.attr("href"),
				"text"    : el.text()
			}).appendTo("nav select");
			});
   
			// To make dropdown actually work
			// To make more unobtrusive: http://css-tricks.com/4064-unobtrusive-page-changer/
			$("nav select").change(function() {
				window.location = $(this).find("option:selected").val();
			});
  
			});
		</script>	
		
	</head>
	<body>
	
	<%
	
	Usuario logedUser = null;
	Usuario user = null;
	UserHomeController controller = new UserHomeController(); 
	logedUser = (Usuario)request.getSession().getAttribute("user");
	
	int user_id = 0;
	boolean showPage = true;

	if (logedUser == null) 
	{
		showPage = false;
	}
	else
	{
		System.out.println("USUARIO es " + logedUser.getIdUsuario());
		System.out.println("USUARIO es " + logedUser.getNickname());
		try
		{
			user_id = Integer.parseInt(request.getParameter("user_id"));
			user = controller.getUser(user_id);
			System.out.println("USUARIO XXes " + user);
			System.out.println("USUARIO XXes " + logedUser.getIdUsuario());
			System.out.println("USUARIO XXes " + logedUser.getNickname());
			if(user == null) showPage = false;
		}
		catch(Exception e)
		{
			user_id = logedUser.getIdUsuario();
			if(user == null) showPage = false;
		}
	}
	%>
		
	<% if (!showPage) 
		{
			if (logedUser == null)
			{
				%>
				Debes estar logeado para ver el contenido!!! 
				<a href="login.jsp">Inicia sesión o registra un nuevo usuario</a><br>
				<% 
			}
			else
			{
				%>
				Página no encontrada! 
				<a href="home.jsp?user_id=<%=logedUser.getIdUsuario()%>">Volver a mi pantalla de inicio</a><br>
				<% 
			}
		} 
		else 
		{
		%>


		<div id="header_container">		
		    <div class="container">
			<!-- Header -->
				<div id="header" class="row">
					<div class="5u">
						<div class="transparent">
							<p style="float: left;"> <img src="<%=user.getProfilePhoto() %>?time=<%=new java.util.Date().getTime() %>" width="130" height="130"> </p>
						
							<h1> &emsp; <a href="home.jsp?user_id=<%= user_id %>">
							<%= (user.getNombre() + " " + user.getApellidos())
							%>
							</a></h1>
							<h2> &emsp; <%="(" + user.getNickname() + ")" %></h2>
						</div>
							
					</div>

					
										
					<nav id="main-nav" class="7u">
						<ul>
							<li><a class="active" href="home.jsp?user_id=<%=logedUser.getIdUsuario()%>">Home</a></li>
							<li><a href="upload.jsp">Subir foto</a></li>
							<li>
								<a href="search.jsp">Buscar</a>
							</li>
							<li><a href="settings.jsp">Ajustes de perfil</a></li>
							<li><a href="LogoutController">Log Out</a></li>
							
						</ul>
					</nav>
				</div>
			</div>	
        </div>		

		<div id="site_content">
			<div class="container">			
			
				<!-- Features -->			
				<div class="row">	
				
				<section class="3u">
						<div id="sidebar">
							<section class="12u">
								<h3>Últimas novedades</h3>
								
								<%
									UserHomeManager manager = new UserHomeManager();
									List<String> userLastNews = manager.getLastNews(user);

								%>
								<ul type="disk">
								
								<%
									for(String s : userLastNews)
									{
								%>
									<li> <%=s %> </li>
								<%
									}
								%>
								</ul>
								
							</section>
						</div>
					</section>			
													
					<section class="9u">				
						
						<!-- Banner -->								
						<div id="banner">
							<a href="#"><img src="images/banner.png" alt="banner image" /></a>
						</div>
						

						
						<div id="grid-gallery" class="grid-gallery">
							<section class="grid-wrap">
								<ul class="grid">
									<li class="grid-sizer"></li><!-- for Masonry column width -->
									
									<% 
										
										List<Foto> userFotos = manager.getUsuarioFotos(user);
										for (Foto f : userFotos)
										{
											System.out.println("RUTA " + user.getProfilePhoto());
											System.out.println("RUTA " + f.getPhotoUrl());
											
									%>
											<li>
											<figure>
												<img src="<%=f.getPhotoUrl()%>" width="400" height="260" alt="<%= f.getIdFoto()%>"/>
												<figcaption><h3><%=f.getDescripcion() %></h3><p><%=f.getDescripcion() %></p></figcaption>
											</figure>
										</li>
										
									<%
										}
									%>
									
									
								</ul>
							</section>
							
							<section class="slideshow">
							
							<ul style="overflow: auto">
							<% 
										
										
					         for (Foto f : userFotos)
							{
							System.out.println("RUTA " + user.getProfilePhoto());
							System.out.println("RUTA " + f.getPhotoUrl());
									
									%>
							
							<li>
							<figure>
								<figcaption>
									<h3><%=f.getDescripcion() %></h3>

								
								</figcaption>
								<img src="<%=f.getPhotoUrl()%>" alt="<%= f.getIdFoto()%>"/>
								
								<%
						
							Set<Comentario> comentarios=f.getComentarios();
							System.out.println(comentarios);

								for (Comentario c : comentarios)
								{
							%>
							<p><%=c.getComentario() %></p>
							<%
								}
						    %>
							</figure>
							
							
						    </li>
						    <%} %>
						    </ul>
						    <nav>
									<span class="icon nav-prev"></span>
									<span class="icon nav-next"></span>
									<span class="icon nav-close"></span>
							</nav>
							<div class="info-keys icon">Navigate with arrow keys</div>
						</section><!-- // slideshow -->
						    
						    
						</div>
								
				</section>
					

				</div>
			</div>
        </div>		
		
		<script src="js/imagesloaded.pkgd.min.js"></script>
		<script src="js/masonry.pkgd.min.js"></script>
		<script src="js/classie.js"></script>
		<script src="js/cbpGridGallery.js"></script>
		<script>
			new CBPGridGallery( document.getElementById( 'grid-gallery' ) );
		</script>
		
		
			<div class="container">			
			<!-- Footer -->
				<footer>
					<p><a class="active" href="home.jsp?user_id=<%=logedUser.getIdUsuario()%>">Home</a> | <a href="upload.jsp">Subir foto</a> | <a href="settings.jsp">Ajustes de perfil</a> | <a href="LogoutController">Log Out</a>
					<p>Copyright &copy; UNSA | Jan Llerena | Julio Vera | Jhon Monroy</p>
				</footer>		
			</div>		
			
	</body>
	<% } %>
</html>
