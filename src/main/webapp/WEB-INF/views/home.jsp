<%@ include file="includes/header.jsp" %>

<ol>
	<li><a href="product/inventario">Ver inventario</a></li>
	<li><a href="persona/persona">Ver Personas</a></li>
	<li><a href="<c:url value="persona/insertar-persona.html"/>">Crear Persona</a></li>
</ol>

<P>  The time on the server is ${serverTime}. </P>

<h2>Datos Request<a href="info">(pincha para verlos)</a></h2>
<ul>
	<li>IP:${requestIp}</li>
	<li>UserAgent:${requestUa}</li>
</ul>

<%@ include file="includes/footer.jsp" %>