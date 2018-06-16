package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "user", urlPatterns="/user")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2730570594632207963L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	
}
