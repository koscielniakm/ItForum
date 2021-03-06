<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="user" scope="session" value="${ user }" />
<html>
<head>
	<title>Konto użytkownika - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="style.jsp" />
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="header.jsp" />	
		<jsp:include page="navbar.jsp" />
	</div>
	
	<div class="container">
		
		<p class="change-info">
			<c:choose>
				<c:when test="${ requestScope.changeinfo != null }">
					Informacja : ${ requestScope.changeinfo }
				</c:when>
			</c:choose>
		</p>
		
		<div class="">
			<h3>Konto użytkownika ${ user.login }</h3>
			
			<form action="changeemail" method="post">
				<h4>Zmiana e-maila</h4>
				<div class="form-group">
					<input type="email" name="email" placeholder="${ user.email }"/>
					<small class="form-text text-muted">Podaj nowy adres e-mail.</small><br>
					<input type="password" name="password" placeholder="Hasło"/>
					<small class="form-text text-muted">Podaj swoje hasło.</small><br>
					<input type="submit" class="btn btn-primary" value="Zmien e-mail" />
				</div>
			</form>
			
			<form action="changepassword" method="post">
				<h4>Zmiana hasła</h4>
				<div class="form-group">
					<input type="password" name="password" placeholder="Obecne hasło"/>
					<small class="form-text text-muted">Podaj obecne hasło.</small><br>
					<input type="password" name="newpassword" placeholder="Nowe hasło"/>
					<small class="form-text text-muted">Podaj nowe hasło.</small><br>
					<input type="password" name="newpassword2" placeholder="Powtórz nowe hasło"/>
					<small class="form-text text-muted">Powtórz nowe hasło.</small><br>
					<input type="submit" class="btn btn-primary" value="Zmien hasło" />
				</div>
			</form>
			
			<form action="deleteuser" method="post">
				<h4>Usunięcie konta</h4>
				<div class="form-group">
					<input type="password" name="deletepassword" placeholder="Hasło"/>
					<small class="form-text text-muted">Podaj swoje hasło.</small><br>
					<input type="submit" class="btn btn-danger" value="Usuń konto" />
				</div>
			</form>
			
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>