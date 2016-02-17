package katugallup.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import katugallup.model.Vastaus;
import katugallup.model.dao.VastausDAO;



@WebServlet("/LisaaVastaus")
public class LisaaVastausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LisaaVastausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/vastaus.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}
	
	//Tässä testikommentti. Toimiiko tämä?


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String idString = request.getParameter("id");
			/*for(int i = 0; i < vastaukset.size(); i++) {
				if (idString==Vastaus.get(i).getId()) {
					
				}
			}*/
			
			int id = new Integer(idString);
			String vastausteksti = request.getParameter("vastausteksti");
			String vastausaika = request.getParameter("vastausaika");
			//int vastausaika = new Integer(vastausaikaString);
			String vastaaja = request.getParameter("vastaaja");
			
			Vastaus vastaus = new Vastaus(id, vastausteksti, vastausaika, vastaaja);
			VastausDAO vastausdao = new VastausDAO();
			vastausdao.addVastaus(vastaus);
			
		} catch (SQLException e) {
			
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
		}
		//String contextPath = request.getContextPath();
		response.sendRedirect("Kiitos");
	}
	

}
