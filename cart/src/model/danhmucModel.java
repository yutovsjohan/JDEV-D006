package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.product;
import entities.danhmuc;

public class danhmucModel {
	danhmuc dm;

	public danhmucModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public danhmucModel(danhmuc dm) {
		super();
		this.dm = dm;
	}

	public danhmuc getDm() {
		return dm;
	}

	public void setDm(danhmuc dm) {
		this.dm = dm;
	}
	
	public ArrayList getList(){
		ArrayList<danhmuc> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null){
			return null;
		}
		
		String sql = "select * from danhmuc";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				danhmuc temp = new danhmuc(rs.getInt(1),rs.getString(2));
				list.add(temp);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getTendmByMadm(String madm) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		String a="";
		String sql = "select tendm from danhmuc where madm=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, madm);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = rs.getString(1);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}