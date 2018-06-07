package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "createTopic", urlPatterns = "/create")
public class CreateTopicServlet extends HttpServlet {

	private static final long serialVersionUID = 196028239179202695L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		request.getRequestDispatcher("/create.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		doGet(request, response);
	}
	
}