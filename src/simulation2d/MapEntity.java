package simulation2d;

import simulation2d.entity.*;
import simulation2d.entity.creature.Creature;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEntity {
    private int sizeX;
    private int sizeY;
    private HashMap<Coordinate, Entity> mapEntity;

    public MapEntity(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.mapEntity = new HashMap<>();
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

    public <T extends Entity> int  getEntitysByClass(Class<T> entityClass) {
        int count = 0;
        for (Entity entry: mapEntity.values()) {
            if (entry.getClass().equals(entityClass)) {
                count++;
            }
        }
        return count;
    }

    public <T extends Creature> int getHPbyClass(Class<T> entityClass) {
        int countHP = 0;
        for (Entity entry: mapEntity.values()) {
            if (entry.getClass().equals(entityClass)) {
                countHP += ((Creature)entry).hp;
            }
        }
        return countHP;
    }
 }
