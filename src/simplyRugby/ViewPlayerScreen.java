package simplyRugby;

/**
 * <H1> View - View Player Screen</H1>
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
 * Imports the Java Swing JScrollPane that is used a container for the table, this allows the table to be scrollable. 
 */
import javax.swing.JScrollPane;
/**
 * Imports Java Swing JTable which allows for data to be displayed using columns and rows.
 */
import javax.swing.JTable;
/**
 * Imports Java Swing JTextArea that is used to display the notes of categories.
 */
import javax.swing.JTextArea;
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
 * ViewPlayerScreen Class that extends from the JFrame super class.
 *
 */
public class ViewPlayerScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	/**
	 * Declares the viewPlayerTableDisplaySkills JTable
	 */
	private JTable viewPlayerTableDisplaySkills;
	
	/**
	 * Create the frame.
	 * @param coachObj holds the coachObj that has been passed by the controller. 
	 * @param playerObj holds the playerObj that has been passed by the controller.
	 * @param control holds the an instance of the controller.
	 */
	public ViewPlayerScreen(Coach coachObj, Player playerObj, Controller control) {
		/**
		 * Declares and Initialises the currentUser to the coachObj that has been passed in by the controller.
		 */
		Coach currentUser = coachObj;
		/**
		 * Declares and Initialises the currentSquad to the squadObj that has been passed in by the controller.
		 */
		Player currentPlayer = playerObj;
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
		 * Declares and Initialises a new JScrollPane and stores it in the scrollPane variable.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 113, 300, 235);
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
		model = simplyRugbyController.displayPlayerSkills(currentPlayer);
		
		/**
		 * Creates a new JTable a passes it the model, this will display the model data that was just built by the controller this within the scroll pane.
		 */
		viewPlayerTableDisplaySkills = new JTable(model);
		
		scrollPane.setViewportView(viewPlayerTableDisplaySkills);
		
		/**
		 * Declares and Initialises the viewPlayerBtnViewNotes button that will display a popup box to the coach that contains the value of the note.
		 */
		JButton viewPlayerBtnViewNotes = new JButton("View Notes on Selected Category");
		viewPlayerBtnViewNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					/**
					 * Declares and Initialises the column variable that is used to store the index of the column that information is to be read from.
					 */
					int column = 0;
					
					/**
					 * Declares and Initialises the row variable that is used to store the value of the selected row.
					 */
					int row = viewPlayerTableDisplaySkills.getSelectedRow();
					
					/**
					 * Declares and initialises categoryName as the value found in the selected row and column.
					 */
					String categoryName = viewPlayerTableDisplaySkills.getModel().getValueAt(row, column).toString();
					
					/**
					 * Declares and initialises msgContainer as the value returned from the method in the controller called getSkillCategoryNote.
					 * This method is used to return the value of the skill category note.
					 */
					String msgContainer = simplyRugbyController.getSkillCategoryNote(currentPlayer, categoryName);
					
					/**
					 * Declares and initialises the msg JTextArea. This variable stores a JTextArea that contains the value obtained from the controller.
					 */
					JTextArea msg = new JTextArea(msgContainer);
					msg.setLineWrap(true);
					msg.setWrapStyleWord(true);
					msg.setEditable(false);
					/**
					 * Declares and Initialises the MsgScrollPane that is used to display the category note in a scrollable text araa.
					 */
					JScrollPane MsgScrollPane = new JScrollPane(msg);
					JOptionPane.showMessageDialog(null, MsgScrollPane);
				} catch (ArrayIndexOutOfBoundsException oobEx)
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a category to view the note of. \n Please select a category from the table and try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		viewPlayerBtnViewNotes.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnViewNotes.setBounds(294, 66, 214, 36);
		contentPane.add(viewPlayerBtnViewNotes);
		
		/**
		 * Declares and Initialises the viewPlayerLblHeader label that is used as a header.
		 */
		JLabel viewPlayerLblHeader = new JLabel("Viewing " + currentPlayer.getFirstName() + " " + currentPlayer.getLastName());
		viewPlayerLblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader.setBounds(20, 11, 356, 30);
		contentPane.add(viewPlayerLblHeader);
		
		/**
		 * Declares and Initialises the viewPlayerBtnReturn button. 
		 * This button contains an action listener that waits for the user to click on the button, upon click of the button the user will be redirected to the menu. 
		 */
		JButton viewPlayerBtnReturn = new JButton("Return to Menu");
		viewPlayerBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		viewPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewPlayerBtnReturn.setBounds(439, 14, 124, 31);
		contentPane.add(viewPlayerBtnReturn);
		
		/**
		 * Declares and Initialises the viewPlayerLblHeader2 label that is used as a secondary header.
		 */
		JLabel viewPlayerLblHeader2 = new JLabel("Player Information");
		viewPlayerLblHeader2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewPlayerLblHeader2.setBounds(26, 69, 154, 30);
		contentPane.add(viewPlayerLblHeader2);
		
		/**
		 * Declares and Initialises the viewPlayerLblPlayerIDTooltip label that is used to label the current players scrumsID.
		 */
		JLabel viewPlayerLblPlayerIDTooltip = new JLabel("Player Scrums ID:");
		viewPlayerLblPlayerIDTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblPlayerIDTooltip.setBounds(26, 113, 110, 24);
		contentPane.add(viewPlayerLblPlayerIDTooltip);
		
		/**
		 * Declares and Initialises the viewPlayerLblPositionTooltip label that is used to label the current players Position.
		 */
		JLabel viewPlayerLblPositionTooltip = new JLabel("Position:");
		viewPlayerLblPositionTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblPositionTooltip.setBounds(26, 159, 63, 24);
		contentPane.add(viewPlayerLblPositionTooltip);
		
		/**
		 * Declares and Initialises the viewPlayerLblECNameToolTip label that is used to label the current players Emergency Contact Name.
		 */
		JLabel viewPlayerLblECNameToolTip = new JLabel("Emergency Contact Name:");
		viewPlayerLblECNameToolTip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblECNameToolTip.setBounds(26, 208, 171, 24);
		contentPane.add(viewPlayerLblECNameToolTip);
		
		/**
		 * Declares and Initialises the viewPlayerLblECNumberTooltip label that is used to label the current players Emergency Contact Phone Number.
		 */
		JLabel viewPlayerLblECNumberTooltip = new JLabel("Emergency Contact Phone Number:");
		viewPlayerLblECNumberTooltip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		viewPlayerLblECNumberTooltip.setBounds(26, 258, 207, 24);
		contentPane.add(viewPlayerLblECNumberTooltip);
		
		/**
		 * Declares and Initialises the viewPlayerLblPlayerID label that is used to display the currentPlayers scrumsID.
		 */
		JLabel viewPlayerLblPlayerID = new JLabel(currentPlayer.getScrumsID());
		viewPlayerLblPlayerID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPlayerID.setBounds(26, 134, 207, 24);
		contentPane.add(viewPlayerLblPlayerID);
		
		/**
		 * Declares and Initialises the viewPlayerLblPosition label that is used to display the currentPlayers position of play.
		 */
		JLabel viewPlayerLblPosition = new JLabel(currentPlayer.getPosition());
		viewPlayerLblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblPosition.setBounds(26, 182, 215, 24);
		contentPane.add(viewPlayerLblPosition);
		
		/**
		 * Declares and Initialises the viewPlayerLblECName label that is used to display the currentPlayers emergency contact name.
		 */
		JLabel viewPlayerLblECName = new JLabel(currentPlayer.getEmergencyContactName());
		viewPlayerLblECName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECName.setBounds(26, 234, 207, 24);
		contentPane.add(viewPlayerLblECName);
		
		/**
		 * Declares and Initialises the viewPlayerLblECNumber label that is used to display the currentPlayers emergency contact number.
		 */
		JLabel viewPlayerLblECNumber = new JLabel(currentPlayer.getEmergencyContactNo());
		viewPlayerLblECNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewPlayerLblECNumber.setBounds(26, 282, 214, 24);
		contentPane.add(viewPlayerLblECNumber);
		
		/**
		 * Declares and Initialises the btnEditPlayer button.
		 * This button is used to navigate the user to the edit player screen.
		 * It passes data along with it to the method within the controller.
		 */
		JButton btnEditPlayer = new JButton("Edit Player");
		btnEditPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayEditPlayer(currentUser, currentPlayer);
			}
		});
		btnEditPlayer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnEditPlayer.setBounds(56, 317, 124, 31);
		contentPane.add(btnEditPlayer);
		
		/**
		 * Declares and Initialises a new JPanel outlineRectangle that is used as an outline for the main content of the view.
		 */
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(20, 52, 543, 303);
		contentPane.add(outlineRectangle);
	}
}
