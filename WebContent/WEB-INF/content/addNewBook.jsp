<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<title>书目查询系统</title>
	<link rel="stylesheet" type="text/css" href="style/register-login.css">
</head>
<script LANGUAGE="javascript"> 
	function openwin() { alert("现在可以添加图书信息了！") } 
</script> 
<body onload="openwin()">
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">lab2</h1>
		<h2 class="sub-title">樊昱才lab2 - BookDB System</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href=searchResult>查询</a>
				<a href=addNewWhat class="active">添加</a>
				<a href=ListAndUpdateBook.action>编辑</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>

		<form action="AddNewBook.action" method="post">
		
		<div class="login form">
			<div class="group">
				<div class="group-ipt bookISBN">
					<input type="text" name="isbn" id="email" class="ipt" placeholder="图书ISBN编号" required>
				</div>
				<div class="group-ipt bookTitle">
					<input type="text" name="title" id="user" class="ipt" placeholder="图书名目" required>
				</div>
				
				<div class="group-ipt name">
					<input type="hidden" name="name" id="user" class="ipt" value='<s:property value="name"/>' >
				</div>
				
				<div class="group-ipt bookPublisher">
					<input type="text" name="publisher" id="user" class="ipt" placeholder="图书出版商" required>
				</div>
				<div class="group-ipt bookDate">
					<input type="text" name="publishdate" id="user" class="ipt" placeholder="图书出版日期" required>
				</div>
				<div class="group-ipt bookPrice">
					<input type="text" name="price" id="user" class="ipt" placeholder="图书价格" required>
				</div>
			</div>
		</div>
		
		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">添加图书并保存</button>
		</div>
		
		</form>
	</div>
</div>

<!-- background -->
<div class="footer">
	<p>lab2 - 樊昱才 1140320213</p>
</div>
<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script src='js/index.js' type="text/javascript"></script>
<!-- background -->

</body>
</html>