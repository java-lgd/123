<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
		<c:if test="${info==null }">
		  <form action="insert.action" method="post">
		</c:if>
		<c:if test="${info!=null }">
			<form action="update.action" method="post">
			<input name="id"  type="hidden" value="${info.id }">
		</c:if>
		
		<input name="name" value="${info.name }">
			<select name="sex">
				<c:forEach items="${sexs}"  var="s"  varStatus="v">
					<c:if test="${info.sex==v.index }">
						<option value="${v.index }" selected="selected">${s}</option>
					</c:if>
					<c:if test="${info.sex!=v.index }">
						<option value="${v.index }">${s}</option>
					</c:if>
				</c:forEach>
				
			</select>
			<select name="typeid">
				<c:forEach items="${typelist }" var="t">
					<c:if test="${info.typeid==t.id }">
						<option value="${t.id }" selected="selected">${t.name }</option>
					</c:if>
					<c:if test="${info.typeid!=t.id }">
						<option value="${t.id }">${t.name }</option>
					</c:if>
				</c:forEach>
			</select>

		<input type="submit" value="提交">
	</form>
</body>
</html>