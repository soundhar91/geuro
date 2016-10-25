package main.java.com.geuro.domain;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private int RouteId;
	private ArrayList<Station> stations;

	public int getRouteId() {
		return RouteId;
	}

	public void setRouteId(String routeId) {
		RouteId = Integer.parseInt(routeId);
	}

	public void addStation(Station s) {
		stations.add(s);
	}

	public boolean hasStation(Station station) {
		return stations.contains(station);
	}

	public Route(int RouteId) {
		this.RouteId = RouteId;
		stations = new ArrayList<Station>();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Route s = (Route) o;

		return RouteId == s.RouteId;

	}

	public int hashCode() {
		return RouteId;
	}
}
