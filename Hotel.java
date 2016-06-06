package hotel;

import java.util.ArrayList;

/**
 * A hotel with an array list of rooms.
 * @author Brandon Tiqui
 */
public class Hotel 
{
    /**
     *  Hotel constructor.
     */
    public Hotel()
    {
       roomsList = new ArrayList<>();
    }
    
    /**
     * Gets a list of rooms in the hotel.
     * @return roomsList the ArrayList object of rooms
     */
    public ArrayList<Room> getRoomsList()
    {
        return roomsList;
    }
    
    /**
     * Gets a room object given the room number.
     * @param roomNumber the room number
     * @return a Room 
     */
    public Room getRoom(int roomNumber)
    {
        for (Room a : roomsList)
        {
            if (a.getRoomNumber() == roomNumber)
            {
                return a;
            }
        }
        return null;
    }
   
    private ArrayList<Room> roomsList;
}