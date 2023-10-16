package simulation2d;

import simulation2d.actions.NameEntity;

public class Renderer {

    public Renderer() {
    }

    public void render(MapEntity map) {
        for (int y = (map.getSizeY() - 1); y >= 0; y--) {
            for (int x = 0; x < map.getSizeX(); x++) {
                if (map.containsCoordinate(new Coordinate(x, y))) {
                    System.out.print(map.getEntity(new Coordinate(x, y)).ikon);
                } else {
                    System.out.print(NameEntity.FLOOR.getIcon());
                }
            }
            System.out.println();
        }
    }
}
