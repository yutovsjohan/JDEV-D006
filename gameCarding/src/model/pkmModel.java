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
import entities.player;

public class pkmModel {
	pkm pk;
	Part file;

	public pkmModel(pkm pk, Part file) {
		super();
		this.pk = pk;
		this.file = file;
	}

	public pkmModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pkmModel(pkm pk) {
		super();
		this.pk = pk;
	}

	public pkm getPk() {
		return pk;
	}

	public void setPk(pkm pk) {
		this.pk = pk;
	}
	
	public ArrayList<pkm> getList() {
		ArrayList<pkm> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		pkm a;
		String sql = "select * from pkm";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new pkm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public pkm getPkmById(int id) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		pkm a = null;
		String sql = "select * from pkm where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a = new pkm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<pkm> getListByIdplayer(int idplayer) {
		ArrayList<pkm> list = new ArrayList<>();
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return null;
		}
		pkm a;
		String sql = "select * from pkm where idplayer = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, idplayer);
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				a = new pkm(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
				list.add(a);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getIdByName(String name) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		int a = 0;
		String sql = "select * from pkm where name like ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				a=rs.getInt(1);
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public String getFileName(Part filepart) {
		String filename="";
		String header=filepart.getHeader("Content-Disposition");
//		System.out.println("header: "+header);
		int beginIndex=header.lastIndexOf("=");
		filename=header.substring(beginIndex+1);
		
		
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(filename);
		while(m.find()) {
			filename=m.group(1);
		}
//		System.out.println("filename: "+filename);
		
//		Dành cho IE
//		beginIndex=header.lastIndexOf("\\");
//		filename=filename.substring(beginIndex+1);
//		System.out.println("filename: "+filename);
		
		return filename;
	}
	
	public void uploadFile(String uploadRootPath) {
		InputStream fis;
		try {
			fis = file.getInputStream();
			byte[] data = new byte[fis.available()];
			fis.read(data);
			
			FileOutputStream out = new FileOutputStream(new File(uploadRootPath + "\\" + getFileName(file)));
			out.write(data);			
			
			out.close();
		} catch (IOException e) {
			System.out.println("Thất bại");
		}
		System.out.println("Thành công");
	}
	
	public int add() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "INSERT INTO pkm(name, img, level, exp, type, ability, idplayer) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pk.getName());
			ps.setString(2, pk.getImg());
			ps.setInt(3, pk.getLevel());
			ps.setInt(4, pk.getExp());
			ps.setString(5, pk.getType());
			ps.setString(6, pk.getAbility());
			ps.setInt(7, pk.getIdplayer());
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
		
		String sql = "UPDATE `pkm` SET `name`=?,`img`=?,`level`=?, `exp`=?,`type`=?,`ability`=?,`idplayer`=?, friendship=? WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, pk.getName());
			ps.setString(2, pk.getImg());
			ps.setInt(3, pk.getLevel());
			ps.setInt(4, pk.getExp());
			ps.setString(5, pk.getType());
			ps.setString(6, pk.getAbility());
			ps.setInt(7, pk.getIdplayer());
			ps.setInt(8, pk.getFriendship());
			ps.setInt(9, pk.getId());
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
			ps.setInt(1, pk.getId());		
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
		String sql = "SELECT count(id) FROM pkm ";
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
	
	public int noone() {
		int kq=0;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return 0;
		}
		String sql = "UPDATE pkm SET idplayer=0 WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);			
			ps.setInt(1, pk.getId());
			kq=ps.executeUpdate();
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}	
	
	public String output() {
		String str = "";
		str = str + "id: "+this.getPk().getId()+"\n";
		str = str + "name: "+this.getPk().getName()+"\n";
		str = str + "img: "+this.getPk().getImg()+"\n";
		str = str + "level: "+this.getPk().getLevel()+"\n";		
		str = str + "type: "+this.getPk().getType()+"\n";		
		str = str + "ability: "+this.getPk().getAbility()+"\n";
		str = str + "idplayer: "+this.getPk().getIdplayer()+"\n";
		return str;
	}
	
	public boolean checkId(int id) {
		boolean f=false;
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			return false;
		}
		String sql = "select * from pkm WHERE id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				f=true;
			}
			
			ps.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
}
