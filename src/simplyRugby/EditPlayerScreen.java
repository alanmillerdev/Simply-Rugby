package simplyRugby;

/**
 * <H1> View - Edit Player Screen</H1>
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
 * Imports Java Swing DefaultComboBoxModel that will be used in the add skill process to allow for skill category selection.
 */
import javax.swing.DefaultComboBoxModel;
/**
 * Imports Java Swing JButton that allows buttons to be placed within the frame that allow actions to be performed.
 */
import javax.swing.JButton;
/**
 * Imports Java AWT Font which allows the rendering of fonts within the frame.
 */
import java.awt.Font;
/**
 * Imports the Java ArrayList utility that is used in the population process of combo boxes.
 */
import java.util.ArrayList;
/**
 * Imports Java Swing JLabel which is used to display text or images within the frame.
 */
import javax.swing.JLabel;
/**
 * Imports Java Swing JOptionPane which allows for pop up like boxes to be used for input or output.
 */
import javax.swing.JOptionPane;
/**
 * Imports the Java Swing JScrollPane that is used a container for the table, this allows the table to be scrollable. 
 */
import javax.swing.JScrollPane;
/**
 * Imports Java Swing JTable which allows for data to be displayed using columns and rows.
 */
import javax.swing.JTable;
/**
 * Imports Java Swing JTextArea that is used to display and allow the editing of skill category notes.
 */
import javax.swing.JTextArea;
/**
 * Imports Java Swing Table DefaultTableModel which allows for dynamically generating tables.
 */
import javax.swing.table.DefaultTableModel;
/**
 * Imports Java Swing JComboBox that allows for the construction of combo boxes.
 */
import javax.swing.JComboBox;
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
 * EditPlayerScreen Class that extends from the JFrame super class.
 *
 */
