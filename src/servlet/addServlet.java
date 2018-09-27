package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import service.PetService;
import service.Impl.PetServiceImpI;
import entity.Pet;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String breed = request.getParameter("bread");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String desc = request.getParameter("desc");
		PetService p = new PetServiceImpI();
		
		if (StringUtils.deleteWhitespace(name).equals("") || StringUtils.deleteWhitespace(name) == null) {
			response.getWriter().write("namenull");
		}else {
			Pet pet = new Pet();
			pet.setPetName(name);
			pet.setPetBreed(breed);
			pet.setPetSex(sex);
			pet.setDesc(desc);
			pet.setBirthday(birthday);
			if(p.getAddPet(pet)>0) {
				response.getWriter().write("success");
			}else {
				response.getWriter().write("fail");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
