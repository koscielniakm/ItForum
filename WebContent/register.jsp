<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>${ requestScope.topic.title } - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
</head>
<body>
	<div class="container">
	
		<jsp:include page="navbar.jsp" />
		
		<jsp:include page="header.jsp" />
		
		<p class="text-primary row">${ requestScope.result }</p>
		
		<form class="row" action="register" method="post">
			<div class="form-group">
				<input type="email" name="email" placeholder="E-mail"/>
				<small class="form-text text-muted">Wpisz adres e-mail.</small>
			</div>
			<div class="form-group">
				<input type="text" name="login" placeholder="Login"/>
				<small class="form-text text-muted">Wpisz swój login (5 - 20 znaków).</small>
			</div>
			<div class="form-group">
				<input type="password" name="password" placeholder="Hasło"/>
				<small class="form-text text-muted">Wpisz hasło (8 - 20 znaków).</small>
			</div>
			<div class="form-group">
				<input type="password" name="password2" placeholder="Powtórz hasło"/>
				<small class="form-text text-muted">Powtórz hasło wprowadzone u góry.</small>
			</div>
			<input type="submit" value="Rejestracja" class="btn btn-primary"/>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>