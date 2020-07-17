package com.hotelapp.service;

import com.hotelapp.models.Delivery;

public interface DeliveryService {

	void updateDelivery(Delivery delivery);
	void deleteDelivery(int deliveryId);
	Delivery getDeliveryById(int deliveryId);
	Delivery getDeliveryByPartner(String partnerName);
}
