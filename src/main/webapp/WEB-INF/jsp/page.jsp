<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 16.04.15
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="80%" align="center" border="1">

  <tr>
    <td colspan=6 height="30px" align="center"> Logging:</td>
  </tr>
  <tr>
    <td>id</td>
    <td>Input Data</td>
    <td>Operations</td>
    <td>Elements</td>
    <td>Status</td>
    <td>Result</td>
  </tr>

  <c:forEach var="log" items="${logs}">
    <tr>
      <td>${log.id}</td>
      <td>${element.inputData}</td>
      <td>${log.operations}</td>
      <td>${log.elements}</td>
      <td>${log.status}</td>
      <td>${log.result}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>
