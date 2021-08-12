package com.iu.s1.location;

import java.util.ArrayList;

public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		
		locationDAO= new LocationDAO();
		locationView = new LocationView();
		
	}
	
	public void start() {
		//DB에서 Location Table의 모든 정보 조회
		// ArrayList<LocationDTO> ar = locationDAO.getList();
		
		// locationView.view(ar);
		
//		LocationDTO locationDTO =locationDAO.getOne1(1000);
//		locationView.view(locationDTO);
		
		
		//ArrayList<LocationDTO> ar2 =locationDAO.getSearch("a");
		//locationView.view(ar2);
		
		//int count = locationDAO.getCount();
		//locationView.view(count);
		
		LocationDTO locationDTO =locationDAO.getLocation(100);
		locationView.view(locationDTO);
			
	}

}
