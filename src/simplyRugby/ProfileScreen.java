package simplyRugby;

/**
 * <H1> View - Profile Screen</H1>
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
 * Imports Java Swing JPasswordField which allows for hidden inputs of passwords on the profile page.
 */
import javax.swing.JPasswordField;
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
 * ProfileScreen Class that extends from the JFrame super class.
 *
 */
public class ProfileScreen extends JFrame {
	
	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	/**
	 * Declares the profilePasswordInputConfirm JPasswordField
	 */
	private JPasswordField profilePasswordInputConfirm;
	/**
	 * Declares the profilePasswordInputNew JPasswordField
	 */
	private JPasswordField profilePasswordInputNew;
	/**
	 * Declares the profilePasswordInputCurrent JPasswordField
	 */
	private JPasswordField profilePasswordInputCurrent;

	/**
	 * Create the frame.
	 * @param coachObj holds the coachObj that has been passed by the controller.
	 * @param control holds the an instance of the controller.
	 */
	public ProfileScreen(Coach coachObj, Controller control) {
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
			        "Are you sure you want to exit to the main menu", "Return to Menu?",
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
		 * Declares and Initialises the viewPlayerBtnReturn button. 
		 * This button contains an action listener that waits for the user to click on the button, upon click of the button the user will be redirected to the menu. 
		 */
		JButton profileBtnReturn = new JButton("Return to Menu");
		profileBtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				simplyRugbyController.displayMenu(coachObj);
			}
		});
		profileBtnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		profileBtnReturn.setBounds(450, 11, 124, 31);
		contentPane.add(profileBtnReturn);
		
		/**
		 * Declares and Initialises profileLblHeader that is used to display the header for the profile screen.
		 */
		JLabel profileLblHeader = new JLabel(currentUser.getFirstName() + "'s Profile");
		profileLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profileLblHeader.setBounds(6, 11, 430, 31);
		contentPane.add(profileLblHeader);
		
		/**
		 * Declares and Initialises lblMyProfile that is used as a secondary header.
		 */
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMyProfile.setBounds(256, 81, 105, 31);
		contentPane.add(lblMyProfile);
		
		/**
		 * Declares and Initialises profileLblMemberToolTip that is used as a header for the memberID display.
		 */
		JLabel profileLblMemberToolTip = new JLabel("My Member ID:");
		profileLblMemberToolTip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblMemberToolTip.setBounds(30, 113, 124, 22);
		contentPane.add(profileLblMemberToolTip);
		
		/**
		 * Declares and Initialises profileLblSquadIDToolTip that is used as a header for the squadID display.
		 */
		JLabel profileLblSquadIDToolTip = new JLabel("My Squad ID:");
		profileLblSquadIDToolTip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblSquadIDToolTip.setBounds(30, 163, 109, 22);
		contentPane.add(profileLblSquadIDToolTip);
		
		/**
		 * Declares and Initialises profileLblMemberID that is used to display the memberID.
		 */
		JLabel profileLblMemberID = new JLabel(currentUser.getMemberID());
		profileLblMemberID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profileLblMemberID.setBounds(53, 137, 90, 24);
		contentPane.add(profileLblMemberID);
		
		/**
		 * Declares and Initialises profileLblMemberID that is used to display the squadID.
		 */
		JLabel profileLblSquadID = new JLabel(currentUser.getCoachesSquadID());
		profileLblSquadID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		profileLblSquadID.setBounds(53, 185, 77, 24);
		contentPane.add(profileLblSquadID);
		
		/**
		 * Declares and Initialises profileLblChangePassword that is used to display the header for the change password function.
		 */
		JLabel profileLblChangePassword = new JLabel("Change Password:");
		profileLblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profileLblChangePassword.setBounds(348, 113, 155, 22);
		contentPane.add(profileLblChangePassword);
		
		/**
		 * sets profilePasswordInputConfirm to a JPasswordField instance.
		 */
		profilePasswordInputConfirm = new JPasswordField();
		profilePasswordInputConfirm.setBounds(348, 267, 202, 34);
		contentPane.add(profilePasswordInputConfirm);
		
		/**
		 * sets profilePasswordInputNew to a JPasswordField instance.
		 */
		profilePasswordInputNew = new JPasswordField();
		profilePasswordInputNew.setBounds(348, 213, 202, 34);
		contentPane.add(profilePasswordInputNew);
		
		/**
		 * sets profilePasswordInputCurrent to a JPasswordField instance.
		 */
		profilePasswordInputCurrent = new JPasswordField();
		profilePasswordInputCurrent.setBounds(348, 159, 202, 34);
		contentPane.add(profilePasswordInputCurrent);
		
		/**
		 * Declares and Initialises profileLblCurrentTooltip that is used as a header for the Current Password input.
		 */
		JLabel profileLblCurrentTooltip = new JLabel("Current Password:");
		profileLblCurrentTooltip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblCurrentTooltip.setBounds(348, 143, 105, 14);
		contentPane.add(profileLblCurrentTooltip);
		
		/**
		 * Declares and Initialises profileLblNewPassword that is used as a header for the New Password input.
		 */
		JLabel profileLblNewPassword = new JLabel("New Password:");
		profileLblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblNewPassword.setBounds(348, 196, 105, 14);
		contentPane.add(profileLblNewPassword);
		
		/**
		 * Declares and Initialises profileLblConfirmPassword that is used as a header for the Confirm Password input.
		 */
		JLabel profileLblConfirmPassword = new JLabel("Confirm Password:");
		profileLblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileLblConfirmPassword.setBounds(348, 253, 105, 14);
		contentPane.add(profileLblConfirmPassword);
		
		/**
		 * Declares and Initialises btnChangePassword as a new JButton that contains the value "Change Password"
		 */
		JButton btnChangePassword = new JButton("Change Password");
		/**
		 * btnChangePassword has an action listener that is waiting for the user to click the change password button, upon them clicking the button a few things will happen.
		 * The first action that occurs is that all of the inputs are checked for null or empty values, if any are found a error message is displayed to the user.
		 * Secondly, the view will check if the two new password inputs match, if they don't an error message will be displayed to the user.
		 * If the all of the inputs contain a value and the matching check passes the values are passed to the controller.
		 * Once the controller has done it's part of the process, it will return a true or false value in the form of a boolean, this boolean is stored in the result variable.
		 * If the variable is True, a success message will be displayed to the user, if the Variable is false, an error message will be displayed to the user.
		 */
		btnChangePassword.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (profilePasswordInputConfirm.getText().trim().isEmpty() || profilePasswordInputNew.getText().trim().isEmpty() || profilePasswordInputCurrent.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Oh No! It appears you have missed an input, please try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
				} else if (profilePasswordInputNew.getText().equals(profilePasswordInputConfirm.getText()))
				{
					
					boolean result = control.changePassword(profilePasswordInputCurrent.getText(), profilePasswordInputNew.getText(), currentUser);
					
					if(result)
					{
						JOptionPane.showMessageDialog(contentPane, "Yay! Your new password has been saved!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(contentPane, "Oh no! You have entered your current password incorrectly. Please try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
					}
					
				} else
				{
					JOptionPane.showMessageDialog(contentPane, "Oh No! Your new passwords don't match. Make sure that you input your new password \n into both the New Password and Confirm Password inputs correctly. Please Try Again.", "Alert!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangePassword.setBounds(348, 306, 202, 31);
		contentPane.add(btnChangePassword);
		
		/**
		 * Declares and Initialises a new JPanel outlineRectangle that is used as an outline for the main content of the view.
		 */
		JPanel outlineRectangle = new JPanel();
		outlineRectangle.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		outlineRectangle.setBounds(6, 53, 568, 299);
		contentPane.add(outlineRectangle);
	}
}