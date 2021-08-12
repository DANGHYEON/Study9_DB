package com.iu.s1.location;

import java.util.ArrayList;

public class LocationView {
	
	
	public void view(ArrayList<LocationDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			System.out.println(ar.get(i).getLocation_id());
			
			
			
		}
		
	}
	

	public void view(LocationDTO locationDTO) {
		
		System.out.println(locationDTO.getLocation_id());
		System.out.println(locationDTO.getStreet_address());
		System.out.println(locationDTO.getCity());
		
		
		
	}
	
	
	
	
}
