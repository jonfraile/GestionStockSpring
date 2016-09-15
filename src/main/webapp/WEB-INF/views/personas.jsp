<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title><fmt:message key="personas.title"/></title>
</head>
<body>
	
    
    <h3><fmt:message key="personas.encabezado"/></h3>
    
    <c:forEach items="${persons}" var="persona">
      <c:out value="${persona.nombre}"/> 
      <br><br>
    </c:forEach>

</body>
</html>
