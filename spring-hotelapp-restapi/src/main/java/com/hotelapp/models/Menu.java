package com.hotelapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {
	@Id
	@GeneratedValue(generator = "menu_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "menu_id",sequenceName = "menu_id" )
	private Integer menuId;
	private String menuName;
	private double price;
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@JsonIgnore
	private Hotel hotel;
	public Menu(String menuName, double price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", price=" + price + "]";
	}
	
	
	

}
