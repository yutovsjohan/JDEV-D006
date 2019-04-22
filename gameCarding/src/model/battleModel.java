package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.battle;
import entities.pkm;

public class battleModel {
	battle b;

	public battleModel(battle b) {
		super();
		this.b = b;
	}

	public battleModel() {
		super();
		this.b = new battle();
	}

	public battle getB() {
		return b;
	}

	public void setB(battle b) {
		this.b = b;
	}
	
	public ArrayList<battle> getList() {
		ArrayList<battle> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		battle a;
		String sql = "select * from battle";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new battle(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getString(16),rs.getString(17));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public battle getBattleByName(String name) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		battle a = null;
		String sql = "select * from battle where name like ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new battle(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getString(16),rs.getString(17));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public battle getBattleById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		battle a = null;
		String sql = "select * from battle where id = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new battle(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getString(16),rs.getString(17));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int getIdByName(String name) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		int a=0;
		String sql = "select * from battle where name like ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = rs.getInt(1);
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
		String sql = "INSERT INTO `battle`(`name`, `level`, `type`, `ability`, `atk`, `hp`, `de`, `ct`, `cd`, `ev`, `bl`, `blpoint`, `att`, `energy`, `status`, `note`)  VALUES (?,?,?,?, ?,?,?,?, ?,?,?,?, ?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, b.getName());
			ps.setInt(2, b.getLevel());
			ps.setString(3, b.getType());
			ps.setString(4, b.getAbility());
			
			ps.setInt(5, b.getAtk());
			ps.setInt(6, b.getHp());
			ps.setInt(7, b.getDe());
			ps.setInt(8, b.getCt());
			
			ps.setInt(9, b.getCd());
			ps.setInt(10, b.getEv());
			ps.setInt(11, b.getBl());
			ps.setInt(12, b.getBlpoint());
			
			ps.setInt(13, b.getAtt());
			ps.setInt(14, b.getEnergy());
			ps.setString(15, b.getStatus());
			ps.setString(16, b.getNote());
			
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
		
		String sql = "UPDATE `battle` SET `name`=?,`level`=?,`type`=?,`ability`=?,`atk`=?,`hp`=?,`de`=?,`ct`=?,`cd`=?,`ev`=?,`bl`=?,`blpoint`=?,`att`=?,`energy`=?,`status`=?,`note`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, b.getName());
			ps.setInt(2, b.getLevel());
			ps.setString(3, b.getType());
			ps.setString(4, b.getAbility());
			
			ps.setInt(5, b.getAtk());
			ps.setInt(6, b.getHp());
			ps.setInt(7, b.getDe());
			ps.setInt(8, b.getCt());
			
			ps.setInt(9, b.getCd());
			ps.setInt(10, b.getEv());
			ps.setInt(11, b.getBl());
			ps.setInt(12, b.getBlpoint());
			
			ps.setInt(13, b.getAtt());
			ps.setInt(14, b.getEnergy());
			ps.setString(15, b.getStatus());
			ps.setString(16, b.getNote());
			
			ps.setInt(17, b.getId());
			
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
		String sql = "DELETE FROM battle WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, b.getId());		
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int deleteAll() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "DELETE FROM battle";
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
	
	public ArrayList<Integer> getTwoRows() {
		ArrayList<Integer> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		
		String sql = "select id from battle ORDER BY id DESC LIMIT 2";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String output() {
		String str = "";		
		str = str + "name: "+this.getB().getName()+"\n";
		str = str + "level: "+this.getB().getLevel()+"\n";		
		str = str + "type: "+this.getB().getType()+"\n";		
		str = str + "ability: "+this.getB().getAbility()+"\n";
		str = str + "atk: "+this.getB().getAtk()+"\n";
		return str;
	}
}
