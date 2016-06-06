package hotel;

import java.util.ArrayList;

/**
 * Receptionist to control the creation, checking-in and out of hotel rooms.
 * @author Brandon Tiqui
 */
public class Receptionist 
{
    /**
     * Class constructor assigns receptionist to a hotel.
     */
    public Receptionist()
    {
        california = new Hotel();
    }
    
    /**
     * Adds a room to the hotel given the room number.
     * @param roomNumber the room number
     */
    public void addRoom(int roomNumber)
    {
        Room e = new Room(roomNumber);
        california.getRoomsList().add(e);
    }
    
    /**
     * Sets the vacancy status of the room.
     * @param roomNumber the room number
     * @param vacancy true if the room is vacant, false otherwise
     */
    public void setRoomVacancy(int roomNumber, boolean vacancy)
    {
        Room a = california.getRoom(roomNumber);
        a.setRoomVacancy(vacancy);
    }
    
    /**
     * Gets the room vacancy status as a string.
     * @param roomNumber the room number
     * @return String: "vacant" if room is vacant, "occupied" if occupied
     */
    public String getRoomVacancy(int roomNumber)
    {
        Room a = california.getRoom(roomNumber);
        if (a.getRoomVacancy() == true)
        {
            return "vacant";
        }
        else
        {
            return "occupied";
        }
    }
    
    /**
     * Verifies if room exists in hotel.
     * @param roomNumber the room number
     * @return true if room exists, false otherwise
     */
    public boolean isRoom (int roomNumber)
    {
        for (Room a : california.getRoomsList())
        {
            if (a.getRoomNumber() == roomNumber)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return a string containing the summary of the rooms and their vacancy status
     */
    public String hotelSummary()
    {
        String message = "";
        for(Room a : california.getRoomsList())
        {
            message += "Room " + a.getRoomNumber() + ": " + getRoomVacancy(a.getRoomNumber()) + "\n";
        }
        return message;    
    }
   
    private Hotel california;
}