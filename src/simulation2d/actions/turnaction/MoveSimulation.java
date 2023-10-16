package simulation2d.actions.turnaction;

import simulation2d.MapEntity;
import simulation2d.actions.intitaction.InstallerObjectsMap;
import simulation2d.entity.creature.Creature;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

import java.util.Collection;
import java.util.LinkedList;

public class MoveSimulation {
    BreadsFirstSearch breadsFirstSearch;
    Astar pathShortest;
    Step step;
    LinkedList<Creature> queue;
    LinkedList<Creature> queueForRemove;
    LinkedList<Creature> listReproduction;

    public MoveSimulation() {
        this.breadsFirstSearch = new BreadsFirstSearch();
        this.pathShortest = new Astar();
        this.step = new Step();
        this.queue = new LinkedList<>();
        this.queueForRemove = new LinkedList<>();
        this.listReproduction = new LinkedList<>();
    }

    public boolean makeMoveCreatures(MapEntity map, BreadsFirstSearch breadsFirstSearch, InstallerObjectsMap installer) {

        if (!findCreatures(map, installer)) return false;
        while (!queue.isEmpty()) {
            Creature creature = queue.remove();
            creature.makeMove(map, breadsFirstSearch, pathShortest, step, queue);
        }
        return true;
    }

    public boolean findCreatures(MapEntity map, InstallerObjectsMap installer) {
        Collection collection = map.getValues();
        queue.clear();
        queueForRemove.clear();
        listReproduction.clear();
        for (Object entity : collection) {
            if (checkHP(entity)) {
                continue;
            }
            if (entity instanceof Predator) {
                queue.addFirst((Creature) entity);
            }
            if (entity instanceof Herbivore) {
                queue.add((Creature) entity);
            }
        }

        if (!queueForRemove.isEmpty()) {
            for (Creature creature: queueForRemove) {
                map.removeEntity(creature.coordinate);
            }
        }

        if(!listReproduction.isEmpty()) {
            for (Creature creature: listReproduction) {
                creature.reproduct(map, installer);
            }
        }

        if (queue.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkHP(Object entity) {
        if (entity instanceof Predator || entity instanceof Herbivore) {
            Creature creature = (Creature) entity;
            if (creature.hp <= 0) {
                queueForRemove.add(creature);
                return true;
            }
            if (creature.hp >= (creature.reproductionHP * 2)) {
                listReproduction.add(creature);
            }
        }
        return false;
    }

}
