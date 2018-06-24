package br.hackaton.java.entity.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Domain related to position ability by restaurants.
 * 
 * @author fabiana.araujo
 *
 */
public enum Position {

	WAITER (0,"Waiter"),
	MANAGER (1,"Manager"),
	COOKER (2, "Cooker");
	
	private Integer code;
	private String description;
	
	private Position(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDesciption() {
		return description;
	}
	
	public static Position getByCode(Integer code) {
		
		Stream<Position> values = Arrays.stream(Position.values());
		
		Predicate<Position> predicate = x -> x.getCode() == code;
		
		Optional<Position> result = values.filter(predicate).findFirst();
		
		return result.get();
		
	}
}
