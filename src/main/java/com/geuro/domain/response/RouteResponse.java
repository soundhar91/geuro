package main.java.com.geuro.domain.response;

import main.java.com.geuro.domain.Station;

public class RouteResponse implements Response{

	private int dep_sid;
	private int arr_sid;
	private boolean direct_bus_route;

	public int getDep_sid() {
		return dep_sid;
	}

	public void setDep_sid(int dep_sid) {
		this.dep_sid = dep_sid;
	}

	public int getArr_sid() {
		return arr_sid;
	}

	public void setArr_sid(int arr_sid) {
		this.arr_sid = arr_sid;
	}

	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}

	public void setDirect_bus_route(boolean direct_bus_route) {
		this.direct_bus_route = direct_bus_route;
	}

	public RouteResponse(Station departingStation, Station arrivingStation, boolean pathFound) {
		this.dep_sid = departingStation.getId();
		this.arr_sid = arrivingStation.getId();
		this.direct_bus_route = pathFound;
	}
}
