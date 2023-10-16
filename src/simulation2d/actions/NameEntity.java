package simulation2d.actions;

import simulation2d.entity.*;
import simulation2d.entity.creature.Herbivore;
import simulation2d.entity.creature.Predator;

public enum NameEntity {
    HERBIVORE(Herbivore.class, "\u001b[48;5;252m\uD83D\uDC0F\u001b[0m"),
    PREDATOR(Predator.class, "\u001b[48;5;124m\uD83D\uDC3A\u001b[0m"),
    GRASS(Grass.class, "\u001b[48;5;252m\u001b[38;5;76m▉ \u001b[0m"),
    ROCK(Rock.class, "\u001b[48;5;245m\u001b[38;5;240m▉ \u001b[0m"),
    TREE(Tree.class, "\u001b[48;5;65m\u001b[38;5;58m▉ \u001b[0m"),
    FLOOR("\u001b[48;5;252m\u001b[38;5;250m⟦ ⟧\u001b[0m");

//    HERBIVORE(Herbivore.class, "H"), //"\u001b[48;5;252m\uD83D\uDC0F\u001b[0m"
//    PREDATOR(Predator.class, "P"), //"\u001b[48;5;124m\uD83D\uDC3A\u001b[0m"
//    GRASS(Grass.class, "G"), //"\u001b[48;5;252m\u001b[38;5;76m▉ \u001b[0m"
//    ROCK(Rock.class, "R"), //"\u001b[48;5;245m\u001b[38;5;240m▉ \u001b[0m"
//    TREE(Tree.class, "T"), //"\u001b[48;5;65m\u001b[38;5;58m▉ \u001b[0m"
//    FLOOR("_"); //"\u001b[48;5;252m\u001b[38;5;250m⟦ ⟧\u001b[0m"

    String ikon;
    Class type;
    NameEntity(Class type, String ikon) {
        this.type = type;
        this.ikon = ikon;
    }
    NameEntity(String ikon) {
        this.type = type;
        this.ikon = ikon;
    }

    public String getIcon() {
        return ikon;
    }

    public Class getType() {
        return type;
    }
}
