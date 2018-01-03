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

@WebServlet("/Groups")
public class GroupLoadAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Group> gList = pl.coderslab.model.Group.loadAll();
		
		for (Group group : gList) {
			int id = group.getId();
			int size = User.loadAllByGroupId(id).size();
			group.setNumber(size);
		}
		
		
		request.setAttribute("groupList", gList );
		
		
		
		
	
		
		
		getServletContext().getRequestDispatcher("/Groups.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
