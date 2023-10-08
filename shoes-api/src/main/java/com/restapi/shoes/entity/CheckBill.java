package com.restapi.shoes.entity;

public class CheckBill {
	
	private int id;
	private int qty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public CheckBill(int id, int qty) {
		this.id = id;
		this.qty = qty;
	}
	
}
