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
	
	
	public LocationDTO insert(Scanner sc) {
		
		LocationDTO dto = new LocationDTO();
		System.out.println("Location ID를 입력하세요");
		dto.setLocation_id(sc.nextInt());
		System.out.println("Street_address를 입력하세요");
		dto.setStreet_address(sc.next());
		System.out.println("Postal_code를 입력하세요");
		dto.setPostal_code(sc.next());
		System.out.println("City를 입력하세요");
		dto.setCity(sc.next());
		System.out.println("State_province를 입력하세요");
		dto.setState_province(sc.next());
		System.out.println("Country_id를 입력하세요");
		dto.setCountry_id(sc.next());
		
		return dto;
		
	}
	
	
	
	

}
