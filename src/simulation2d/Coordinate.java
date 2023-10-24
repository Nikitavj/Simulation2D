package simulation2d;

import java.util.Comparator;

public class Coordinate implements Comparator<Coordinate> {
    public int x;
    public int y;
    public int weight;
    public int lengthAll;
    public int approcsimationHeuristic;
    public Coordinate coordinatePrevious;

    public Coordinate(int x, int y) {
        if (x < 50 & y < 50) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("Coordinate is out of bounds!");
        }
    }

    @Override
    public int compare(Coordinate o1, Coordinate o2) {
        return o1.weight - o2.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
