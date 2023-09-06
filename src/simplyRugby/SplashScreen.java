package simplyRugby;

/**
 * <H1> View - Splash Screen</H1>
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
 * Imports Java Swing JProgressBar to display loading progress.
 */
import javax.swing.JProgressBar;
/**
 * Imports Java Swing JLabel which is used to display text or images within the frame.
 */
import javax.swing.JLabel;
/**
 * Imports Java AWT Font which allows the rendering of fonts within the frame.
 */
import java.awt.Font;

/**
 * 
 * SplashScreen Class that extends from the JFrame super class.
 *
 */
public class SplashScreen extends JFrame {

	/**
	 * Declares the JPanel ContentPane
	 */
	private JPanel contentPane;
	/**
	 * Declares splashProgressBar as a protected static JProgressBar. This allows the controller to edit the value of it.
	 */
	protected static JProgressBar splashProgressBar;

	/**
	 * Create the frame.
	 * 
	 */
	public SplashScreen() {
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
		 * sets spashProgressBar to a new progress bar instance.
		 */
		splashProgressBar = new JProgressBar();
		splashProgressBar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		splashProgressBar.setToolTipText("");
		splashProgressBar.setBounds(50, 320, 500, 40);
		contentPane.add(splashProgressBar);
		
		/**
		 * Declares and Initialises the splashLblPleaseWait label and sets the text to "Please Wait"
		 */
		JLabel splashLblPleaseWait = new JLabel("Please Wait");
		splashLblPleaseWait.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		splashLblPleaseWait.setBounds(220, 269, 159, 40);
		contentPane.add(splashLblPleaseWait);
		
		/**
		 * Declares and Initialises the splashLblNowLoading label and sets the text to "Now Loading"
		 */
		JLabel splashLblNowLoading = new JLabel("Now Loading");
		splashLblNowLoading.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		splashLblNowLoading.setBounds(206, 218, 174, 40);
		contentPane.add(splashLblNowLoading);
		
		/**
		 * Declares and Initialises the splashLblSimplyRugby label and sets the text to "Simply Rugby"
		 */
		JLabel splashLblSimplyRugby = new JLabel("Simply Rugby");
		splashLblSimplyRugby.setFont(new Font("Times New Roman", Font.PLAIN, 72));
		splashLblSimplyRugby.setBounds(90, 11, 412, 78);
		contentPane.add(splashLblSimplyRugby);
	}
}
