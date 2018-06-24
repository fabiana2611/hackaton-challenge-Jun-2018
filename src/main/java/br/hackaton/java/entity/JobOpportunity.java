package br.hackaton.java.entity;

import java.util.Date;

import br.hackaton.java.entity.domain.Position;

/**
 * Class to represent Job Opportunities from registered restaurants
 * 
 * @author fabiana.araujo
 *
 */
public class JobOpportunity {
	
	private Integer id;
	
	private Integer positionCode;
	
	private Integer restaurantId;
	
	private Date dateStartannounce;
	
	public JobOpportunity(Integer positionCode, Integer restaurantId, Date dateStartannounce) {
		this.positionCode = positionCode;
		this.restaurantId = restaurantId;
		this.dateStartannounce = dateStartannounce;
	}

	// --- Getters && Setters ---
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(Integer positionCode) {
		this.positionCode = positionCode;
	}
	
	public String getPositionDescription() {
		return Position.getByCode(positionCode).getDesciption();
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Date getDateStartannounce() {
		return dateStartannounce;
	}

	public void setDateStartannounce(Date dateStartannounce) {
		this.dateStartannounce = dateStartannounce;
	}
	
}
