package simulation2d.entity;

import simulation2d.actions.NameEntity;

public class Tree extends Entity{

    public Tree(){
        super.ikon = NameEntity.TREE.getIcon();      //"\u001b[48;5;65m\u001b[38;5;58m▉ \u001b[0m"
    }
}