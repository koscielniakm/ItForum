package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.dao.DaoThread;

@WebServlet(name = "thread", urlPatterns = "/thread")
public class ThreadServlet extends HttpServlet {

	private static final long serialVersionUID = 3929671120125392564L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		Integer threadId = Integer.parseInt(request.getParameter("id"));
		if (threadId == null || threadId < 0) response.sendRedirect("/index");
		setCurrentThread(request, threadId);
		request.getRequestDispatcher("/thread.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {	
		doGet(request, response);
	}
	
	private void setCurrentThread(HttpServletRequest request, Integer threadId) {
		DaoThread topicAccess = new DaoThread();
		request.setAttribute("thread", topicAccess.findById(threadId));
	}
	
}