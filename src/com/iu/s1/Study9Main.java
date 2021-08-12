package com.iu.s1;

import java.sql.Connection;
import java.util.ArrayList;

import com.iu.s1.location.LocationController;
import com.iu.s1.location.LocationDAO;
import com.iu.s1.location.LocationDTO;
import com.iu.s1.location.LocationView;
import com.iu.s1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		LocationController controller = new LocationController();
		controller.start();
//		LocationDTO locationDTO = new LocationDTO();
//		LocationDAO dao = new LocationDAO();
//		ArrayList<LocationDTO> ar = dao.getList();
//		LocationView locationView = new LocationView();
//		
		
		
//		locationDTO.setLocation_id(1000);
//		
//		locationDTO = dao.getOne(locationDTO);
//		
//		System.out.println(locationDTO .getLocation_id());
//		System.out.println(locationDTO.getStreet_address());
//		System.out.println(locationDTO.getCity());
		
		
	}

}
