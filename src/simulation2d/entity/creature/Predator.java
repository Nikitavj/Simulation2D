package simulation2d.entity.creature;

import simulation2d.Simulation;
import java.util.LinkedList;

public class Predator extends Creature {

    public Predator() {
        super.typeEat = Herbivore.class;
        super.hp = Simulation.hpPredators;
        super.reproductionHP = Simulation.hpPredators;
        super.speed = Simulation.speedPredators;
        super.path = new LinkedList<>();
        super.ikon = "\u001b[48;5;124m\uD83D\uDC3A\u001b[0m";
    }
}


