package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.entities.UserEntity;
import forum.model.services.UserManageService;

@WebServlet(name = "deleteUser", urlPatterns = "/deleteuser")
public class DeleteUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		response.setContentType("text/html; charset=utf-8");
		deleteUser(request);
		request.getSession().invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request) {
		String enteredPassword = (String) request.getParameter("deletepassword");
		UserEntity loggedUser = (UserEntity) request.getSession().getAttribute("user");
		UserManageService userManage = new UserManageService();
		userManage.deleteUser(loggedUser, enteredPassword);
	}
	
}