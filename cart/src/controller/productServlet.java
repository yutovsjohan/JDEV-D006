package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entities.product;
import model.productModel;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class productServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
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
		String action = request.getParameter("action");
		String masp = request.getParameter("masp");
		String tensp = request.getParameter("tensp");
		int gia = Integer.parseInt(request.getParameter("gia"));
		int madm = Integer.parseInt(request.getParameter("madm"));
		System.out.println(tensp);
		
		String page="index.jsp";
		String msg=null;
		String chuoi="";		
		
		if(action.equals("add")) {
			Part file = request.getPart("file");
			product p = new product(masp, tensp, gia, "",madm);
			productModel pm = new productModel(p,file);
			
			p.setHinh(pm.getFileName(file));
//			pm.setSanpham(p);
			
			if(pm.add()==0) {
				msg="Thêm thất bại";
				chuoi="danger";
			}
			else {
				msg="Thêm thành công";
				chuoi="success";
				String uploadRootPath = request.getServletContext().getRealPath("image");
//				String uploadRootPath = "F:\\Program Files\\android\\JavaDev\\cart\\WebContent\\image";
//				System.out.println(uploadRootPath);
				pm.uploadFile(uploadRootPath);
			}
		}
		else if(action.equals("update")){
			Part file = request.getPart("file");
			String hinh="";
			product p = new product(masp, tensp, gia, "",madm);
			productModel pm = new productModel(p,file);
			
			if(file.getSize()==0) {
				hinh=pm.getProductByMasp(masp).getHinh();
			}
			else {
				hinh=pm.getFileName(file);
			}
			
			p.setHinh(hinh);
			
			System.out.println("masp: "+masp);
			System.out.println("tensp: "+tensp);
			System.out.println("gia: "+gia);
			System.out.println("hinh: "+hinh);
			System.out.println("madm: "+madm);
			
//			pm.setSanpham(p);
			
			if(pm.update()==0) {
				msg="Update thất bại";
				chuoi="danger";
			}
			else {
				msg="Update thành công";
				chuoi="success";
				
				if(file.getSize()!=0) {
					String uploadRootPath = request.getServletContext().getRealPath("image");
	//				String uploadRootPath = "F:\\Program Files\\android\\JavaDev\\cart\\WebContent\\image";
	//				System.out.println(uploadRootPath);
					pm.uploadFile(uploadRootPath);
				}
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("chuoi", chuoi);
		request.getRequestDispatcher(page).forward(request, response);
	}
}
