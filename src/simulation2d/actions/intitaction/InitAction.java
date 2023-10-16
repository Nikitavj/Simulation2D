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

    InstallerObjectsMap installerObjectsMap = new InstallerObjectsMap();

    public boolean setObjectsOnTheMap(MapEntity map) {

        installerObjectsMap.addCreatureOnMap(map, NameEntity.TREE, NameEntity.TREE.getNumber());
        installerObjectsMap.addCreatureOnMap(map, NameEntity.ROCK, NameEntity.ROCK.getNumber());
        installerObjectsMap.addCreatureOnMap(map, NameEntity.HERBIVORE, NameEntity.HERBIVORE.getNumber());
        installerObjectsMap.addCreatureOnMap(map, NameEntity.PREDATOR, NameEntity.PREDATOR.getNumber());
        installerObjectsMap.addCreatureOnMap(map, NameEntity.GRASS, NameEntity.GRASS.getNumber());
        return true;
    }
}
