package simulation2d.entity.creature;

import simulation2d.Coordinate;
import simulation2d.actions.intitaction.InstallerObjectsMap;
import simulation2d.MapEntity;
import simulation2d.actions.NameEntity;
import simulation2d.entity.Entity;
import simulation2d.actions.turnaction.BreadsFirstSearch;
import simulation2d.actions.turnaction.Astar;
import simulation2d.actions.turnaction.Step;

import java.util.Deque;
import java.util.LinkedList;

public abstract class Creature extends Entity {
    public Coordinate finalCoordinat;           //координата цели
    public Class typeEat;
    public Deque<Coordinate> path;
    public int speed;
    public int hp;
    public int reproductionHP;
    public NameEntity name;

    public boolean makeMove(MapEntity map,
                            BreadsFirstSearch breadsFirstSearch,
                            Astar pathShortest,
                            Step step,
                            LinkedList<Creature> queue) {
        finalCoordinat = breadsFirstSearch.breadSearch(map, this);
        if (finalCoordinat == null) {
            hp -= 1;
            return false;
        }
        pathShortest.findePath(map, this);
        step.makeStepCreature(map, this, queue);
        return true;
    };

    public boolean reproduct(MapEntity map, InstallerObjectsMap installerObjectsMap) {
            hp -= reproductionHP;
            installerObjectsMap.addCreatureOnMap(map, name, 1);
        return true;
    }
}
