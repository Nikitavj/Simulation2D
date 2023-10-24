package simulation2d.actions.intitaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.actions.Action;
import simulation2d.entity.Entity;
import java.util.Random;
import java.util.Set;

public abstract class InitAction extends Action {

    MapEntity map;
    Random random = new Random();
    int numbersEntity;

    @Override
    public void perform() {
        addEntityOnMap(numbersEntity);
    }

    public void addEntityOnMap(int numbers) {
        Set<Coordinate> keySet = map.getSetKey();

        for (int i = 0; i < numbers; i++) {
            boolean containsKey = true;
            while (containsKey) {
                Coordinate coordinateThis = getRandomeCoordinate();
                if (!keySet.contains(coordinateThis)) {
                    Entity entity = produseEntity();
                    entity.coordinate = coordinateThis;
                    map.addEntity(coordinateThis, entity);
                    containsKey = false;
                }
            }
        }
    }

    public Coordinate getRandomeCoordinate() {
        return new Coordinate(random.nextInt(map.getSizeX()), random.nextInt(map.getSizeY()));
    }

    public abstract Entity produseEntity();
}
