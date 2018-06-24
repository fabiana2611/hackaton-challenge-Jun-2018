package br.hackaton.java.entity;

public class OrderFood {
	
	private Integer id;
	
	private Integer orderId;
	
	private Integer foodId;
	
	public OrderFood (String name, Integer orderId, Integer foodId) {
		this.orderId = orderId;
		this.foodId = foodId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}


}
