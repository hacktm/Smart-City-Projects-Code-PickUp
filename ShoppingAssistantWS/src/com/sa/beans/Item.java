package com.sa.beans;

public class Item {
	private int id;
	private String name;
	private String brand;
	private int quantity;
	private double price;
	private String market;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", brand=" + brand
				+ ", quantity=" + quantity + ", price=" + price + ", market="
				+ market + "]";
	}

}
