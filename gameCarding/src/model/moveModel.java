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
import entities.move;
import entities.pkm;

public class moveModel {
	move m;
	
	
	public moveModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public moveModel(move m) {
		super();
		this.m = m;
	}

	public move getM() {
		return m;
	}

	public void setM(move m) {
		this.m = m;
	}

	public ArrayList<move> getList() {
		ArrayList<move> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		move a;
		String sql = "select * from move";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new move(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getString(15),rs.getInt(16));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public move getMoveById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		move a = null;
		String sql = "select * from move where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new move(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getString(15),rs.getInt(16));
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
		String sql = "INSERT INTO `move`(`name`, `power`, `energy`, `type`, `acc`, `eff1`, `point1`, `obj1`, `perEff1`, `eff2`, `point2`, `obj2`, `perEff2`, `status`, `perStatus`) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getPower());
			ps.setInt(3, m.getEnergy());
			ps.setString(4, m.getType());
			ps.setInt(5, m.getAcc());
			
			ps.setString(6, m.getEff1());
			ps.setInt(7, m.getPoint1());
			ps.setString(8, m.getObj1());
			ps.setInt(9, m.getPerEff1());
			ps.setString(10, m.getEff2());
			
			ps.setInt(11, m.getPoint2());
			ps.setString(12, m.getObj2());
			ps.setInt(13, m.getPerEff2());
			ps.setString(14, m.getStatus());
			ps.setInt(15, m.getPerStatus());
						
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
		String sql = "UPDATE `move` SET `name`=?,`power`=?,`energy`=?,`type`=?,`acc`=?,`eff1`=?,`point1`=?,`obj1`=?, `perEff1`=? ,`eff2`=?,`point2`=?,`obj2`=?,`perEff2`=? ,`status`=?, `perStatus`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setInt(2, m.getPower());
			ps.setInt(3, m.getEnergy());
			ps.setString(4, m.getType());
			ps.setInt(5, m.getAcc());
			
			ps.setString(6, m.getEff1());
			ps.setInt(7, m.getPoint1());
			ps.setString(8, m.getObj1());
			ps.setInt(9, m.getPerEff1());
			ps.setString(10, m.getEff2());
			
			ps.setInt(11, m.getPoint2());
			ps.setString(12, m.getObj2());
			ps.setInt(13, m.getPerEff2());
			ps.setString(14, m.getStatus());
			ps.setInt(15, m.getPerStatus());
			
			ps.setInt(16, m.getId());
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
		String sql = "DELETE FROM move WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, m.getId());		
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
		String sql = "SELECT count(id) FROM move ";
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
