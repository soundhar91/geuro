package main.java.com.geuro.parser;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.geuro.domain.Route;
import main.java.com.geuro.domain.Station;
import main.java.com.geuro.service.CityMapService;
import org.apache.log4j.Logger;

@Service
public class InputParser {
	private static File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private Scanner scanner;
	static Logger logger = Logger.getLogger(InputParser.class);
	@Autowired
	private CityMapService mapService;

	@Autowired
	public void setMapService(CityMapService mapService) {
		this.mapService = mapService;
	}

	public void parse(String filename) {
		int no, count, routeId;
		if (mapService == null) {
			logger.error("Map service is not running");
			return;
		}
		
		try {
			this.file = new File(filename);
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
			logger.error("Parser Error" + e);
		}

	}

}
