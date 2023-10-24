package simulation2d.actions.turnaction;

import simulation2d.MapEntity;
import simulation2d.actions.intitaction.InstallerPredators;
import simulation2d.entity.Entity;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Predator;
import java.util.Collection;
import java.util.LinkedList;

public class TurnActionPredator extends TurnAction{

    public TurnActionPredator(MapEntity map) {
        super.map = map;
    }

    public LinkedList<Creature> listCreature() {

        LinkedList<Creature> listCreature = new LinkedList<>();
        Collection<Entity> listEntity = map.getValues();
        for (Entity entity: listEntity) {
            if (entity instanceof Predator) {
                listCreature.add((Creature)entity);
            }
        }
        return listCreature;
    }

    @Override
    public void reproduct(Creature creature) {
        if (creature.hp >= (creature.reproductionHP * 2)) {
            new InstallerPredators(map).addEntityOnMap(1);
            creature.hp -= creature.reproductionHP;
        }
    }
}
