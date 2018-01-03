package pl.coderslab.controller.Group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import pl.coderslab.model.Group;
import pl.coderslab.model.User;

@WebServlet("/GroupAdd")
public class GroupAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/GroupAdd.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String groupName = request.getParameter("GroupName");
		Group tmp = new Group(groupName);

		String idStr = request.getParameter("id");
		if (!StringUtils.isEmpty(idStr)) {
			int id = Integer.parseInt(idStr);
			tmp.setId(id);
		}
		tmp.saveToDB();
		getServletContext().getRequestDispatcher("/Groups").forward(request, response);
		
		
		
		
		
	}

}
