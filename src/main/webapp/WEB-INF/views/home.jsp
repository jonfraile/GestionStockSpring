<%@ include file="/WEB-INF/views/include.jsp" %>


<html>
<head>
	<title>Home</title>
</head>
<body>

<ol>
	<li><a href="product/inventario">Ver inventario</a></li>
	<li><a href="persona">Ver Personas</a></li>
	<li><a href="<c:url value="insertar-persona.html"/>">Crear Persona</a></li>
</ol>

<P>  The time on the server is ${serverTime}. </P>

<h2>Datos Request<a href="info">(pincha para verlos)</a></h2>
<ul>
	<li>IP:${requestIp}</li>
	<li>UserAgent:${requestUa}</li>
</ul>

</body>
</html>
