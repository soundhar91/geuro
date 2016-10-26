package main.java.com.geuro.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import main.java.com.geuro.domain.*;
import main.java.com.geuro.service.CityMapService;


@Component
public class CityMapServiceImpl implements CityMapService {
	private HashMap<Route, ArrayList<Station>> RouteMap;
	private HashMap<Station, ArrayList<Route>> StationMap;

	private static CityMapServiceImpl singleton = new CityMapServiceImpl( );
	
	private CityMapServiceImpl() {
		RouteMap = new HashMap<Route, ArrayList<Station>>();
		StationMap = new HashMap<Station, ArrayList<Route>>();
	}

	public boolean hasStation(Station s) {
		return StationMap.containsKey(s);
	}

	public RouteResponse hasDirectRoute(Station station1, Station station2) {
		System.out.println(StationMap.size()+"--"+RouteMap.size());
		if (StationMap.containsKey(station1) == false || StationMap.containsKey(station2) == false) {
			return new RouteResponse(station1,station2,false);
		}
		System.out.println(StationMap.size()+"--"+RouteMap.size());
		boolean pathFound = false;
		ArrayList<Route> routes = StationMap.get(station1);
		for (Route route : routes) {
			ArrayList<Station> stations = RouteMap.get(route);
			if (stations.contains(station2) == true) {
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
		if(StationMap.containsKey(station) == false){
			System.out.println("not found");
			StationMap.put(station, new ArrayList<Route>());
		}
		StationMap.get(station).add(route);
		ArrayList<Route> t = StationMap.get(station);
		for(Route r: t) {
			System.out.println("station ->"+station.getId()+"has "+r.getRouteId());
		}
	}

	public void addStation(Station station, Route route) {
		if(RouteMap.containsKey(route) == false){
			RouteMap.put(route, new ArrayList<Station>());
		}		
		RouteMap.get(route).add(station);
		ArrayList<Station> t = RouteMap.get(route);
		for(Station r: t) {
			System.out.println("route ->"+route.getRouteId()+"has"+ r.getId());
		}
	}
	
	public static CityMapService getInstance(){
		return singleton;
	}
}
