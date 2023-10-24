package simulation2d.actions.turnaction;
import simulation2d.actions.Action;
import simulation2d.entity.creature.Creature;
import java.util.LinkedList;

public abstract class TurnAction extends Action {

    BreadsFirstSearch breadsFirstSearch = new BreadsFirstSearch();
    Astar astar = new Astar();
    Step step = new Step();

    public void perform() {
        map.countCycleIncrement();
        for (Creature creature: listCreature()) {
            if (creature.hp > 0) {
                breadsFirstSearch.breadSearch(map, creature);
                astar.findePath(map, creature);
                step.makeStepCreature(map, creature);
                reproduct(creature);
            } else {
                map.listRemovedEntity.add(creature);
                map.removeEntity(creature.coordinate);
            }

        }
    }

    public abstract LinkedList<Creature> listCreature();

    public abstract void reproduct(Creature creature);
}
