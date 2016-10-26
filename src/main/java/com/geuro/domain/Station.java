package main.java.com.geuro.domain;

public class Station {
	private int id;
	private Route route;

	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Station(int stationId, int route) {
		this.id = stationId;
		// this.route = route;
	}

	public Station(int stationId) {
		this.id = stationId;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Station s = (Station) o;

		return id == s.id;

	}

	public int hashCode() {
		return id;
	}
}