package simulation2d;

import simulation2d.actions.intitaction.*;
import simulation2d.actions.turnaction.AddGrass;
import simulation2d.actions.turnaction.TurnActionHerbivore;
import simulation2d.actions.turnaction.TurnActionPredator;
import simulation2d.entity.Grass;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

import java.util.Scanner;

public class Simulation {
    public static int numberOfPredators = 2;
    public static int hpPredators = 8;
    public static int speedPredators = 1;

    public static int numberOfHerbivore = 10;
    public static int hpHerbivore = 6;
    public static int speedHerbivore = 1;

    public static int numberOfGrass = 20;
    public static int nutritionalOfGrass = 6;

    public static int numberOfTree = 35;
    public static int numberOfRock = 35;

    public static int mapSizeX = 20;
    public static int MapSizeY = 15;

    MapEntity mapEntity = new MapEntity(mapSizeX, MapSizeY);
    Renderer renderer = new Renderer();
    TurnActionPredator turnActionPredator = new TurnActionPredator(mapEntity);
    TurnActionHerbivore turnActionHerbivore = new TurnActionHerbivore(mapEntity);
    AddGrass addGrass = new AddGrass(mapEntity);
    boolean activeSimulation = true;

    public void startSimulation() {
        initMap(mapEntity);
        renderer.render(mapEntity);
        informationSimulation();
        System.out.println("Size map: " + Simulation.mapSizeX + " x " + Simulation.MapSizeY + "\n" +
                "\n" +
                "This is a 2D Simulation of animal world");
        inputData();
        System.out.println("Simulation is finished!");
    }

    public boolean startContinuousSimulation() {

        Thread thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine() != null) {
                activeSimulation = false;
                System.out.println("Stop Simulation!!!");
            }
        });
        thread.start();

        while (activeSimulation) {
            if (!nextTurn()) {
                return false;
            }
            System.out.println("\n(Enter) for STOP!");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (activeSimulation == false) {
            activeSimulation = true;
            inputData();
        }
        return true;
    }

    public boolean nextTurn() {
        turnActionPredator.perform();
        turnActionHerbivore.perform();
        addGrass.perform();
        renderer.render(mapEntity);
        informationSimulation();
        if (mapEntity.getCreatures().isEmpty()) {
            return false;
        }
        return true;
    }

    public void informationSimulation() {
        System.out.println("Cycle: " + mapEntity.getCountCycle() + "\n" +
                "Predator: " + mapEntity.getEntitysByClass(Predator.class) + "    HP: " + mapEntity.getHPbyClass(Predator.class) + "\n" +
                "Herbivore: " + mapEntity.getEntitysByClass(Herbivore.class) + "  HP: " + mapEntity.getHPbyClass(Herbivore.class) + "\n" +
                "Grass: " + mapEntity.getEntitysByClass(Grass.class));
    }

    public boolean inputData() {
        System.out.println("____________________________________");
        Scanner scanner = new Scanner(System.in);
        boolean correctInput = false;
        boolean finishedSimulation = false;
        do {
            if (mapEntity.getCreatures().isEmpty()) return false;
            System.out.println("Enter (1) for start simulation or enter (2) for makeMove: ");
            int rezult = scanner.nextInt();
            switch (rezult) {
                case 1:
                    finishedSimulation = startContinuousSimulation();
                case 2:
                    finishedSimulation = nextTurn();
                default:
                    correctInput = true;
            }
        } while (correctInput & finishedSimulation);
        return false;
    }

    public boolean initMap(MapEntity map) {
        new InstallerPredators(map).perform();
        new InstallerHerbivores(map).perform();
        new InstallerGrass(map).perform();
        new InstallerTree(map).perform();
        new InstallerRock(map).perform();
        return true;
    }

}


