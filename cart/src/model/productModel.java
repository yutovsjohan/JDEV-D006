package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import controller.MyConnect;
import entities.product;

public class productModel {
	product sanpham;
	Part file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public productModel(product sanpham, Part file) {
		super();
		this.sanpham = sanpham;
		this.file = file;
	}

	public productModel(Part file) {
		super();
		this.file = file;
	}

	public productModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public productModel(product sanpham) {
		super();
		this.sanpham = sanpham;
	}

	public product getSanpham() {
		return sanpham;
	}

	public void setSanpham(product sanpham) {
		this.sanpham = sanpham;
	}
	
	public ArrayList<product> getList() {
		ArrayList<product> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		product a;
		String sql = "select * from product";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public product getProductByMasp(String masp) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		product a = null;
		String sql = "select * from product where masp=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, masp);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new product(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public String getFileName(Part filepart) {
		String filename="";
		String header=filepart.getHeader("Content-Disposition");
//		System.out.println("header: "+header);
		int beginIndex=header.lastIndexOf("=");
		filename=header.substring(beginIndex+1);
		
		
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(filename);
		while(m.find()) {
			filename=m.group(1);
		}
//		System.out.println("filename: "+filename);
		
//		beginIndex=header.lastIndexOf("\\");
//		filename=filename.substring(beginIndex+1);
//		System.out.println("filename: "+filename);
		
		return filename;
	}
	
	public void uploadFile(String uploadRootPath) {
		InputStream fis;
		try {
			fis = file.getInputStream();
			byte[] data = new byte[fis.available()];
			fis.read(data);
			
			FileOutputStream out = new FileOutputStream(new File(uploadRootPath + "\\" + getFileName(file)));
			out.write(data);			
			
			out.close();
		} catch (IOException e) {
			System.out.println("Thất bại");
		}
		System.out.println("Thành công");
	}
	
	public int add() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "INSERT INTO product VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sanpham.getMasp());
			ps.setString(2, sanpham.getTensp());
			ps.setInt(3, sanpham.getGia());
			ps.setString(4, sanpham.getHinh());
			ps.setInt(5, sanpham.getMadm());
			kq = ps.executeUpdate();
									
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int update() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "UPDATE product SET tensp=?, gia=?, hinh=?, madm=? WHERE masp=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sanpham.getTensp());
			ps.setInt(2, sanpham.getGia());
			ps.setString(3, sanpham.getHinh());
			ps.setInt(4, sanpham.getMadm());
			ps.setString(5, sanpham.getMasp());
			kq = ps.executeUpdate();
									
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
