package com.hotelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapp.models.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

	// Derived Queries
	Delivery findByPartnerName(String partnerName);
	
	
}
