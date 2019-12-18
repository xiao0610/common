<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resource/mystyles.css">
<script type="text/javascript" src="resource/jquery-3.2.1.js"></script>
<title>列表展示</title>
</head>
<body>
	<table>
		<tr>
			<th colspan="16">
			<form action="list" method="post">
				<input type="hidden" name="pagenum"/>
				名称:<input name="name" value="${name}" type="text"/>
			</form>
			</th>
		</tr>
		<tr>
			<td>编号</td>
			<td>keywords</td>
			<td>description</td>
			<td>供应方</td>
			<td>标题</td>
			<td>户型</td>
			<td>面积</td>
			<td>朝向</td>
			<td>楼层</td>
			<td>地址</td>
			<td>售价[万元]单价[元/㎡]</td>
			<td>单价</td>
			<td>发布时间</td>
			<td>备注</td>
			<td>审核状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="a">
			<tr>
				<td>${a.id}</td>
				<td>${a.keywords}</td>
				<td>${a.description}</td>
				<td>${a.provider}</td>
				<td>${a.title}</td>
				<td>${a.houseType}</td>
				<td>${a.area}</td>
				<td>${a.toward}</td>
				<td>${a.story}</td>
				<td>${a.address}</td>
				<td>${a.sellPrice}</td>
				<td>${a.unitPrice}</td>
				<td>${a.publishTime}</td>
				<td>${a.rmk}</td>
				<td>${a.checkStatus}</td>
				<td><button onclick="look(${a.id})">详情</button></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="16">
				<button type="button" onclick="page(1)">首页</button>
				<button type="button"
					onclick="page(${pagenum>1?pagenum-1:1})">上一页</button>
				共有${pages}页，当前是${pagenum}页
				<button type="button"
					onclick="page(${pagenum<pages?pagenum+1:pages})">下一页</button>
				<button type="button" onclick="page(${pages})">尾页</button>
			</th>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function page(a){
		$("[name='pagenum']").val(a);
		$("form").submit();
	}
	function look(id){
		location="toupdate?id="+id;
	}
</script>
</html>