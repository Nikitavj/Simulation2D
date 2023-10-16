package simulation2d;

import simulation2d.actions.turnaction.BreadsFirstSearch;
import simulation2d.actions.intitaction.InitAction;
import simulation2d.actions.turnaction.TurnAction;
import simulation2d.entity.Grass;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Simulation {
    public static int numberOfPredators = 2;
    public static int hpPredators = 8;
    public static int speedPredators = 1;
    public static int numberOfHerbivore = 15;
    public static int hpHerbivore = 6;
    public static int speedHerbivore = 1;
    public static int numberOfGrass = 30;
    public static int nutritionalOfGrass = 6;
    public static int numberOfTree = 50;
    public static int numberOfRock = 100;
    public static int mapSizeX = 20;
    public static int MapSizeY = 20;
    private int count = 0;

    MapEntity mapEntity = new MapEntity(mapSizeX, MapSizeY);
    TurnAction turnAction = new TurnAction();
    InitAction initAction = new InitAction();
    Renderer renderer = new Renderer();
    BreadsFirstSearch breadsFirstSearch = new BreadsFirstSearch();
    boolean activeSimulation = true;


    public void startSimulation(){
        initAction.setObjectsOnTheMap(mapEntity);
        turnAction.makeMoveCreatures(mapEntity, breadsFirstSearch);
        renderer.render(mapEntity);
        informationSimulation();
        System.out.println("Size map: " + Simulation.mapSizeX + " x " + Simulation.MapSizeY + "\n" +
                "\n" +
                "This is a 2D Simulation of animal world");
        inputData();
    }

    public void startContinuousSimulation() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                if (scanner.nextLine() != null) {
                    activeSimulation = false;
                    System.out.println("Stop Simulation!!!");
                }
            }
        });
        thread.start();

        while (activeSimulation) {
            turnAction.makeMoveCreatures(mapEntity, breadsFirstSearch);
            count++;
            renderer.render(mapEntity);
            informationSimulation();
            try {
                System.out.println();
                System.out.println("(Enter) for STOP!");
                Thread.sleep(700);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (activeSimulation == false) {

            activeSimulation = true;
            inputData();
        }

        renderer.render(mapEntity);
        informationSimulation();
        System.out.println("Simulation is finished...");

    }

    public void nextTurn() {
        renderer.render(mapEntity);
        System.out.println("(Enter) for nextTurn or (1) for srartSimulation");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            int in = input.equals("")? 0: parseInt(input);
            if (in == 1) {
                startContinuousSimulation();
            }

            turnAction.makeMoveCreatures(mapEntity, breadsFirstSearch);
            count++;
            renderer.render(mapEntity);
            informationSimulation();
            System.out.println("(Enter) for nextTurn or (1) for srartSimulation");
        }
    }

    public void puseSimulation() {
    }

    public void informationSimulation() {
        System.out.println("Cycle: " + count + "\n" +
                "Predator: " + mapEntity.getEntitysByClass(Predator.class) + "  HP: " + mapEntity.getHPbyClass(Predator.class) + "\n" +
                "Herbivore: " + mapEntity.getEntitysByClass(Herbivore.class) + "    HP: " + mapEntity.getHPbyClass(Herbivore.class) + "\n" +
                "Grass: " + mapEntity.getEntitysByClass(Grass.class));
    }

    public boolean inputData() {
        System.out.println("____________________________________");
        Scanner scanner = new Scanner(System.in);
        boolean correctInput = false;
        do {
            System.out.println("Enter (1) for start simulation or enter (2) for makeMove: ");
            int rezult = scanner.nextInt();
            switch (rezult) {
                case 1:
                    startContinuousSimulation();
                    break;
                case 2:
                    nextTurn();
                    break;
                default:
                    correctInput = true;
            }
        } while (correctInput);
        return false;
    }
}


