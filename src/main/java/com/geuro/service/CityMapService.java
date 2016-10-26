package main.java.com.geuro.service;

import main.java.com.geuro.domain.Route;
import main.java.com.geuro.domain.RouteResponse;
import main.java.com.geuro.domain.Station;

public interface CityMapService {
	public RouteResponse hasDirectRoute(Station station1, Station station2);

	public void addRoute(Route route, Station station);

	public void addStation(Station station, Route route);
}
