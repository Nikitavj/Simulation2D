package simulation2d.actions;

import simulation2d.MapEntity;

public abstract class Action {

    public MapEntity map;
    public abstract void perform();
}
