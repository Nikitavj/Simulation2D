package simulation2d.actions.intitaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.Rock;

public class InstallerRock extends InitAction {

    public InstallerRock(MapEntity map) {
        super.map = map;
        super.numbersEntity = Simulation.numberOfRock;
    }

    @Override
    public Entity produseEntity() {
        return new Rock();
    }
}
