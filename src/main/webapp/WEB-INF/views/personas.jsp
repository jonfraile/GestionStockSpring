<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title><fmt:message key="title"/></title>
</head>
<body>
	
    
    <h3>Personas</h3>
    
    <c:forEach items="${persons}" var="persona">
      <c:out value="${persona.nombre}"/> 
      <br><br>
    </c:forEach>

</body>
</html>
