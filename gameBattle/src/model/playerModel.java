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
import entities.player;

public class playerModel {
	player pl;
	
	public player getPl() {
		return pl;
	}

	public void setPl(player pl) {
		this.pl = pl;
	}

	public playerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public playerModel(player pl) {
		super();
		this.pl = pl;
	}

	public ArrayList<player> getList() {
		ArrayList<player> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		player a;
		String sql = "select * from player";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public player getPlayerById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		player a = null;
		String sql = "select * from player where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public player getPlayerByName(String name) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		player a = null;
		String sql = "select * from player where name=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new player(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
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
		String sql = "INSERT INTO player(name) VALUES (?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pl.getName());
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
		String sql = "UPDATE player SET `name`=?,`level`=?,`exp`=?,`main`=?,`gym`=?,`money`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pl.getName());
			ps.setInt(2, pl.getLevel());
			ps.setInt(3, pl.getExp());
			
			ps.setInt(4, pl.getMain());
			ps.setInt(5, pl.getGym());
			ps.setInt(6, pl.getMoney());
			ps.setInt(7, pl.getId());
			
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
		String sql = "DELETE FROM player WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, pl.getId());		
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
		String sql = "SELECT count(id) count FROM player where id != 0 ";
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
