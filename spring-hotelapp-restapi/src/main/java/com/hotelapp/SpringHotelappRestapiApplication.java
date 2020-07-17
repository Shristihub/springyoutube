package com.hotelapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapp.models.Address;
import com.hotelapp.models.Delivery;
import com.hotelapp.models.Hotel;
import com.hotelapp.models.Menu;
import com.hotelapp.service.DeliveryService;
import com.hotelapp.service.HotelService;
import com.hotelapp.service.MenuService;

@SpringBootApplication
public class SpringHotelappRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelappRestapiApplication.class, args);
	}

	@Autowired
	HotelService hotelService;
	@Autowired
	DeliveryService deliveryService;
	@Autowired
	MenuService menuService;
	
	@Override
	public void run(String... args) throws Exception {
//		Address address = new Address("JP nagar","Bangalore",537890,"KAR");
//		Menu menu1 = new Menu("Idli", 20);
//		Menu menu2 = new Menu("Dosa", 20);
//		Set<Menu> menuList = new HashSet<>(Arrays.asList(menu1,menu2));
//		Delivery del1 = deliveryService.getDeliveryByPartner("uber");
//		Set<Delivery> deliveryList = new HashSet<>(Arrays.asList(del1));
//		Hotel hotel = new Hotel("The Shanthos",address,menuList,deliveryList);
//		//hotelService.addHotel(hotel);
//		
//		Hotel hotel = hotelService.getHotelById(202);
//		System.out.println(hotel);
//		hotel.getAddress().setCity("Karwar");
//		hotelService.updateHotel(hotel);
//		hotel = hotelService.getHotelById(202);
//		System.out.println(hotel);
		
//		hotelService.getHotelsByCity("Bangalore")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+h.getAddress().getCity()));
//		System.out.println();
//		hotelService.getHotelsByLocation("JP nagar")
//		.stream()
//		.forEach((h)->System.out.println(h.getHotelName()+h.getMenuList()));
		  
//		hotelService.getHotelsByMenu("Idli")
//					.stream()
//					.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getStreetName() ));
//		System.out.println();
//		hotelService.getHotelsByDelivery("swiggy")
//		.stream()
//		.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getStreetName() ));
//		
//		hotelService.getHotelsByLocationAndMenu("JP nagar", "Dosa")
//				.forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getCity() ));
//		
//		
//		menuService.getMenusByHotel("The Truffles")
//			.forEach((m)->System.out.println(m.getMenuName()+" "+m.getPrice()));
	}

	

}
