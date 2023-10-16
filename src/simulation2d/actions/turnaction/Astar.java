package simulation2d.actions.turnaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.entity.creature.Creature;

import java.util.*;

public class Astar {

    Set<Coordinate> closedSetCoordinate;
    PriorityQueue<Coordinate> openQueueCoordinate;
    LinkedList<Coordinate> listNeighbours;


    public Astar() {
        this.closedSetCoordinate = new HashSet<>();
        this.openQueueCoordinate = new PriorityQueue<>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.weight - o2.weight;
            }
        });
        this.listNeighbours = new LinkedList<>();
    }

    public boolean findePath(MapEntity map, Creature creature) {

        openQueueCoordinate.clear();
        closedSetCoordinate.clear();
        listNeighbours.clear();
        creature.coordinate.coordinatePrevious = null;
        creature.coordinate.weight = 0;
        creature.coordinate.lengthAll = 0;
        creature.coordinate.approcsimationHeuristic = 0;

        openQueueCoordinate.add(creature.coordinate);
        while (!openQueueCoordinate.isEmpty()) {
            Coordinate current = openQueueCoordinate.poll();
            if (current.equals(creature.finalCoordinat)) {
                restoreThePath(current, creature);
                return true;
            }
            closedSetCoordinate.add(current);
            findNeighbours(map, current, creature);

            for (Coordinate neighbour: listNeighbours) {
                if (openQueueCoordinate.contains(neighbour)) {
                    Coordinate reapite = null;
                    for (Coordinate open: openQueueCoordinate) {
                        if (open.equals(neighbour)) {
                            reapite = open;
                            break;
                        }
                    }
                    if (reapite.weight > neighbour.weight) {
                        openQueueCoordinate.remove(reapite);
                        openQueueCoordinate.add(neighbour);
                    }
                    continue;
                }
                openQueueCoordinate.add(neighbour);
            }
        }
        return false;
    }

    public boolean restoreThePath(Coordinate current, Creature creature) {
        creature.path.clear();
        Coordinate point = current;
        while (point != null) {
            if (point.equals(creature.coordinate))break;
            creature.path.addFirst(point);
            point = point.coordinatePrevious;
        }
        return false;
    }

    public void findNeighbours(MapEntity map, Coordinate thisCoordinate, Creature creature) {
        listNeighbours.clear();
        for (int x = thisCoordinate.x - 1; x <= thisCoordinate.x + 1; x++) {
            for (int y = thisCoordinate.y - 1; y <= thisCoordinate.y + 1; y++) {
                if (!(x >= 0 & x < map.getSizeX() & y >= 0 & y < map.getSizeY())) continue;
                Coordinate neighbour = new Coordinate(x, y);
                if (closedSetCoordinate.contains(neighbour)) continue;
                if (map.containsCoordinate(neighbour)) {
                    Class typeNeighbours = map.getEntity(neighbour).getClass();
                    Class typeEat = creature.typeEat;
                    if (!typeNeighbours.equals(typeEat)) continue;
                }
                neighbour.lengthAll = findeLengthEdge(thisCoordinate, neighbour);
                neighbour.approcsimationHeuristic = findeApprocsimationHeuristic(neighbour, creature.finalCoordinat);
                neighbour.weight = neighbour.lengthAll + neighbour.approcsimationHeuristic;
                neighbour.coordinatePrevious = thisCoordinate;
                listNeighbours.add(neighbour);
            }
        }
    }

    private int findeApprocsimationHeuristic(Coordinate thisPosition, Coordinate finalCoordinat) {
        int numberOfSteps = Math.abs(thisPosition.x - finalCoordinat.x) +
                Math.abs(thisPosition.y - finalCoordinat.y);
        int approcsimationHeuristic = 10 * numberOfSteps;
        return approcsimationHeuristic;
    }

    private int findeLengthEdge(Coordinate thisCoordinate, Coordinate neighbour) {
        int lengthAll = 0;
        int length = 0;
        if ((Math.abs(thisCoordinate.x - neighbour.x) +
                Math.abs(thisCoordinate.y - neighbour.y)) == 1) {
            length = 10;
        } else {
            length = 14;
        }
        lengthAll = thisCoordinate.lengthAll + length;
        return lengthAll;
    }

}


