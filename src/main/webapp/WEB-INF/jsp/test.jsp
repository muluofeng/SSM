<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<body>
<h2>Hello World! test.jsp  </h2>

<c:forEach items="${categoryList}" var="obj">
    <p>${obj.catname}</p>
</c:forEach>

<c:forEach items="${pamAccounts}" var="obj">
    <p>${obj.getAccountType()}</p>
</c:forEach>

<c:forEach items="${mapData}" var="item">
    <p>${item.key}===>${item.value}</p>
</c:forEach>


</body>
</html>
