package simulation2d.actions;

import simulation2d.Simulation;
import simulation2d.entity.*;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

public enum NameEntity {
    HERBIVORE(Herbivore.class, "\u001b[48;5;252m\uD83D\uDC0F\u001b[0m", Simulation.numberOfHerbivore),
    PREDATOR(Predator.class, "\u001b[48;5;124m\uD83D\uDC3A\u001b[0m", Simulation.numberOfPredators),
    GRASS(Grass.class, "\u001b[48;5;252m\u001b[38;5;76m▉ \u001b[0m", Simulation.numberOfGrass),
    ROCK(Rock.class, "\u001b[48;5;245m\u001b[38;5;240m▉ \u001b[0m", Simulation.numberOfRock),
    TREE(Tree.class, "\u001b[48;5;65m\u001b[38;5;58m▉ \u001b[0m", Simulation.numberOfTree),
    FLOOR("\u001b[48;5;252m\u001b[38;5;250m⟦ ⟧\u001b[0m");

    String ikon;
    Class type;
    int number;
    NameEntity(Class type, String ikon, int number) {
        this.type = type;
        this.ikon = ikon;
        this.number = number;
    }
    NameEntity(String ikon) {
        this.ikon = ikon;
    }

    public String getIcon() {
        return ikon;
    }

    public Class getType() {
        return type;
    }

    public int getNumber() { return number;}
}
