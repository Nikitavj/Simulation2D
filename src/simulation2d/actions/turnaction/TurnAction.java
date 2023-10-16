package simulation2d.actions.turnaction;

import simulation2d.MapEntity;
import simulation2d.actions.Action;
import simulation2d.actions.intitaction.InstallerObjectsMap;

public class TurnAction extends Action {

    MoveSimulation moveSimulation = new MoveSimulation();
    InstallerObjectsMap installerObjectsMap = new InstallerObjectsMap();

    public boolean makeMoveCreatures(MapEntity map, BreadsFirstSearch breadsFirstSearch) {
        if(!moveSimulation.makeMoveCreatures(map, breadsFirstSearch, installerObjectsMap)) {
            return false;
        }
        installerObjectsMap.addGrass(map);
        return true;
    }
}
