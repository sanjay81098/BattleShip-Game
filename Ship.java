import java.util.*;

class Ship {
    String id;
    Set<Coordinate> cells = new HashSet<>();

    Ship(String id, int size, int x, int y) {
        this.id = id;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinate coord = new Coordinate(x + i, y + j);
                cells.add(coord);
            }
        }
    }

    boolean isHit(Coordinate c) {
        return cells.contains(c);
    }
}