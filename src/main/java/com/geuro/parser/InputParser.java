package main.java.com.geuro.parser;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.geuro.domain.Route;
import main.java.com.geuro.domain.Station;
import main.java.com.geuro.service.CityMapService;
import org.apache.log4j.Logger;

public class InputParser {
	private File file;
	private Scanner scanner;
	static Logger log = Logger.getLogger(InputParser.class);
	private CityMapService mapService;

	public InputParser(String fileName, CityMapService map) {
		if (fileName.length() == 0) {
			log.error("File name is empty");
		}
		file = new File(fileName);
		this.mapService = map;
	}

	public void parse() {
		int no, count, routeId;
		if (mapService == null) {
			log.error("Map service is not running");
			return;
		}
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			no = Integer.parseInt(line);
			while (no > 0) {
				line = scanner.nextLine();
				Scanner in = new Scanner(line);
				count = 0;
				Route route = null;
				while (in.hasNext()) {
					int id = in.nextInt();
					if (count == 0) {
						route = new Route(id);
						routeId = id;
						count++;
						continue;
					}
					Station station1 = new Station(id);
					mapService.addRoute(route, station1);
					mapService.addStation(station1, route);
					count++;
				}
				no--;
			}

		} catch (Exception e) {
			log.error("Parser Error"+e);
		}

	}
}
