<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="user" scope="session" value="${ user }" />
<html>
<head>
	<title>${ requestScope.thread.title } - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="style.jsp" />
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="header.jsp" />	
		<jsp:include page="navbar.jsp" />
	</div>
	
	<div class="container">
	
		<!-- Post -->
		<div class="post row">
			<div class="post-userpanel col-lg-2">
				<div class="post-userimg-slot text-center">
					<img src="img/users/default.png" class="post-userimg">
					<p class="">${ requestScope.thread.author.login }</p>
					<p class="">Rejestracja : ${ requestScope.thread.author.registerDate }</p>
				</div>
			</div>
			<div class="col-lg-10">
				<div class="container-fluid">
					<div class="row">
						<div class="post-title col-lg-12">
							<div class="text-left">${ requestScope.thread.title }</div>
						</div>
						<p class="post-content col-lg-12">${ requestScope.thread.content }</p>
					</div>
				</div>
			</div>		
		</div>
		
		<!-- Answers -->
		<c:forEach var="a" items="${ requestScope.thread.answers }">
			<div class="post row">
				<div class="post-userpanel col-lg-2">
					<div class="post-userimg-slot text-center">
						<img src="img/users/default.png" class="post-userimg">
						<p class="">${ a.answerAuthor.login }</p>
						<p class="">Rejestracja : ${ a.answerAuthor.registerDate }</p>
					</div>
				</div>
				<div class="col-lg-10">
					<div class="container-fluid">
						<div class="row">
							<p class="post-title col-lg-12">Re : ${ requestScope.thread.title }</p>
							<p class="post-content col-lg-12">${ a.content }</p>
						</div>
					</div>
				</div>		
			</div>
		</c:forEach>
		
		<!-- 
		<c:choose>
			<c:when test="${ user != null }">
				<div class="thread-input-area">
					<form action="sendanswer" method="post">
						<input type="hidden" name="tid" value="${ requestScope.thread.id }" />
						<input name="content" type="text" class="thread-answer-area row" placeholder="Twoja odpowiedz "/><br>
						<input class="btn btn-primary" type="submit" value="Wyślij" />
					</form>
				</div>
			</c:when>
		</c:choose>
		-->
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>