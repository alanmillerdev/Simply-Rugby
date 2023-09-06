package simplyRugby;

/**
 * <H1> View - Menu Screen</H1>
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 */

/**
 * Imports the Java Swing Jframe that is used to display the contents of the view to the user.
 */
import javax.swing.JFrame;
/**
 * Imports the Java Swing JPanel that is used as a container for elements within the view.
 */
import javax.swing.JPanel;
/**
 * Imports Java Swing Border Empty Border to allow for transparent borders.
 */
import javax.swing.border.EmptyBorder;
/**
 * Imports Java ImageIO ImageIO that is used to encode and decode images.
 */
import javax.imageio.ImageIO;
/**
 * Imports Java Swing ImageIcon that is used to display an icon image.
 */
import javax.swing.ImageIcon;
/**
 * Imports Java Swing JButton that allows buttons to be placed within the frame that allow actions to be performed.
 */
import javax.swing.JButton;
/**
 * Imports Java AWT Font which allows the rendering of fonts within the frame.
 */
import java.awt.Font;
/**
 * Imports Java AWT Image BufferedImage that is used during the icon display process.
 */
import java.awt.image.BufferedImage;
/**
 * Imports Java IO File that is used to import the file that is used in the Icon.
 */
import java.io.File;
/**
 * Imports Java IO IOException to catch any errors that occur during the image fetching process.
 */
import java.io.IOException;
/**
 * Imports Java Calendar Utility that is used to get the time for the greeting message.
 */
import java.util.Calendar;
/**
 * Imports Java Swing JLabel which is used to display text or images within the frame.
 */
import javax.swing.JLabel;
/**
 * Imports Java Swing JOptionPane which allows for pop up like boxes to be used for input or output.
 */
import javax.swing.JOptionPane;
/**
 * Imports Java Swing Border MatteBorder which allows for Borders to be Matte in appearance.
 */
import javax.swing.border.MatteBorder;
/**
 * Imports Java AWT Color that is used to encapsulate colours.
 */
import java.awt.Color;
/**
 * Imports Java AWT Event Mouse adapter that is used to create listeners for when a mouse button is pressed.
 */
import java.awt.event.MouseAdapter;
/**
 * Imports Java AWT Event MouseEvent that is used in conjunction with Mouse Adapter.
 */
import java.awt.event.MouseEvent;
/**
 * Imports Java AWT Event WindowAdapter which is used in the confirm close message.
 */
import java.awt.event.WindowAdapter;
/**
 * Imports Java AWT Event WindowEvent that is used in the window closing process.
 */
import java.awt.event.WindowEvent;
/**
 * Imports Java AWT Event Action Listener that is used to listen for events within the frame.
 */
import java.awt.event.ActionListener;
/**
 * Imports Java AWT Event ActionEvent that is used by buttons.
 */
import java.awt.event.ActionEvent;

/**
 * 
 * MenuScreen Class that extends from the JFrame super class.
 *
 */
