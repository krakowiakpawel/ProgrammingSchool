package pl.coderslab.controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Group;

/**
 * Servlet implementation class UsersById
 */
@WebServlet("/UsersBy")
public class UsersById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("userList", pl.coderslab.model.User.loadAllByGroupId(id));

		request.setAttribute("groupName", Group.loadById(id).getName());

		getServletContext().getRequestDispatcher("/UsersById.jsp").forward(request, response);
	}

}
