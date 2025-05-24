import java.util.*;

class Coordinate {
    int x, y;
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
            
        if (!(o instanceof Coordinate))
            return false;
            
        Coordinate Coordinate = (Coordinate) o;
        return x == Coordinate.x && y == Coordinate.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}