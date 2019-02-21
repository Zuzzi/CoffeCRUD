package it.io.coffecrud.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "sup_id")
	private Set<Coffees> coffees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String country;
}
