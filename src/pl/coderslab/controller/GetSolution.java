package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;

@WebServlet("/aa")
public class GetSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int numSolLim = Integer.parseInt(getServletContext().getInitParameter("numberSolutions"));
		List<Solution> solList = Solution.loadAll(numSolLim);
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("solList", solList);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
