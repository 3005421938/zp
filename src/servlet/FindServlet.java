package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import service.PetService;
import service.Impl.PetServiceImpI;

import com.alibaba.fastjson.JSON;

import entity.Pet;
@WebServlet("/indexServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 实例化服务类对象
		PetService service = new PetServiceImpI();
		String flag = request.getParameter("flag");
		if (StringUtils.deleteWhitespace(flag).equals("index")) {
			List<Pet> list = service.getFindAllPets();
			request.setAttribute("listPet", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if (StringUtils.deleteWhitespace(flag).equals("find")) {
			String value = request.getParameter("value");
			try {
				List<Pet> list = service.getFindBybreed(value);
				out.print(JSON.toJSON(list));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
