<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title><fmt:message key="priceIncrease.title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="priceIncrease.heading"/></h1>
<form:form method="post" commandName="priceIncrease">
  <table >
    <tr>
      <td align="right" width="20%"><fmt:message key="increase"/>(%):</td>
        <td width="20%">
        	<form:input path="percentage"/>
        </td>
        <td width="60%">
        	<form:errors path="percentage" cssClass="error"/>
        </td>
    </tr>
    <tr>
    	<td align="right" width="20%"> <form:checkbox path="confirmar"/><fmt:message key="priceIncrease.confirmar"/></td> 
    	<td width="60%">
    		<form:errors path="confirmar" cssClass="error"/>
    	</td>
    </tr>
  </table>
  <br>
  <input type="submit" value="<fmt:message key="priceIncrease.ejecutar"/>">
</form:form>
<a href="<c:url value="/"/>"><fmt:message key="priceIncrease.retorno"/></a>
</body>
</html>