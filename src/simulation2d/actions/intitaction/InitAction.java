package simulation2d.actions.intitaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.actions.Action;
import simulation2d.actions.NameEntity;
import simulation2d.entity.Entity;
import simulation2d.entity.Grass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Set;

public class InitAction extends Action {

    int count;
    Random random = new Random();

    public boolean setObjectsOnTheMap(MapEntity map) {

        arrangeObjectsOfType(map, NameEntity.TREE);
        arrangeObjectsOfType(map, NameEntity.ROCK);
        arrangeObjectsOfType(map, NameEntity.HERBIVORE);
        arrangeObjectsOfType(map, NameEntity.PREDATOR);
        arrangeObjectsOfType(map, NameEntity.GRASS);

        return true;
    }

    private boolean arrangeObjectsOfType(MapEntity map, NameEntity nameEntity) {
        int numbers = 0;

        switch (nameEntity) {
            case GRASS:
                numbers = Simulation.numberOfGrass;
                break;
            case PREDATOR:
                numbers = Simulation.numberOfPredators;
                break;
            case HERBIVORE:
                numbers = Simulation.numberOfHerbivore;
                break;
            case ROCK:
                numbers = Simulation.numberOfRock;
                break;
            case TREE:
                numbers = Simulation.numberOfTree;
                break;
            default:
                numbers = 0;
        }

        addCreatureOnMap(map, nameEntity, numbers);
        return true;
    }

    public boolean addCreatureOnMap(MapEntity map, NameEntity nameEntity, int numbers) {
        Set<Coordinate> keySet = map.getSetKey();

        for (int i = 0; i < numbers; i++) {
            boolean containsKey = true;
            while (containsKey) {
                Coordinate coordinateThis = new Coordinate(random.nextInt(map.getSizeX()), random.nextInt(map.getSizeY()));
                if (!keySet.contains(coordinateThis)) {
                    try {
                        Class typeEntity = nameEntity.getType();
                        Constructor constructor = typeEntity.getConstructor();

                        try {
                            Entity entity = (Entity) constructor.newInstance();
                            entity.coordinate = coordinateThis;
                            map.addEntity(coordinateThis, entity);

                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    containsKey = false;
                }
            }
        }
        return true;
    }

    public boolean addGrass(MapEntity map) {
        count++;
        if (count == 5) {
            if (map.getEntitysByClass(Grass.class) < 30) {
                arrangeObjectsOfType(map, NameEntity.GRASS);
            }
            count = 0;
            return true;
        }
        return false;
    }
}
