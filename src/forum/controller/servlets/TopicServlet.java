package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.dao.DaoTopic;

@WebServlet(name = "topic", urlPatterns = "/topic")
public class TopicServlet extends HttpServlet {

	private static final long serialVersionUID = 3929671120125392564L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		Integer topicId = Integer.parseInt(request.getParameter("id"));
		if(topicId == null || topicId < 0) response.sendRedirect("/error"); //TODO
		setCurrentTopic(request, topicId);
		request.getRequestDispatcher("/topic.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		doGet(request, response);
	}
	
	private void setCurrentTopic(HttpServletRequest request, Integer topicId) {
		DaoTopic topicAccess = new DaoTopic();
		request.setAttribute("topic", topicAccess.findById(topicId));
	}
	
}