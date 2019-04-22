package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.MyConnect;
import entities.contest;
import entities.detailcontest;

public class detailcontestModel {
	detailcontest dc;

	public detailcontestModel(detailcontest dc) {
		super();
		this.dc = dc;
	}

	public detailcontestModel() {
		super();
		this.dc = new detailcontest();
	}

	public detailcontest getDc() {
		return dc;
	}

	public void setDc(detailcontest dc) {
		this.dc = dc;
	}
	
	public ArrayList<detailcontest> getList() {
		ArrayList<detailcontest> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		detailcontest a;
		String sql = "select * from detailcontest";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new detailcontest(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<detailcontest> getListByIdContest(int idcontest) {
		ArrayList<detailcontest> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		detailcontest a;
		String sql = "select * from detailcontest where idcontest = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idcontest);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new detailcontest(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public detailcontest getDetailContestById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		detailcontest a = null;
		String sql = "select * from detailcontest where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new detailcontest(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
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
		String sql = "INSERT INTO `detailcontest`(`idcontest`, `idplayer`, `idpkm`)  VALUES (?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, dc.getIdcontest());
			ps.setInt(2, dc.getIdplayer());
			ps.setInt(3, dc.getIdpkm());
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
		String sql = "UPDATE `detailcontest` SET `idcontest`=?,`idplayer`=?,`idpkm`=?,`point`=?,`rank`=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, dc.getIdcontest());
			ps.setInt(2, dc.getIdplayer());
			ps.setInt(3, dc.getIdpkm());			
			
			ps.setInt(4, dc.getPoint());
			ps.setInt(5, dc.getRank());			
			ps.setInt(6, dc.getId());
			
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
		String sql = "DELETE FROM detailcontest WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, dc.getId());		
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
		String sql = "SELECT count(id) count FROM detailcontest ";
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
