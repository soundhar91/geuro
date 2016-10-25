package main.java.com.geuro.parser;

import java.io.File;
import java.util.Scanner;

import javax.inject.Inject;

import main.java.com.geuro.domain.Route;
import main.java.com.geuro.domain.Station;
import main.java.com.geuro.service.CityMapService;

public class InputParser {
	private File file;
	private Scanner scanner;
	@Inject
	private CityMapService mapService;

	public InputParser(String fileName) {
		if (fileName.length() == 0) {

		}
		file = new File(fileName);
	}

	public void parse() {
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			int no = Integer.parseInt(line);
			System.out.println("number of lines " + no);
			while (no > 0) {
				line = scanner.nextLine();
				System.out.println("next -> " + line);
				Scanner in = new Scanner(line);
				int count = 0;
				Route route=null;int routeId;
				while (in.hasNext()) {
					int station = in.nextInt();
					if (count == 0) {
						route = new Route(station);
						routeId = station;
						count++;
						continue;
					}
					Station station1 = new Station(station);
					if(mapService == null) {
						System.out.println("service isn't startes");
						break;
					}
					mapService.addRoute(route, station1);
					mapService.addStation(station1, route);
					count++;
				}
				no--;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
