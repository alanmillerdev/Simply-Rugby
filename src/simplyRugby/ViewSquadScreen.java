package simplyRugby;

/**
 * <H1> View - View Squad Screen</H1>
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
 * Imports the Java Swing JScrollPane that is used a container for the table, this allows the table to be scrollable. 
 */
import javax.swing.JScrollPane;
/**
 * Imports Java Swing Border Empty Border to allow for transparent borders.
 */
import javax.swing.border.EmptyBorder;
/**
 * Imports Java Swing JButton that allows buttons to be placed within the frame that allow actions to be preformed.
 */
import javax.swing.JButton;
/**
 * Imports Java AWT Font which allows the rendering of fonts within the frame.
 */
import java.awt.Font;
/**
 * Imports Java Swing JLabel which is used to display text or images within the frame.
 */
import javax.swing.JLabel;
/**
 * Imports Java Swing JOptionPane which allows for pop up like boxes to be used for input.
 */
import javax.swing.JOptionPane;
/**
 * Imports Java Swing JTable which allows for data to be displayed using columns and rows.
 */
import javax.swing.JTable;
/**
 * Imports Java Swing Table DefaultTableModel which allows for dynamically generating tables.
 */
import javax.swing.table.DefaultTableModel;
/**
 * Imports Java Swing Border MatteBorder which allows for Borders to be Matte in appearance.
 */
import javax.swing.border.MatteBorder;
/**
 * Imports Java AWT Color that is used to encapsulate colours.
 */
import java.awt.Color;
/**
 * Imports Java AWT Event Action Listener that is used to listen for events within the frame.
 */
import java.awt.event.ActionListener;
/**
 * Imports Java AWT Event Window Adapter that is used to receive events within the frame
 */
import java.awt.event.WindowAdapter;
/**
 * Imports Java AWT Event WindowEvent that is used in the window closing process.
 */
import java.awt.event.WindowEvent;
/**
 * Imports Java AWT Event ActionEvent that is used by buttons.
 */
import java.awt.event.ActionEvent;

/**
 * 
 * ViewSquadScreen Class that extends from the JFrame super class.
 *
 */
public class ViewSquadScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	/**
	 * Declares the viewSquadTablePlayerData JTable
	 */
	private JTable viewSquadTablePlayerData;

	/**
	 * Create the frame.
	 * @param squadObj holds the squadObj that has been passed by the controller. 
	 * @param coachObj holds the coachObj that has been passed by the controller.
	 * @param control holds the an instance of the controller.
	 */
	public ViewSquadScreen(Coach coachObj, Squad squadObj, Controller control) {
		/**
		 * Declares and Initialises the currentUser to the coachObj that has been passed in by the controller.
		 */
		Coach currentUser = coachObj;
		/**
		 * Declares and Initialises the currentSquad to the squadObj that has been passed in by the controller.
		 */
		Squad currentSquad = squadObj;
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
			        "Are you sure you want to exit to the main menu?", "Return to Menu?",
			        JOptionPane.YES_NO_OPTION);
			    
			    /**
			     * Check for if the user clicked the confirm button
			     * If they clicked the confirm button the user will be navigated the the Menu and the current page will be disposed of.
			     * Otherwise nothing will happen.
			     */
			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.displayMenu(currentUser);
			    dispose();
			      
			    } else 
			    {
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		/**
		 * Declares and Initialises the viewSquadBtnReturn button. 
		 * This button contains an action listener that waits for the user to click on the button, upon click of the button the user will be redirected to the menu. 
		 */
		JButton viewSquadBtnReturn = new JButton("Return to Menu");
		viewSquadBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		viewSquadBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewSquadBtnReturn.setBounds(460, 11, 124, 31);
		contentPane.add(viewSquadBtnReturn);
		
		/**
		 * Declares and initialises the lblsquadNameAt label.
		 * This label is used to display information connected to the squad, such as the name of the squad and the age range that they play at.
		 */
		JLabel lblsquadNameAt = new JLabel(currentSquad.getName() + " at " + currentSquad.getAgeRange() + " Information");
		lblsquadNameAt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblsquadNameAt.setBounds(10, 11, 440, 31);
		contentPane.add(lblsquadNameAt);
		
		/**
		 * Declares and initialises a new JScroll pane.
		 * This will be used to hold the table once it has been built.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 93, 528, 202);
		contentPane.add(scrollPane);
		
		/**
		 * Declares and initialises a new Default Table Model known as model.
		 * This will be used to populate the data for a table.
		 */
		DefaultTableModel model = new DefaultTableModel();

		/**
		 * Model is set to the value of the response of a method within the controller.
		 * In this case the method will generate a model and return it to the view for it to display.
		 */
		model = simplyRugbyController.displaySquadPlayers(currentSquad);
		
		/**
		 * Creates a new JTable a passes it the model, this will display the model data that was just built by the controller within the scroll pane.
		 */
		viewSquadTablePlayerData = new JTable(model);

		scrollPane.setViewportView(viewSquadTablePlayerData);
		
		/**
		 * Declares and Initialises the viewSquadBtnViewSelectedPlayer button.
		 * This button is used to get data from the table and pass it to the controller. This will allow the controller to open the new View Player Screen.
		 * The data that is read from the view is the PlayerID. To read this value, the location of it needs to be found by getting the column that it is in
		 * as well as the row it is in, this data is found by setting the column to a static value that we know will contain the information that is required.
		 * However for the row, the information will be obtained by using the getSelectedRow method which will read the index value of the row and store it within the row variable.
		 * These two variables are then used in conjunction to get the playerID that has been selected from the table. This is done by using the getValueAt method from the model.
		 * Using this method allows the PlayerID to be set and send to the controller for handling.
		 */
		JButton viewSquadBtnViewSelectedPlayer = new JButton("View Selected Player");
		viewSquadBtnViewSelectedPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * Try catch to catch ArrayIndexOutOfBoundsException that comes from the user clicking the button before selecting a value from the table.
				 */
				try {
					
					int column = 0;
					
					int row = viewSquadTablePlayerData.getSelectedRow();
					
					String playerID = viewSquadTablePlayerData.getModel().getValueAt(row, column).toString();
						
					simplyRugbyController.displayViewPlayer(currentUser, playerID);
					
					dispose();
					
				} catch (ArrayIndexOutOfBoundsException oobEx)
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a player to view. \n Please select a player from the table and try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		viewSquadBtnViewSelectedPlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		viewSquadBtnViewSelectedPlayer.setBounds(210, 306, 183, 36);
		contentPane.add(viewSquadBtnViewSelectedPlayer);
		
		/**
		 * Declares and Initialises a new JPanel outlineRectangle that is used as an outline for the main content of the view.
		 */
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(28, 53, 543, 303);
		contentPane.add(outlineRectangle);
	}
}
