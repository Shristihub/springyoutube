package com.hotelapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.models.Hotel;
import com.hotelapp.service.HotelService;

@RestController 
@RequestMapping("/hotels-restapi")
public class HotelController {
	@Autowired
	HotelService hotelService; 
	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		Hotel newHotel = hotelService.addHotel(hotel);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "one hotel added");
		return ResponseEntity.ok().headers(header).body(newHotel);
	}
	@PutMapping("/hotels")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel){
		hotelService.updateHotel(hotel);
		return ResponseEntity.ok("Updated");
	}
	@GetMapping("/hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId){
		Hotel hotel = hotelService.getHotelById(hotelId);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "getting one hotel instance");
		return ResponseEntity.ok().headers(header).body(hotel);
		
	}
	@DeleteMapping("/hotels/hotel-by-id/{hotelId}")
	public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId){
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/hotels/hotels-by-city/{city}")
	public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable("city") String city){
		List<Hotel> hotelList = hotelService.getHotelsByCity(city);
		return ResponseEntity.ok().body(hotelList);
		
	}
	@GetMapping("/hotels/hotels-by-menu/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByMenu(@PathVariable String menuName){
		List<Hotel> hotelList = hotelService.getHotelsByMenu(menuName);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("/hotels/hotels-by-delivery/{partnerName}")
	public ResponseEntity<List<Hotel>> getHotelsByDelivery(@PathVariable String partnerName){
		List<Hotel> hotelList = hotelService.getHotelsByDelivery(partnerName);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("/hotels/hotels-by-location/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location){
		List<Hotel> hotelList = hotelService.getHotelsByLocation(location);
		return ResponseEntity.ok().body(hotelList);
	}
	@GetMapping("/hotels/hotels-by-location/{location}/menuName/{menuName}")
	public ResponseEntity<List<Hotel>> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menuName){
		List<Hotel> hotelList = hotelService.getHotelsByMenu(menuName);
		return ResponseEntity.ok().body(hotelList);
	}
	
}
