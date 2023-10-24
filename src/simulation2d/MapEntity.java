package simulation2d;

import simulation2d.entity.*;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

import java.util.*;

public class MapEntity {
    private int sizeX;
    private int sizeY;
    private HashMap<Coordinate, Entity> mapEntity = new HashMap<>();
    public Set<Entity> listRemovedEntity = new HashSet<>();
    private int countCycle = 0;

    public MapEntity(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Set<Coordinate> getSetKey() {
        return mapEntity.keySet();
    }

    public Collection<Entity> getValues() {
        return mapEntity.values();
    }

    public Collection<Creature> getCreatures() {
        Collection<Creature> listCreature = new HashSet<>();
        for (Entity entity : mapEntity.values()) {
            if (entity instanceof Predator || entity instanceof Herbivore) {
                listCreature.add((Creature) entity);
            }
        }
        return listCreature;
    }

    public int getNumberGrass() {
        int count = 0;
        for (Entity entity: mapEntity.values()) {
            if (entity instanceof Grass) {
                count++;
            }
        }
        return count;
    }

    public void removeEntity(Coordinate coordinate) {
        mapEntity.remove(coordinate);
    }

    public void addEntity(Coordinate coordinate, Entity entity) {
        mapEntity.put(coordinate, entity);
    }

    public boolean containsCoordinate(Coordinate coordinate) {
        return mapEntity.containsKey(coordinate);
    }

    public Entity getEntity(Coordinate coordinate) {
        return mapEntity.get(coordinate);
    }

    public void countCycleIncrement() {
        countCycle++;
    }

    public int getCountCycle() {
        return countCycle;
    }

    public <T extends Entity> int getEntitysByClass(Class<T> entityClass) {
        int count = 0;
        for (Entity entry : mapEntity.values()) {
            if (entry.getClass().equals(entityClass)) {
                count++;
            }
        }
        return count;
    }

    public <T extends Creature> int getHPbyClass(Class<T> entityClass) {
        int countHP = 0;
        for (Entity entry : mapEntity.values()) {
            if (entry.getClass().equals(entityClass)) {
                countHP += ((Creature) entry).hp;
            }
        }
        return countHP;
    }
}
