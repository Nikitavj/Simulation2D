package simulation2d;

public class Renderer {

    public Renderer() {
    }

    public void render(MapEntity map) {
        for (int y = (map.getSizeY() - 1); y >= 0; y--) {
            for (int x = 0; x < map.getSizeX(); x++) {
                if (map.containsCoordinate(new Coordinate(x, y))) {
                    System.out.print(map.getEntity(new Coordinate(x, y)).ikon);
                } else {
                    System.out.print("\u001b[48;5;252m\u001b[38;5;250m⟦ ⟧\u001b[0m");
                }
            }
            System.out.println();
        }
    }
}
