<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${fecha}"/></p>
    <h3>Productos</h3>
    <c:forEach items="${products}" var="prod">
      <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    
    <form:form commandName="inventario" action="saveProduct" method="post">
		
		<label for="description"><fmt:message key="producto.description"/></label>
		<form:input path="description" placeholder="Escribe nombre de producto"/>
		<form:errors path="description" cssClass="error"/>
		<br><br>
		
		<label for="price"><fmt:message key="producto.price"/></label>
		<form:input path="price"/>
		<form:errors path="price" cssClass="error"/>
		<br><br><br>	
		
		<input type="submit" value="<fmt:message key="producto.boton.crear"/>">
		
	</form:form>
	-->	
  </body>
</html>