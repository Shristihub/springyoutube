package com.hotelapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(generator = "add_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "add_id",sequenceName = "address_id" )
	private Integer addressId;
	private String streetName;
	private String city;
	private long zipcode;
	private String state;
	public Address(String streetName, String city, long zipcode, String state) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city + ", zipcode=" + zipcode + ", state=" + state
				+ "]";
	}
	
	
	

	
	
	
	

}
