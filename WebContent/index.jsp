<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物管理系统</title>
<style type="text/css">
	table {margin-top: 15px}
	.main{margin-top: 5%;}
	thead {background-color: #808080;text-align: center;}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
	<c:if test="${empty listPet}">
		<jsp:forward page="indexServlet?flag=index"></jsp:forward>
	</c:if>
	
	<div align="center" class="main">
		<div>
			<label for="breed">品种</label> 
			<select id="breed" name="breed">
				<option value=''>--请选择--</option>
				<option value="猫">猫</option>
				<option value="狗">狗</option>
				<option value="鸟">鸟</option>
				<option value="鼠">鼠</option>
			</select> 
			<button id="find">查询</button>
			<a href="add.jsp">新增宠物</a>
		</div>
		<table border="1" width="300px">
			<thead>
				<tr>
					<th>名称</th>
					<th>出生日期</th>
					<th>性别</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listPet}" var="item">
					<tr>
						<td>${item.petName}</td>
						<td>${item.birthday}</td>
						<td>${item.petSex}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(function (){
			$('tbody tr:even').css('background-color','red');
			var $find = $('#find');	//查询按钮对象
			$find.on('click',function (){
				var value = $('#breed').val();
				if(value.length<=0 || value == null || value==''){
					alert("请选择查询的动物品种！");
				}else{
					$.post('indexServlet?flag=find',{'value':value},function (data){
						if(data != null && data.length>0){
							$('tbody').children().remove();
							for(var i in data){
								var $tr = $("<tr></tr>");// 创建一个<tr><td></td></tr>
								$tr.append("<td>"+data[i].petName+"</td>");
								$tr.append("<td>"+data[i].birthday+"</td>");
								$tr.append("<td>"+data[i].petSex+"</td>");
								$('tbody').append($tr);
							} 
							$('tbody tr:even').css('background-color','red');
						}else{
							alert("您查询的数据并不存在！");
						}
					},'JSON');	// post END
				}
			});// Find click END
			
		});//--	$ END
	</script>
</body>
</html>