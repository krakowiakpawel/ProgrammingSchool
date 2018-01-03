package pl.coderslab.controller.Solution;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

@WebServlet("/SolutionUpdate")
public class SolutionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Solution sol = Solution.loadSolutionById(id);
		request.setAttribute("Solution", sol);
		List<Exercise> exerciseList = Exercise.loadAll();
		request.setAttribute("exerciseList", exerciseList);

		List<User> userList = User.loadAll();
		request.setAttribute("userList", userList);
		getServletContext().getRequestDispatcher("/SolutionUpdate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
