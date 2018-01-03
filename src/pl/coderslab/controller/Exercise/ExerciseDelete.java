package pl.coderslab.controller.Exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Exercise;

@WebServlet("/ExerciseDelete")
public class ExerciseDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Exercise.loadById(id).delete();
	
		getServletContext().getRequestDispatcher("/Exercises").forward(request, response);

	
	}


}
