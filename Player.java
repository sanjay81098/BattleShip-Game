import java.util.*;

class Player {
    String name;
    List<Ship> ships = new ArrayList<>();
    Set<Coordinate> takenCoord = new HashSet<>();

    Player(String name) {
        this.name = name; 
    }

    boolean addShip(String id, int size, int x, int y) {
        Ship ship = new Ship(id, size, x, y);
        for (Coordinate c : ship.cells) {
            if (takenCoord.contains(c))
                return false;
        }
        takenCoord.addAll(ship.cells);
        ships.add(ship);
        return true;
    }

    boolean fireAt(Coordinate c) {
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            if (ship.isHit(c)) {
                System.out.println(name + "'s ship with id " + ship.id + " destroyed.");
                ships.remove(i);
                return true;
            }
        }
        return false;
    }

    boolean hasShips() {
        return !ships.isEmpty(); 
    }
}