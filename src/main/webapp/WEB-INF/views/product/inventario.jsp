<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${fecha}"/></p>
    <h3>Productos</h3>
    <li><a href="<c:url value="incremento-precio.html"/>">Incrementar Precio</a></li>
    <li>Crear nuevo</li>
    <c:forEach items="${products}" var="prod">
      <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    
   
  </body>
</html>