<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title><fmt:message key="insert.title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="insert.encabezado"/></h1>
<form:form method="post" commandName="persona" >
  <table >
    <tr>
      <td align="right" width="20%"><fmt:message key="insert.nombre"/>:</td>
        <td width="20%">
        	<form:input path="nombre"/>
        </td>
        <td width="60%">
        	<form:errors path="nombre" cssClass="error"/>
        </td>
    </tr>
    <tr>
    	<td align="right" width="20%"><fmt:message key="insert.edad"/>:</td>
        <td width="20%">
        	<form:input path="edad"/>
        </td>
        <td width="60%">
        	<form:errors path="edad" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="<fmt:message key="insert.crear"/>">
</form:form>
<a href="<c:url value="/"/>"><fmt:message key="insert.retorno"/></a>
</body>
</html>