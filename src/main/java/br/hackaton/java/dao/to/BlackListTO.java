package br.hackaton.java.dao.to;

import br.hackaton.java.entity.Courier;
import br.hackaton.java.entity.User;

public class BlackListTO {

	private Courier courier;
	
	private User user;

	public BlackListTO() {
		
	}
	
	public BlackListTO(User user, Courier courier) {
		this.user = user;
		this.courier = courier;
	}
	
	public Courier getCourier() {
		return courier;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
