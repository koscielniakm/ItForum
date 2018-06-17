<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="user" scope="session" value="${ user }" />
	
<div class="row" id="navbar">
	<div class="container">
		<div class="text-center">
			<a href="index">
				<button class="navbar-btn">
					<img src="img/icons/homepage.png" class="navbar-btn-img">
					<span class="navbar-btn-text">Strona główna</span>
				</button>
			</a>
			<c:choose>
				<c:when test="${ user == null }">
					<a href="login">
						<button class="navbar-btn">
							<img src="img/icons/login.png" class="navbar-btn-img">
							<span class="navbar-btn-text">Logowanie</span>
						</button>
					</a>
					<a href="register">
						<button class="navbar-btn">
							<img src="img/icons/register.png" class="navbar-btn-img">
							<span class="navbar-btn-text">Rejestracja</span>
						</button>
					</a>
				</c:when>
				<c:otherwise>
					<a href="create">
						<button class="navbar-btn">
							<img src="img/icons/create.png" class="navbar-btn-img">
							<span class="navbar-btn-text">Utwórz temat</span>
						</button>
					</a>
					<a href="user">
						<button class="navbar-btn">
							<img src="img/icons/settings.png" class="navbar-btn-img">
							<span class="navbar-btn-text">Ustawienia</span>
						</button>
					</a>
					<a href="logout">
						<button class="navbar-btn">
							<img src="img/icons/logout.png" class="navbar-btn-img">
							<span class="navbar-btn-text">Wyloguj</span>
						</button>
					</a>
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