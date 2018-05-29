package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.dao.DaoTopic;

@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 196028239179202695L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		setAvaiableTopicsList(request);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		doGet(request, response);
	}
	
	private void setAvaiableTopicsList(HttpServletRequest request) {
		DaoTopic topicAccess = new DaoTopic();
		request.setAttribute("topicList", topicAccess.findAll());
	}
	
}