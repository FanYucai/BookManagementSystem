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
	<br />
	<h3 align="center"  style="color:white;background-color:#0faafa"><i><s:property value="title"/></i></h3>
	<br/>
	<h4 align="center"><i><s:property value="isbn"/></i></h4>
	<br />
	
	<h3>AuthorName: <s:property value="authorname"/></h3>
	<h3>Publisher:	<s:property value="publisher"/></h3>
	<h3>PublishDate: <s:property value="publishdate"/></h3>
	<h3>Price: <s:property value="price"/></h3>
	
	<div class="index-tab">
		<div class="index-slide-nav">
			<a href='EditBook.action?id=<s:property value="title"/>' name="id" class="active">编辑</a>
			<a href='DeleteBook.action?id=<s:property value="title"/>' name="id" class="active">删除</a>
			<div class="slide-bar"></div>
			<div class="slide-bar slide-bar1"></div>
		</div>
	</div>
	
	<br />
	<hr style=" height:1px;border:none;border-top:1px solid #0f88eb;" />
	<br />
	
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

<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script src='js/index.js' type="text/javascript"></script>

</body>
</html>