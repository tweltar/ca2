package com.cleaning_service.ws.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cleaning_service.ws.model.Service;
import com.cleaning_service.ws.model.ServiceDAO;

@RestController
@RequestMapping("services")
public class ServiceController {
	
//	@GetMapping
	@RequestMapping(method=RequestMethod.GET, path="/all")
	public ArrayList<Service> getAllServices() {
		ArrayList<Service> serviceList = new ArrayList<Service>();
		
		try {
			ServiceDAO db = new ServiceDAO();
			serviceList = db.listAllServices();
		} catch(Exception e) {
			System.out.print("Error :" + e);
		}
		
		return serviceList;
	}
}
