package model;

import java.util.ArrayList;
import java.util.HashMap;

import entities.item;
import entities.product;

public class cartModel {
	HashMap<String, item> cart;
	
	public cartModel() {
		super();
		cart = new HashMap<>();
	}

	public cartModel(HashMap<String, item> cart) {
		super();
		this.cart = cart;
	}

	public HashMap<String, item> getCart() {
		return cart;
	}

	public void setCart(HashMap<String, item> cart) {
		this.cart = cart;
	}
	
	public void add(String masp) {
		if(cart.containsKey(masp)) {
			item a = cart.get(masp);
			a.setSoluong(a.getSoluong()+1);
		}
		else {
			product sp = new productModel().getProductByMasp(masp);
			item a = new item(sp,1); 
			cart.put(masp, a);
		}
	}
	
	public void delete(String masp) {
		cart.remove(masp);
	}
	
	public void deleteAll() {
		cart.clear();
	}
	
	public ArrayList<item> getList(){
		ArrayList<item> giohang = new ArrayList<>();
		for (item i : cart.values()) {
			giohang.add(i);
		}
		return giohang;
	}
	
	public int total() {
		int total=0;
		for (item i : cart.values()) {
			total += (i.getSoluong() * i.getSanpham().getGia());
		}
		return total;
	}
}