public class EditPlayerScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	
	/**
	 * Declares the editPlayerTableSkillData JTable
	 */
	private JTable editPlayerTableSkillData;

	/**
	 * Create the frame.
	 * @param coachObj holds the coachObj that has been passed by the controller. 
	 * @param playerObj holds the playerObj that has been passed by the controller.
	 * @param control holds the an instance of the controller.
	 */
	public EditPlayerScreen(Coach coachObj, Player playerObj, Controller control) {
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
			        "Are you sure you want to exit to the main menu? \n Your changes will be saved.", "Return to Menu?",
			        JOptionPane.YES_NO_OPTION);

			    /**
			     * Check for if the user clicked the confirm button
			     * If they clicked the confirm button the user will be navigated the the Menu and the current page will be disposed of.
			     * Otherwise nothing will happen.
			     */
			    if (confirmed == JOptionPane.YES_OPTION) {
			    simplyRugbyController.requestSave();
			    simplyRugbyController.displayMenu(currentUser);
			    dispose();
			      
			    } else 
			    { 
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
			  }
			});
		
		/**
		 * Declares and Initialises the editPlayerBtnReturn button. 
		 * This button contains an action listener that waits for the user to click on the button, upon click of the button the user will be redirected to the menu. 
		 */
		JButton editPlayerBtnReturn = new JButton("Return to Menu");
		editPlayerBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(currentUser);
			}
		});
		editPlayerBtnReturn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		editPlayerBtnReturn.setBounds(457, 20, 124, 31);
		contentPane.add(editPlayerBtnReturn);
		
		/**
		 * Declares and Initialises the EditPlayerLblHeader. This Label is used as a header that will tell the coach what player they are editing.
		 */
		JLabel EditPlayerLblHeader = new JLabel("Editing " + currentPlayer.getFirstName() + " " + currentPlayer.getLastName());
		EditPlayerLblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		EditPlayerLblHeader.setBounds(16, 20, 360, 30);
		contentPane.add(EditPlayerLblHeader);
		
		/**
		 * Declares and Initialises a new JScrollPane and stores it in the scrollPane variable.
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 75, 360, 271);
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
		editPlayerTableSkillData = new JTable(model);
		
		scrollPane.setViewportView(editPlayerTableSkillData);
		
		/**
		 * Declares and Initialises the editPlayerLblPlayerPositionTooltip variable, that is used as a header for the editPlayerComboBoxPlayerPosition JComboBox.
		 */
		JLabel editPlayerLblPlayerPositionTooltip = new JLabel("Player Position:");
		editPlayerLblPlayerPositionTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		editPlayerLblPlayerPositionTooltip.setBounds(28, 75, 82, 20);
		contentPane.add(editPlayerLblPlayerPositionTooltip);
	
		/**
		 * Declares and Initialises editPlayerComboBoxPlayerPosition JComboBox, this combo box will be set dynamically using a Switch Statement to the position the player plays.
		 * This is done by first pre populating the JComboBox with the string values of all of the Positions.
		 * Then, using a switch statement, the currentPlayer position is obtained and then then index of the comboBox is set to that value.
		 */
		JComboBox editPlayerComboBoxPlayerPosition = new JComboBox();
		editPlayerComboBoxPlayerPosition.setModel(new DefaultComboBoxModel(new String[] {"Loose Head Prop", "Hooker", "Tight Head Prop", "Left Lock", "Right Lock",
				"Blind Side Flanker", "Open Side Flanker", "Number 8", "Scrum Half", "Stand Off", "Left Wing", "Inside Centre", "Outside Centre", "Right Wing", "Full Back"}));
		switch(currentPlayer.getPosition()) {
		  case "Loose Head Prop":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(0);
		    break;
		  case "Hooker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(1);
		    break;
		  case "Tight Head Prop":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(2);
		    break;
		  case "Left Lock":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(3);
		    break;
		  case "Right Lock":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(4);
		    break;
		  case "Blind Side Flanker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(5);
		    break;
		  case "Open Side Flanker":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(6);
		    break;
		  case "Number 8":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(7);
		    break;
		  case "Scrum Half":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(8);
		    break;
		  case "Stand Off":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(9);
		    break;
		  case "Left Wing":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(10);
		    break;
		  case "Inside Centre":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(11);
		    break;
		  case "Outside Centre":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(12);
		    break;
		  case "Right Wing":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(13);
		    break;
		  case "Full Back":
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(14);
		    break;
		  default:
			  editPlayerComboBoxPlayerPosition.setSelectedIndex(-1);
		}
		editPlayerComboBoxPlayerPosition.setBounds(28, 98, 176, 34);
		contentPane.add(editPlayerComboBoxPlayerPosition);
		
		/**
		 * Declares and Initialises the editPlayerBtnAddCategory button that is populated with the value "Add Category".
		 * This button is responsible for the adding of new skill categories. 
		 * The first action taken place by the button upon event start is that a popup JFrame is created that will be used for receiving input from the user.
		 * The retVal variable is then Declared and Initialised and set to False. This will be used later on in the event for displaying either a success message or error message.
		 * Next, the string variable categoryName is declared and initialised as the input of a JOptionPane. 
		 * The input is then checked to make sure that it contains a value, this is done by trimming the category name and checking it to make sure it's not empty.
		 * If the input is empty, an error message will be displayed to the user, other wise, the user is prompted for another input, 
		 * this input being the CategoryNote string variable, just as before, the categoryNote variable is declared and initialised as the result of a JOptionPane input.
		 * This input doesn't need to be checked for empty values as the system is designed to allow for empty values here.
		 * The next step is setting retVal to be the result of the addSkillCategory method from the controller, this method is called from the view and is passed the 
		 * data inputed by the user as well as the currentPlayer Object.
		 * If the Controller manages to add the skill category to the player, the user will be displayed with a success message on retVal return.
		 * otherwise, an error message will be displayed to the user informing them that the skill category already exists.
		 */
		JButton editPlayerBtnAddCategory = new JButton("Add Category");
		editPlayerBtnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame popup;
				
				popup = new JFrame(); 
				
				boolean retVal = false;
				
				String categoryName = JOptionPane.showInputDialog(popup, "Please enter the name of the new Skill Category.");
				
				if (categoryName.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't entered a value for the name of the skill category. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				} else
				{
					
					String categoryNote = JOptionPane.showInputDialog(popup, "Please enter a note for the new category: " + categoryName + ".\n Please note this is not required and can be updated later.");
					
					retVal = simplyRugbyController.addSkillCategory(currentPlayer, categoryName, categoryNote);
					
					if (retVal == true)
					{
						JOptionPane.showMessageDialog(contentPane, "Yay! You have created a new Category!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
					} else 
					{
						JOptionPane.showMessageDialog(contentPane, "Uh Oh! That skill category already exists! \n Please enter a unique name for the new category.", "Alert!", JOptionPane.WARNING_MESSAGE);	
					}
				}
			}
		});
		
		editPlayerBtnAddCategory.setBounds(28, 136, 176, 36);
		contentPane.add(editPlayerBtnAddCategory);
		
		/**
		 * Declares and Initialises the editPlayerBtnAddSkillToCategory button that is populated with the value "Add Skill to Category".
		 * This button is responsible for the adding of new skills to skill categories.
		 * The first action taken place by the button upon event start is that a popup JFrame is created that will be used for receiving input from the user.
		 * The retVal variable is then Declared and Initialised and set to False. This will be used later on in the event for displaying either a success message or error message.
		 * The next step performed is getting all of the players skills and storing them as part of the new ArrayList skillCategoryNames.
		 * To get this information the view calls on the controller to run the findAllPlayerSkills method within the controller and return the result.
		 * Once this result has been returned the view populates a String Array named choices to the returned value.
		 * The view then displays a input dialog pop up that allows the user to select the name of the skill category that they want to add a skill to.
		 * Upon selection and submission, a check will be performed to make sure that the inputed value is not empty.
		 * If the input is empty, an error message will be displayed to the user.
		 * Otherwise, the next input will be asked for.
		 * This being, the name of the new skill, again, the same check is performed on the input and if it passes, the next input is asked for.
		 * This input being the rating that the new skill should start with, here more input validation is performed to ensure that the user has entered a number
		 * and that the number is between 0 and 100. If the inputed value is not an expected number, an error message will be displayed to the user asking them to only enter numbers
		 * between 0 and 100. 
		 * If the input is as expected, the values will be passed to the controller and the result of the operation will be returned to retVal.
		 * Upon return, a check is performed on the retVal, if the retVal is set to true, a success message will be displayed and the view will be refreshed to display the new skill.
		 * If the retVal is set to false, an error message will be displayed informing the user that the skill already exists.
		 */
		
		JButton editPlayerBtnAddSkillToCategory = new JButton("Add Skill to Category");
		editPlayerBtnAddSkillToCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame popup;
				
				popup = new JFrame(); 
				
				boolean retVal = false;
				
				ArrayList<String> skillCategoryNames = simplyRugbyController.findAllPlayerSkills(currentPlayer);
				
				String[] choices = skillCategoryNames.toArray(new String[skillCategoryNames.size()]);
			    String categoryInput = (String) JOptionPane.showInputDialog(null, "Please choose a category to add a skill to!",
			        "Choose a Category", JOptionPane.QUESTION_MESSAGE, null,
			                                                                       
			        choices, // Array of choices
			        choices[0]); // Initial choice
			    
			    if (categoryInput.trim().isEmpty())
			    {
			    	JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a value for the name of the skill category. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    } else 
			    {
			    	String skillName = JOptionPane.showInputDialog(popup, "Please enter the name of the new Skill.");
			    	
			    	if (skillName.trim().isEmpty())
			    	{
			    		JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't inputted a value for the name of the skill. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    	} else
			    	{
			    		
			    		try {
			    			int skillRating  = Integer.parseInt(JOptionPane.showInputDialog(popup, "Please enter the rating of the new Skill. \n Numbers between 0 - 100 only"));
			    			
			    			if (skillRating < 0 || skillRating > 100)
			    			{
			    				JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you entered an unexpected number. Please input numbers between 0 - 100 only! \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    			} else 
			    			{
			    				 retVal = simplyRugbyController.addSkill(currentPlayer, categoryInput, skillName, skillRating);
			    			}
			    			
			    			}
			    			catch(NumberFormatException numError) {
			    				JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you entered an unexpected character. Please input numbers between 0 - 100 only! \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    			} catch (Exception otherError){
			    				
			    			}
			    		
			    		if (retVal == true)
			    		{
			    			simplyRugbyController.displayEditPlayer(currentUser, currentPlayer);
			    			dispose();
			    			JOptionPane.showMessageDialog(contentPane, "Yay! You have created a new Skill!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
			    		} else 
			    		{
			    			JOptionPane.showMessageDialog(contentPane, "Uh Oh! That skill already exists! \n Please enter a unique name for the new skill.", "Alert!", JOptionPane.WARNING_MESSAGE);
			    		}	
			    	}   	
			    }
			}
		});

		editPlayerBtnAddSkillToCategory.setBounds(28, 176, 176, 36);
		contentPane.add(editPlayerBtnAddSkillToCategory);
		
		/**
		 * 
		 * Declares and Initialises the editPlayerBtnAddSkillToCategory button that is populated with the value "Edit Skill Rating".
		 * This button is responsible for the allowing the coach to edit skill ratings.
		 * The first action taken place by the button upon event start is opening a try catch block, this allows for error handling with the action.
		 * 
		 * The Column and Row Variables are Declared and Initialised. 
		 * The Column variable can be hard coded as the data we are looking for will be in that column every time.
		 * The Row Variable is set by getting index of the selected row from within the table.
		 * The String skillRatingString variable is then declared and initialised to the value of the skill rating within the table.
		 * The column index is then updated and 
		 * The String skillName variable is then declared and initialised to the value of the skill name within the table.
		 * The column index is then updated and 
		 * The String skillCategoryName variable is then declared and initialised to the value of the skill category name within the table.
		 * 
		 * The action will then prompt an input from the user requesting the new value of the rating. This is input via a string and is stored in the new stringNewRatingValue variable.
		 * Any errors with getting the input will be caught as part of the try catch. The try catch is attempting to parse the stringNewRatingValue from a string to an integer, during this process multiple issues can occur
		 * so multiple catches have been added to catch potential errors, these catches have custom error messages that they will output to the user that will tell them what
		 * they have done wrong.
		 * Catches are in place for Number format Exceptions, these Exceptions occur when a character that is not a number is passed into the parse method, 
		 * NullPointerException, which is an error that occurs when an input is empty, ArrayIndexOutOfBoundsException which is used to catch errors when the user does not select a row
		 * and otherEx which is in place to catch any other errors that may occur.
		 *
		 * If the input parses successfully is will be checked to see if it is within the correct range of numbers, which is 0 - 100.
		 * If the number fits into this criteria, the boolean retVal will request the editSkillRating method to be run via the controller, the view will also
		 * pass in the information required for this method to take place.
		 * If the number does not pass validation one of the exception messages will display an error to the user.
		 * 
		 * Upon return of the retVal value a check will be started, if the retVal is returned as true, the view will be refreshed and a success message will be shown to the user.
		 * If the retVal returns as false, an error message will be displayed to the user.
		 * 
		 */
		JButton editPlayerBtnEditSkillRating = new JButton("Edit Skill Rating");
		editPlayerBtnEditSkillRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					int column = 2;
					
					int row = editPlayerTableSkillData.getSelectedRow();
					
					String skillRatingString = editPlayerTableSkillData.getModel().getValueAt(row, column).toString();
					
					column = 1;
					
					String skillName = editPlayerTableSkillData.getModel().getValueAt(row, column).toString();
					
					column = 0;
					
					String skillCategoryName = editPlayerTableSkillData.getModel().getValueAt(row, column).toString();

					JFrame popup;
					
					popup = new JFrame(); 
					
					String stringNewRatingValue = null;
					
					stringNewRatingValue = JOptionPane.showInputDialog(popup, "Please enter the new value for the " + skillName + " skill.", skillRatingString);
					
					int newRatingValue = Integer.parseInt(stringNewRatingValue);
					
					if (newRatingValue < 0 || newRatingValue > 100)
					{
						
						JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you have entered an invalid number. \n Please try again entering numbers between 0 and 100 only.", "Alert!", JOptionPane.WARNING_MESSAGE);
					
					} else
					{
						
						boolean retVal = simplyRugbyController.editSkillRating(currentPlayer, skillCategoryName , skillName , newRatingValue);
						
						if (retVal == true)
						{
							simplyRugbyController.displayEditPlayer(currentUser, currentPlayer);
			    			dispose();
			    			JOptionPane.showMessageDialog(contentPane, "Yay! You have updated the rating.", "Alert!", JOptionPane.INFORMATION_MESSAGE);
						} else
						{
							JOptionPane.showMessageDialog(contentPane, "Uh Oh! An unexpected error has occured. Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);	
						}
					}
					
				} catch (NumberFormatException numEx)
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't entered a number. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				} catch (NullPointerException nullEx)
				{
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't inputted an updated value. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				} catch (ArrayIndexOutOfBoundsException oobEx) {
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a skill rating to update. \n Please select a skill from the table and try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				} catch (Exception otherEx){
					JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears an unexpected error has occured. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		editPlayerBtnEditSkillRating.setBounds(28, 216, 176, 36);
		contentPane.add(editPlayerBtnEditSkillRating);
		
		/**
		 * Declares and Initialises the editPlayerbtnEditCategoryNote button that is populated with the value "Edit Category Note".
		 * This button is responsible for the allowing the coach to edit Skill Category notes.
		 * The first action taken place by the button upon event start is Declaring and Initialising the Column, Row and retVal Variables.
		 * The Column variable can be hard coded as the data we are looking for will be in that column every time.
		 * The Row Variable is set by getting index of the selected row from within the table.
		 * The retVal variable is to false, this will be used later to display the result of a return.
		 * 
		 * The next action is to get the required data that is needed to complete the action, this data includes the titleOfCategory String Variable,
		 * the oldNoteValue which makes use of a method that is located within the controller to get the value of the note via a returned value.
		 * Then, the newNoteValue is declared and initialised as a null string.
		 * 
		 * A JTextArea is then generated to hold the oldNoteValue, this will allow the user to read the old value before updating it.
		 * This JTextArea is declared and initialised as msg and is passed the oldNoteValue variable.
		 * 
		 * It is then displayed to the user to allow them to edit it.
		 * Once the user has submitted the updated value, the new value is stored in the newNoteValue variable that is then checked.
		 * 
		 * The newNoteValue is then checked to make sure it's not empty, by using the .trim and .isEmpty methods. 
		 * If this check does not pass, the user will be displayed an error message.
		 * If the check passes, the retVal will be set to the returned value of the method in controller called editCategoryNote.
		 * This method is used to update the category note and requires the current player information, title of the category and the new note value to be able to perform it's task.
		 * 
		 * Once the boolean of retVal has been returned, a check will be performed on the retVal to check if it returned true or false.
		 * If retVal is set to true, a success message will be displayed to the user.
		 * If retVal is set to false, a error message will be displayed to the user.
		 * 
		 * All of the functionality is held within a try catch block. This allows for catching of errors to do with the user not selecting the category they wish to edit.
		 */
		JButton editPlayerbtnEditCategoryNote = new JButton("Edit Category Note");
		editPlayerbtnEditCategoryNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					boolean retVal = false;
					
					int column = 0;
					
					int row = editPlayerTableSkillData.getSelectedRow();
					
					String titleOfCategory = editPlayerTableSkillData.getModel().getValueAt(row, column).toString();
					
					String oldNoteValue = simplyRugbyController.getSkillCategoryNote(currentPlayer, titleOfCategory);
					
					String newNoteValue = null;
					
					JTextArea msg = new JTextArea(oldNoteValue);
					msg.setLineWrap(true);
					msg.setWrapStyleWord(true);
					msg.setEditable(true);
					JScrollPane MsgScrollPane = new JScrollPane(msg);
					JOptionPane.showMessageDialog(null, MsgScrollPane);
					
					newNoteValue = msg.getText();
					
					if (newNoteValue.trim().isEmpty())
				    {
				    	JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't inputted an updated value. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				    } else 
				    {
				    	retVal = simplyRugbyController.editCategoryNote(currentPlayer, titleOfCategory, newNoteValue);
				    	
				    	if (retVal == true)
				    	{
				    		JOptionPane.showMessageDialog(contentPane, "Yay! You have updated the note value successfully.", "Alert!", JOptionPane.INFORMATION_MESSAGE);
				    	} else
				    	{
				    		JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears an error has occured. \n Please try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
				    	}
				   }
					} catch (ArrayIndexOutOfBoundsException oobEx)
					{
						JOptionPane.showMessageDialog(contentPane, "Uh Oh! It appears you haven't selected a skill category to view. \n Please select a category from the table and try again.", "Alert!", JOptionPane.WARNING_MESSAGE);
					}
			}
			});
		
		editPlayerbtnEditCategoryNote.setBounds(28, 256, 176, 36);
		contentPane.add(editPlayerbtnEditCategoryNote);
		
		/**
		 * Declares and Initialises the editPlayerBtnSaveChanges button that is populated with the value "Save Changes".
		 * This button is responsible for the saving the changes to the player. 
		 * Upon clicking of the button, the button Declares and Initialises the saveStatus boolean which holds the returned result of the requestSave method in the controller.
		 * This method will return a true or false value determined by if the save is successful or not.
		 * Upon return of the saveStatus variable, a check is made on the variable to display an error or success message.
		 * If the result returns as true, the view will display a success message to the user.
		 * If the result returns as false, the view will display a error message to the user.
		 */
		JButton editPlayerBtnSaveChanges = new JButton("Save Changes");
		editPlayerBtnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlayer.setPosition(editPlayerComboBoxPlayerPosition.getSelectedItem().toString());  
				
				boolean saveStatus = simplyRugbyController.requestSave();
				
				if (saveStatus == true)
				{
					JOptionPane.showMessageDialog(contentPane, "Changes Saved Successfully", "Save", JOptionPane.INFORMATION_MESSAGE);
				} else
				{
					JOptionPane.showMessageDialog(contentPane, "There has been an issue saving your changes, please try again.", "Save", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		editPlayerBtnSaveChanges.setBounds(44, 303, 152, 36);
		contentPane.add(editPlayerBtnSaveChanges);
		
		/**
		 * Declares and Initialises a new JPanel outlineRectangle that is used as an outline for the main content of the view.
		 */
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(16, 61, 568, 299);
		contentPane.add(outlineRectangle);
	}
}