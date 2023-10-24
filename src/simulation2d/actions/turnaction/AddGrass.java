package simulation2d.actions.turnaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.actions.Action;
import simulation2d.actions.intitaction.InstallerGrass;

public class AddGrass extends Action {

    public AddGrass(MapEntity map) {
        super.map = map;
    }
    @Override
    public void perform() {
        if (map.getNumberGrass() <= 3) {
            int number = Simulation.numberOfGrass;
            new InstallerGrass(map).addEntityOnMap(number);
        }
    }
}
