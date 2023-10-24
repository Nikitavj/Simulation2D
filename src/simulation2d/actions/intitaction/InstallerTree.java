package simulation2d.actions.intitaction;

import simulation2d.MapEntity;
import simulation2d.Simulation;
import simulation2d.entity.Entity;
import simulation2d.entity.Tree;

public class InstallerTree extends InitAction {

    public InstallerTree(MapEntity map) {
        super.map = map;
        super.numbersEntity = Simulation.numberOfTree;
    }

    @Override
    public Entity produseEntity() {
        return new Tree();
    }
}
