package com.restapi.shoes.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	
	private String nameCategory;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Shoes> shoes;
	
	

	public Category() {
	}

	public Category(int id, String nameCategory, List<Shoes> shoes) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.shoes = shoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}
	
	
}
