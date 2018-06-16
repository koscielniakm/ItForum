<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Logowanie - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="style.jsp" />
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="navbar.jsp" />
		<jsp:include page="header.jsp" />	
	</div>

	<div class="container">
		
		<p class="text-primary row">${ requestScope.error }</p>
		
		<form class="row" action="login" method="post">
			<div class="form-group">
				<input type="text" name="loginOrEmail" placeholder="Login / e-mail"/>
				<small class="form-text text-muted">Wpisz login lub adres e-mail.</small>
			</div>
			<div class="form-group">
				<input type="password" name="password" placeholder="Hasło"/>
				<small class="form-text text-muted">Wpisz hasło.</small>
			</div>
			<input type="submit" value="Logowanie" class="btn btn-primary"/>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>