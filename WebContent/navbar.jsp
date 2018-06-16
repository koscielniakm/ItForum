<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="user" scope="session" value="${ user }" />
	<div class="row">
		<nav role="navigation" class="col-lg-8">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="index">Strona główna</a></li>
				<c:choose>
					<c:when test="${ user == null }">
						<li role="presentation"><a href="login">Logowanie</a></li>
						<li role="presentation"><a href="register">Rejestracja</a></li>
					</c:when>
					<c:otherwise>
						<li role="presentation"><a href="user">${ user.login }</a></li>
						<li role="presentation"><a href="logout">Wyloguj</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>