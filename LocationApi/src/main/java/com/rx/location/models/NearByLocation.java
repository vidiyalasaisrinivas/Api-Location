package com.rx.location.models;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NearByLocation {

	@Autowired
	Location location;
	
	@Autowired
	TodoRepository todoRepository;

	/*
	 * @GetMapping("/api") public Location nearByPharmacy() {
	 * 
	 * location = new
	 * Location("WALGREENS","3696 SW TOPEKA BLVD","TOPEKA","KS",66611,39.001423f,-95
	 * .68695f); return location;
	 * 
	 * }
	 */
	@GetMapping("/api/loc")
	String findByLatAndLong(@RequestParam("latitude") double latitude,@RequestParam("longitude") double longitude){
		System.out.println("we are in api");
		String result=todoRepository.findBySearchTerm(latitude, longitude);
		if(result.length()>0) {
			result=result+" "+"Miles";
			return result;
		}
		else {
			return result;
		}
		//return todoRepository.findBySearchTerm(latitude, longitude);
		
	}

}
