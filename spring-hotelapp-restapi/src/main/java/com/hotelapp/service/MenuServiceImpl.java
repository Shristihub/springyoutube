package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.models.Menu;
import com.hotelapp.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepository;
	@Override
	public List<Menu> getMenusByHotel(String hotelName) {
//		return menuRepository.findByHotelHotelName(hotelName);
		return menuRepository.findByHotel(hotelName);
	}

}
