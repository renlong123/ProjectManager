<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<style type="text/css">
.table>tbody>tr>td{
    border:0px;
    }
</style>
<script>
/* 	$(function jump(){
		window.location.href="${request}"
	}
			) */
</script>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="#">Link</a>
						</li>
						<li>
							 <a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">Action</a>
								</li>
								<li>
									 <a href="#">Another action</a>
								</li>
								<li>
									 <a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Separated link</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div> <button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">Action</a>
								</li>
								<li>
									 <a href="#">Another action</a>
								</li>
								<li>
									 <a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>				
			</nav>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center">
				项目管控工具
			</h3>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-8 column">
							<img alt="找不到图片" src="img/美女.jpg" class="img-rounded" width="100%"/>
						</div>
						<div class="col-md-4 column">
						<form action="loginServlet" method="post">
							<table class="table">
							
								<tbody>
									<tr >
										<td colspan="2" >
											<img alt="找不到图片" src="img/bilibili.jpg" class="img-rounded" width="100%"/>
										</td>
									</tr>
									<tr >
										<td style="text-align:right;vertical-align:middle">
											用户名：
										</td>
										<td>
											<input type="text" class="form-control" placeholder="用户名" name="name"/>
										</td>
									</tr>
									<tr>
										<td  style="text-align:right;vertical-align:middle">
											密&nbsp;&nbsp;&nbsp;&nbsp;码：
										</td>
										<td>
											<input type="password" class="form-control" placeholder="密码" name="password"/>
										</td>
									</tr>
									<tr >
										<td align="center" colspan="2">
											<button type="submit" class="btn btn-primary" >登陆</button>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<button class="btn btn-primary" id="register" onclick="location.href='${request.contextPath}/register.jsp'">注册</button>
										</td>
									</tr>
									<!-- <tr><div class="warning" ></div></tr> -->
									<tr >
										<td colspan="2">
											<img alt="找不到图片" src="img/2233.jpg" class="img-rounded" width="100%"/>
										</td>
									</tr>
								</tbody>
								
							</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>