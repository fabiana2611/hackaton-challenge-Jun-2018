package br.hackaton.java.entity.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CategoryFood {


	SEAFOOD (0,"Sea food"),
	JAPANESE (1,"Japanese Food"),
	BRAZILIAN (2, "Brazilian Food");
	
	private Integer code;
	private String description;
	
	private CategoryFood(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDesciption() {
		return description;
	}
	
	public static CategoryFood getByCode(Integer code) {
		
		Stream<CategoryFood> values = Arrays.stream(CategoryFood.values());
		
		Predicate<CategoryFood> predicate = x -> x.getCode() == code;
		
		Optional<CategoryFood> result = values.filter(predicate).findFirst();
		
		return result.get();
		
	}
}
