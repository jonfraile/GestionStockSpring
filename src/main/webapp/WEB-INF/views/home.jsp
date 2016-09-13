<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<p>  The time on the server is ${serverTime}. </p>

<p>Datos cliente <a href="info">click</a></p>
<p>  IP: ${requestIp}. </p>
<p>  UserAgent: ${requestUa}. </p>

<p><a href="inventario">Inventario</a></p>
<p><a href="personas">Personas</a></p>
</body>
</html>
