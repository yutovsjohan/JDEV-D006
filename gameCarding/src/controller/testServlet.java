package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String page="test.jsp";
		response.setContentType("text/plain");
		
		String move = request.getParameter("select");
		int hp2 = Integer.parseInt(request.getParameter("hp2"));
		int hp = Integer.parseInt(request.getParameter("hp"));
		
		String str = "";

		if(move.equalsIgnoreCase("icebeam")) {
			int power = 1200;
						 			
			if(hp2 > 0) {
				hp2 -= power;
			}
			
			if(hp2 < 0) {
				hp2 = 0;
			}
			
			int perEff = 40;
			int random = new Random().nextInt(500) + 1;
			String status = "";
			
			if(perEff >= random) {
				status = "freeze";
			}
			
			str += hp2 + "," + status + "," + random + "," + hp;
									
			response.getWriter().print(str);
		}
		else if(move.contentEquals("blastburn")) {
			int power = 1500;
			
			if(hp2 > 0) {
				hp2 -= power;
			}
			
			if(hp2 < 0) {
				hp2 = 0;
			}
			
			int perEff = 50;
			int random = new Random().nextInt(100) + 1;
			String status = "";			
			
			if(perEff >= random) {
				status = "burn";
			}
			
			str += hp2 + "," + status + "," + random + "," + hp;
									
			response.getWriter().print(str);
		}
		else if(move.contentEquals("gigadrain")) {
			
			int power = 700;
			
			if(hp2 > 0) {
				hp2 -= power;
			}
			
			if(hp2 < 0) {
				hp2 = 0;
			}
			
			hp = hp + (hp/100);
			
			String status = "";		
			int random = 100;			
			
			str += hp2 + "," + status + "," + random + "," + hp;
									
			response.getWriter().print(str);
		}	
//		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
