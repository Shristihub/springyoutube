package com.hotelapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(generator = "hotel_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "hotel_id",sequenceName = "hotel_id" )
	private Integer hotelId;
	private String hotelName;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="address_id")
	private Address address;
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="hotel_id")
	private Set<Menu> menuList;
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="hotel_delivery",
				joinColumns = @JoinColumn(name="hotel_id"),
				inverseJoinColumns = @JoinColumn(name="delivery_id"))
	private Set<Delivery> delivery;
	public Hotel(String hotelName, Address address, Set<Menu> menuList, Set<Delivery> delivery) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.menuList = menuList;
		this.delivery = delivery;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", address=" + address + ", menuList=" + menuList + ", delivery="
				+ delivery + "]";
	}
	
	
}




