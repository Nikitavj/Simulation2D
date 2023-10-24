package simulation2d.entity.creature;

import simulation2d.Simulation;
import simulation2d.entity.Grass;
import java.util.LinkedList;

public class Herbivore extends Creature {

    public Herbivore() {
        super.typeEat = Grass.class;
        super.hp = Simulation.hpHerbivore;
        super.reproductionHP = Simulation.hpHerbivore;
        super.speed = Simulation.speedHerbivore;
        super.path = new LinkedList<>();
        super.ikon = "\u001b[48;5;252m\uD83D\uDC0F\u001b[0m";
    }
}

