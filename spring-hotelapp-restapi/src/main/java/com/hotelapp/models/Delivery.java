package com.hotelapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {
	@Id
	@GeneratedValue(generator = "del_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "del_id",sequenceName = "delivery_id" )
	private Integer deliveryId;
	private String partnerName;
	private double charges;
	@ManyToMany(mappedBy = "delivery")
	@JsonIgnore
	private Set<Hotel> hotelList = new HashSet<>();
	public Delivery(String partnerName, double charges) {
		super();
		this.partnerName = partnerName;
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "Delivery [partnerName=" + partnerName + ", charges=" + charges + "]";
	}
	
	

}
