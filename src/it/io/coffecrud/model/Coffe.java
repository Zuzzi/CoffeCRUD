package it.io.coffecrud.model;

public class Coffe {
	private String cofName;
	private int supId;
	private float price;
	private int sales;
	private int total;
	
	public String getCofName() {
		return this.cofName;
	}
	
	public void setCofName (String cofName) {
		this.cofName = cofName;
	}
	
	public int getSupId () {
		return this.supId;
	}
	
	public void setSupId(int supId) {
		this.supId = supId;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getSales() {
		return this.sales;
	}
	
	public void setSales(int sales) {
		this.sales = sales;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	

}
