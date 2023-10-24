package simulation2d.actions.turnaction;

import simulation2d.MapEntity;
import simulation2d.actions.intitaction.InstallerHerbivores;
import simulation2d.actions.intitaction.InstallerPredators;
import simulation2d.entity.Entity;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Herbivore;

import java.util.Collection;
import java.util.LinkedList;

public class TurnActionHerbivore extends TurnAction {

    public TurnActionHerbivore(MapEntity map) {
        super.map = map;
    }

    public LinkedList<Creature> listCreature() {

        LinkedList<Creature> listCreature = new LinkedList<>();
        Collection<Entity> listEntity = map.getValues();
        for (Entity entity : listEntity) {
            if (entity instanceof Herbivore) {
                listCreature.add((Creature) entity);
            }
        }
        return listCreature;
    }

    @Override
    public void reproduct(Creature creature) {
        if (creature.hp >= (creature.reproductionHP * 2)) {
            new InstallerHerbivores(map).addEntityOnMap(1);
            creature.hp -= creature.reproductionHP;
        }
    }
}
