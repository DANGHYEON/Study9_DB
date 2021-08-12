package com.iu.s1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	//private LocationDTO locationDTO;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		locationInput = new LocationInput();
		//locationDTO = new LocationDTO();
		sc = new Scanner(System.in);
	}
	
	
	public void start() {
		
		boolean check = true;
		
		while(check) {
			System.out.println("1. 전체정보출력");
			System.out.println("2. 한개정보출력");
			System.out.println("3. 나가기");
			
			int select =sc.nextInt();
			
			if(select==1) {
				ArrayList<LocationDTO> ar = locationDAO.getList();
				if(ar.size()>0) {
				locationView.view(ar);
				}else {
					System.out.println("비어있음");
				}
				
			}else if(select ==2) {
				
				LocationDTO locationDTO = locationInput.inputId(sc);
				locationDTO = locationDAO.getOne(locationDTO);
				if(locationDTO!=null) {
				locationView.view(locationDTO);
				}else {
					System.out.println("비어있음 다시 입력해줘요");
				}
				
			}else {
				System.out.println("종료합니다.");
				check=false;
				
			}
			
			
		
		}
		
	}

}
