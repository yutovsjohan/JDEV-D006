package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entites.account;
import model.accountModel;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		account acc = new account();
		acc.setUsername(username);
		accountModel accmodel = new accountModel(acc);
		
		String message="";
		String page="";
		String flag="";
		
		Connection cn = new MyConnect().getcn();
		if (cn==null) {
			message="Kết nối thất bại";
			page="index.jsp";
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
			return;
		}
		
		String task = request.getParameter("task");
//		if(task.equals("delete")) {
			int kq = accmodel.delete();
			if(kq==0) {
				message="Delete thất bại";
				page="view.jsp";
				flag="danger";
			}
			else {
				message="Delete thành công";
				page="view.jsp";
				flag="success";	
				session.setAttribute("accountList", new accountModel().getList());
			}
			request.setAttribute("flag", flag);
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		account acc = new account(username,password);
		accountModel accmodel = new accountModel(acc);
		HttpSession session = request.getSession();
		String message="";
		String page="";
		String flag="";
		
		Connection cn = new MyConnect().getcn();
		if (cn==null) {
			message="Kết nối thất bại";
			page="index.jsp";
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
			return;
		}
		
		String task = request.getParameter("task");
		
		if(task.equals("login")) {
			String sql = "select * from admin where username like ?";
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					if(rs.getString("password").equals(password)) {
						message="Login thành công";
						page="view.jsp";
						flag="success";	
						session.setAttribute("accountList", accmodel.getList());
					}
					else {
						message="Login thất bại";
						page="index.jsp";
					}
				}
				else {
					message="Username không tồn tại";
					page="index.jsp";
				}
				
				request.setAttribute("flag", flag);
				request.setAttribute("thongbao", message);
				request.getRequestDispatcher(page).forward(request, response);
				
				ps.close();
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(task.equals("insert")) {
			int kq = accmodel.insert();
			if(kq==0) {
				message="Insert thất bại";
				page="view.jsp";
				flag="danger";
			}
			else {	
				message="Insert thành công";
				page="view.jsp";
				flag="success";	
				session.setAttribute("accountList", new accountModel().getList());
			}
			request.setAttribute("flag", flag);
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
		else if(task.equals("update")) {
			int kq = accmodel.update();
			if(kq==0) {
				message="Update thất bại";
				page="view.jsp";
				flag="danger";
			}
			else {
				message="Update thành công";
				page="view.jsp";
				flag="success";		
				session.setAttribute("accountList", new accountModel().getList());
			}
			request.setAttribute("flag", flag);
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		
	}

}
