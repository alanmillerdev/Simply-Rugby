package simplyRugby;

/**
 * <H1> Class - JuniorPlayer</H1>
 * 
 * This class is responsible for holding information that is specific to a junior player.
 * This class extends from the player class that extends from the member super class.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 * 
 */

/**
 * 
 * Imports the Java ArrayList Utility that is used to store a list of the players skill categories. 
 * Imports the Java Date Utility that is used to store the members date of birth within the class.
 * 
 */
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * JuniorPlayer class that is used as a blueprint for creating and storing information about Junior Players within the club.
 * This class extends from the Player class, that extends from the Member Super Class.
 *
 */
public class JuniorPlayer extends Player{
	
	/**
	 * Declares guardianName variable that is used to store the junior player guardians name that will be used as contact information if required.
	 */
	private String guardianName;
	/**
	 * Declares guardianPhoneNo variable that is used to store the junior player guardians name that will be used as contact information if required.
	 */
	private String guardianPhoneNo;
	
	/**
	 * Constructors
	 * Constructor for the Player child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	public JuniorPlayer()
	{
		/**
		 * Sets the value of guardianName to null.
		 */
		guardianName = null;
		/**
		 * Sets the value of guardianPhoneNo to null.
		 */
		guardianPhoneNo = null;
	}
	
	/**
	 * 
	 * Constructor sets all variables within the Constructor to the values passed in via arguments.
	 * 
	 * @param memberID passed in value that holds the junior players Member identification number.
	 * @param firstName passed in value that holds the first name of the junior player.
	 * @param middleNames passed in value that holds the middle names of the junior player.
	 * @param lastName passed in value that holds the last name of the junior player.
	 * @param email passed in value that holds the email of the junior player.
	 * @param phoneNo passed in value that holds the phone number of the junior player.
	 * @param address1 passed in value that holds the 1st line of the junior players address.
	 * @param address2 passed in value that holds the 2nd line of the junior players address.
	 * @param city passed in value that holds the city that the junior player lives in.
	 * @param postcode passed in value that holds the junior players postcode.
	 * @param DOB passed in value that holds the junior players date of birth.
	 * @param scrumsID passed in value that holds the junior players scrumsID.
	 * @param position passed in value that holds the position of the junior players.
	 * @param emergencyContactName passed in value that holds the emergency contact name of the person of the junior players choice. 
	 * @param emergencyContactNo passed in value that holds the emergency contact number of the person of the junior players choice.
	 * @param playerSkills passed in value that holds a list of all of the players skill categories. 
	 * @param guardianName passed in value that holds the name of the junior players guardian.
	 * @param guardianPhoneNo passed in value that holds the phone number of the junior players guardian.
	 */
	
	public JuniorPlayer(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB, String scrumsID, String position, String emergencyContactName,
			String emergencyContactNo, ArrayList<SkillCategory> playerSkills, String guardianName, String guardianPhoneNo)
	{
		/**
		 * The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		 */
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode, DOB, scrumsID, position, emergencyContactName, emergencyContactNo, playerSkills);
		/**
		 * Sets the guardianName variable within the Class to the value in the passed in parameter.
		 */
		this.guardianName = guardianName;
		/**
		 * Sets the guardianPhoneNo variable within the Class to the value in the passed in parameter.
		 */
		this.guardianPhoneNo = guardianPhoneNo;
	}
	
	/**
	 * Gets the current guardianName and returns it.
	 * @return the guardianName
	 */
	public String getGuardianName() {
		return guardianName;
	}
	/**
	 * Gets the guardianName parameter passed in and sets it to this instances guardianName.
	 * @param guardianName the guardianName to set
	 */
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	/**
	 * Gets the current guardianPhoneNo and returns it.
	 * @return the guardianPhoneNo
	 */
	public String getGuardianPhoneNo() {
		return guardianPhoneNo;
	}
	/**
	 * Gets the guardianPhoneNo parameter passed in and sets it to this instances guardianPhoneNo.
	 * @param guardianPhoneNo the guardianPhoneNo to set
	 */
	public void setGuardianPhoneNo(String guardianPhoneNo) {
		this.guardianPhoneNo = guardianPhoneNo;
	}
	
}