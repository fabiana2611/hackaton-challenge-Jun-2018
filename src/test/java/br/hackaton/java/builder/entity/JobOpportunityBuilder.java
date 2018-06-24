package br.hackaton.java.builder.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.hackaton.java.entity.JobOpportunity;

public class JobOpportunityBuilder {
	
	private static JobOpportunity entity;
	
	private JobOpportunityBuilder () {
		
	}
	
	public JobOpportunity now() {
		return entity;
	}
	
	public static JobOpportunityBuilder createOne() {
		JobOpportunityBuilder builder = new JobOpportunityBuilder();
		entity = new JobOpportunity (1, 1);
		entity.setDateStartannounce(LocalDate.now().toString());
		return builder;
	}
	
	public static List<JobOpportunity> createMoreThenOne(int count) {
		
		List<JobOpportunity> list =  new ArrayList<>();
		
		for (int i = 0; i< count; i++) {
			list.add(create(i));
		}
		return list;
	}
	
	private static JobOpportunity create(Integer id) {
		JobOpportunity jobOpportunity = new JobOpportunity(id, id);
		jobOpportunity.setDateStartannounce(LocalDate.now().toString());
		jobOpportunity.setId(id);
		return jobOpportunity;
	}
	

}
