<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body>
	<form action="update" method="post">
		<input name="id" type="text" value="${obj.id}"/>
		<input name="keywords" type="text" value="${obj.keywords}"/>
		<input name="description" type="text" value="${obj.description}"/>
		<input name="provider" type="text" value="${obj.provider}"/>
		<input name="title" type="text" value="${obj.title}"/>
		<input name="houseType" type="text" value="${obj.houseType}"/>
		<input name="area" type="text" value="${obj.area}"/>
		<input name="toward" type="text" value="${obj.toward}"/>
		<input name="story" type="text" value="${obj.story}"/>
		<input name="address" type="text" value="${obj.address}"/>
		<input name="sellPrice" type="text" value="${obj.sellPrice}"/>
		<input name="unitPrice" type="text" value="${obj.unitPrice}"/>
		<input name="publishTime" type="date" value="${obj.publishTime}"/>
		描述:<input name="rmk" type="text" value="${obj.rmk}"/>
		<select name="checkStatus">
			<option value="审核未通过">审核未通过</option>
			<option value="审核通过">审核通过</option>
		</select>
		<button>提交</button>
	</form>
</body>
</html>