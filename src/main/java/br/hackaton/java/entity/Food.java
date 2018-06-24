package br.hackaton.java.entity;

public class Food {
	
	private Integer id;
	
	private String name;
	
	private Integer restaurantId;
	
	private Integer categoryCode;
	
	public Food (String name, Integer restaurantId, Integer categoryCode) {
		this.name = name;
		this.restaurantId = restaurantId;
		this.categoryCode = categoryCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}

}
