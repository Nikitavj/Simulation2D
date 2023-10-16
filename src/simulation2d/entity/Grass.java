package simulation2d.entity;

import simulation2d.actions.NameEntity;

public class Grass extends Entity{

    public Grass(){
        super.ikon = NameEntity.GRASS.getIcon();        //"\u001b[48;5;250m\u001b[38;5;76m▉ \u001b[0m"
    }

}
