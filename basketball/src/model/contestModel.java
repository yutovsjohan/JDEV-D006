package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.contest;
import entities.player;

public class contestModel {
	contest c;
	public contestModel() {
		this.c = new contest();
	}
	public contestModel(contest c) {
		super();
		this.c = c;
	}
	public contest getC() {
		return c;
	}
	public void setC(contest c) {
		this.c = c;
	}
	
	public ArrayList<contest> getList() {
		ArrayList<contest> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		contest a;
		String sql = "select * from contest";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new contest(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public contest getContestById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		contest a = null;
		String sql = "select * from contest where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new contest(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int add() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "INSERT INTO `contest`(`name`) VALUES (?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, c.getName());
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
		if(cn==null) {
			return 0;
		}
		String sql = "UPDATE `contest` SET `name`=?,`soluong`=?,`winner`=?,`mvp`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setInt(2, c.getSoluong());
			ps.setString(3, c.getWinner());
			
			ps.setString(4, c.getMvp());
			ps.setInt(5, c.getId());
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
		if(cn==null) {
			return 0;
		}
		String sql = "DELETE FROM contest WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, c.getId());		
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int count() {
		int count=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "SELECT count(id) count FROM contest ";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
