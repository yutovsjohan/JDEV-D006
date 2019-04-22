package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.player;
import model.playerModel;

/**
 * Servlet implementation class playerServlet
 */
@WebServlet("/playerServlet")
public class playerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playerServlet() {
        super();	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String page="player.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");
		int id= Integer.parseInt(request.getParameter("id"));
		playerModel plm = new playerModel();
		
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
		
		
		if(action.equals("selectPlayer")) {
			page="player.jsp";
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
		String page="player.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");
		
		String name=request.getParameter("name");
		
		Part file = request.getPart("file");
		String img="user.png";
		
		player p = new player(name, img, 0);
		playerModel plm = new playerModel(p, file);
		
		if(!(file.getSize()==0)) {
			p.setImg(plm.getFileName(file));
		}
		
		if(action.equals("add")) {			
			if(plm.add()==0) {
				msg="Add fail";
				flag="danger";
			}
			else {
				msg="Add success";
				flag="success";
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					plm.uploadFile(uploadRootPath);
				}
			}
		}
		else if(action.equals("update")) {
			
			page = "player.jsp";
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			p = plm.getPlayerById(id);
			
			if(!(file.getSize()==0)) {
				p.setImg(plm.getFileName(file));
			}
			
			if(!name.isEmpty()) {
				p.setName(name);
			}
			
			plm = new playerModel(p,file);			
			
			if(plm.update()==0) {
				msg="Update fail";
				flag="danger";
			}
			else {
				msg="Update success";
				flag="success";
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					plm.uploadFile(uploadRootPath);
				}
			}
		}
		
		else if(action.equals("updateDetail")) {
			int money = Integer.parseInt(request.getParameter("money"));
			page="playerDetail.jsp";
			
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id);
			p = plm.getPlayerById(id);
			
			if(!(file.getSize()==0)) {
				p.setImg(plm.getFileName(file));
			}	
			
			p.setName(name);
			p.setMoney(money);
			
			plm = new playerModel(p,file);
			
			if(plm.update()==0) {
				msg="Update fail";
				flag="danger";
			}
			else {
				msg="Update success";
				flag="success";
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					plm.uploadFile(uploadRootPath);
				}
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
