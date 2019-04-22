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
import entities.pkm;
import entities.stat;

public class statModel {
	stat st;

	public statModel(stat st) {
		super();
		this.st = st;
	}

	public statModel() {
		super();
		this.st = new stat();
	}

	public stat getSt() {
		return st;
	}

	public void setSt(stat st) {
		this.st = st;
	}
	
	public ArrayList<stat> getList() {
		ArrayList<stat> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		stat a;
		String sql = "select * from stat";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new stat(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public stat getStatById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		stat a = null;
		String sql = "select * from stat where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new stat(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8));
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
		String sql = "INSERT INTO stat VALUES ()";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);			
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
		
		String sql = "UPDATE `stat` SET `atk`=?,`hp`=?,`de`=?,`ct`=?,`cd`=?,`ev`=?,`bl`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, st.getAtk());
			ps.setInt(2, st.getHp());
			ps.setInt(3, st.getDe());
			ps.setFloat(4, st.getCt());
			
			ps.setFloat(5, st.getCd());
			ps.setFloat(6, st.getEv());
			ps.setFloat(7, st.getBl());			
			ps.setInt(8, st.getId());
			
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
		String sql = "DELETE FROM pkm WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, st.getId());		
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
}
