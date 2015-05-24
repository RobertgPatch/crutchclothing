package com.crutchclothing.products.model;

public class Shirt extends Product {

	private static final long serialVersionUID = 1L;
	private Color color;
	private Size size;
	
	public Shirt(Color color, Size size) {
		this.color = color;
		this.size = size;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor (Color color) {
		this.color = color;
	}
	
	public Size getSize() {
		return this.size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public enum Color {
		BLACK, GREY;
	}
	
	public enum Size {
		SMALL, MEDIUM, LARGE, XLARGE;
	}
}
