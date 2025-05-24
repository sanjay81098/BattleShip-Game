import java.util.*;


public class Game {
    int N;
    Player A = new Player("PlayerA");
    Player B = new Player("PlayerB");
    Set<Coordinate> fired = new HashSet<>();
    Random rand = new Random();

    public void initGame(int n) {
        N = n;
        System.out.println("Game initialized with board size: " + N + "x" + N);
    }

    public void addShip(String id, int size, int ax, int ay, int bx, int by) {
        if (!A.addShip("A-" + id, size, ax, ay))
            System.out.println("This ship is overlapping with another ship for player A");
        if (!B.addShip("B-" + id, size, bx, by))
            System.out.println("This ship is overlapping with another ship for player B");
    }

   private Coordinate getRandomCoordinate(boolean forA) {
        int x, y;
        Coordinate c;
        do {
            x = rand.nextInt(N / 2);
            y = rand.nextInt(N);
            if (forA) x += N / 2;
            c = new Coordinate(x, y);
        } while (fired.contains(c));
        fired.add(c);
        return c;
    }

    public void startGame() {
        boolean turnA = true;
        while (A.hasShips() && B.hasShips()) {
            Player attacker = turnA ? A : B;
            Player defender = turnA ? B : A;
            Coordinate c = getRandomCoordinate(!turnA);
            System.out.print(attacker.name + "'s turn: Missile fired at (" + c.x + ", " + c.y + ") : ");
            if (defender.fireAt(c)) System.out.println("Hit");
            else System.out.println("Miss");
            System.out.println("Ships Remaining - PlayerA:" + A.ships.size() + ", PlayerB:" + B.ships.size());
            turnA = !turnA;
        }
        System.out.println("GameOver. " + (A.hasShips() ? "PlayerA" : "PlayerB") + " wins.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initGame(4);
        game.addShip("SH1", 2, 1, 3, 4, 4);
        game.startGame();
    }
}
