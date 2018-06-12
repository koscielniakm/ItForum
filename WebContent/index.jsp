<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Forum - strona główna</title>
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
		<div class="panel panel-default row">
			<div class="panel-heading bg-primary text-dark">
				<h3 class="panel-title">
					<span>Tematy </span><a href="create">[Utwórz temat]</a>
				</h3>
			</div>
			<div class="panel-body">
				<table class="table table-stripped">
					<thread>
						<tr class="text-center">
							<th class="col-lg-8 text-center">Temat</th>
							<th class="col-lg-2 text-center">Autor</th>
							<th class="col-lg-2 text-center">Data utworzenia</th>
						</tr>
					</thread>
					<tbody>
						<c:forEach var="t" items="${ requestScope.threadList }">
							<tr>
								<td class="col-lg-8"><a href="thread?id=${ t.id }">${ t.title }</a></td>
								<td class="col-lg-2 text-center">${ t.author.login }</td>
								<td class="col-lg-2 text-center">${ t.postDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>