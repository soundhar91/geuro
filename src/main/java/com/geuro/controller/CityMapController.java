package main.java.com.geuro.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.geuro.domain.RouteResponse;
import main.java.com.geuro.domain.Station;
import main.java.com.geuro.service.CityMapService;

import javax.inject.Inject;
import javax.inject.Named;


import javax.annotation.Resource;
@RestController
@RequestMapping("/api")
public class CityMapController {
	private CityMapService mapService;
	
	@Inject
	public CityMapController(@Named("CityMapService") CityMapService citymapService){
		this.mapService = citymapService;
	}
	
	@RequestMapping(value="direct")
	@ResponseStatus(HttpStatus.OK)
	public RouteResponse getDirectPath(@RequestParam("dep_sid") String startStation, @RequestParam("arr_sid") String endStation) {
		Station st1 = new Station(Integer.parseInt(startStation));
		Station st2 = new Station(Integer.parseInt(endStation));
		return mapService.hasDirectRoute(st1, st2);
	}

}
