package hotel;

/**
 * A room has a number and vacancy status.
 * @author Brandon Tiqui
 */
public class Room 
{
    /**
     * Constructs a vacant room with a room number.
     * @param roomNumber the room number
     */
    public Room(int roomNumber)
    {
        this.setRoomNumber(roomNumber);
        this.setRoomVacancy(true);
    }
    
    /**
     * Sets the room number.
     * @param roomNumber the room number
     */
    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }
    
    /**
     * Gets the room number.
     * @return the room number 
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }
    
    /**
     * Sets the vacancy status of the room.
     * @param vacancy true if room is vacant, false otherwise
     */
    public void setRoomVacancy(boolean vacancy)
    {
        this.vacancy = vacancy;
    }
    
    /**
     * Gets the vacancy status of the room.
     * @return vacancy true if room is vacant, false otherwise
     */
    public boolean getRoomVacancy()
    {
        return vacancy;
    }
 
    private int roomNumber;
    private boolean vacancy;
}