package br.hackaton.java.entity;

import br.hackaton.java.entity.domain.CourierStatus;

public class Courier {

	private Integer id;
	
	private String name;
	
	private String localToDelivery;
	
	private Integer courirStatusCode;
	
	public Courier(String name, String localToDelivery, Integer courirStatusCode) {
		this.name = name;
		this.localToDelivery = localToDelivery;
		this.courirStatusCode = courirStatusCode;
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

	public String getLocalToDelivery() {
		return localToDelivery;
	}

	public void setLocalToDelivery(String localToDelivery) {
		this.localToDelivery = localToDelivery;
	}

	public Integer getCourirStatusCode() {
		return courirStatusCode;
	}

	public void setCourirStatusCode(Integer courirStatusCode) {
		this.courirStatusCode = courirStatusCode;
	}
	
	public String getStatusDescription() {
		return CourierStatus.getByCode(courirStatusCode).getDesciption();
	}
	
}
