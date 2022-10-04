package de.myapp.ee.app.pattern.standard.microservice.model;

public class PatternDTO {
    private String name;
    private int rating;
    
    public PatternDTO() {
    }

    public String getName() {
        return name;
    }

    public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PatternDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
