<%@ page import="ua.com.pb.biplane.testexercise.dto.enumerations.TypeOfOperations" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    Object[] types = TypeOfOperations.values();
%>

<!DOCTYPE html>
<html>
<body>
<form name="form" method="post" action="change">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="22%">&nbsp;</td>
            <td width="78%">&nbsp;</td>
        </tr>
        <tr>
            <td>Elements Number</td>
            <td><input type="text" name="elements"></td>
        </tr>
        <tr>
            <td>Operations Type</td>
            <td>
                <select name="operations">
                    <c-rt:forEach var="type" items="<%= types %>">
                        <option><c:out value="${type}"/></option>
                </c-rt:forEach>
                    </select>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</form>
</body>
</html>