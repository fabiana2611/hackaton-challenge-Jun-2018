package br.hackaton.java.entity;

/**
 * Entity to represent restaurants
 * 
 * @author fabiana.araujo
 *
 */
public class Restaurant {

	private Integer id;
	
	private String name;
	
	private String address;
	
	private String email;
	
	public Restaurant(String name, String address, String email) {
		this.name =  name;
		this.address = address;
		this.email = email;
	}

	// --- Getters && Setters ----
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// --- Equals && Hashcode ----
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id;
        return result;
    }
	
}
