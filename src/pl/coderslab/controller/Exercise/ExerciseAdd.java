package pl.coderslab.controller.Exercise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import pl.coderslab.model.Exercise;

@WebServlet("/ExerciseAdd")
public class ExerciseAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/ExerciseAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String desc = request.getParameter("description");
		Exercise ex = new Exercise(title, desc);

		String idStr = request.getParameter("id");
		if (!StringUtils.isEmpty(idStr)) {
			int id = Integer.parseInt(idStr);
			ex.setId(id);
		}

		ex.saveToDB();

		getServletContext().getRequestDispatcher("/Exercises").forward(request, response);

	}

}
