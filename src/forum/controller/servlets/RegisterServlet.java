package forum.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forum.model.services.RegisterResult;
import forum.model.services.RegisterService;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 6392289732462919094L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		response.setContentType("text/html; charset=utf-8");
		RegisterResult result = register(request);
		request.setAttribute("result", getRegisterResultInfo(result));
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	private RegisterResult register(HttpServletRequest request) {
		RegisterService register = new RegisterService();
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		RegisterResult result = register.register(login, password, password2, email);
		return result;
	}
	
	private String getRegisterResultInfo(RegisterResult result) {
		if (result == RegisterResult.SUCCESS)
			return "Rejestracja pomyślna. Możesz się zalogować.";
		else if (result == RegisterResult.ERROR_USER_EXIST)
			return "Użytkownik wykorzystujący wpisane dane już instnieje.";
		else if (result == RegisterResult.ERROR_WRONG_LOGIN)
			return "Błędny login.";
		else if (result == RegisterResult.ERROR_WRONG_PASSWORD)
			return "Błędne hasło.";
		else if (result == RegisterResult.ERROR_WRONG_EMAIL)
			return "Błędny e-mail.";
		else if (result == RegisterResult.ERROR_DIFFERENT_PASSWORDS)
			return "Podane hasła nie są identyczne.";
		else
			return "Bład rejestracji.";
	}

}
