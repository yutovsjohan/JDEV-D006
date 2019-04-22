package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.contest;
import model.contestModel;

/**
 * Servlet implementation class contestServlet
 */
@WebServlet("/contestServlet")
public class contestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String page="contest.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");

		if(action.equals("add")){
			String name = request.getParameter("name");
			String prize= request.getParameter("prize");
			int money = Integer.parseInt(request.getParameter("money"));
			contest ct = new contest(name,0,"",prize,money,"");
			contestModel ctm = new contestModel(ct);
			
			if(ctm.add()==0) {
				msg="Add fail";
				flag="danger";
			}
			else {
				msg="Add success";
				flag="success";				
			}
		}

		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
