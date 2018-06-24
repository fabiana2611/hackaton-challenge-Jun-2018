package br.hackaton.java.entity;

import java.time.LocalDate;

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
	
	private String dateStartannounce;
	
	public JobOpportunity(Integer positionCode, Integer restaurantId) {
		this.positionCode = positionCode;
		this.restaurantId = restaurantId;
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

	public String getDateStartannounce() {
		return dateStartannounce;
	}

	public void setDateStartannounce(String dateStartannounce) {
		this.dateStartannounce = dateStartannounce;
	}
	
	public LocalDate getDateStart() {
		return LocalDate.parse(dateStartannounce);
	}
	
	// ------ EQUAL AND HASH
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		JobOpportunity review = (JobOpportunity) o;

		if (!positionCode.equals(review.positionCode))
			return false;
		if (!restaurantId.equals(review.restaurantId))
			return false;
		return dateStartannounce.equals(review.dateStartannounce);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + positionCode.hashCode();
		result = 31 * result + restaurantId.hashCode();
		result = 31 * result + dateStartannounce.hashCode();
		return result;
	}
	
}
