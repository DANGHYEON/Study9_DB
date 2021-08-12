package com.iu.s1.location;

import java.util.Scanner;

public class LocationInput {
	
	
	
	public LocationDTO inputId(Scanner sc) {
		LocationDTO dto = new LocationDTO();
		System.out.println("Location ID를 입력하세요");
		int location_id = sc.nextInt();
		dto.setLocation_id(location_id);
		
		return dto;
		
	}

}
