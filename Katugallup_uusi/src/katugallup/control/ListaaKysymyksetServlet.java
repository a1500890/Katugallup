package katugallup.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import katugallup.model.Kysymys;
import katugallup.model.dao.KysymysDAO;


@WebServlet("/ListaaKysymykset")
public class ListaaKysymyksetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KysymysDAO kysymysdao = new KysymysDAO();
		ArrayList<Kysymys> kysymykset = kysymysdao.findAll();
		//System.out.println(kysymykset);
		request.setAttribute("kysymykset", kysymykset);
		
		String jsp = "/view/listaa-kysymykset.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}*/

}
