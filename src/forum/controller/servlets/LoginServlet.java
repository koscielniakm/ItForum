package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.entities.UserEntity;
import forum.model.services.LoginService;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -6386146130291401887L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		String loginOrEmail = request.getParameter("loginOrEmail");
		String password = request.getParameter("password");
		UserEntity loggedUser = login(loginOrEmail, password);
		if (loggedUser == null) {
			request.setAttribute("error", "Błędny login lub hasło.");
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			request.getSession(true).setAttribute("user", loggedUser);
			request.getRequestDispatcher("/index").forward(request, response);
		}
	}
	
	private UserEntity login(String loginOrEmail, String password) {
		LoginService loginService = new LoginService();
		UserEntity currentLoggedUser = loginService.login(loginOrEmail, password);
		return currentLoggedUser;
	}
	
}
