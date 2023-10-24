package simulation2d.actions.intitaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.Grass;

public class InstallerGrass extends InitAction {

    public InstallerGrass(MapEntity map) {
        super.map = map;
        super.numbersEntity = Simulation.numberOfGrass;
    }

    @Override
    public Entity produseEntity() {
        return new Grass();
    }
}
