<%@ page import="ua.com.pb.biplane.testexercise.dto.InputDto" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    InputDto dto;
%>
<%
    if (request.getParameter("dto") == null) {
        dto = (InputDto) request.getAttribute("dto");
    } else {
        out.println("<b>Oooops getAttribute dto is null </b>!");
    }
%>

<!DOCTYPE html>
<html>
<body>

<table width="80%" border="1">

    <tr>
        <td colspan=<%=dto.getValues().length%> height="30px" align="center"> Input Ddata</td>
    </tr>
    <tr>
        <c-rt:forEach var="type" items="<%= dto.getValues() %>">
            <td align="center"><c:out value="${type}"/></td>
        </c-rt:forEach>

    </tr>
</table>

</body>
</html>