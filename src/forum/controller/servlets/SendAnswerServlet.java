package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.entities.UserEntity;
import forum.model.services.AnswerManageService;

@WebServlet(name = "sendanswer", urlPatterns = "/sendanswer")
public class SendAnswerServlet extends HttpServlet {

	private static final long serialVersionUID = 2031270790409762899L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		insertAnswer(request);
		response.sendRedirect("topic?id=" + request.getParameter("tid"));
	}
	
	private void insertAnswer(HttpServletRequest request) {
		if (request.getSession(false).getAttribute("user") != null) {
			String content = request.getParameter("content");
			UserEntity author = (UserEntity) request.getSession(false).getAttribute("user");	
			Integer topicId = Integer.parseInt(request.getParameter("tid"));
			AnswerManageService answerService = new AnswerManageService();
			answerService.insertAnswer(author.getId(), topicId, content);
		}
	}
	
}
