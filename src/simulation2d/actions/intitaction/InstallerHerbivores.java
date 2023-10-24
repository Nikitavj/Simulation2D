package simulation2d.actions.intitaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.creature.Herbivore;

public class InstallerHerbivores extends InitAction {

    public InstallerHerbivores(MapEntity map) {
        super.map = map;
        super.numbersEntity = Simulation.numberOfHerbivore;
    }

    @Override
    public Entity produseEntity() {
        return new Herbivore();
    }
}
