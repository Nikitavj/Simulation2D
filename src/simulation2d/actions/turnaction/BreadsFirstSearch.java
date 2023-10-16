package simulation2d.actions.turnaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.entity.Rock;
import simulation2d.entity.Tree;
import simulation2d.entity.creature.Creature;

import java.util.*;

public class BreadsFirstSearch {
    Set<Coordinate> setUsedCoordinates;
    Deque<Coordinate> dequeCreatureCoordinate;

    public BreadsFirstSearch() {
        this.setUsedCoordinates = new HashSet<>();
        this.dequeCreatureCoordinate = new LinkedList<>();
    }

    public Coordinate breadSearch(MapEntity map, Creature creature) {
        setUsedCoordinates.clear();
        dequeCreatureCoordinate.clear();
        Coordinate finalCoordinate = null;
        Coordinate positionCurrent = null;
        dequeCreatureCoordinate.add(creature.coordinate);

        while (!dequeCreatureCoordinate.isEmpty()) {
            positionCurrent = dequeCreatureCoordinate.remove();
            setUsedCoordinates.add(positionCurrent);
            for (int x = (positionCurrent.x - 1); x <= (positionCurrent.x + 1); x++) {
                for (int y = (positionCurrent.y - 1); y <= (positionCurrent.y + 1); y++) {
                    if (x >= 0 & x < map.getSizeX() & y >= 0 & y < map.getSizeY()) {
                        Coordinate anotherCoordinate = new Coordinate(x, y);
                        if (setUsedCoordinates.contains(anotherCoordinate)) {
                            continue;
                        }
                        if (map.containsCoordinate(anotherCoordinate)) {
                            if (map.getEntity(anotherCoordinate) instanceof Rock || map.getEntity(anotherCoordinate) instanceof Tree)
                                continue;
                            Class typeEat = creature.typeEat;
                            Class typeAnother = map.getEntity(anotherCoordinate).getClass();
                            if (typeAnother.equals(typeEat)) {
                                return finalCoordinate = anotherCoordinate;
                            }
                        }
                        dequeCreatureCoordinate.add(anotherCoordinate);
                    }
                }
            }
        }
        return finalCoordinate;
    }
}
