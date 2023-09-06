package simplyRugby;

/**
 * <H1> Class - Member</H1>
 * This class is responsible for holding information that is important to members. 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 * 
 */

/**
 * Imports the Java Date Utility that is used to store the members date of birth within the class.
 */
import java.util.Date;

/**
 * 
 * Member class that is used as a blueprint for creating and storing information about Members within the club.
 * This class is a super class that is used to create different types of users within the club, such as players and coaches.
 * Implements Java.IO.Serializable to allow for data saving to local files.
 * 
 */

public class Member implements java.io.Serializable{
	/**
	 * Initialises and Sets the VersionID for serialisation, This ensures that when Data is saved, it's saved in the same way.
	 */
	private static final long serialVersionUID = 541583651513199852L;
	/**
	 * Declares memberID variable that is used as an identifier for the member.
	 */
	private String memberID;
	/**
	 * Declares firstName variable that is used to store the members first name. 
	 */
	private String firstName;
	/**
	 * Declares middleNames variable that is used to store the members middle names. 
	 */
	private String middleNames;
	/**
	 * Declares lastName variable that is used to store the members last name.
	 */
	private String lastName;
	/**
	 * Declares email variable that is used to store the members email.
	 */
	private String email;
	/**
	 * Declares phoneNo variable that is used to store the members phone number.
	 */
	private String phoneNo;
	/**
	 * Declares address1 variable that is used to store the first line of the members address.
	 */
	private String address1;
	/**
	 * Declares address2 variable that is used to store the second line of the member address.
	 */
	private String address2;
	/**
	 * Declares city variable that is used to store the name of the city the member lives in.
	 */
	private String city;
	/**
	 * Declares postcode variable that is used to store the postcode of the member.
	 */
	private String postcode;
	/**
	 * Declares DOB variable that is used to store the date of birth of the member.
	 */
	private Date DOB;
	
	/**
	 * Constructors
	 * Constructor for the Member super class.
	 * 1st Constructor sets all variables within the Constructor to their default values.
	 * 2nd Constructor sets all variables within the Constructor to the values passed in via arguments.
	 */
	
	/**
	 * Constructor sets all variables within the Constructor to their default values.
	 */
	
	public Member()
	{
		//Sets the value of memberID to null.
		memberID = null;
		//Sets the value of firstName to null.
		firstName = null;
		//Sets the value of middleNames to null.
		middleNames = null;
		//Sets the value of lastName to null.
		lastName = null;
		//Sets the value of email to null.
		email = null;
		//Sets the value of phoneNo to null.
		phoneNo = null;
		//Sets the value of address1 to null.
		address1 = null;
		//Sets the value of address2 to null.
		address2 = null;
		//Sets the value of city to null.
		city = null;
		//Sets the value of postcode to null.
		postcode = null;
		//Sets the value of DOB to null.
		DOB = (null);
	}
	
	/**
	 * 
	 * @param memberID passed in value that holds the members Member identification number.
	 * @param firstName passed in value that holds the first name of the member.
	 * @param middleNames passed in value that holds the middle names of the member.
	 * @param lastName passed in value that holds the last name of the member.
	 * @param email passed in value that holds the email of the member.
	 * @param phoneNo passed in value that holds the phone number of the member.
	 * @param address1 passed in value that holds the 1st line of the members address.
	 * @param address2 passed in value that holds the 2nd line of the members address.
	 * @param city passed in value that holds the city that the member lives in.
	 * @param postcode passed in value that holds the members postcode.
	 * @param DOB passed in value that holds the members date of birth.
	 */
	
	public Member(String memberID, String firstName, String middleNames, String lastName, String email, String phoneNo, String address1,
			String address2, String city, String postcode, Date DOB)
	{
		/**
		 * Sets the memberID variable within the Class to the value in the passed in parameter.
		 */
		this.memberID = memberID;
		/**
		 * Sets the firstName variable within the Class to the value in the passed in parameter.
		 */
		this.firstName = firstName;
		/**
		 * Sets the middleNames variable within the Class to the value in the passed in parameter.
		 */
		this.middleNames = middleNames;
		/**
		 * Sets the lastName variable within the Class to the value in the passed in parameter.
		 */
		this.lastName = lastName;
		/**
		 * Sets the email variable within the Class to the value in the passed in parameter.
		 */
		this.email = email;
		/**
		 * Sets the phoneNo variable within the Class to the value in the passed in parameter.
		 */
		this.phoneNo = phoneNo;
		/**
		 * Sets the address1 variable within the Class to the value in the passed in parameter.
		 */
		this.address1 = address1;
		/**
		 * Sets the address2 variable within the Class to the value in the passed in parameter.
		 */
		this.address2 = address2;
		/**
		 * Sets the city variable within the Class to the value in the passed in parameter.
		 */
		this.city = city;
		/**
		 * Sets the postcode variable within the Class to the value in the passed in parameter.
		 */
		this.postcode = postcode;
		/**
		 * Sets the DOB variable within the Class to the value in the passed in parameter.
		 */
		this.DOB = DOB;
	}
	
	/**
	 * Gets the current memberID and returns it.
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * Gets the memberID parameter passed in and sets it to this instances memberID.
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	/**
	 * Gets the current firstName and returns it.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Gets the firstName parameter passed in and sets it to this instances first name.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the current middleNames variable and returns it.
	 * @return the middleNames
	 */
	public String getMiddleNames() {
		return middleNames;
	}
	/**
	 * Gets the middleNames parameter passed in and sets it to this instances middle names.
	 * @param middleNames the middleNames to set
	 */
	public void setMiddleNames(String middleNames) {
		this.middleNames = middleNames;
	}
	/**
	 * Gets the current lastName variable and returns it.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Gets the lastName parameter passed in and sets it to this instances last name.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Gets the current email variable and returns it.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Gets the email parameter passed in and sets it to this instances email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Gets the current phoneNo variable and returns it.
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * Gets the phoneNo parameter passed in and sets it to this instances phoneNo.
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * Gets the current address1 variable and returns it.
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * Gets the address1 parameter passed in and sets it to this instances address line 1.
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * Gets the current address2 variable and returns it.
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * Gets the address2 parameter passed in and sets it to this instances address line 2.
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * Gets the current city variable and returns it.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Gets the city parameter passed in and sets it to this instances city.
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Gets the current postcode variable and returns it.
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * Gets the postcode parameter passed in and sets it to this instances postcode.
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Gets the current DOB variable and returns it.
	 * @return the DOB
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * Gets the DOB parameter passed in and sets it to this instances DOB.
	 * @param dOB the DOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	
}
