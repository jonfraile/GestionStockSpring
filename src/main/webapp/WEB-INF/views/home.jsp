<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title><fmt:message key="home.title"/></title>
</head>
<body>
<h1>
	<fmt:message key="home.h1"/> 
</h1>
 
<p><fmt:message key="home.mensajeHora"/> ${serverTime}. </p>

<p><fmt:message key="home.datosCliente"/><a href="info">Click</a></p>
<p>  IP: ${requestIp}. </p>
<p>  UserAgent: ${requestUa}. </p>

<p><a href="inventario"><fmt:message key="home.inventario"/></a></p>
<p><a href="personas"><fmt:message key="home.persona"/></a></p>
<p><a href="<c:url value="incremento-precio"/>"><fmt:message key="home.incrementarPrecio"/></a></p>
<p><a href="<c:url value="insert-persona"/>"><fmt:message key="home.insertarPersona"/></a></p>
</body>
</html>
