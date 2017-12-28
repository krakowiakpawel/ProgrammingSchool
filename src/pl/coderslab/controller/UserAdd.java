package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import pl.coderslab.model.Group;
import pl.coderslab.model.User;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<Group> groupList = Group.loadAll();
		request.setAttribute("groupList", groupList);

		getServletContext().getRequestDispatcher("/UserAdd.jsp").forward(request, response);

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		int Group = Integer.parseInt(request.getParameter("Group"));
		User tmp = new User(Group, userName, Email, Password);

		String idStr = request.getParameter("id");
		if (!StringUtils.isEmpty(idStr)) {
			int id = Integer.parseInt(idStr);
			tmp.setId(id);
		}
		tmp.saveToDB();
		getServletContext().getRequestDispatcher("/Users").forward(request, response);
	}

}
