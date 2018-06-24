package br.hackaton.java.entity;

import br.hackaton.java.entity.domain.Position;

/**
 * Entity to represent restaurants
 * 
 * @author fabiana.araujo
 *
 */
public class Email {

	private String nameCandidate;
	
	private String emailCandidate;
	
	private Integer positionCode;
	
	public Email(String nameCandidate, String emailCandidate, Integer positionCode) {
		this.nameCandidate =  nameCandidate;
		this.emailCandidate = emailCandidate;
		this.positionCode = positionCode;
	}

	// --- Getters && Setters ----
	
	public String getNameCandidate() {
		return nameCandidate;
	}

	public void setNameCandidate(String nameCandidate) {
		this.nameCandidate = nameCandidate;
	}

	public String getEmailCandidate() {
		return emailCandidate;
	}

	public void setEmailCandidate(String emailCandidate) {
		this.emailCandidate = emailCandidate;
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
	
	public String getSubject() {
		return "Opportunity: " + getPositionDescription();
	}
	
	public String getBody() {
		return "Candidate: " + getNameCandidate() + "\n" + "Candidate Email: "+ emailCandidate;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email that = (Email) o;

        if (!nameCandidate.equals(that.nameCandidate)) return false;
        if (!emailCandidate.equals(that.emailCandidate)) return false;
        if (!positionCode.equals(that.positionCode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = nameCandidate.hashCode();
        result = 31 * result + emailCandidate.hashCode();
        result = 31 * result + positionCode.hashCode();
        return result;
    }
	
}
