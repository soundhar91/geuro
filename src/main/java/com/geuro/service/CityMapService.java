package main.java.com.geuro.service;

import org.springframework.stereotype.Component;

import main.java.com.geuro.domain.Route;
import main.java.com.geuro.domain.RouteResponse;
import main.java.com.geuro.domain.Station;

@Component
public interface CityMapService {
	public RouteResponse hasDirectRoute(Station station1,Station station2);
	public void addRoute(Route route, Station station);
	public void addStation(Station station, Route route);	
}
