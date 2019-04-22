package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.MyConnect;
import entities.hoadon;
import entities.product;

public class hoadonModel {
	hoadon hd;

	public hoadonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hoadonModel(hoadon hd) {
		super();
		this.hd = hd;
	}

	public hoadon getHd() {
		return hd;
	}

	public void setHd(hoadon hd) {
		this.hd = hd;
	}
	
	public int add() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "INSERT INTO hoadon VALUES ()";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			kq = ps.executeUpdate();

			sql = "select * from hoadon ";
			ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int getCurrentRow() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "select max(mahd) from hoadon ";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				kq=rs.getInt(1);
			}			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
