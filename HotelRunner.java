package hotel;

import java.io.PrintStream;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.IOException;
import java.awt.Color;

/**
 * HotelRunner executes the GUI for the hotel room management console.
 * @author Brandon Tiqui
 */
public class HotelRunner 
{
    public static void main(String[] args)
    {
        final Receptionist robot = new Receptionist();
        
        JFrame frame = new JFrame();
        
        JLabel label = new JLabel("Room Number: ");
        final JTextField field = new JTextField(10);
        JButton createroomButton = new JButton ("Create Room");
        JButton checkinButton = new JButton("Check In");
        JButton checkoutButton = new JButton("Check Out");
        final JTextArea messageOutput = new JTextArea("Welcome to the Hotel Room Management Console!", 1, 50);
        final JTextArea summaryOutput = new JTextArea(20, 50);
        messageOutput.setBackground(Color.cyan);
        
        
        JPanel panel = new JPanel();
        panel.add(messageOutput);
        panel.add(createroomButton);
        panel.add(label);
        panel.add(field);
        
        panel.add(checkinButton);
        panel.add(checkoutButton);
        panel.add(summaryOutput);
        
        
        frame.add(panel);
        
        
        class CreateroomListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent event)
            { 
               if (field.getText().isEmpty())
                    messageOutput.setText("Please enter a room number."); 
               
               else if (robot.isRoom(Integer.parseInt(field.getText())) == false)
               {
                   robot.addRoom(Integer.parseInt(field.getText()));
                   messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " has been added to the hotel.");
               }
               
               else
               {
                   messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " already exists.");
               }
               summaryOutput.setText(robot.hotelSummary());
            }
        }
        
        ActionListener createroomListener = new CreateroomListener();
        createroomButton.addActionListener(createroomListener);
        
        class CheckinListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
               if (field.getText().isEmpty())
                    messageOutput.setText("Please enter a room number."); 
               
               else if (robot.isRoom(Integer.parseInt(field.getText())) == true)
               {
                   if (robot.getRoomVacancy(Integer.parseInt(field.getText())) == "vacant")
                   {
                        robot.setRoomVacancy(Integer.parseInt(field.getText()), false);
                        messageOutput.setText("Guest has been checked into room " + Integer.parseInt(field.getText()) + ".");
                   }
                   else
                   {
                        messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " is still occupied.");
                   }
               }
               else
               {
                   messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " doesn't exist.  Please create the room before checking into it.");
               }
               summaryOutput.setText(robot.hotelSummary());
            }
        }
        ActionListener checkinListener = new CheckinListener();
        checkinButton.addActionListener(checkinListener);
        
        class CheckoutListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
               if (field.getText().isEmpty())
                    messageOutput.setText("Please enter a room number."); 
               
               else if (robot.isRoom(Integer.parseInt(field.getText())) == true)
               {
                   if (robot.getRoomVacancy(Integer.parseInt(field.getText())) == "occupied")
                   {
                        robot.setRoomVacancy(Integer.parseInt(field.getText()), true);
                        messageOutput.setText("Guest has been checked out of room " + Integer.parseInt(field.getText()) + ".");
                   }
                   else
                   {
                        messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " is vacant.  Please verify that the room number is correct.");
                   }
               }
               else
               {
                   messageOutput.setText("Room " + Integer.parseInt(field.getText()) + " doesn't exist.  Please verify that the room number is correct.");
               }
               summaryOutput.setText(robot.hotelSummary());
            }
        }
        ActionListener checkoutListener = new CheckoutListener();
        checkoutButton.addActionListener(checkoutListener);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
    
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
}
