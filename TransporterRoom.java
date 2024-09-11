import java.util.Random;
/**
 * A room that teleports the player to a random room in the game.
 *
 * This class is part of the "World of Zuul" application. "World of Zuul" is a
 * very simple, text based adventure game.
 *
 * A "TransporterRoom" is a room that teleports the player to a random room in
 * the game. It is a sub-class of Room
 * 
 * @author Mithushan Ravichandramohan
 * @version A2 Solution 2024-03-17
 */
public class TransporterRoom extends Room {
    private Random random;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "kitchen" or "courtyard".
     *
     * @param description The room's description.
     */
    public TransporterRoom(String description) {
        super(description);
        random = new Random();
    }

    /**
     * Returns a random room from the list of all rooms.
     *
     * @return A random room from the list of all rooms.
     */
    @Override
    public Room getExit(String direction) {
        return findRandomRoom();
    }

    /**
     * Returns a random room from the list of all rooms.
     *
     * @return A random room from the list of all rooms.
     */
    private Room findRandomRoom() {
        int index = random.nextInt(allRooms.size());
        return allRooms.get(index);
    }
}