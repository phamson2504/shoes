package com.restapi.shoes.model;

public class ShoesDTO {
private int id;
	
	private String img;
	
	private String title;
	
	private String star;
	
	private String reviews;
	
	private int prevPrice;
	
	private int newPrice;
	
	private int maxQuantity;
	
	private String company;
	
	private String color;
	
	private String category;

	public ShoesDTO(int id, String img, String title, String star, String reviews, int prevPrice, int newPrice,
			int maxQuantity, String company, String color, String category) {
		super();
		this.id = id;
		this.img = img;
		this.title = title;
		this.star = star;
		this.reviews = reviews;
		this.prevPrice = prevPrice;
		this.newPrice = newPrice;
		this.maxQuantity = maxQuantity;
		this.company = company;
		this.color = color;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public int getPrevPrice() {
		return prevPrice;
	}

	public void setPrevPrice(int prevPrice) {
		this.prevPrice = prevPrice;
	}

	public int getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
