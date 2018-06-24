package br.hackaton.java.entity.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum CourierStatus {

	ACTIVE (0,"Active"),
	SUSPENSE (1,"Suspense"),
	STANDBY (2, "Stand by");
	
	private Integer code;
	private String description;
	
	private CourierStatus(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDesciption() {
		return description;
	}
	
	public static CourierStatus getByCode(Integer code) {
		
		Stream<CourierStatus> values = Arrays.stream(CourierStatus.values());
		
		Predicate<CourierStatus> predicate = x -> x.getCode() == code;
		
		Optional<CourierStatus> result = values.filter(predicate).findFirst();
		
		return result.get();
		
	}
}
