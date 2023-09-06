package simplyRugby;

/**
 * <H1> Class - Skill Category</H1>
 * This class is to be used as a blueprint for creating skill categories that will be used as part of the system
 * the class contains a list of Skills that are specific to their category that can be defined using this class.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 *
 */

/**
 * Imports ArrayList utility for storing data as an array list.
 */
import java.util.ArrayList;

/**
 * 
 * SkillCategory class that is used as a blueprint for creating and storing skill categories of players within the club.
 * Implements Java.IO.Serializable to allow for data saving to local files.
 *
 */

public class SkillCategory implements java.io.Serializable{
	/**
	 * Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	 */
	private static final long serialVersionUID = 541583651513199852L;
	/**
	 * Declares categoryName variable that is used to store information about the name of the category.
	 */
	private String categoryName;
	/**
	 * Declares categoryNotes variable that is used to store information within the category.
	 */
	private String categoryNotes;
	/**
	 * Declares the categorySkillList variable that is used to store a list of the skills in the category.
	 */
	private ArrayList<Skill> categorySkillList;
	
	/**
	 * Constructors
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	public SkillCategory()
	{
		/**
		 * Sets the value of categoryName to null.
		 */
		categoryName = null;
		/**
		 * Sets the value of categoryNotes to null.
		 */
		categoryNotes = null;
		/**
		 * Sets the value of categorySkillList to null.
		 */
		categorySkillList = null;
	}
	
	/**
	 * Constructor sets all variables within the Constructor to the values passed in via arguments.
	 * @param categoryName holds the value of the CategoryName that is to be created.
	 * @param categoryNotes holds the value of the note that is to be saved within the category.
	 * @param categorySkillList holds the value of individual skills within the category.
	 */
	public SkillCategory(String categoryName, String categoryNotes, ArrayList<Skill> categorySkillList)
	{
		/**
		 * Sets the categoryName variable within the Class to the value in the passed in parameter.
		 */
		this.categoryName = categoryName;
		/**
		 * Sets the categoryNotes variable within the Class to the value in the passed in parameter.
		 */
		this.categoryNotes = categoryNotes;
		/**
		 * Sets the categorySkillList variable within the Class to the value in the passed in parameter.
		 */
		this.categorySkillList = categorySkillList;
	}
	
	/**
	 * Gets the current categoryName and returns it.
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * Gets the categoryName parameter passed in and sets it to this instances Category Name.
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * Gets the current categoryNotes and returns it.
	 * @return the categoryNotes
	 */
	public String getCategoryNotes() {
		return categoryNotes;
	}
	/**
	 * Gets the categoryNotes parameter passed in and sets it to this instances categoryNotes.
	 * @param categoryNotes the categoryNotes to set
	 */
	public void setCategoryNotes(String categoryNotes) {
		this.categoryNotes = categoryNotes;
	}
	/**
	 * gets the current skill list and returns it.
	 * @return the categorySkillList
	 */
	public ArrayList<Skill> getCategorySkillList() {
		return categorySkillList;
	}
	/**
	 * Gets the categorySkillList parameter passed in and sets it to this instances Category Skill List.
	 * @param categorySkillList the categorySkillList to set
	 */
	public void setCategorySkillList(ArrayList<Skill> categorySkillList) {
		this.categorySkillList = categorySkillList;
	}
	
}