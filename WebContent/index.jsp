<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Forum - strona główna</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="style.jsp" />
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="header.jsp" />	
		<jsp:include page="navbar.jsp" />
	</div>

	<!--  BACKEND  -->
	<div class="container-fluid">
		<div class="container index-thread-group">
			<div class="row">
				<div class="index-thread-header">
					<p class="index-thread-header-title">Backend</p>
					<p class="index-thread-header-description">Pytania dotyczące backendu.</p>
				</div>
				<div class="index-thread-table-container">
					<table class="table borderless index-thread-table">
						<thead>
							<tr class="text-center">
								<td class="col-lg-7 text-center">Temat</td>
								<td class="col-lg-2 text-center">Autor</td>
								<td class="col-lg-2 text-center">Data utworzenia</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="t" items="${ requestScope.threadList }">
								<tr class="index-thread-row">
									<td class="col-lg-7">
										<a href="thread?id=${ t.id }">
											<img src="img/icons/backend.png" class="index-thread-icon">
											${ t.title }
										</a>
									</td>		
									<td class="col-lg-2 text-center">
										<a>${ t.author.login }</a>
									</td>
									<td class="col-lg-2 text-center">
										<a href="thread?id=${ t.id }">
											${ t.postDate }
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>	
		</div>
	</div>
	
	<!--  FRONTEND  -->
	<div class="container-fluid">
		<div class="container index-thread-group">
			<div class="row">
				<div class="index-thread-header">
					<p class="index-thread-header-title">Frontend</p>
					<p class="index-thread-header-description">Pytania dotyczące frontendu.</p>
				</div>
				<div class="index-thread-table-container">
					<table class="table borderless index-thread-table">
						<thead>
							<tr class="text-center">
								<td class="col-lg-7 text-center">Temat</td>
								<td class="col-lg-2 text-center">Autor</td>
								<td class="col-lg-2 text-center">Data utworzenia</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="t" items="${ requestScope.threadList }">
								<tr class="index-thread-row">
									<td class="col-lg-7">
										<a href="thread?id=${ t.id }">
											<img src="img/icons/frontend.png" class="index-thread-icon">
											${ t.title }
										</a>
									</td>		
									<td class="col-lg-2 text-center">
										<a>${ t.author.login }</a>
									</td>
									<td class="col-lg-2 text-center">
										<a href="thread?id=${ t.id }">
											${ t.postDate }
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!--  MISC  -->
	<div class="container-fluid">
		<div class="container index-thread-group">
			<div class="row">
				<div class="index-thread-header">
					<p class="index-thread-header-title">Pozostałe</p>
					<p class="index-thread-header-description">Pozostałe pytania dotyczące programowania</p>
				</div>
				<div class="index-thread-table-container">
					<table class="table borderless index-thread-table">
						<thead>
							<tr class="text-center">
								<td class="col-lg-7 text-center">Temat</td>
								<td class="col-lg-2 text-center">Autor</td>
								<td class="col-lg-2 text-center">Data utworzenia</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="t" items="${ requestScope.threadList }">
								<tr class="index-thread-row">
									<td class="col-lg-7">
										<a href="thread?id=${ t.id }">
											<img src="img/icons/misc.png" class="index-thread-icon">
											${ t.title }
										</a>
									</td>		
									<td class="col-lg-2 text-center">
										<a>${ t.author.login }</a>
									</td>
									<td class="col-lg-2 text-center">
										<a href="thread?id=${ t.id }">
											${ t.postDate }
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
	
</body>
</html>