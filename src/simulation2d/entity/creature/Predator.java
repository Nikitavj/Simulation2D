package simulation2d.entity.creature;

import simulation2d.actions.NameEntity;
import simulation2d.Simulation;

import java.util.LinkedList;

public class Predator extends Creature {

    public Predator() {
        super.ikon = NameEntity.PREDATOR.getIcon(); //"\u001b[48;5;196m  \u001b[0m"
        super.typeEat = NameEntity.HERBIVORE.getType();
        super.hp = Simulation.hpPredators;
        super.reproductionHP = Simulation.hpPredators;
        super.speed = Simulation.speedPredators;
        super.path = new LinkedList<>();
        super.name = NameEntity.PREDATOR;
    }

}


