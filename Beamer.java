
/**
 * A beamer is a device that can be charged and fired. When you charge the beamer, it memorizes the current room. 
 * When you fire the beamer, it transports you immediately back to the room it was charged in.
 *
 
 * @author Mithushan Ravichandramohan
 * @version A2 Solution 2024-03-17
 */
public class Beamer extends Item //subclass of item
{
    private boolean isCharged;
    
    private Room roomCharged;
    /**
     * Constructor for objects of class Beamer
     */
    public Beamer(String name, String description, double weight)
    {
        super(name, description, weight);
        isCharged = false;
        roomCharged = null;
    }

    /**
     * Returns a description of the item.
     *
     * @return  A description of the item
     */
    public String getDescription()
    {
        return super.getDescription();
    }

    /**
     * Returns the name of the item.
     *
     * @return  The name of the item
     */
    public String getName()
    {
        return super.getName();
    }

    /**
     * Returns if the beamer is charged.
     *
     * @return  True if the beamer is charged, else false.
     */
    public boolean isCharged(){
        return isCharged; //
    }

    /**
     * Charges the beamer in the current room.
     *
     * @param currentRoom The room the beamer is charged in.
     */
    public void charge(Room currentRoom){
        if(!isCharged){
            roomCharged = currentRoom;
            isCharged = true;
            System.out.println("Beamer has been charged");
        }else{
            System.out.println("Beamer is already Charged");
        }
    }

    /**
     * Fires the beamer and returns the room it was charged in.
     *
     * @return  The room the beamer was charged in.
     */
    public Room fire(){
        if(isCharged){
            System.out.println("Beamer has been fired");
            isCharged = false;
            return roomCharged;
        }else{
            System.out.println("Beamer is not charged");
            return null;
        }
    }
}
