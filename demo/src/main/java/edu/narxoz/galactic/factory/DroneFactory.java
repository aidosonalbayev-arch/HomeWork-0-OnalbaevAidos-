package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;

public class DroneFactory {

    public static Drone createDrone(String type, String id, double maxPayloadKg) {

        if (type == null) {
            throw new IllegalArgumentException("Drone type cannot be null");
        }

        return switch (type.toUpperCase()) {
            case "LIGHT" -> new LightDrone(id, maxPayloadKg);
            case "HEAVY" -> new HeavyDrone(id, maxPayloadKg);
            default -> throw new IllegalArgumentException("Unknown drone type: " + type);
        };
    }
}
