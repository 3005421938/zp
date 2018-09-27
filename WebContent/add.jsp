<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<style type="text/css">
	div>label {
	text-align: right;
}
	.main{width: 300px; margin: 20px auto;}
	form>div {
	width: 400px;
	margin-top: 20px;
}
	form {
	display: block;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="main" >
		<form action="" method="post" id="form">
			<h1>宠物的基本信息</h1>
			<div>
				<label for="name">昵称：</label>
				<input type="text" id="name"  name="name" required><span style="color: red;" id="erroor"></span>
			</div>
			
			<div>
				<label for="bread">品种：</label>
				<select id="bread" name="bread" required>
						<option value=''>--请选择--</option>
						<option value="猫">猫</option>
						<option value="狗">狗</option>
						<option value="鸟">鸟</option>
						<option value="鼠">鼠</option>
				</select>
			</div>
			
			<div>
				<label for="sex">性别：</label>
				<input type="radio" name = "sex" checked value="雄">雄 <input type="radio" value="雌" name="sex">雌
			</div>
			
			<div>
				<label for="birthday">出生日期：</label>
				<input type="date" id="birthday" name="birthday" required>
				<span style="font-size: 12px">yyyy-MM-dd格式</span>
			</div>
			
			<div>
				<label for="desc">宠物描述：</label>
				<textarea cols="40px" rows="2px" name="desc"></textarea>
			</div>
			<div>
				<input type="submit" value="添加">
				<input type="reset">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(function (){
			 flagg = true;
			$("#name").on('blur',function (){
				var name = $(this).val();
				$.post("panduanServlet","petName="+name,function back(data){
					if(data =="true"){
						flagg = false;
						$("#erroor").html('用户名已经存在！');
					}else{
						flagg = true;
						$('#erroor').text('');
					}
				})
			});
			
			$("#form").on('submit',function (){
				var $inputs = $("#form").find(":input");
				var jsonVal = $inputs.serialize();
				var bread = $("#bread").val();
				if(bread == ""){
					alert("请选择宠物品种！");
					return false;
				}else if(flagg == false){
					alert("请输入可用名称！");
					return false;
				}else{
					$.post("addServlet",jsonVal,function (data){
						if(data == "namenull"){
							alert("姓名不能为空！！");
						}else if (data == "success") {
							alert("添加成功！");
							location.href='index.jsp';
						}else{
							alert("添加失败！");
						}
					},"text");
				}
				return false;
			});// -- end
			
			
		});// $-- end
	</script>
</body>
</html>