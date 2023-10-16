package simulation2d.entity.creature;

import simulation2d.actions.NameEntity;
import simulation2d.Simulation;

import java.util.LinkedList;

public class Herbivore extends Creature {

    public Herbivore() {
        super.ikon = NameEntity.HERBIVORE.getIcon(); //"\u001b[48;5;196m  \u001b[0m"
        super.typeEat = NameEntity.GRASS.getType();
        super.hp = Simulation.hpHerbivore;
        super.reproductionHP = Simulation.hpHerbivore;
        super.speed = Simulation.speedHerbivore;
        super.path = new LinkedList<>();
        super.name = NameEntity.HERBIVORE;
    }

}

