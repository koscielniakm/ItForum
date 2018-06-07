<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="user" scope="session" value="${ user }" />
<html>
<head>
	<title>Konto użytkownika - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
</head>
<body>
	<div class="container">
	
		<jsp:include page="navbar.jsp" />
		<div class="jumbotron">
			<h1>Forum</h1>
		</div>
		
		<div class="">
			<h3>Konto użytkownika ${ user.login }</h3>
			
			<form action="update" method="post">
				<h4>Zmiana e-maila</h4>
				<div class="form-group">
					<input type="email" name="email" placeholder="${ user.email }"/>
					<small class="form-text text-muted">Podaj nowy adres e-mail.</small><br>
					<input type="password" name="password" placeholder="Hasło"/>
					<small class="form-text text-muted">Podaj swoje hasło.</small><br>
					<input type="submit" class="btn btn-primary" value="Zmien e-mail" />
				</div>
			</form>
			
			<form action="update" method="post">
				<h4>Zmiana hasła</h4>
				<div class="form-group">
					<input type="password" name="password" placeholder="Hasło"/>
					<small class="form-text text-muted">Podaj nowe hasło.</small><br>
					<input type="password" name="password2" placeholder="Powtórz hasło"/>
					<small class="form-text text-muted">Powtórz nowe hasło.</small><br>
					<input type="submit" class="btn btn-primary" value="Zmien hasło" />
				</div>
			</form>
			
			<form action="update" method="post">
				<h4>Usunięcie konta</h4>
				<div class="form-group">
					<input type="password" name="password" placeholder="Hasło"/>
					<small class="form-text text-muted">Podaj swoje hasło.</small><br>
					<input type="submit" class="btn btn-danger" value="Usuń konto" />
				</div>
			</form>
			
		</div>
		
	</div>
</body>
</html>