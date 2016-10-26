package main.java.com.geuro.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import main.java.com.geuro.domain.*;
import main.java.com.geuro.service.CityMapService;

@Service
public class CityMapServiceImpl implements CityMapService {
	private HashMap<Route, ArrayList<Station>> RouteMap;
	private HashMap<Station, ArrayList<Route>> StationMap;

	public boolean hasStation(Station s) {
		return StationMap.containsKey(s);
	}

	public RouteResponse hasDirectRoute(Station station1, Station station2) {
		System.out.println(StationMap.size()+"---"+RouteMap.size());
		if (StationMap.containsKey(station1) == false || StationMap.containsKey(station2) == false) {
			return new RouteResponse(station1, station2, false);
		}
		boolean pathFound = false;
		ArrayList<Route> routes = StationMap.get(station1);
		for (Route route : routes) {
			ArrayList<Station> stations = RouteMap.get(route);
			if (stations.contains(station2) == true) {
				pathFound = true;
				break;
			}
		}
		return new RouteResponse(station1, station2, pathFound);

	}

	public boolean hasRoute(Route route) {
		return RouteMap.containsKey(route);
	}

	public void addRoute(Route route, Station station) {
		if (StationMap.containsKey(station) == false) {
			StationMap.put(station, new ArrayList<Route>());
		}
		StationMap.get(station).add(route);

	}

	public void addStation(Station station, Route route) {
		if (RouteMap.containsKey(route) == false) {
			RouteMap.put(route, new ArrayList<Station>());
		}
		RouteMap.get(route).add(station);
	}
	
	public CityMapServiceImpl() {
		RouteMap = new HashMap<Route, ArrayList<Station>>();
		StationMap = new HashMap<Station, ArrayList<Route>>();
	}

}
