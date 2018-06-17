<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Nowy temat - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="style.jsp" />
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="header.jsp" />	
		<jsp:include page="navbar.jsp" />
	</div>

	<div class="container">
	
		<form class="row" action="create" method="post">
			<div class="form-group">
				<input type="text" name="title" placeholder="Tytuł"/>
				<small class="form-text text-muted">Wprowadz nazwę tematu.</small>
			</div>
			<div class="form-group">
				<input type="text" name="content" placeholder="Treść"/>
				<small class="form-text text-muted">Wprowadz tresc tematu</small>
			</div>
			<div class="form-group">
				<input type="submit" value="Załóż temat" class="btn btn-success"/>
			</div>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>