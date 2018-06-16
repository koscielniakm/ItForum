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

@WebServlet(name = "changePassword", urlPatterns = "/changepassword")
public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = -651135939740950801L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		response.setContentType("text/html; charset=utf-8");
		changePassword(request);
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	
	private void changePassword(HttpServletRequest request) {
		UserEntity loggedUser = (UserEntity) request.getSession().getAttribute("user");
		String currentPassword = (String) request.getParameter("password");
		String newPassword = (String) request.getParameter("newpassword");
		String newPassword2 = (String) request.getParameter("newpassword2");
		UserManageService userService = new UserManageService();
		AuthValidationResult changePasswordResult = userService.
			changePassword(loggedUser, currentPassword, newPassword, newPassword2);
		addResultInformation(request, changePasswordResult);
	}
	
	private void addResultInformation(HttpServletRequest request, AuthValidationResult result) {
		if (result == AuthValidationResult.ERROR)
			request.setAttribute("changeinfo", "Nieznany błąd.");
		else if (result == AuthValidationResult.ERROR_DIFFERENT_PASSWORDS) 
			request.setAttribute("changeinfo", "Podane hasła różnią się.");
		else if (result == AuthValidationResult.ERROR_WRONG_OLDNEW_COMPARATION) 
			request.setAttribute("changeinfo", "Wprowadzono błędne hasło.");
		else if (result == AuthValidationResult.ERROR_WRONG_PASSWORD_LENGTH) 
			request.setAttribute("changeinfo", "Wprowadzone hasło nie spełnia wymagań.");
		else if (result == AuthValidationResult.SUCCESS) 
			request.setAttribute("changeinfo", "Pomyślnie zmieniono hasło.");
	}
	
}