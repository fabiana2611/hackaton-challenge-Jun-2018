package br.hackaton.java.builder.entity;

import java.util.ArrayList;
import java.util.List;

import br.hackaton.java.entity.Restaurant;

public class RestaurantBuilder {
	
	private static Restaurant entity;
	
	private RestaurantBuilder () {
		
	}
	
	public Restaurant now() {
		return entity;
	}
	
	public static RestaurantBuilder createOne() {
		RestaurantBuilder builder = new RestaurantBuilder();
		entity = new Restaurant ("Burguer King", "Street 1", "b@k.com");
		return builder;
	}
	
	public static List<Restaurant> createMoreThenOne(int count) {
		
		List<Restaurant> list =  new ArrayList<>();
		
		for (int i = 0; i< count; i++) {
			list.add(create(i));
		}
		return list;
	}
	
	private static Restaurant create(Integer id) {
		Restaurant restaurant = new Restaurant("Restaurant "+id, "Street "+id, id+"email@email.com" );
		restaurant.setId(id);
		return restaurant;
	}
	

}
