package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.entities.UserEntity;
import forum.model.services.LoginService;

@WebServlet(name = "update", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -6386146130291401887L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		if (!checkPassword(request))
			request.getRequestDispatcher("/user.jsp").forward(request, response);
		else {
			
		}
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	
	private boolean checkPassword(HttpServletRequest request) {
		UserEntity loggedUser = (UserEntity) request.getSession().getAttribute("user");
		String loggedUserPassword = loggedUser.getPassword();
		String formPassword = (String) request.getAttribute("password");
		if (loggedUserPassword.equals(formPassword)) return true;
		else return false;
	}
	
}
