package simplyRugby;

/**
 * <H1> Class - Coach</H1>
 * 
 * This class is to be used as a blueprint for creating coach members. 
 * The class extends from the Member super class that allows it to store specific 
 * information connected to the coach.
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 *
 */

/**
 * 
 * Imports the Java Date Utility that is used to store the members date of birth within the class.
 * 
 */
import java.util.Date;

/**
 * <p>
 * Coach class that is used as a blueprint for creating and storing information about Coaches within the club.
 * This class extends from the Member class.
 */
public class Coach extends Member{
	
	/**
	 * Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	 */
	private static final long serialVersionUID = 541583651513199852L;
	/**
	 * Declares the username String that is used to store the coaches username used in the login process.
	 */
	private String username;
	/**
	 * Declares the password String that is used to store the coaches password that is used in the login process.
	 */
	private String password;
	/**
	 * Declares the coachesSquadID String that is used to store the ID of the Squad that is coached by them. 
	 */
	private String coachesSquadID;
	
	/**
	 * Constructors
	 * Constructor for the Coach child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	public Coach()
	{
		//Sets the value of username to null.
		username = null;
		//Sets the value of password to null.
		password = null;
		//Sets the value of coachesSquadID to null.
		coachesSquadID = null;
		
	}
	
	/**
	 * 
	 * Constructor sets all variables within the Constructor to the values passed in via arguments.
	 * 
	 * @param memberID passed in value that holds the coaches Member identification number.
	 * @param firstName passed in value that holds the first name of the coach.
	 * @param middleNames passed in value that holds the middle names of the coach.
	 * @param lastName passed in value that holds the last name of the coach.
	 * @param email passed in value that holds the email of the coach.
	 * @param phoneNo passed in value that holds the phone number of the coach.
	 * @param address1 passed in value that holds the 1st line of the coaches address.
	 * @param address2 passed in value that holds the 2nd line of the coaches address.
	 * @param city passed in value that holds the city that the coach lives in.
	 * @param postcode passed in value that holds the coaches postcode.
	 * @param DOB passed in value that holds the coaches date of birth.
	 * @param username passed in value that holds the coaches username.
	 * @param password passed in value that holds the coaches password.
	 * @param coachesSquadID passed in the value that holds the coaches coachesSquadID.
	 */
	public Coach(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB, String username, String password, String coachesSquadID)
	{
		/**
		 * The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		 */
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode, DOB);
		/**
		 * Sets the username variable within the Class to the value in the passed in parameter.
		 */
		this.username = username;
		/**
		 * Sets the password variable within the Class to the value in the passed in parameter.
		 */
		this.password = password;
		/**
		 * Sets the coachesSquadID variable within the Class to the value in the passed in parameter.
		 */
		this.coachesSquadID = coachesSquadID;
	}
	
	/**
	 * Gets the current username and returns it.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Gets the username parameter passed in and sets it to this instances username.
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Gets the current password and returns it.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Gets the password parameter passed in and sets it to this instances password.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Gets the current username and returns it.
	 * @return the coachesSquadID
	 */
	public String getCoachesSquadID() {
		return coachesSquadID;
	}
	/**
	 * Gets the coachesSquadID parameter passed in and sets it to this instances coachesSquadID.
	 * @param coachesSquadID the coachesSquadID to set
	 */
	public void setCoachesSquadID(String coachesSquadID) {
		this.coachesSquadID = coachesSquadID;
	}
	
}