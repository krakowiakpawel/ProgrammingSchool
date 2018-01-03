package pl.coderslab.controller.Group;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Group;
import pl.coderslab.model.User;

@WebServlet("/GroupUpdate")
public class GroupUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Group group = Group.loadById(id);
		request.setAttribute("group", group);

		// List<Group> groupList = Group.loadAll();
		// request.setAttribute("groupList", groupList);
		// int userGroup = User.getuser_group_id();
		// request.setAttribute("userGroup", userGroup);
		getServletContext().getRequestDispatcher("/GroupUpdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
