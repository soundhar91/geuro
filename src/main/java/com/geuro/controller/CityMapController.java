package main.java.com.geuro.controller;

import main.java.com.geuro.domain.RouteResponse;
import main.java.com.geuro.domain.Station;
import main.java.com.geuro.impl.CityMapServiceImpl;
import main.java.com.geuro.service.CityMapService;
import main.java.com.geuro.domain.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CityMapController {
	private CityMapService mapService;

	public CityMapService getMapService() {
		return mapService;
	}

	@Autowired
	public void setMapService(CityMapService mapService) {
		this.mapService = mapService;
	}

	public CityMapController() {
	}

	@RequestMapping(value = "direct", method = RequestMethod.GET)
	@ResponseBody
	public RouteResponse getDirectPath(@RequestParam("dep_sid") String startStation,
			@RequestParam("arr_sid") String endStation) {
		
		Station st1 = new Station(Integer.parseInt(startStation));
		Station st2 = new Station(Integer.parseInt(endStation));
		return mapService.hasDirectRoute(st1, st2);
	}

}
