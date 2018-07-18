package creational.factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class MazeGame {
    private final List<Room> rooms = new ArrayList<Room>();

    public MazeGame() {
        Room room1 = makeRoom();
        Room room2 = makeRoom();
        // just a demo: connect room1 with room2, room1.connect(room2);
        rooms.add(room1);
        rooms.add(room2);
    }

    // the factory method
    // for different concrete games, implement this method to create different rooms.
    abstract protected Room makeRoom();
}
