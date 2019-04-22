package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.MyConnect;
import entities.chitiethd;

public class chitiethdModel {
	chitiethd cthd;

	public chitiethdModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public chitiethdModel(chitiethd cthd) {
		super();
		this.cthd = cthd;
	}

	public chitiethd getCthd() {
		return cthd;
	}

	public void setCthd(chitiethd cthd) {
		this.cthd = cthd;
	}
	
	public int add() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "INSERT INTO chitiethoadon VALUES (?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, cthd.getMahd());
			ps.setString(2, cthd.getMasp());
			ps.setInt(3, cthd.getSoluong());
			kq=ps.executeUpdate();
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
