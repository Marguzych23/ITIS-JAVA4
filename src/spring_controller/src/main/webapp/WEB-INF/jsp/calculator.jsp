<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form:form method="post" action="calculator" commandName="calculateModel" modelAttribute="calculateModel">
    <%--<form:label path="firstNumber">First Number</form:label>--%>
    <form:input path="firstNumber" />
    <%--<form:label path="mathOperation">Math</form:label>--%>
    <form:select path="mathOperation">
        <form:option value="addition">+</form:option>
        <form:option value="subtraction">-</form:option>
        <form:option value="multiplication">*</form:option>
        <form:option value="division">/</form:option>
    </form:select>

    <%--<form:label path="secondNumber">Second Number</form:label>--%>
    <form:input type="text" path="secondNumber" />
    <input type="submit" value="calculate">
</form:form>

<div style="width: 40px; border:3px double black;margin:30px; padding:10px">
    ${result}
</div>

</body>
</html>
