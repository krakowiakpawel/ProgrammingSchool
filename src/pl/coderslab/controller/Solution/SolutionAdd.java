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

@WebServlet("/SolutionAdd")
public class SolutionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Exercise> exerciseList = Exercise.loadAll();
		request.setAttribute("exerciseList", exerciseList);

		List<User> userList = User.loadAll();
		request.setAttribute("userList", userList);

		getServletContext().getRequestDispatcher("/SolutionAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = (String) request.getParameter("desc");
		int exercise = Integer.parseInt(request.getParameter("Exercise"));
		int UserId = Integer.parseInt(request.getParameter("UserId"));
		Solution sol = new Solution(description, exercise, UserId);
		sol.saveToDB();
		getServletContext().getRequestDispatcher("/Solutions").forward(request, response);

	}

}
