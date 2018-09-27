package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import service.Impl.PetServiceImpI;

/**
 * Servlet implementation class panduanServlet
 */
@WebServlet("/panduanServlet")
public class panduanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public panduanServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("petName");
		PetService petService = new PetServiceImpI();
		if(petService.getPetName(name)) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
