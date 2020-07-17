package com.hotelapp.service;

import java.util.List;

import com.hotelapp.models.Menu;

public interface MenuService {
	List<Menu> getMenusByHotel(String hotelName);
	
}
