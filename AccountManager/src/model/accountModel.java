package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entites.account;

public class accountModel {
	account acc;
	public accountModel() {
		// TODO Auto-generated constructor stub
	}
	public accountModel(account acc) {
		super();
		this.acc = acc;
	}
	
	public ArrayList<account> getList() {
		ArrayList<account> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		account a;
		String sql = "select * from admin";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new account(rs.getString(1),rs.getString(2));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int insert() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		String sql = "INSERT INTO admin(username, password) VALUES (?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, acc.getUsername());
			ps.setString(2, acc.getPassword());
			kq=ps.executeUpdate();
			
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
		String sql = "UPDATE admin SET password=? WHERE username=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, acc.getPassword());
			ps.setString(2, acc.getUsername());			
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int delete() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		String sql = "DELETE FROM admin WHERE username=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, acc.getUsername());			
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
