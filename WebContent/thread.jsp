<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="user" scope="session" value="${ user }" />
<html>
<head>
	<title>${ requestScope.thread.title } - Forum</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="style.css" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
</head>
<body>
	<div class="container">
	
		<jsp:include page="navbar.jsp" />
		
		<jsp:include page="header.jsp" />
		
		<div class="post">
			<div class="post-header bg-warning text-dark row">
				<p class="post-author col-lg-2">${ requestScope.thread.author.login }</p>
				<p class="post-title col-lg-8">${ requestScope.thread.title }</p>
				<p class="post-date col-lg-2">${ requestScope.thread.postDate }</p>
			</div>
			<div class="post-body row">
				<p class="post-content col-lg-12">${ requestScope.thread.content }</p>
			</div>
		</div>

		<c:forEach var="a" items="${ requestScope.thread.answers }">
			<div class="post">
				<div class="post-header bg-primary text-dark row">
					<p class="post-author col-lg-2">${ a.answerAuthor.login }</p>
					<p class="post-author col-lg-8">&nbsp;</p>
					<p class="post-date col-lg-2">${ a.postDate }</p>
				</div>
				<div class="post-body row">
					<p class="post-content col-lg-12">${ a.content }</p>
				</div>
			</div>	
		</c:forEach>
			
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
		
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>