package org.java.pizzeria.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String imgUrl;
	private Float price;
	private boolean deleted;
	
	public Pizza() { }
	public Pizza(String name, String description, String imgUrl, Float price) {
		setId(id);
		setName(name);
		setDescription(description);
		setImgUrl(imgUrl);
		setPrice(price);
	}
	
	@OneToMany(mappedBy = "pizza")
	private List<Offer> offers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] " + getName() 
		+ "\ndescrizione: " + getDescription()
		+ "\nfoto: " + getImgUrl()
		+ "\nprezzo: " + getPrice();
	}
}
