package simulation2d.actions.intitaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.creature.Predator;

public class InstallerPredators extends InitAction {

    public InstallerPredators(MapEntity map) {
        super.map = map;
        super.numbersEntity = Simulation.numberOfPredators;
    }

    @Override
    public Entity produseEntity() {
            return new Predator();
    }
}
