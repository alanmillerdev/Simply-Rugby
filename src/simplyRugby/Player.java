package simplyRugby;


/**
 * <H1> Class - Player</H1>
 * This class is to be used as a blueprint for creating player members. 
 * The class extends from the Member super class that allows it to store specific 
 * information connected to the player.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 * 
 */

/**
 * Imports the Java ArrayList utility that is used to store the list of the players Skill Categories in the class.
 */
import java.util.ArrayList;
import java.util.Date;

/**
 * Player class that is used as a blueprint for creating and storing information about Players within the club.
 * Extends from the Member Super Class.
 */
public class Player extends Member{
	/**
	 * Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	 */
	private static final long serialVersionUID = 541583651513199852L;
	/**
	 * Declares scrumsID variable that is used to store the players scrums identification number.
	 */
	private String scrumsID;
	/**
	 * Declares position variable that is used to store the position that the player plays in. 
	 */
	private String position;
	/**
	 * Declares emergencyContactName variable that is used to store the name of the emergency contact. 
	 */
	private String emergencyContactName;
	/**
	 * Declares emergencyContactNo variable that is used to store the contact number of the emergency contact. 
	 */
	private String emergencyContactNo;
	/**
	 * Declares playerSkills variable that is used to store a list of skill categories. 
	 */
	private ArrayList<SkillCategory> playerSkills;
	
	/**
	 * Constructors
	 * Constructor for the Player child class of super class Member.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	public Player()
	{
		/**
		 * Sets the value of scrumsID to null.
		 */
		scrumsID = null;
		/**
		 * Sets the value of position to null.
		 */
		position = null;
		/**
		 * Sets the value of emergencyContactName to null.
		 */
		emergencyContactName = null;
		/**
		 * Sets the value of emergencyContactNo to null.
		 */
		emergencyContactNo = null;
		/**
		 * Sets the value of playerSkills to null.
		 */
		playerSkills = null;
	}
	
	/**
	 * Constructor sets all variables within the Constructor to the values passed in via arguments.
	 * @param memberID passed in value that holds the players Member identification number.
	 * @param firstName passed in value that holds the first name of the player.
	 * @param middleNames passed in value that holds the middle names of the player.
	 * @param lastName passed in value that holds the last name of the player.
	 * @param email passed in value that holds the email of the player.
	 * @param phoneNo passed in value that holds the phone number of the player.
	 * @param address1 passed in value that holds the 1st line of the players address.
	 * @param address2 passed in value that holds the 2nd line of the players address.
	 * @param city passed in value that holds the city that the player lives in.
	 * @param postcode passed in value that holds the users postcode.
	 * @param DOB passed in value that holds the users date of birth.
	 * @param scrumsID passed in value that holds the users scrumsID.
	 * @param position passed in value that holds the position of the player.
	 * @param emergencyContactName passed in value that holds the emergency contact name of the person of the players choice. 
	 * @param emergencyContactNo passed in value that holds the emergency contact number of the person of the players choice.
	 * @param playerSkills passed in value that holds a list of all of the players skill categories. 
	 */
	public Player(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB, String scrumsID, String position, String emergencyContactName,
			String emergencyContactNo, ArrayList<SkillCategory> playerSkills)
	{
		/**
		 * The Super keyword is used to access the data of the parent class, in this case, Member. These values are also passed in as Parameters, then set.
		 */
		super(memberID, firstName, middleNames, lastName, email, phoneNo, address1, address2, city, postcode, DOB);
		/**
		 * Sets the scrumsID variable within the Class to the value in the passed in parameter.
		 */
		this.scrumsID = scrumsID;
		/**
		 * Sets the position variable within the Class to the value in the passed in parameter.
		 */
		this.position = position;
		/**
		 * Sets the emergencyContactName variable within the Class to the value in the passed in parameter.
		 */
		this.emergencyContactName = emergencyContactName;
		/**
		 * Sets the emergencyContactNo variable within the Class to the value in the passed in parameter.
		 */
		this.emergencyContactNo = emergencyContactNo;
		/**
		 * Sets the playerSkills variable within the Class to the value in the passed in parameter.
		 */
		this.playerSkills = playerSkills;
	}
	
	/**
	 * Gets the current scrumsID and returns it.
	 * @return the scrumsID
	 */
	public String getScrumsID() {
		return scrumsID;
	}
	/**
	 * Gets the scrumsID parameter passed in and sets it to this instances scrumsID.
	 * @param scrumsID the scrumsID to set
	 */
	public void setScrumsID(String scrumsID) {
		this.scrumsID = scrumsID;
	}
	/**
	 * gets the current position and returns it.
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * Gets the position parameter passed in and sets it to this instances position.
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * gets the current Emergency contact name and returns it.
	 * @return the emergencyContactName
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/**
	 * Gets the emergencyContactName parameter passed in and sets it to this instances Emergency contact name.
	 * @param emergencyContactName the emergencyContactName to set
	 */
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	/**
	 * gets the current Emergency contact number and returns it.
	 * @return the emergencyContactNo
	 */
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}
	/**
	 * Gets the Emergency contact number parameter passed in and sets it to this instances Emergency contact name.
	 * @param emergencyContactNo the emergencyContactNo to set
	 */
	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}
	/**
	 * gets the current player skills list and returns it.
	 * @return the playerSkills
	 */
	public ArrayList<SkillCategory> getPlayerSkills() {
		return playerSkills;
	}
	/**
	 * Gets the playerSkills parameter passed in and sets it to this instances Player Skills List.
	 * @param playerSkills the playerSkills to set
	 */
	public void setPlayerSkills(ArrayList<SkillCategory> playerSkills) {
		this.playerSkills = playerSkills;
	}

}