package de.myapp.ee.app.pattern.standard.microservice.model;

import javax.persistence.*;

@Entity
public class Pattern {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int rating;
    
    public Pattern(){}

    public Pattern(String name) {
        this.name = name;
    }

    public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                '}';
    }
}
