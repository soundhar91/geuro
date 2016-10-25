package main.java.com.geuro.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import main.java.com.geuro.domain.*;
import main.java.com.geuro.service.CityMapService;

@Named("CityMapService")
@Component
public class CityMapServiceImpl implements CityMapService {
	private HashMap<Route, ArrayList<Station>> RouteMap;
	private HashMap<Station, ArrayList<Route>> StationMap;

	public CityMapServiceImpl() {
		RouteMap = new HashMap<Route, ArrayList<Station>>();
		StationMap = new HashMap<Station, ArrayList<Route>>();
	}

	public boolean hasStation(Station s) {
		return StationMap.containsKey(s);
	}

	public RouteResponse hasDirectRoute(Station station1, Station station2) {
		if (StationMap.containsKey(station1) == false || StationMap.containsKey(station2) == false) {
			return new RouteResponse(station1,station2,false);
		}
		boolean pathFound = false;
		ArrayList<Route> routes = StationMap.get(station1);
		for (Route route : routes) {
			boolean found = route.hasStation(station2);
			if (found == true) {
				pathFound= true;
				break;
			}
		}
		return new RouteResponse(station1,station2,pathFound);

	}

	public boolean hasRoute(Route route) {
		return RouteMap.containsKey(route);
	}

	public void addRoute(Route route, Station station) {
		StationMap.get(station).add(route);
	}

	public void addStation(Station station, Route route) {
		RouteMap.get(route).add(station);
	}
}
