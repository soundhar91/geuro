package main.java.com.geuro.domain;

public class RouteResponse {
	private int dep_sid;
	private int arr_sid;
	private boolean direct_bus_route;
	
	public RouteResponse(Station departingStation, Station arrivingStation,boolean pathFound ) {
		this.dep_sid = departingStation.getId();
		this.arr_sid = arrivingStation.getId();
		this.direct_bus_route = pathFound;
	}
}
