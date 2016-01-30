package com.product.domain;
import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;

@Indexed
@Table(name = "product")
@Entity
public class Product  implements Comparable<Product> {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="user_name")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String fullName;
	@Column(name="category")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String category;
	@Column(name="store_rating")
	private Integer rating;
	@Column(name="latitude")
	private Double latitude;
	@Column(name="longitude")
	private Double longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int compareTo(Product arg0) {
		
		return this.fullName.compareTo(arg0.getFullName());
	}
}
