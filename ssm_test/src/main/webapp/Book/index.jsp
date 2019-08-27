<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(id) {
		if(confirm("是否删除？")){
			open("delete.action?id="+id,"_self");
		}
	}
</script>
</head>
<body>
	<form action="index.action" method="post">
		<input name="txt">
		<input type="submit" value="查询">
	</form>
	
	<a href="add.action">新增</a>
	<table>
		<tr>
			<td>编号</td>
			<td>书名</td>
			<td>状态</td>
			<td>类型</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${bookList}"  var="list">
			<tr>
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>${list.sexname }</td>
				<td>${list.typename }</td>
				<td><a href="javascript:del(${list.id })">删除</a>
				<a href="edit.action?id=${list.id }">修改</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>