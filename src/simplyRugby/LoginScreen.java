package simplyRugby;

/**
 * <H1> View - Login Screen</H1>
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
 * Imports Java Swing JLabel which is used to display text or images within the frame.
 */
import javax.swing.JLabel;
/**
 * Imports Java Swing JOptionPane which allows for pop up like boxes to be used for input or output.
 */
import javax.swing.JOptionPane;
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
 * Imports Java Swing JPasswordField which allows for hidden inputs of passwords on the profile page.
 */
import javax.swing.JPasswordField;
/**
 * Imports Java Swing JTextField which allows for inputs of text via input boxes.
 */
import javax.swing.JTextField;
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
 * LoginScreen Class that extends from the JFrame super class.
 *
 */
public class LoginScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	/**
	 * Declares the loginPasswordField JPasswordField
	 */
	private JPasswordField loginPasswordField;
	/**
	 * Declares the loginTextFieldUsername JPasswordField
	 */
	private JTextField loginTextFieldUsername; 

	/**
	 * Create the Frame.
	 * @param control holds the an instance of the controller.
	 */
	public LoginScreen(Controller control) {
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
		 * Sets the close operation to exit on close.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		 * Declares and Initialises the new loginBtnLogin button that displays the value "Login".
		 * This button contains an action listener that activate upon click of the button.
		 * Upon click of the button, input validation is performed to make sure that the user has entered values into each input. These being the 
		 * loginTextFieldUsername and loginPasswordField inputs. This is done by using the getText method on the fields, trimming that value which will remove any spaces.
		 * The final check is made by the isEmpty method that returns a boolean value that states weather the input is empty or not.
		 * If either of the inputs are empty, an error message is displayed to the user asking them to try again.
		 * If the inputs both contain a value, they are passed to the controller for handling.
		 * The result of this handling by the controller is stored in the result variable and is used to display an error message or close the view upon result return.
		 * If the result returns as True, the page is disposed of, however if the result returns as False, an error message is displayed to the user, informing them that they have entered the wrong credentials.
		 * 
		 */
		JButton loginBtnLogin = new JButton("Login");
		loginBtnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (loginTextFieldUsername.getText().trim().isEmpty() || loginPasswordField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "Oh No! Please enter your login credientials before pressing the login button. Try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
				} else
				{
					boolean result = simplyRugbyController.authenticateUser(loginTextFieldUsername.getText(), loginPasswordField.getText());
					
					if(result)
					{
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(contentPane, "Oh no! It appears that this user does not exist or you have entered your credientials wrong, please try again.", "Alert!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		loginBtnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtnLogin.setBounds(399, 301, 137, 38);
		contentPane.add(loginBtnLogin);
		
		/**
		 * sets loginPasswordField to a new JPasswordField instance.
		 */
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(344, 238, 240, 38);
		contentPane.add(loginPasswordField);
		
		/**
		 * sets loginTextFieldUsername to a new JTextField instance.
		 */
		loginTextFieldUsername = new JTextField();
		loginTextFieldUsername.setBounds(344, 173, 240, 38);
		contentPane.add(loginTextFieldUsername);
		loginTextFieldUsername.setColumns(10);
		
		/**
		 * Declares and Initialises the loginLblUsername label that is used as a header for the username input.
		 */
		JLabel loginLblUsername = new JLabel("Username:");
		loginLblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblUsername.setBounds(344, 158, 77, 14);
		contentPane.add(loginLblUsername);
		
		/**
		 * Declares and Initialises the loginLblPassword label that is used as a header for the password input.
		 */
		JLabel loginLblPassword = new JLabel("Password:");
		loginLblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblPassword.setBounds(344, 222, 77, 14);
		contentPane.add(loginLblPassword);
		
		/**
		 * Declares and Initialises the loginLblInstruction label that is used to hold some of the instructions that are apart of the login view.
		 */
		JLabel loginLblInstruction = new JLabel("Please enter your");
		loginLblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblInstruction.setBounds(399, 76, 126, 50);
		contentPane.add(loginLblInstruction);
		
		/**
		 * Declares and Initialises the loginLblInstruction2 label that is used to hold some of the instructions that are apart of the login view.
		 */
		JLabel loginLblInstruction2 = new JLabel("credentials below!");
		loginLblInstruction2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginLblInstruction2.setBounds(399, 101, 126, 50);
		contentPane.add(loginLblInstruction2);
		
		/**
		 * Declares and Initialises the loginLblHeader label that is used as a header for the login page.
		 */
		JLabel loginLblHeader = new JLabel("Simply Rugby");
		loginLblHeader.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loginLblHeader.setBounds(364, 35, 200, 50);
		contentPane.add(loginLblHeader);
		
		/**
		 * Declares and Initialises the loginScreenLblImageLabel label that is used to display the a image on the side of the login page.
		 * The first step in this process is Declaring and Initialising the loginImg variable and setting it to null.
		 * Then a try a catch will attempt to load the image into the system and store it in the loginImg variable using the Image.IO import.
		 * Upon successful loading of the image, the image will be converted into a new ImageIcon and set to the loginScreenLblImageLabel variable.
		 */
		JLabel loginScreenLblImageLabel = new JLabel();
		loginScreenLblImageLabel.setBounds(10, 11, 324, 349);
		BufferedImage loginImg = null;
		try {
			loginImg = ImageIO.read(new File(
				    "src/images/loginPageImg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon loginIcon = new ImageIcon(loginImg);
		loginScreenLblImageLabel.setIcon(loginIcon);
		contentPane.add(loginScreenLblImageLabel);
		
	}
}
