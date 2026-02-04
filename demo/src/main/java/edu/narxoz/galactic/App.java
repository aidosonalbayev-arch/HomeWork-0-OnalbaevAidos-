package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.factory.DroneFactory;
import edu.narxoz.galactic.task.DeliveryTask;

public class App {
 public static void main(String[] args) {

        Planet earth = new Planet("Earth", 0, 0, "Oxygen");
        SpaceStation iss = new SpaceStation("ISS", 100, 0, 5);

        Cargo cargo = new Cargo(50, "Metal");

        Drone light = DroneFactory.createDrone("LIGHT", "LD-1", 20);
        Drone heavy = DroneFactory.createDrone("HEAVY", "HD-1", 100);

        DeliveryTask task = new DeliveryTask(earth, iss, cargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("1) LightDrone assign:");
        System.out.println(dispatcher.assignTask(task, light));

        System.out.println("2) HeavyDrone assign:");
        Result ok = dispatcher.assignTask(task, heavy);
        System.out.println(ok);

        System.out.println("3) Estimated time:");
        System.out.println(task.estimateTime());

        System.out.println("4) Completion:");
        System.out.println(dispatcher.completeTask(task));
        System.out.println("Drone status: " + heavy.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}
