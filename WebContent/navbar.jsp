<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="user" scope="session" value="${ user }" />
	
<div class="row" id="navbar">
	<div class="container">
		<div class="text-center">
			<a href="index">Strona główna</a>
			<i class=" glyphicon glyphicon-option-vertical"></i>
			<c:choose>
				<c:when test="${ user == null }">
					<a href="login">Logowanie</a>
					<i class=" glyphicon glyphicon-option-vertical"></i>
					<a href="register">Rejestracja</a>
				</c:when>
				<c:otherwise>
					<a href="create">Utwórz temat</a>
					<i class=" glyphicon glyphicon-option-vertical"></i>
					<a href="user">Ustawienia użytkownika</a>
					<i class=" glyphicon glyphicon-option-vertical"></i>
					<a href="logout">Wyloguj</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="text-center">
			<c:choose>
				<c:when test="${ user == null }">
					<p>Nie jesteś zalogowany</p>
				</c:when>
				<c:otherwise>
					<p>Obecnie zalogowany jako : ${ user.login }</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>