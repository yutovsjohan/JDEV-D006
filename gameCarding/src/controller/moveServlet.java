package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.move;
import model.moveModel;
import model.playerModel;

/**
 * Servlet implementation class moveServlet
 */
@WebServlet("/moveServlet")
public class moveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String page="move.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");
		
		Connection cn = new MyConnect().getcn();
		if (cn==null) {
			msg="Kết nối thất bại";
			page="index.jsp";
			flag="danger";
			request.setAttribute("msg", msg);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher(page).forward(request, response);
			return;
		}
						
		
		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String page="move.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");
		
		Connection cn = new MyConnect().getcn();
		if (cn==null) {
			msg="Kết nối thất bại";
			page="index.jsp";
			flag="danger";
			request.setAttribute("msg", msg);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher(page).forward(request, response);
			return;
		}
		
		move m = new move();
		moveModel mm = new moveModel(m);
		
		if(action.equals("add")) {	
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String eff1 = request.getParameter("eff1");
			String eff2 = request.getParameter("eff2");
			String status = request.getParameter("status");
			String obj1 = request.getParameter("obj1");
			String obj2 = request.getParameter("obj2");
			
			int power = Integer.parseInt(request.getParameter("power"));
			int energy = Integer.parseInt(request.getParameter("energy"));
			int acc = Integer.parseInt(request.getParameter("acc"));
			int point1 = Integer.parseInt(request.getParameter("point1"));
			int point2 = Integer.parseInt(request.getParameter("point2"));
			int perEff1 = Integer.parseInt(request.getParameter("perEff1"));
			int perEff2 = Integer.parseInt(request.getParameter("perEff2"));
			int perStatus = Integer.parseInt(request.getParameter("perStatus"));
			
			m = new move(name, power, energy, type, acc, eff1, point1, obj1, perEff1 , eff2, point2, obj2, perEff2 ,status, perStatus);
			mm.setM(m);
			
			if(mm.add()==0) {
				msg="Add fail";
				flag="danger";
			}
			else {
				msg="Add success";
				flag="success";
			}
		}
		else if(action.equals("update")) {			
			int id = Integer.parseInt(request.getParameter("id"));
			
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			String eff1 = request.getParameter("eff1");
			String eff2 = request.getParameter("eff2");
			String status = request.getParameter("status");
			String obj1 = request.getParameter("obj1");
			String obj2 = request.getParameter("obj2");
			
			int power = Integer.parseInt(request.getParameter("power"));
			int energy = Integer.parseInt(request.getParameter("energy"));
			int acc = Integer.parseInt(request.getParameter("acc"));
			int point1 = Integer.parseInt(request.getParameter("point1"));
			int point2 = Integer.parseInt(request.getParameter("point2"));
			int perEff1 = Integer.parseInt(request.getParameter("perEff1"));
			int perEff2 = Integer.parseInt(request.getParameter("perEff2"));
			int perStatus = Integer.parseInt(request.getParameter("perStatus"));
			
			m = new move(name, power, energy, type, acc, eff1, point1, obj1, perEff1 , eff2, point2, obj2, perEff2 ,status, perStatus);
			mm.setM(m);
			
			if(mm.update()==0) {
				msg="Update fail";
				flag="danger";
			}
			else {
				msg="Update success";
				flag="success";				
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
