package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.chitiethd;
import entities.hoadon;
import entities.item;
import model.cartModel;
import model.chitiethdModel;
import model.hoadonModel;
import model.productModel;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cartModel cart = new cartModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String page="cart.jsp";
		String masp=request.getParameter("masp");
		
		HttpSession session = request.getSession();
		
				
		Connection cn = new MyConnect().getcn(); 
		if(cn==null) {
			return;
		}
		
		if(action.equals("viewcart")) {}
		else if(action.equals("add")) {
			cart.add(masp);
		}
		else if(action.equals("delete")) {
			cart.delete(masp);
		}
		else if(action.equals("deleteAll")) {
			cart.deleteAll();
		}
		else if(action.equals("buy")) {			
			hoadon hd = new hoadon();
			hoadonModel hdModel = new hoadonModel(hd);
			String msg = null;
			String chuoi="danger";
			
			boolean f = true;
			
			int kq = hdModel.add();
			
			if(kq==0) {
				msg="Đăt mua không thành công";
				f=false;
			}
			else {
				int idhd = hdModel.getCurrentRow();
				
				chitiethd cthd;
				chitiethdModel cthdModel;
				
				ArrayList<item> gh = cart.getList();
				
				for (item i : gh) {
					cthd  = new chitiethd(idhd,i.getSanpham().getMasp(),i.getSoluong());
					cthdModel = new chitiethdModel(cthd);
					if(cthdModel.add()==0) {
						msg="Đăt mua không thành công";
						f=false;
						break;
					}
				}
				
				if(f) {
					cart.deleteAll();
					msg="Đặt mua thành công";
					chuoi="success";
				}
			}
			
			page="index.jsp";
			request.setAttribute("msg", msg);
			request.setAttribute("chuoi", chuoi);
		}
		
		request.setAttribute("total", cart.total());
		request.setAttribute("cart", cart.getList());
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String page;		
		HttpSession session = request.getSession();
				
		Connection cn = new MyConnect().getcn(); 
		if(cn==null) {
			return;
		}
		
			
		hoadon hd = new hoadon();
		hoadonModel hdModel = new hoadonModel(hd);
		String msg = null;
		String chuoi="danger";
		
		boolean f = true;
		
		int kq = hdModel.add();
		
		if(kq==0) {
			msg="Đăt mua không thành công";
			f=false;
		}
		else {
			int idhd = hdModel.getCurrentRow();
			
			chitiethd cthd;
			chitiethdModel cthdModel;
			
			ArrayList<item> gh = cart.getList();
			
			for (item i : gh) {
				cthd  = new chitiethd(idhd,i.getSanpham().getMasp(),i.getSoluong());
				cthdModel = new chitiethdModel(cthd);
				if(cthdModel.add()==0) {
					msg="Đăt mua không thành công";
					f=false;
					break;
				}
			}
			
			if(f) {
				cart.deleteAll();
				msg="Đặt mua thành công";
				chuoi="success";
			}
		}
		
		page="index.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("chuoi", chuoi);		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
