<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>书目查询系统</title>
	<link rel="stylesheet" type="text/css" href="style/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">lab2</h1>
		<h2 class="sub-title">樊昱才lab2 - BookDB System</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href=searchResult class="active">查询</a>
				<a href=addNewWhat>添加</a>
				<a href=ListAndUpdateBook.action>编辑</a>
				<div class="slide-bar"></div>				
			</div>
		</div>


<!-- 这里加入显示的作者的全部图书 -->
		<h3>authorid:</h3><h2><i><s:property value="id"/> </i></h2>
		<h3>删除</h3><h2><i><s:property value="title"/> </i></h2><h3>成功！</h3>

<!-- 这里加入显示的作者的全部图书 -->
		<form action="SearchBook.action" method="post">
		
		<div class="login form">
			<div class="group">

				<div class="group-ipt authorsname">
					<input type="text" name="authorsname" id="authorsname" class="ipt" placeholder="请输入作者的姓名" required>
				</div>
			</div>
		</div>

 		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">查询该作者的图书</button>
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

</body>
</html>