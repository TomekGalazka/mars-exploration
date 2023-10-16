package com.codecool.marsexploration.mapexplorer.rovers;

import com.codecool.marsexploration.mapexplorer.Configuration.Config;
import com.codecool.marsexploration.mapexplorer.buildings.Building;
import com.codecool.marsexploration.mapexplorer.maploader.model.Coordinate;
import com.codecool.marsexploration.mapexplorer.maploader.model.Map;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class RoverDeployer {


    public void placeRover(MarsRover rover, Map map, Config config) {

        Coordinate[] adjacentCoordinatesOfStarship = {
                new Coordinate(config.landingCoordinates().X(), config.landingCoordinates().Y() - 1),
                new Coordinate(config.landingCoordinates().X(), config.landingCoordinates().Y() + 1),
                new Coordinate(config.landingCoordinates().X() - 1, config.landingCoordinates().Y()),
                new Coordinate(config.landingCoordinates().X() + 1, config.landingCoordinates().Y())
        };

        Optional<Coordinate> roverCoordinate = Arrays.stream(adjacentCoordinatesOfStarship)
                .filter(map::isEmpty).findFirst();

        rover.setCurrentPosition(roverCoordinate.orElseThrow(() -> new IllegalStateException("Coordinate not present")));
    }

    public void placeRover(MarsRover rover, Map map, Building building) {
        Coordinate[] adjacentCoordinatesOfStarship = {
                new Coordinate(building.getBaseCoordinate().X(), building.getBaseCoordinate().Y() - 1),
                new Coordinate(building.getBaseCoordinate().X(), building.getBaseCoordinate().Y() + 1),
                new Coordinate(building.getBaseCoordinate().X() - 1, building.getBaseCoordinate().Y()),
                new Coordinate(building.getBaseCoordinate().X() + 1, building.getBaseCoordinate().Y())
        };

        Optional<Coordinate> roverCoordinate = Arrays.stream(adjacentCoordinatesOfStarship)
                .filter(map::isEmpty).findFirst();

        rover.setCurrentPosition(roverCoordinate.orElseThrow(() -> new IllegalStateException("Coordinate not present")));
    }

}
