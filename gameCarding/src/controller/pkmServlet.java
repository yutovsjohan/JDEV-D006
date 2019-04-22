package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.pkm;
import entities.player;
import entities.stat;
import model.pkmModel;
import model.playerModel;
import model.statModel;

/**
 * Servlet implementation class pkmServlet
 */
@WebServlet("/pkmServlet")
public class pkmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pkmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String page="pkm.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");
		int id= Integer.parseInt(request.getParameter("id"));
		pkm p = new pkm();
		p.setId(id);
		pkmModel pkm = new pkmModel(p);
		
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
				
		if(action.equals("noone")) {
			pkm.noone();
		}
		else if(action.equals("selectpkm")) {
//			response.setContentType("text/plain");
			
			String str="";
			if(pkm.checkId(id)) {
				p = pkm.getPkmById(id);
				str = p.getName();
			}
			
			response.getWriter().print(str);
			return;
		}
		if(action.equals("selectpkUpdate")) {
			page="pkm.jsp";	
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
		String page="pkm.jsp";
		String msg=null;
		String flag="success";
		String action=request.getParameter("action");				
		
		if(action.equals("add")) {
			String name=request.getParameter("name");		
			int idplayer= Integer.parseInt(request.getParameter("idplayer"));
			Part file = request.getPart("file");
			String img="user.png";
			
			pkm p = new pkm(name, img, 1, 0, "", "", idplayer, 0);
			pkmModel pkm = new pkmModel(p, file);
			
			if(!(file.getSize()==0)) {
				p.setImg(pkm.getFileName(file));
			}
			
			String type=request.getParameter("type");
			String ability=request.getParameter("ability");
			
			p.setAbility(ability);
			p.setType(type);
			
			pkm.setPk(p);
			
			if(pkm.add()==0) {
				msg="Add fail";
				flag="danger";
			}
			else {
				statModel sm = new statModel();
				sm.add();
				
				msg="Add success";
				flag="success";
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					pkm.uploadFile(uploadRootPath);
				}
			}
		}
		else if(action.equals("update")) {
			page = "pkm.jsp";
			int id = Integer.parseInt(request.getParameter("id"));
			pkmModel pkm = new pkmModel();
			pkm p = pkm.getPkmById(id);
			
			String name=request.getParameter("name");		
			int idplayer= Integer.parseInt(request.getParameter("idplayer"));
			Part file = request.getPart("file");
			
			
			if(!(file.getSize()==0)) {
				p.setImg(pkm.getFileName(file));
			}
			
			
			
			if(!name.equals("")) {
				p.setName(name);
			}			
			
			if(!(file.getSize()==0)) {
				p.setImg(pkm.getFileName(file));
			}
			
			p.setIdplayer(idplayer);
			
			pkm = new pkmModel(p,file);			
			
			if(pkm.update()==0) {
				msg="Update fail";
				flag="danger";
			}
			else {
				msg="Update success";
				flag="success";
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					pkm.uploadFile(uploadRootPath);
				}
			}
		}
		else if(action.equals("detail")) {			
			int id = Integer.parseInt(request.getParameter("id"));
			pkmModel pkm = new pkmModel(); 	
			
			pkm pk = pkm.getPkmById(id);
			page="pkmDetail.jsp";
			
			Part file = request.getPart("file");
			if(!(file.getSize()==0)) {
				pk.setImg(pkm.getFileName(file));
			}
			
			String name = request.getParameter("name");
			int level = Integer.parseInt(request.getParameter("level"));
			String type = request.getParameter("type");
			String ability = request.getParameter("ability");
			int idplayer = Integer.parseInt(request.getParameter("idplayer"));						
			
			pk.setName(name);		
			pk.setLevel(level);
			pk.setType(type);
			pk.setAbility(ability);
			pk.setIdplayer(idplayer);
			
			stat st = new statModel().getStatById(id);
			
			int atk = Integer.parseInt(request.getParameter("atk"));
			int hp = Integer.parseInt(request.getParameter("hp"));
			int de = Integer.parseInt(request.getParameter("de"));
			int ct = Integer.parseInt(request.getParameter("ct"));
			int cd = Integer.parseInt(request.getParameter("cd"));
			int ev = Integer.parseInt(request.getParameter("ev"));
			int bl = Integer.parseInt(request.getParameter("bl"));
			int blpoint = Integer.parseInt(request.getParameter("blpoint"));
			int att = Integer.parseInt(request.getParameter("att"));
			int energy = Integer.parseInt(request.getParameter("energy"));

			st.setAtk(atk);
			st.setHp(hp);
			st.setCd(cd);
			st.setCt(ct);
			st.setDe(de);
			st.setBl(bl);
			st.setBlpoint(blpoint);
			st.setAtt(att);
			st.setEnergy(energy);
			st.setEv(ev);
			
			statModel sm = new statModel(st);
			sm.update();
			
			pkm.setPk(pk);
			System.out.println(pkm.output());
			
			if(pkm.update()==0) {
				msg="Update fail";
				flag="danger";
			}
			else {
				msg="Update success";
				flag="success";				
				if(!(file.getSize()==0)) {
					String uploadRootPath = request.getServletContext().getRealPath("img");
					pkm.uploadFile(uploadRootPath);
				}
				
			}
			
			request.setAttribute("id", id);
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

}


