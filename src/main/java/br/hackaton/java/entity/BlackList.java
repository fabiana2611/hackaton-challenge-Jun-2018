package br.hackaton.java.entity;

/**
 * This class represent wich courier can not delivery to wich coustumert.
 * OBS: Sometimes there is some problems between them so the system can't let
 * the courier delivery to that coustumer.
 * 
 * The Order should look this list to know who can'not delivery to who.
 * 
 * This is indicate by coustumer.
 * 
 * @author fabiana
 *
 */
public class BlackList {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer courierId;
	
	public BlackList(Integer userId, Integer courierId) {
		this.userId = userId;
		this.courierId = courierId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCourierId() {
		return courierId;
	}

	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}
	
}
