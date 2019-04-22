package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.battle;
import entities.move;
import entities.pkm;
import entities.player;
import entities.stat;
import model.battleModel;
import model.moveModel;
import model.pkmModel;
import model.playerModel;
import model.statModel;

/**
 * Servlet implementation class BattleServlet
 */
@WebServlet("/BattleServlet")
public class BattleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	pkm pk1 = new pkm();
	pkm pk2 = new pkm();
	stat st1 = new stat();
	stat st2 = new stat();
	String status1="";
	String status2="";
	int id1=1;
	int id2=1;
	battle b = new battle();
	battleModel bm = new battleModel();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");								
		
		String page="test.jsp";
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
		
		pkm pk = new pkm();
		stat st = new stat();
		String eff = "";
		int num=0;
		
		if(action.equals("init")) {			
			int kq1=0;
			int kq2=0;
			
			id1 = Integer.parseInt(request.getParameter("idpk1"));
			id2 = Integer.parseInt(request.getParameter("idpk2"));			
			
			System.out.println(id1);
			System.out.println(id2);
			
			pk = new pkmModel().getPkmById(id1);			
			st = new statModel().getStatById(id1);
			
			b.setName(pk.getName());
			b.setLevel(pk.getLevel());
			b.setType(pk.getType());
			b.setAbility(pk.getAbility());
			
			b.setAtk(st.getAtk());
			b.setHp(st.getHp());
			b.setDe(st.getDe());
			b.setCt(st.getCt());
			
			b.setCd(st.getCd());
			b.setEv(st.getEv());
			b.setBl(st.getBl());
			b.setBlpoint(st.getBlpoint());
			
			b.setAtt(st.getAtt());
			b.setEnergy(0);
			b.setStatus("");
			b.setNote("");
			
			bm.setB(b);
			kq1 = bm.add();
			
			System.out.println(bm.output());
			
			pk = new pkmModel().getPkmById(id2);
			st = new statModel().getStatById(id2);
					
			b.setName(pk.getName());
			b.setLevel(pk.getLevel());
			b.setType(pk.getType());
			b.setAbility(pk.getAbility());
			
			b.setAtk(st.getAtk());
			b.setHp(st.getHp());
			b.setDe(st.getDe());
			b.setCt(st.getCt());
			
			b.setCd(st.getCd());
			b.setEv(st.getEv());
			b.setBl(st.getBl());
			b.setBlpoint(st.getBlpoint());
			
			b.setAtt(st.getAtt());
			b.setEnergy(0);
			b.setStatus("");
			b.setNote("");
			
			bm.setB(b);
			kq2 = bm.add();
			
			System.out.println(bm.output());
			
			page="test.jsp";
		}
		
		else if(action.equals("energy")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int energy = Integer.parseInt(request.getParameter("energy"));
			
			pk = new pkmModel().getPkmById(id);
			
			b = bm.getBattleByName(pk.getName());
			
			b.setEnergy(energy);
			bm.setB(b);
			
			bm.update();
			response.getWriter().print(energy);

			return;
		}		
		
		else if(action.equals("move")) {
			int idmove = Integer.parseInt(request.getParameter("idmove"));
			int idpk = Integer.parseInt(request.getParameter("idpk"));
			
			if(idpk==id2) {
				pkm pktemp = pk1;
				pk1 = pk2;
				pk2 = pktemp;
				
				stat stattemp = st1;
				st1 = st2;
				st2 = stattemp;
				
				String temp = status1;
				status1 = status2;
				status2 = temp;
			}
						
			move m = new moveModel().getMoveById(idmove);
			
			st2.setAtk(st2.getAtk()-m.getPower());
			
			if(!m.getEff1().equals("none")) {
				if(m.getObj1().equals("self")) {
					pk = pk1;
					st = st1;
				}
				else {
					pk = pk2;
					st = st2;
				}
				eff = m.getEff1();
				
				switch(eff) {
				case "atk":
					num = st.getAtk() + m.getPoint1();
					st.setAtk(num);
					break;
				case "hp":
					num = st.getHp() + m.getPoint1();
					st.setHp(num);
					break;
				case "de":
					num = st.getDe() + m.getPoint1();
					st.setDe(num);
					break;
				case "ct":
					num = st.getCt() + m.getPoint1();
					st.setCt(num);
					break;
				case "cd":
					num = st.getCd() + m.getPoint1();
					st.setCd(num);
					break;
				case "ev":
					num = st.getEv() + m.getPoint1();
					st.setEv(num);
					break;
				case "bl":
					num = st.getBl() + m.getPoint1();
					st.setBl(num);
					break;
				case "att":
					num = st.getAtt() + m.getPoint1();
					st.setAtt(num);
					break;
				case "energy":
					num = st.getEnergy() + m.getPoint1();
					st.setEnergy(num);
					break;
				}			
				
				if(m.getObj1().equals("self")) {
					st1 = st;
				}
				else {
					st2 = st;
				}
			}
			
			if(!m.getEff2().equals("none")) {
				if(m.getObj2().equals("self")) {
					pk = pk1;
					st = st1;
				}
				else {
					pk = pk2;
					st = st2;
				}
				eff = m.getEff2();
				
				switch(eff) {
				case "atk":
					num = st.getAtk() + m.getPoint2();
					st.setAtk(num);
					break;
				case "hp":
					num = st.getHp() + m.getPoint2();
					st.setHp(num);
					break;
				case "de":
					num = st.getDe() + m.getPoint2();
					st.setDe(num);
					break;
				case "ct":
					num = st.getCt() + m.getPoint2();
					st.setCt(num);
					break;
				case "cd":
					num = st.getCd() + m.getPoint2();
					st.setCd(num);
					break;
				case "ev":
					num = st.getEv() + m.getPoint2();
					st.setEv(num);
					break;
				case "bl":
					num = st.getBl() + m.getPoint2();
					st.setBl(num);
					break;
				case "att":
					num = st.getAtt() + m.getPoint2();
					st.setAtt(num);
					break;
				case "energy":
					num = st.getEnergy() + m.getPoint2();
					st.setEnergy(num);
					break;
				}		
				
				if(m.getObj2().equals("self")) {
					st1 = st;
				}
				else {
					st2 = st;
				}
			}
			
			if(!m.getStatus().equals("none")) {
				status2 = m.getStatus();
			}
			
			
			if(idpk==id2) {
				pkm pktemp = pk1;
				pk1 = pk2;
				pk2 = pktemp;
				
				stat stattemp = st1;
				st1 = st2;
				st2 = stattemp;
				
				String temp = status1;
				status1 = status2;
				status2 = temp;
			}
			
		}
		else if(action.equals("winner")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			player player = new playerModel().getPlayerById(id);
			
			player.setWin(player.getWin()+1);
			
			playerModel pm = new playerModel(player);
			
			pm.update();
			
			String str="";
			str = "Winner is "+player.getName();
			
			id = Integer.parseInt(request.getParameter("id2"));
			
			player = new playerModel().getPlayerById(id);
			
			player.setLose(player.getLose()+1);
			
			pm = new playerModel(player);
			
			pm.update();	
			
			
			response.getWriter().print(str);

			return;
		}	
							
		
		request.setAttribute("msg", msg);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher(page).forward(request, response);
	}

}


//String str = "";
//int need = 100;
//int atk = 5;
//int hp=20;
//int de=3;
//int ct=3;
//int cd=3;
//int ev=3;
//int bl=3;
//int blpoint=2;
//int att=3;
//int energy=5;
//int friendship=2;
//
//for(int i=1;i<=100;i++){
//	need = 100 * i;
//	str = "INSERT INTO `exp` VALUES (" + i + "," + need + "," + atk + "," + hp + "," + de + "," + ct + "," + cd + "," + ev + "," + bl + "," + blpoint + "," + att + "," + energy + "," + friendship + ");";
//	System.out.println(str);
//}
//System.out.println();

