package pl.coderslab.controller.Solution;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;

/**
 * Servlet implementation class SolutionDelete
 */
@WebServlet("/SolutionDelete")
public class SolutionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Solution.loadSolutionById(id).delete();
		getServletContext().getRequestDispatcher("/Solutions").forward(request, response);

	}

}
