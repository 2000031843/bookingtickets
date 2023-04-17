package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_table")
public class Product {

	@Id
	  @GeneratedValue
	  private int id;
	  @Column(nullable = false,length = 100)
	  private String category;
	  @Column(nullable = false,length = 200)
	   private String moviename;
	  @Column(nullable = false,length = 200)
	   private String screen;
	  @Column(nullable = false,length = 200)
	   private String cost;
	  @Column(nullable = false,length = 200)
	   private String fclass;
	  @Column(nullable = false)
	  private Blob productimage;
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", moviename=" + moviename + ", screen=" + screen
				+ ", cost=" + cost + ", fclass=" + fclass + ", productimage=" + productimage + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getFclass() {
		return fclass;
	}
	public void setFclass(String fclass) {
		this.fclass = fclass;
	}
	public Blob getProductimage() {
		return productimage;
	}
	public void setProductimage(Blob productimage) {
		this.productimage = productimage;
	}
}
