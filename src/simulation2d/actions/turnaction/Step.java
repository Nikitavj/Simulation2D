package simulation2d.actions.turnaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.Grass;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Herbivore;

import java.util.LinkedList;

public class Step {

    public boolean makeStepCreature(MapEntity map,
                                    Creature creature,
                                    LinkedList<Creature> queue) {

        if (!creature.path.isEmpty()) {
            Coordinate destination = null;
            if (creature.path.size() < creature.speed) {
                destination = creature.path.pollLast();
                creature.hp -= creature.path.size();
            } else {
                int count = creature.speed;
                while (count > 0) {
                    destination = creature.path.remove();
                    creature.hp -= 1;
                    count--;
                }
            }

            if (destination == null) return false;
            if (destination.equals(creature.finalCoordinat)) {
                Entity eat = map.getEntity(creature.finalCoordinat);
                queue.remove(eat);
                if (eat instanceof Grass) {
                    creature.hp += Simulation.nutritionalOfGrass;
                }
                if (eat instanceof Herbivore) {
                    creature.hp += (((Herbivore) eat).hp / 2);
                }
            }
            map.removeEntity(creature.coordinate);
            creature.coordinate = destination;
            map.addEntity(destination, creature);
            return true;
        }
        return false;
    }

}
