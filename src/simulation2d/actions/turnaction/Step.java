package simulation2d.actions.turnaction;

import simulation2d.Coordinate;
import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.Grass;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Herbivore;

public class Step {

    public boolean makeStepCreature(MapEntity map, Creature creature) {
        if (map.listRemovedEntity.contains(creature)) return false;
        creature.hp--;
        if (!creature.path.isEmpty() && creature.hp >= 0) {
            Coordinate destination = null;
            if (creature.path.size() < creature.speed) {   //если расстояние до цели меньше шага существа
                destination = creature.path.pollLast();
                creature.hp -= creature.path.size();
            } else {
                int count = creature.speed;  //если расстояние до цели больше шага существа
                while (count > 0) {
                    destination = creature.path.remove();
                    count--;
                }
            }

            if (destination == null) return false;
            if (destination.equals(creature.finalCoordinat)) {        // если цель является искомой финальной координатой
                Entity eat = map.getEntity(creature.finalCoordinat);
                map.listRemovedEntity.add(eat);
                if (eat instanceof Grass) {
                    creature.hp += Simulation.nutritionalOfGrass;
                }
                if (eat instanceof Herbivore) {
                    creature.hp += (((Herbivore) eat).hp * 0.8);
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
