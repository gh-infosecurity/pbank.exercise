<%@ page import="ua.com.pb.biplane.testexercise.dto.InputDto" %>
<%@ page import="ua.com.pb.biplane.testexercise.dto.UnitedDto" %>
<%@ page import="ua.com.pb.biplane.testexercise.dto.StateDto" %>
<%@ page import="ua.com.pb.biplane.testexercise.dto.ConfigDto" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    UnitedDto unDto;
    StateDto sdto;
    InputDto inDto;
    ConfigDto confDto;
    int colspan;
%>
<%
    if (request.getParameter("dto") == null) {
        unDto = (UnitedDto) request.getAttribute("dto");
        sdto = unDto.getStDato();
        inDto = unDto.getInputDto();
        confDto = unDto.getConfDto();
        colspan = inDto.getValues().length;
    } else {
        out.println("<b>Oooops getAttribute dto is null </b>!");
    }


%>

<!DOCTYPE html>
<html>
<body>

<table width="80%" border="1">

    <tr>
        <td colspan=<%=colspan%> height="30px" align="center"> Input Ddata</td>
    </tr>
    <tr>
        <c-rt:forEach var="type" items="<%= unDto.getInputDto().getValues() %>">
            <td align="center"><c:out value="${type}"/></td>
        </c-rt:forEach>

    </tr>
    <tr>
        <td colspan=<%=colspan%> align="center">
            Finish with <%=sdto.getStatus()%>. Result - <%=sdto.getResult()%>
        </td>
    </tr>
    <tr>
        <td colspan=<%=colspan%> align="left">
            TypeOfOperations <%=confDto.getTypeOfOperations()%>
        </td>
    </tr>
    <tr>
        <td colspan=<%=colspan%> align="left">
            NumberOfInputElements = <%=confDto.getNumberOfInputElements()%>
        </td>
    </tr>
</table>

</body>
</html>