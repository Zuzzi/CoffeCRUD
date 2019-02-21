package it.io.coffecrud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coffees implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cof_name")
	private String cofName;
	@Column(name = "sup_id")
	private int supId;
	private float price;
	private int sales;
	private int total;



	public String getCofName() {
		return cofName;
	}

	public void setCofName(String cofName) {
		this.cofName = cofName;
	}

	public int getSupId() {
		return supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}