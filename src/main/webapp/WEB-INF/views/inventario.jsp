<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
	<title><fmt:message key="inventario.title"/></title>
</head>
<body>
	<h1><fmt:message key="inventario.heading"/></h1>
    
    <p><fmt:message key="inventario.greeting"/> <c:out value="${fecha}"/></p>
    
    <h3><fmt:message key="inventario.encabezado"/></h3>
    
    <c:forEach items="${products}" var="prod">
      <c:out value="${prod.description}"/> 
      <i>$<c:out value="${prod.price}"/></i>
      <br><br>
    </c:forEach>

</body>
</html>
