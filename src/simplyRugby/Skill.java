package simplyRugby;
/**
 * <H1> Class - Skill</H1>
 * <p>
 * This class is to be used as a blueprint for creating skills that will be used as
 * a part of the skill tracking system for Simply Rugby. 
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 */

/**
 * Skill class that is used as a blueprint for creating and storing skills of players within the club.
 * Implements Java.IO.Serializable to allow for data saving to local files.
 */
public class Skill implements java.io.Serializable{
	/**
	 * Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	 */
	private static final long serialVersionUID = 541583651513199852L;
	/**
	 * Declares the skillName variable for use within the skill tracking part of the system.
	 */
	private String skillName;
	/**
	 * Declares the rating variable for use within the skill tracking part of the system.
	 */
	private int rating;
	
	/**
	 * Constructors
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	public Skill()
	{
		/**
		 * Sets the value of skillName to null.
		 */
		skillName = null;
		/**
		 * Sets the value of rating to 0 (null).
		 */
		rating = 0;
	}
	
	/**
	 * Constructor sets all variables within the Constructor to the values passed in via arguments.
	 * @param skillName passed in value that holds the name of the skill to be created.
	 * @param rating passed in value that holds the rating number of the players skill.
	 */
	public Skill(String skillName, int rating)
	{
		/**
		 * Sets the skillName variable within the Class to the value in the passed in parameter.
		 */
		this.skillName = skillName;
		/**
		 * Sets the rating variable within the Class to the value in the passed in parameter.
		 */
		this.rating = rating;
	}
	
	/**
	 * Gets the current skillName and returns it.
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * Gets the skillName parameter passed in and sets it to this instances skillName.
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	/**
	 * Gets the current rating and returns it.
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Gets the rating parameter passed in and sets it to this instances rating.
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}