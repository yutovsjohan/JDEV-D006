package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		String username = request.getParameter("txtname");
		String password = request.getParameter("txtpass");
		String page = "";
		
		String message = "";
		
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			message = "Kết nối thất bại";
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}
		
		String sql = "select username, password from admin where username like ?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(rs.getString(1).equalsIgnoreCase(username) && rs.getString(2).equalsIgnoreCase(password)){
					message = "Login thành công";
					page = "view.jsp";
				}
				else {
					message = "Login thất bại";					
					page = "error.jsp";
				}
			}
			else {
				message = "Username không tồn tại";
				page = "error.jsp";
			}
			
			request.setAttribute("thongbao", message);
			request.getRequestDispatcher(page).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
