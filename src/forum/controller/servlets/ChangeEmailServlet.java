package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.persistence.entities.UserEntity;
import forum.model.services.auth.AuthValidationResult;
import forum.model.services.entityservices.UserManageService;

@WebServlet(name = "changeEmail", urlPatterns = "/changeemail")
public class ChangeEmailServlet extends HttpServlet {

	private static final long serialVersionUID = -651135939740950801L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		response.setContentType("text/html; charset=utf-8");
		changeEmail(request);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	
	private void changeEmail(HttpServletRequest request) {
		UserEntity loggedUser = (UserEntity) request.getSession().getAttribute("user");
		String newEmail = (String) request.getParameter("email");
		UserManageService userService = new UserManageService();
		AuthValidationResult changeEmailResult = userService.changeEmail(loggedUser, newEmail);
		addResultInformation(request, changeEmailResult);
	}
	
	private void addResultInformation(HttpServletRequest request, AuthValidationResult result) {
		if (result == AuthValidationResult.SUCCESS)
			request.setAttribute("changeinfo", "Adres e-mail został pomyślnie zmieniony.");
		else
			request.setAttribute("changeinfo", "Podany adres e-mail jest nieprawidłowy.");
	}
	
}