public class MenuScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param coachObj holds the coachObj that has been passed by the controller.
	 * @param control holds the an instance of the controller.
	 */
	public MenuScreen(Coach coachObj, Controller control) {
		/**
		 * Declares and Initialises the currentUser to the coachObj that has been passed in by the controller.
		 */
		Coach currentUser = coachObj;
		/**
		 * Declares and Initialises the simplyRugbyController that has been passed in by the controller.
		 */
		Controller simplyRugbyController = control;
		/**
		 * Sets the Title of the JFrame
		 */
		setTitle("Simply Rugby");
		/**
		 * Sets the Jframe to not be resizeable.
		 */
		setResizable(false);
		/**
		 * Sets the bounds of the JFrame to start the application centered in the middle of a 1080p screen and to the correct size of the application.
		 */
		setBounds(660, 340, 600, 400);
		/**
		 * Sets the new ContentPane to a new JPanel instance.
		 */
		contentPane = new JPanel();
		/**
		 * Sets the border of the Content pane to an empty border.
		 */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		/**
		 * Sets the layout of the content pane to null.
		 */
		contentPane.setLayout(null);
		/**
		 * Sets the content pane to the contentPane that the settings changed for.
		 */
		setContentPane(contentPane);
		/**
		 * Window listener that is used to display a confirmation message to the user when they attempt to close out of the page.
		 */
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit to login?", "Logout?",
			        JOptionPane.YES_NO_OPTION);

			    /**
			     * Check for if the user clicked the confirm button
			     * If they clicked the confirm button the user will be navigated the the Menu and the current page will be disposed of.
			     * Otherwise nothing will happen.
			     */
			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.displayLogin();
			    dispose();
			      
			    } else 
			    {
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		/**
		 * Declares and Initialises the menuBtnLogout button. 
		 * This button contains an action listener that waits for the user to click on the button, upon click of the button the user will be logged out of the system. 
		 */
		JButton menuBtnLogout = new JButton("Logout");
		menuBtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayLogin();
			}
		});
		menuBtnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnLogout.setBounds(460, 11, 124, 31);
		contentPane.add(menuBtnLogout);
		
		/**
		 * menuLblHeader is the label that is at the head of the view.
		 * It is used to display a greeting message to the Coach upon them opening the menu.
		 * A Calendar is used in this process to get the current time of the system.
		 */
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		
		String timeFrame = null;

		if(timeOfDay >= 0 && timeOfDay < 12){
			timeFrame = "Morning";
		         
		}else if(timeOfDay >= 12 && timeOfDay < 16){
			timeFrame = "Afternoon";
		
		}else if(timeOfDay >= 16 && timeOfDay < 24){
			timeFrame = "Evening";
		} else
		{
			timeFrame = "Day";
		}
		JLabel menuLblHeader = new JLabel("Good " + timeFrame + " Coach " + currentUser.getLastName());
		menuLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuLblHeader.setBounds(16, 8, 316, 31);
		contentPane.add(menuLblHeader);
		
		/**
		 * menuLblMenuHeader is the label that is at the head of the menu.
		 * It is used to display a secondary heading within the rectangle that contains the main part of the view.
		 */
		JLabel menuLblMenuHeader = new JLabel("Menu");
		menuLblMenuHeader.setFont(new Font("Tahoma", Font.PLAIN, 24));
		menuLblMenuHeader.setBounds(269, 97, 58, 32);
		contentPane.add(menuLblMenuHeader);
		
		/**
		 * menuMyProfileLabelIcon is the label that displays an image to the user.
		 * This image is a black icon that is often referred to in design as a user.
		 * This label features a Mouse Listener that wait for the user to click on it, once a user has clicked the image, the coaches profile page will be opened and the menu
		 * will be disposed of.
		 * The image is displayed by using the BufferedImage import as well as the ImageIO import to read the PNG file in from the Images Folder. 
		 * This is all done within a try catch that is in place to capture IO Exception Errors.
		 */
		JLabel menuMyProfileLabelIcon = new JLabel("");
		menuMyProfileLabelIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				simplyRugbyController.displayProfile(currentUser);
			}
		});
		menuMyProfileLabelIcon.setBounds(398, 2, 36, 36);
		BufferedImage userIMG = null;
		try {
			userIMG = ImageIO.read(new File(
				    "src/images/user.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Once the data has been loaded into the loginImg variable, it's redefined as an ImageIcon variable called userIcon.
		 * The Icon is then set as the value of the label 
		 * and added to the content Pane.
		 */
		ImageIcon userIcon = new ImageIcon(userIMG);
		menuMyProfileLabelIcon.setIcon(userIcon);
		contentPane.add(menuMyProfileLabelIcon);

		/**
		 * menuLblMyProfileText is the label that accompanies the icon declared above.
		 * This label holds the text "My Profile" and contains a mouseAdapter that is used to perform the same action as the icon above.
		 * Upon clicking of the label, the menu will be disposed of and the profile view will be displayed to the user.
		 */
		JLabel menuLblMyProfileText = new JLabel("My Profile");
		menuLblMyProfileText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				simplyRugbyController.displayProfile(currentUser);
			}
		});
		
		menuLblMyProfileText.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		menuLblMyProfileText.setBounds(392, 40, 51, 13);
		contentPane.add(menuLblMyProfileText);
		
		/**
		 * Declares and Initialises the menuBtnViewSquad button with the text "View Squad".
		 * This button is responsible for displaying the View Squad screen, however before the view is called. Validation takes place to make sure that a coach has a squad
		 * bound to their account.
		 * If the current user's coachesSquadID value is empty then an error message will be displayed to them.
		 * However, if they do have a value in the coachesSquadID the menu will be disposed of and the view will ask the controller to display the squad view page.
		 */
		JButton menuBtnViewSquad = new JButton("View Squad");
		menuBtnViewSquad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (currentUser.getCoachesSquadID().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Oh no! You don't have a squad linked to your account, please talk to administrator to resolve this issue.", "Alert!", JOptionPane.ERROR_MESSAGE);
				} else
				{
					dispose();
					simplyRugbyController.displaySquadView(currentUser);
				}
			}
		});
		menuBtnViewSquad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		menuBtnViewSquad.setBounds(77, 136, 137, 38);
		contentPane.add(menuBtnViewSquad);
		
		/**
		 * Declares and Initialises a new JPanel outlineRectangle that is used as an outline for the main content of the view.
		 */
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(16, 53, 568, 299);
		contentPane.add(outlineRectangle);
			
	}
}
