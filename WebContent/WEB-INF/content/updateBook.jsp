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
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">lab2</h1>
		<h2 class="sub-title">樊昱才lab2 - BookDB System</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href=searchResult>查询</a>
				<a href=addNewWhat>添加</a>
				<a href=ListAndUpdateBook.action class="active">编辑</a>
				<div class="slide-bar slide-bar2"></div>				
			</div>
		</div>


<!-- 这里加入显示的作者的全部图书 -->
	<br />
	<h3 align="center" style="color:white;background-color:#0faafa"><i><s:property value="title"/></i></h3>
	<h4 align="center"><i><s:property value="isbn"/></i></h4>
	<br />
	
	<form action="UpdateBook.action">
		<div class="login form">
			<div class="group">
				<div class="group-ipt bookISBN">
					<input type="hidden" name="isbn" id="email" class="ipt" value='<s:property value="isbn" />' >
				</div>
				<div class="group-ipt bookTitle">
					<input type="hidden" name="title" id="email" class="ipt" value='<s:property value="title" />'>
				</div>
				
				<div class="group-ipt name">
					<input type="hidden" name="name" id="user" class="ipt" value='<s:property value="authorname" />'>
				</div>
				
				<div class="group-ipt authorID">
					<input type="text" name="authorname" id="email" class="ipt" value='<s:property value="authorname" />'>
				</div>
				<div class="group-ipt bookPublisher">
					<input type="text" name="publisher" id="user" class="ipt" value='<s:property value="publisher" />'>
				</div>
				<div class="group-ipt bookDate">
					<input type="text" name="publishdate" id="user" class="ipt" value='<s:property value="publishdate" />'>
				</div>
				<div class="group-ipt bookPrice">
					<input type="text" name="price" id="user" class="ipt" value='<s:property value="price" />'>
				</div>			
			</div>
		</div> 	
	 	
	 	<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">更新该图书的信息</button>
		</div>
	</form>
	<br />
	<hr style=" height:1px;border:none;border-top:1px solid #0f88eb;" />
    <%-- <h5>${requestScope.tip}</h5> --%>
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