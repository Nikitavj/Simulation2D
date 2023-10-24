package simulation2d.entity.creature;

import simulation2d.Coordinate;
import simulation2d.entity.Entity;
import java.util.Deque;

public abstract class Creature extends Entity {
    public Coordinate finalCoordinat;           //координата цели
    public Class typeEat;
    public Deque<Coordinate> path;
    public int speed;
    public int hp;
    public int reproductionHP;

}
