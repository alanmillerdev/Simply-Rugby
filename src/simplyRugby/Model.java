package simplyRugby;

/**
 * <H1> Class - Model</H1>
 * This class is responsible for holding information and saving information linked to the Simply Rugby Club.
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 */

/**
 * Imports the Java IO File Input Stream that is used during the data loading process.
 */
import java.io.FileInputStream;
/**
 * Imports the Java IO File Not Found Exception that is used to catch errors during the data loading process.
 */
import java.io.FileNotFoundException;
/**
 * Imports the Java IO File Output Stream that is used during the saving process.
 */
import java.io.FileOutputStream;
/**
 * Imports the Java IO Exception handler that is used to catch errors during the loading process.
 */
import java.io.IOException;
/**
 * Imports Java IO Object Input Stream that is used during the loading process.
 */
import java.io.ObjectInputStream;
/**
 * Imports Java IO Object Output Stream that is used during the saving process.
 */
import java.io.ObjectOutputStream;
/**
 * Imports Java Text ParseException that is used to catch Parse Exceptions in the data pre population process.
 */
import java.text.ParseException;
/**
 * Imports the Java Text SimpleDataFormat which is used during the data pre population process.
 */
import java.text.SimpleDateFormat;
/**
 * Imports the Java ArrayList utility that is used to store the list of the coaches and squad in the class.
 */
import java.util.ArrayList;
/**
 * Imports the Java Date Utility that is used in data prepopulation.
 */
import java.util.Date;
/**
 * Imports all of the BCrypt functions, BCrypt is a password hashing function that will be used during the data prepopulation process. 
 */
import BCrypt.BCrypt;

/**
 * <p>
 * Model class that will be used by the controller to load and save data.
 *
 */
public class Model {

	/**
	 * Declares and Initialises the coachData array list that holds data about coaches in the system.
	 */
	private ArrayList<Coach> coachData = new ArrayList<Coach>();
	/**
	 * Declares and initalises the squadData array list that holds data about squads within the system.
	 */
	private ArrayList<Squad> squadData = new ArrayList<Squad>();
	
	/**
	 * Model Constructor that is used upon application start to load the data for the system.
	 */
	public Model()
	{
		loadData();
	}

	@SuppressWarnings("unchecked")
	protected void loadData(){
		//Opens a Try block, this allows for easy error catching
		 try {
			//Starts a new FIS(File Input Stream) for the file "SimplyRugbyData.ser".
				FileInputStream fileIn = new FileInputStream("SimplyRugbyData.ser");
				//Starts a new OIS(Object Input Stream)
				ObjectInputStream objIn = new ObjectInputStream(fileIn);
				//Reads the Data input coachData ArrayList from the file.
				setCoachData((ArrayList<Coach>)objIn.readObject());
				//Reads the Data input squadData ArrayList from the file.
				setSquadData((ArrayList<Squad>)objIn.readObject());
				//Closes the OIS(Object Input Stream)
				objIn.close();
				//Closes the FIS(File Input Stream)
				fileIn.close();
				//Catch block for if the file does not exist, if this happens Data Pre Populates.
			} catch (FileNotFoundException ioError) {
				//File not found so the Software prepopulates inital data.
				prePopulate();
			} catch (IOException e) {
				e.printStackTrace();
				//Catch Block for errors surrounding the File existing but not containing the right type of Data.
			} catch (ClassNotFoundException badClass) {
				System.out.println("Coach class or Squad Class not found in file.");
			}
	}
	
	protected void saveData()
	{
		//Opens a Try block, this allows for easy error catching
		 try {
			 //Starts a new FOS(File Output Stream) to the file "SimplyRugbyData.ser".
        	FileOutputStream fos = new FileOutputStream("SimplyRugbyData.ser");
        	//Starts a new OOS(Object Output Stream)
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	//Writes the coachData Object to the file.
        	oos.writeObject(coachData);
        	//Writes the squadData Object to the file.
        	oos.writeObject(squadData);
        	//Closes the FOS(File Output Stream) which saves the file.
        	fos.close();
        	//Catch Block for errors to do with files becoming unavailable, read/write permissions and running out of disk space.
        	}catch(IOException ioe) {
        		ioe.printStackTrace();
        	}
	}
	
	private void prePopulate()
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		/**
		 * Data Prepopulation for Coach.
		 */
		String coachPassword1 = "123";
		String coachPassword2 = "456";
		String coachPassword3 = "789";
		String passwordHashed1 = BCrypt.hashpw(coachPassword1, BCrypt.gensalt());
		String passwordHashed2 = BCrypt.hashpw(coachPassword2, BCrypt.gensalt());
		String passwordHashed3 = BCrypt.hashpw(coachPassword3, BCrypt.gensalt());
		
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		String strDate1 = "13/6/1982";
		String strDate2 = "27/3/1985";
		String strDate3 = "24/10/1978";
		
		try {
			date1 = dateFormat.parse(strDate1);
			date2 = dateFormat.parse(strDate2);
			date3 = dateFormat.parse(strDate3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		coachData.add(new Coach("6SH6A521", "Kris", "Crawford","Forbes","krisforbes@simplyrugby.com", "07751259892", "57", "Boat Lane", "Reedham", "NR13 5WE", date1, "Kris", passwordHashed1, "H26YZA99"));
		coachData.add(new Coach("4B3NR2SK", "Tristan", "McIntosh","Ritchie","tristanritchie@simplyrugby.com", "07043645025", "78", "Farburn Terrace", "Reedham", "NR13 8WZ", date2, "Tristan",passwordHashed2 , "OKYHF5GS"));
		coachData.add(new Coach("B0P2BJR6", "Angus", "MacDonald","Stevenson","angusstevenson@simplyrugby.com", "07774612118", "89", "Osborne Road", "Reedham", "NR13 4GH", date3, "Angus", passwordHashed3 , "8ABTY625"));

		/**
		 * Data prepopulation for skills
		 */

		/**
		 * Squad 1 Category Skill Lists
		 */
		ArrayList<SkillCategory> player0SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player1SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player2SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player3SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player4SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player5SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player6SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player7SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player8SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player9SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player10SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player11SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player12SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player13SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player14SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player15SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player16SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player17SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player18SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player19SkillCategoryList = new ArrayList<SkillCategory>();
		
		/**
		 * Squad 2 Category Skill Lists
		 */
		ArrayList<SkillCategory> player20SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player21SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player22SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player23SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player24SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player25SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player26SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player27SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player28SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player29SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player30SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player31SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player32SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player33SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player34SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player35SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player36SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player37SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player38SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player39SkillCategoryList = new ArrayList<SkillCategory>();
		
		/**
		 * Squad 3 Category Skill Lists
		 */
		ArrayList<SkillCategory> player40SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player41SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player42SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player43SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player44SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player45SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player46SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player47SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player48SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player49SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player50SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player51SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player52SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player53SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player54SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player55SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player56SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player57SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player58SkillCategoryList = new ArrayList<SkillCategory>();
		ArrayList<SkillCategory> player59SkillCategoryList = new ArrayList<SkillCategory>();
		
		/**
		 * Adding the Physical Skill Category for each player.
		 */
		
		/**
		 * Player 0
		 */
		ArrayList<Skill> player0PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player0MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player0AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player0DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player0KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player0ContactSkillList = new ArrayList<Skill>();
		
		Skill player0PhysicalSkill1 = new Skill("Speed", 0);
		Skill player0PhysicalSkill2 = new Skill("Strength", 0);
		Skill player0PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player0MentalSkill1 = new Skill("Decision Making", 0);
		Skill player0MentalSkill2 = new Skill("Positioning", 0);
		Skill player0MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player0AttackSkill1 = new Skill("Grip", 0);
		Skill player0AttackSkill2 = new Skill("Fending Off", 0);
		Skill player0AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player0DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player0DefenceSkill2 = new Skill("Interception", 0);
		Skill player0DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player0KickingSkill1 = new Skill("Punt", 0);
		Skill player0KickingSkill2 = new Skill("Drop", 0);
		Skill player0KickingSkill3 = new Skill("Place", 0);
		
		Skill player0ContactSkill1 = new Skill("Tackle", 0);
		Skill player0ContactSkill2 = new Skill("Scrum", 0);
		Skill player0ContactSkill3 = new Skill("Carrying", 0);
		
		player0PhysicalSkillList.add(player0PhysicalSkill1); player0PhysicalSkillList.add(player0PhysicalSkill2); player0PhysicalSkillList.add(player0PhysicalSkill3);
		player0MentalSkillList.add(player0MentalSkill1); player0MentalSkillList.add(player0MentalSkill2); player0MentalSkillList.add(player0MentalSkill3); 
		player0AttackSkillList.add(player0AttackSkill1); player0AttackSkillList.add(player0AttackSkill2); player0AttackSkillList.add(player0AttackSkill3);
		player0DefenceSkillList.add(player0DefenceSkill1); player0DefenceSkillList.add(player0DefenceSkill2); player0DefenceSkillList.add(player0DefenceSkill3);
		player0KickingSkillList.add(player0KickingSkill1); player0KickingSkillList.add(player0KickingSkill2); player0KickingSkillList.add(player0KickingSkill3);
		player0ContactSkillList.add(player0ContactSkill1); player0ContactSkillList.add(player0ContactSkill2); player0ContactSkillList.add(player0ContactSkill3);
		
		SkillCategory player0StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player0PhysicalSkillList);
		SkillCategory player0MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player0MentalSkillList);
		SkillCategory player0AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player0AttackSkillList);
		SkillCategory player0DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player0DefenceSkillList);
		SkillCategory player0KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player0KickingSkillList);
		SkillCategory player0ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player0ContactSkillList);
		
		player0SkillCategoryList.add(player0StengthSkillsList); player0SkillCategoryList.add(player0MentalSkillsList); player0SkillCategoryList.add(player0AttackSkillsList);
		player0SkillCategoryList.add(player0DefenceSkillsList); player0SkillCategoryList.add(player0KickingSkillsList); player0SkillCategoryList.add(player0ContactSkillsList);

		/**
		 * Player 1
		 */
		ArrayList<Skill> player1PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player1MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player1AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player1DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player1KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player1ContactSkillList = new ArrayList<Skill>();
		
		Skill player1PhysicalSkill1 = new Skill("Speed", 0);
		Skill player1PhysicalSkill2 = new Skill("Strength", 0);
		Skill player1PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player1MentalSkill1 = new Skill("Decision Making", 0);
		Skill player1MentalSkill2 = new Skill("Positioning", 0);
		Skill player1MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player1AttackSkill1 = new Skill("Grip", 0);
		Skill player1AttackSkill2 = new Skill("Fending Off", 0);
		Skill player1AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player1DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player1DefenceSkill2 = new Skill("Interception", 0);
		Skill player1DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player1KickingSkill1 = new Skill("Punt", 0);
		Skill player1KickingSkill2 = new Skill("Drop", 0);
		Skill player1KickingSkill3 = new Skill("Place", 0);
		
		Skill player1ContactSkill1 = new Skill("Tackle", 0);
		Skill player1ContactSkill2 = new Skill("Scrum", 0);
		Skill player1ContactSkill3 = new Skill("Carrying", 0);
		
		player1PhysicalSkillList.add(player1PhysicalSkill1); player1PhysicalSkillList.add(player1PhysicalSkill2); player1PhysicalSkillList.add(player1PhysicalSkill3);
		player1MentalSkillList.add(player1MentalSkill1); player1MentalSkillList.add(player1MentalSkill2); player1MentalSkillList.add(player1MentalSkill3); 
		player1AttackSkillList.add(player1AttackSkill1); player1AttackSkillList.add(player1AttackSkill2); player1AttackSkillList.add(player1AttackSkill3);
		player1DefenceSkillList.add(player1DefenceSkill1); player1DefenceSkillList.add(player1DefenceSkill2); player1DefenceSkillList.add(player1DefenceSkill3);
		player1KickingSkillList.add(player1KickingSkill1); player1KickingSkillList.add(player1KickingSkill2); player1KickingSkillList.add(player1KickingSkill3);
		player1ContactSkillList.add(player1ContactSkill1); player1ContactSkillList.add(player1ContactSkill2); player1ContactSkillList.add(player1ContactSkill3);
		
		SkillCategory player1StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player1PhysicalSkillList);
		SkillCategory player1MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player1MentalSkillList);
		SkillCategory player1AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player1AttackSkillList);
		SkillCategory player1DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player1DefenceSkillList);
		SkillCategory player1KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player1KickingSkillList);
		SkillCategory player1ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player1ContactSkillList);
		
		player1SkillCategoryList.add(player1StengthSkillsList); player1SkillCategoryList.add(player1MentalSkillsList); player1SkillCategoryList.add(player1AttackSkillsList);
		player1SkillCategoryList.add(player1DefenceSkillsList); player1SkillCategoryList.add(player1KickingSkillsList); player1SkillCategoryList.add(player1ContactSkillsList);
		
		/**
		 * Player 2
		 */
		ArrayList<Skill> player2PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player2MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player2AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player2DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player2KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player2ContactSkillList = new ArrayList<Skill>();
		
		Skill player2PhysicalSkill1 = new Skill("Speed", 0);
		Skill player2PhysicalSkill2 = new Skill("Strength", 0);
		Skill player2PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player2MentalSkill1 = new Skill("Decision Making", 0);
		Skill player2MentalSkill2 = new Skill("Positioning", 0);
		Skill player2MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player2AttackSkill1 = new Skill("Grip", 0);
		Skill player2AttackSkill2 = new Skill("Fending Off", 0);
		Skill player2AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player2DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player2DefenceSkill2 = new Skill("Interception", 0);
		Skill player2DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player2KickingSkill1 = new Skill("Punt", 0);
		Skill player2KickingSkill2 = new Skill("Drop", 0);
		Skill player2KickingSkill3 = new Skill("Place", 0);
		
		Skill player2ContactSkill1 = new Skill("Tackle", 0);
		Skill player2ContactSkill2 = new Skill("Scrum", 0);
		Skill player2ContactSkill3 = new Skill("Carrying", 0);
		
		player2PhysicalSkillList.add(player2PhysicalSkill1); player2PhysicalSkillList.add(player2PhysicalSkill2); player2PhysicalSkillList.add(player2PhysicalSkill3);
		player2MentalSkillList.add(player2MentalSkill1); player2MentalSkillList.add(player2MentalSkill2); player2MentalSkillList.add(player2MentalSkill3); 
		player2AttackSkillList.add(player2AttackSkill1); player2AttackSkillList.add(player2AttackSkill2); player2AttackSkillList.add(player2AttackSkill3);
		player2DefenceSkillList.add(player2DefenceSkill1); player2DefenceSkillList.add(player2DefenceSkill2); player2DefenceSkillList.add(player2DefenceSkill3);
		player2KickingSkillList.add(player2KickingSkill1); player2KickingSkillList.add(player2KickingSkill2); player2KickingSkillList.add(player2KickingSkill3);
		player2ContactSkillList.add(player2ContactSkill1); player2ContactSkillList.add(player2ContactSkill2); player2ContactSkillList.add(player2ContactSkill3);
		
		SkillCategory player2StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player2PhysicalSkillList);
		SkillCategory player2MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player2MentalSkillList);
		SkillCategory player2AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player2AttackSkillList);
		SkillCategory player2DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player2DefenceSkillList);
		SkillCategory player2KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player2KickingSkillList);
		SkillCategory player2ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player2ContactSkillList);
		
		player2SkillCategoryList.add(player2StengthSkillsList); player2SkillCategoryList.add(player2MentalSkillsList); player2SkillCategoryList.add(player2AttackSkillsList);
		player2SkillCategoryList.add(player2DefenceSkillsList); player2SkillCategoryList.add(player2KickingSkillsList); player2SkillCategoryList.add(player2ContactSkillsList);
		
		/**
		 * Player 3
		 */
		ArrayList<Skill> player3PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player3MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player3AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player3DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player3KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player3ContactSkillList = new ArrayList<Skill>();
		
		Skill player3PhysicalSkill1 = new Skill("Speed", 0);
		Skill player3PhysicalSkill2 = new Skill("Strength", 0);
		Skill player3PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player3MentalSkill1 = new Skill("Decision Making", 0);
		Skill player3MentalSkill2 = new Skill("Positioning", 0);
		Skill player3MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player3AttackSkill1 = new Skill("Grip", 0);
		Skill player3AttackSkill2 = new Skill("Fending Off", 0);
		Skill player3AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player3DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player3DefenceSkill2 = new Skill("Interception", 0);
		Skill player3DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player3KickingSkill1 = new Skill("Punt", 0);
		Skill player3KickingSkill2 = new Skill("Drop", 0);
		Skill player3KickingSkill3 = new Skill("Place", 0);
		
		Skill player3ContactSkill1 = new Skill("Tackle", 0);
		Skill player3ContactSkill2 = new Skill("Scrum", 0);
		Skill player3ContactSkill3 = new Skill("Carrying", 0);
		
		player3PhysicalSkillList.add(player3PhysicalSkill1); player3PhysicalSkillList.add(player3PhysicalSkill2); player3PhysicalSkillList.add(player3PhysicalSkill3);
		player3MentalSkillList.add(player3MentalSkill1); player3MentalSkillList.add(player3MentalSkill2); player3MentalSkillList.add(player3MentalSkill3); 
		player3AttackSkillList.add(player3AttackSkill1); player3AttackSkillList.add(player3AttackSkill2); player3AttackSkillList.add(player3AttackSkill3);
		player3DefenceSkillList.add(player3DefenceSkill1); player3DefenceSkillList.add(player3DefenceSkill2); player3DefenceSkillList.add(player3DefenceSkill3);
		player3KickingSkillList.add(player3KickingSkill1); player3KickingSkillList.add(player3KickingSkill2); player3KickingSkillList.add(player3KickingSkill3);
		player3ContactSkillList.add(player3ContactSkill1); player3ContactSkillList.add(player3ContactSkill2); player3ContactSkillList.add(player3ContactSkill3);
		
		SkillCategory player3StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player3PhysicalSkillList);
		SkillCategory player3MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player3MentalSkillList);
		SkillCategory player3AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player3AttackSkillList);
		SkillCategory player3DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player3DefenceSkillList);
		SkillCategory player3KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player3KickingSkillList);
		SkillCategory player3ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player3ContactSkillList);
		
		player3SkillCategoryList.add(player3StengthSkillsList); player3SkillCategoryList.add(player3MentalSkillsList); player3SkillCategoryList.add(player3AttackSkillsList);
		player3SkillCategoryList.add(player3DefenceSkillsList); player3SkillCategoryList.add(player3KickingSkillsList); player3SkillCategoryList.add(player3ContactSkillsList);
		
		/**
		 * Player 4
		 */
		ArrayList<Skill> player4PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player4MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player4AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player4DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player4KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player4ContactSkillList = new ArrayList<Skill>();
		
		Skill player4PhysicalSkill1 = new Skill("Speed", 0);
		Skill player4PhysicalSkill2 = new Skill("Strength", 0);
		Skill player4PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player4MentalSkill1 = new Skill("Decision Making", 0);
		Skill player4MentalSkill2 = new Skill("Positioning", 0);
		Skill player4MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player4AttackSkill1 = new Skill("Grip", 0);
		Skill player4AttackSkill2 = new Skill("Fending Off", 0);
		Skill player4AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player4DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player4DefenceSkill2 = new Skill("Interception", 0);
		Skill player4DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player4KickingSkill1 = new Skill("Punt", 0);
		Skill player4KickingSkill2 = new Skill("Drop", 0);
		Skill player4KickingSkill3 = new Skill("Place", 0);
		
		Skill player4ContactSkill1 = new Skill("Tackle", 0);
		Skill player4ContactSkill2 = new Skill("Scrum", 0);
		Skill player4ContactSkill3 = new Skill("Carrying", 0);
		
		player4PhysicalSkillList.add(player4PhysicalSkill1); player4PhysicalSkillList.add(player4PhysicalSkill2); player4PhysicalSkillList.add(player4PhysicalSkill3);
		player4MentalSkillList.add(player4MentalSkill1); player4MentalSkillList.add(player4MentalSkill2); player4MentalSkillList.add(player4MentalSkill3); 
		player4AttackSkillList.add(player4AttackSkill1); player4AttackSkillList.add(player4AttackSkill2); player4AttackSkillList.add(player4AttackSkill3);
		player4DefenceSkillList.add(player4DefenceSkill1); player4DefenceSkillList.add(player4DefenceSkill2); player4DefenceSkillList.add(player4DefenceSkill3);
		player4KickingSkillList.add(player4KickingSkill1); player4KickingSkillList.add(player4KickingSkill2); player4KickingSkillList.add(player4KickingSkill3);
		player4ContactSkillList.add(player4ContactSkill1); player4ContactSkillList.add(player4ContactSkill2); player4ContactSkillList.add(player4ContactSkill3);
		
		SkillCategory player4StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player4PhysicalSkillList);
		SkillCategory player4MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player4MentalSkillList);
		SkillCategory player4AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player4AttackSkillList);
		SkillCategory player4DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player4DefenceSkillList);
		SkillCategory player4KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player4KickingSkillList);
		SkillCategory player4ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player4ContactSkillList);
		
		player4SkillCategoryList.add(player4StengthSkillsList); player4SkillCategoryList.add(player4MentalSkillsList); player4SkillCategoryList.add(player4AttackSkillsList);
		player4SkillCategoryList.add(player4DefenceSkillsList); player4SkillCategoryList.add(player4KickingSkillsList); player4SkillCategoryList.add(player4ContactSkillsList);
		
		
		/**
		 * Player 5
		 */
		ArrayList<Skill> player5PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player5MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player5AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player5DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player5KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player5ContactSkillList = new ArrayList<Skill>();
		
		Skill player5PhysicalSkill1 = new Skill("Speed", 0);
		Skill player5PhysicalSkill2 = new Skill("Strength", 0);
		Skill player5PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player5MentalSkill1 = new Skill("Decision Making", 0);
		Skill player5MentalSkill2 = new Skill("Positioning", 0);
		Skill player5MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player5AttackSkill1 = new Skill("Grip", 0);
		Skill player5AttackSkill2 = new Skill("Fending Off", 0);
		Skill player5AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player5DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player5DefenceSkill2 = new Skill("Interception", 0);
		Skill player5DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player5KickingSkill1 = new Skill("Punt", 0);
		Skill player5KickingSkill2 = new Skill("Drop", 0);
		Skill player5KickingSkill3 = new Skill("Place", 0);
		
		Skill player5ContactSkill1 = new Skill("Tackle", 0);
		Skill player5ContactSkill2 = new Skill("Scrum", 0);
		Skill player5ContactSkill3 = new Skill("Carrying", 0);
		
		player5PhysicalSkillList.add(player5PhysicalSkill1); player5PhysicalSkillList.add(player5PhysicalSkill2); player5PhysicalSkillList.add(player5PhysicalSkill3);
		player5MentalSkillList.add(player5MentalSkill1); player5MentalSkillList.add(player5MentalSkill2); player5MentalSkillList.add(player5MentalSkill3); 
		player5AttackSkillList.add(player5AttackSkill1); player5AttackSkillList.add(player5AttackSkill2); player5AttackSkillList.add(player5AttackSkill3);
		player5DefenceSkillList.add(player5DefenceSkill1); player5DefenceSkillList.add(player5DefenceSkill2); player5DefenceSkillList.add(player5DefenceSkill3);
		player5KickingSkillList.add(player5KickingSkill1); player5KickingSkillList.add(player5KickingSkill2); player5KickingSkillList.add(player5KickingSkill3);
		player5ContactSkillList.add(player5ContactSkill1); player5ContactSkillList.add(player5ContactSkill2); player5ContactSkillList.add(player5ContactSkill3);
		
		SkillCategory player5StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player5PhysicalSkillList);
		SkillCategory player5MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player5MentalSkillList);
		SkillCategory player5AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player5AttackSkillList);
		SkillCategory player5DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player5DefenceSkillList);
		SkillCategory player5KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player5KickingSkillList);
		SkillCategory player5ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player5ContactSkillList);
		
		player5SkillCategoryList.add(player5StengthSkillsList); player5SkillCategoryList.add(player5MentalSkillsList); player5SkillCategoryList.add(player5AttackSkillsList);
		player5SkillCategoryList.add(player5DefenceSkillsList); player5SkillCategoryList.add(player5KickingSkillsList); player5SkillCategoryList.add(player5ContactSkillsList);
		
		/**
		 * Player 6
		 */
		ArrayList<Skill> player6PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player6MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player6AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player6DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player6KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player6ContactSkillList = new ArrayList<Skill>();
		
		Skill player6PhysicalSkill1 = new Skill("Speed", 0);
		Skill player6PhysicalSkill2 = new Skill("Strength", 0);
		Skill player6PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player6MentalSkill1 = new Skill("Decision Making", 0);
		Skill player6MentalSkill2 = new Skill("Positioning", 0);
		Skill player6MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player6AttackSkill1 = new Skill("Grip", 0);
		Skill player6AttackSkill2 = new Skill("Fending Off", 0);
		Skill player6AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player6DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player6DefenceSkill2 = new Skill("Interception", 0);
		Skill player6DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player6KickingSkill1 = new Skill("Punt", 0);
		Skill player6KickingSkill2 = new Skill("Drop", 0);
		Skill player6KickingSkill3 = new Skill("Place", 0);
		
		Skill player6ContactSkill1 = new Skill("Tackle", 0);
		Skill player6ContactSkill2 = new Skill("Scrum", 0);
		Skill player6ContactSkill3 = new Skill("Carrying", 0);
		
		player6PhysicalSkillList.add(player6PhysicalSkill1); player6PhysicalSkillList.add(player6PhysicalSkill2); player6PhysicalSkillList.add(player6PhysicalSkill3);
		player6MentalSkillList.add(player6MentalSkill1); player6MentalSkillList.add(player6MentalSkill2); player6MentalSkillList.add(player6MentalSkill3); 
		player6AttackSkillList.add(player6AttackSkill1); player6AttackSkillList.add(player6AttackSkill2); player6AttackSkillList.add(player6AttackSkill3);
		player6DefenceSkillList.add(player6DefenceSkill1); player6DefenceSkillList.add(player6DefenceSkill2); player6DefenceSkillList.add(player6DefenceSkill3);
		player6KickingSkillList.add(player6KickingSkill1); player6KickingSkillList.add(player6KickingSkill2); player6KickingSkillList.add(player6KickingSkill3);
		player6ContactSkillList.add(player6ContactSkill1); player6ContactSkillList.add(player6ContactSkill2); player6ContactSkillList.add(player6ContactSkill3);
		
		SkillCategory player6StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player6PhysicalSkillList);
		SkillCategory player6MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player6MentalSkillList);
		SkillCategory player6AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player6AttackSkillList);
		SkillCategory player6DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player6DefenceSkillList);
		SkillCategory player6KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player6KickingSkillList);
		SkillCategory player6ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player6ContactSkillList);
		
		player6SkillCategoryList.add(player6StengthSkillsList); player6SkillCategoryList.add(player6MentalSkillsList); player6SkillCategoryList.add(player6AttackSkillsList);
		player6SkillCategoryList.add(player6DefenceSkillsList); player6SkillCategoryList.add(player6KickingSkillsList); player6SkillCategoryList.add(player6ContactSkillsList);
		
		/**
		 * Player 7
		 */
		ArrayList<Skill> player7PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player7MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player7AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player7DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player7KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player7ContactSkillList = new ArrayList<Skill>();
		
		Skill player7PhysicalSkill1 = new Skill("Speed", 0);
		Skill player7PhysicalSkill2 = new Skill("Strength", 0);
		Skill player7PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player7MentalSkill1 = new Skill("Decision Making", 0);
		Skill player7MentalSkill2 = new Skill("Positioning", 0);
		Skill player7MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player7AttackSkill1 = new Skill("Grip", 0);
		Skill player7AttackSkill2 = new Skill("Fending Off", 0);
		Skill player7AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player7DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player7DefenceSkill2 = new Skill("Interception", 0);
		Skill player7DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player7KickingSkill1 = new Skill("Punt", 0);
		Skill player7KickingSkill2 = new Skill("Drop", 0);
		Skill player7KickingSkill3 = new Skill("Place", 0);
		
		Skill player7ContactSkill1 = new Skill("Tackle", 0);
		Skill player7ContactSkill2 = new Skill("Scrum", 0);
		Skill player7ContactSkill3 = new Skill("Carrying", 0);
		
		player7PhysicalSkillList.add(player7PhysicalSkill1); player7PhysicalSkillList.add(player7PhysicalSkill2); player7PhysicalSkillList.add(player7PhysicalSkill3);
		player7MentalSkillList.add(player7MentalSkill1); player7MentalSkillList.add(player7MentalSkill2); player7MentalSkillList.add(player7MentalSkill3); 
		player7AttackSkillList.add(player7AttackSkill1); player7AttackSkillList.add(player7AttackSkill2); player7AttackSkillList.add(player7AttackSkill3);
		player7DefenceSkillList.add(player7DefenceSkill1); player7DefenceSkillList.add(player7DefenceSkill2); player7DefenceSkillList.add(player7DefenceSkill3);
		player7KickingSkillList.add(player7KickingSkill1); player7KickingSkillList.add(player7KickingSkill2); player7KickingSkillList.add(player7KickingSkill3);
		player7ContactSkillList.add(player7ContactSkill1); player7ContactSkillList.add(player7ContactSkill2); player7ContactSkillList.add(player7ContactSkill3);
		
		SkillCategory player7StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player7PhysicalSkillList);
		SkillCategory player7MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player7MentalSkillList);
		SkillCategory player7AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player7AttackSkillList);
		SkillCategory player7DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player7DefenceSkillList);
		SkillCategory player7KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player7KickingSkillList);
		SkillCategory player7ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player7ContactSkillList);
		
		player7SkillCategoryList.add(player7StengthSkillsList); player7SkillCategoryList.add(player7MentalSkillsList); player7SkillCategoryList.add(player7AttackSkillsList);
		player7SkillCategoryList.add(player7DefenceSkillsList); player7SkillCategoryList.add(player7KickingSkillsList); player7SkillCategoryList.add(player7ContactSkillsList);
	
		/**
		 * Player 8
		 */
		ArrayList<Skill> player8PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player8MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player8AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player8DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player8KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player8ContactSkillList = new ArrayList<Skill>();
		
		Skill player8PhysicalSkill1 = new Skill("Speed", 0);
		Skill player8PhysicalSkill2 = new Skill("Strength", 0);
		Skill player8PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player8MentalSkill1 = new Skill("Decision Making", 0);
		Skill player8MentalSkill2 = new Skill("Positioning", 0);
		Skill player8MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player8AttackSkill1 = new Skill("Grip", 0);
		Skill player8AttackSkill2 = new Skill("Fending Off", 0);
		Skill player8AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player8DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player8DefenceSkill2 = new Skill("Interception", 0);
		Skill player8DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player8KickingSkill1 = new Skill("Punt", 0);
		Skill player8KickingSkill2 = new Skill("Drop", 0);
		Skill player8KickingSkill3 = new Skill("Place", 0);
		
		Skill player8ContactSkill1 = new Skill("Tackle", 0);
		Skill player8ContactSkill2 = new Skill("Scrum", 0);
		Skill player8ContactSkill3 = new Skill("Carrying", 0);
		
		player8PhysicalSkillList.add(player8PhysicalSkill1); player8PhysicalSkillList.add(player8PhysicalSkill2); player8PhysicalSkillList.add(player8PhysicalSkill3);
		player8MentalSkillList.add(player8MentalSkill1); player8MentalSkillList.add(player8MentalSkill2); player8MentalSkillList.add(player8MentalSkill3); 
		player8AttackSkillList.add(player8AttackSkill1); player8AttackSkillList.add(player8AttackSkill2); player8AttackSkillList.add(player8AttackSkill3);
		player8DefenceSkillList.add(player8DefenceSkill1); player8DefenceSkillList.add(player8DefenceSkill2); player8DefenceSkillList.add(player8DefenceSkill3);
		player8KickingSkillList.add(player8KickingSkill1); player8KickingSkillList.add(player8KickingSkill2); player8KickingSkillList.add(player8KickingSkill3);
		player8ContactSkillList.add(player8ContactSkill1); player8ContactSkillList.add(player8ContactSkill2); player8ContactSkillList.add(player8ContactSkill3);
		
		SkillCategory player8StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player8PhysicalSkillList);
		SkillCategory player8MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player8MentalSkillList);
		SkillCategory player8AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player8AttackSkillList);
		SkillCategory player8DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player8DefenceSkillList);
		SkillCategory player8KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player8KickingSkillList);
		SkillCategory player8ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player8ContactSkillList);
		
		player8SkillCategoryList.add(player8StengthSkillsList); player8SkillCategoryList.add(player8MentalSkillsList); player8SkillCategoryList.add(player8AttackSkillsList);
		player8SkillCategoryList.add(player8DefenceSkillsList); player8SkillCategoryList.add(player8KickingSkillsList); player8SkillCategoryList.add(player8ContactSkillsList);
		
		
		/**
		 * Player 9
		 */
		ArrayList<Skill> player9PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player9MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player9AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player9DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player9KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player9ContactSkillList = new ArrayList<Skill>();
		
		Skill player9PhysicalSkill1 = new Skill("Speed", 0);
		Skill player9PhysicalSkill2 = new Skill("Strength", 0);
		Skill player9PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player9MentalSkill1 = new Skill("Decision Making", 0);
		Skill player9MentalSkill2 = new Skill("Positioning", 0);
		Skill player9MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player9AttackSkill1 = new Skill("Grip", 0);
		Skill player9AttackSkill2 = new Skill("Fending Off", 0);
		Skill player9AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player9DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player9DefenceSkill2 = new Skill("Interception", 0);
		Skill player9DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player9KickingSkill1 = new Skill("Punt", 0);
		Skill player9KickingSkill2 = new Skill("Drop", 0);
		Skill player9KickingSkill3 = new Skill("Place", 0);
		
		Skill player9ContactSkill1 = new Skill("Tackle", 0);
		Skill player9ContactSkill2 = new Skill("Scrum", 0);
		Skill player9ContactSkill3 = new Skill("Carrying", 0);
		
		player9PhysicalSkillList.add(player9PhysicalSkill1); player9PhysicalSkillList.add(player9PhysicalSkill2); player9PhysicalSkillList.add(player9PhysicalSkill3);
		player9MentalSkillList.add(player9MentalSkill1); player9MentalSkillList.add(player9MentalSkill2); player9MentalSkillList.add(player9MentalSkill3); 
		player9AttackSkillList.add(player9AttackSkill1); player9AttackSkillList.add(player9AttackSkill2); player9AttackSkillList.add(player9AttackSkill3);
		player9DefenceSkillList.add(player9DefenceSkill1); player9DefenceSkillList.add(player9DefenceSkill2); player9DefenceSkillList.add(player9DefenceSkill3);
		player9KickingSkillList.add(player9KickingSkill1); player9KickingSkillList.add(player9KickingSkill2); player9KickingSkillList.add(player9KickingSkill3);
		player9ContactSkillList.add(player9ContactSkill1); player9ContactSkillList.add(player9ContactSkill2); player9ContactSkillList.add(player9ContactSkill3);
		
		SkillCategory player9StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player9PhysicalSkillList);
		SkillCategory player9MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player9MentalSkillList);
		SkillCategory player9AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player9AttackSkillList);
		SkillCategory player9DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player9DefenceSkillList);
		SkillCategory player9KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player9KickingSkillList);
		SkillCategory player9ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player9ContactSkillList);
		
		player9SkillCategoryList.add(player9StengthSkillsList); player9SkillCategoryList.add(player9MentalSkillsList); player9SkillCategoryList.add(player9AttackSkillsList);
		player9SkillCategoryList.add(player9DefenceSkillsList); player9SkillCategoryList.add(player9KickingSkillsList); player9SkillCategoryList.add(player9ContactSkillsList);
		
		/**
		 * Player 10
		 */
		ArrayList<Skill> player10PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player10MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player10AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player10DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player10KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player10ContactSkillList = new ArrayList<Skill>();
		
		Skill player10PhysicalSkill1 = new Skill("Speed", 0);
		Skill player10PhysicalSkill2 = new Skill("Strength", 0);
		Skill player10PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player10MentalSkill1 = new Skill("Decision Making", 0);
		Skill player10MentalSkill2 = new Skill("Positioning", 0);
		Skill player10MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player10AttackSkill1 = new Skill("Grip", 0);
		Skill player10AttackSkill2 = new Skill("Fending Off", 0);
		Skill player10AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player10DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player10DefenceSkill2 = new Skill("Interception", 0);
		Skill player10DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player10KickingSkill1 = new Skill("Punt", 0);
		Skill player10KickingSkill2 = new Skill("Drop", 0);
		Skill player10KickingSkill3 = new Skill("Place", 0);
		
		Skill player10ContactSkill1 = new Skill("Tackle", 0);
		Skill player10ContactSkill2 = new Skill("Scrum", 0);
		Skill player10ContactSkill3 = new Skill("Carrying", 0);
		
		player10PhysicalSkillList.add(player10PhysicalSkill1); player10PhysicalSkillList.add(player10PhysicalSkill2); player10PhysicalSkillList.add(player10PhysicalSkill3);
		player10MentalSkillList.add(player10MentalSkill1); player10MentalSkillList.add(player10MentalSkill2); player10MentalSkillList.add(player10MentalSkill3); 
		player10AttackSkillList.add(player10AttackSkill1); player10AttackSkillList.add(player10AttackSkill2); player10AttackSkillList.add(player10AttackSkill3);
		player10DefenceSkillList.add(player10DefenceSkill1); player10DefenceSkillList.add(player10DefenceSkill2); player10DefenceSkillList.add(player10DefenceSkill3);
		player10KickingSkillList.add(player10KickingSkill1); player10KickingSkillList.add(player10KickingSkill2); player10KickingSkillList.add(player10KickingSkill3);
		player10ContactSkillList.add(player10ContactSkill1); player10ContactSkillList.add(player10ContactSkill2); player10ContactSkillList.add(player10ContactSkill3);
		
		SkillCategory player10StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player10PhysicalSkillList);
		SkillCategory player10MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player10MentalSkillList);
		SkillCategory player10AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player10AttackSkillList);
		SkillCategory player10DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player10DefenceSkillList);
		SkillCategory player10KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player10KickingSkillList);
		SkillCategory player10ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player10ContactSkillList);
		
		player10SkillCategoryList.add(player10StengthSkillsList); player10SkillCategoryList.add(player10MentalSkillsList); player10SkillCategoryList.add(player10AttackSkillsList);
		player10SkillCategoryList.add(player10DefenceSkillsList); player10SkillCategoryList.add(player10KickingSkillsList); player10SkillCategoryList.add(player10ContactSkillsList);
		
		/**
		 * Player 11
		 */
		ArrayList<Skill> player11PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player11MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player11AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player11DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player11KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player11ContactSkillList = new ArrayList<Skill>();
		
		Skill player11PhysicalSkill1 = new Skill("Speed", 0);
		Skill player11PhysicalSkill2 = new Skill("Strength", 0);
		Skill player11PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player11MentalSkill1 = new Skill("Decision Making", 0);
		Skill player11MentalSkill2 = new Skill("Positioning", 0);
		Skill player11MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player11AttackSkill1 = new Skill("Grip", 0);
		Skill player11AttackSkill2 = new Skill("Fending Off", 0);
		Skill player11AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player11DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player11DefenceSkill2 = new Skill("Interception", 0);
		Skill player11DefenceSkill3 = new Skill("Protection", 0);
		
		Skill player11KickingSkill1 = new Skill("Punt", 0);
		Skill player11KickingSkill2 = new Skill("Drop", 0);
		Skill player11KickingSkill3 = new Skill("Place", 0);
		
		Skill player11ContactSkill1 = new Skill("Tackle", 0);
		Skill player11ContactSkill2 = new Skill("Scrum", 0);
		Skill player11ContactSkill3 = new Skill("Carrying", 0);
		
		player11PhysicalSkillList.add(player11PhysicalSkill1); player11PhysicalSkillList.add(player11PhysicalSkill2); player11PhysicalSkillList.add(player11PhysicalSkill3);
		player11MentalSkillList.add(player11MentalSkill1); player11MentalSkillList.add(player11MentalSkill2); player11MentalSkillList.add(player11MentalSkill3); 
		player11AttackSkillList.add(player11AttackSkill1); player11AttackSkillList.add(player11AttackSkill2); player11AttackSkillList.add(player11AttackSkill3);
		player11DefenceSkillList.add(player11DefenceSkill1); player11DefenceSkillList.add(player11DefenceSkill2); player11DefenceSkillList.add(player11DefenceSkill3);
		player11KickingSkillList.add(player11KickingSkill1); player11KickingSkillList.add(player11KickingSkill2); player11KickingSkillList.add(player11KickingSkill3);
		player11ContactSkillList.add(player11ContactSkill1); player11ContactSkillList.add(player11ContactSkill2); player11ContactSkillList.add(player11ContactSkill3);
		
		SkillCategory player11StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player11PhysicalSkillList);
		SkillCategory player11MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player11MentalSkillList);
		SkillCategory player11AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player11AttackSkillList);
		SkillCategory player11DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player11DefenceSkillList);
		SkillCategory player11KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player11KickingSkillList);
		SkillCategory player11ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player11ContactSkillList);
		
		player11SkillCategoryList.add(player11StengthSkillsList); player11SkillCategoryList.add(player11MentalSkillsList); player11SkillCategoryList.add(player11AttackSkillsList);
		player11SkillCategoryList.add(player11DefenceSkillsList); player11SkillCategoryList.add(player11KickingSkillsList); player11SkillCategoryList.add(player11ContactSkillsList);
		
		/**
		 * Player 12
		 */
		ArrayList<Skill> player12PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player12MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player12AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player12DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player12KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player12ContactSkillList = new ArrayList<Skill>();
		
		Skill player12PhysicalSkill1 = new Skill("Speed", 0);
		Skill player12PhysicalSkill2 = new Skill("Strength", 0);
		Skill player12PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player12MentalSkill1 = new Skill("Decision Making", 0);
		Skill player12MentalSkill2 = new Skill("Positioning", 0);
		Skill player12MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player12AttackSkill1 = new Skill("Grip", 0);
		Skill player12AttackSkill2 = new Skill("Fending Off", 0);
		Skill player12AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player12DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player12DefenceSkill2 = new Skill("Interception", 0);
		Skill player12DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player12KickingSkill1 = new Skill("Punt", 0);
		Skill player12KickingSkill2 = new Skill("Drop", 0);
		Skill player12KickingSkill3 = new Skill("Place", 0);
		
		Skill player12ContactSkill1 = new Skill("Tackle", 0);
		Skill player12ContactSkill2 = new Skill("Scrum", 0);
		Skill player12ContactSkill3 = new Skill("Carrying", 0);
		
		player12PhysicalSkillList.add(player12PhysicalSkill1); player12PhysicalSkillList.add(player12PhysicalSkill2); player12PhysicalSkillList.add(player12PhysicalSkill3);
		player12MentalSkillList.add(player12MentalSkill1); player12MentalSkillList.add(player12MentalSkill2); player12MentalSkillList.add(player12MentalSkill3); 
		player12AttackSkillList.add(player12AttackSkill1); player12AttackSkillList.add(player12AttackSkill2); player12AttackSkillList.add(player12AttackSkill3);
		player12DefenceSkillList.add(player12DefenceSkill1); player12DefenceSkillList.add(player12DefenceSkill2); player12DefenceSkillList.add(player12DefenceSkill3);
		player12KickingSkillList.add(player12KickingSkill1); player12KickingSkillList.add(player12KickingSkill2); player12KickingSkillList.add(player12KickingSkill3);
		player12ContactSkillList.add(player12ContactSkill1); player12ContactSkillList.add(player12ContactSkill2); player12ContactSkillList.add(player12ContactSkill3);
		
		SkillCategory player12StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player12PhysicalSkillList);
		SkillCategory player12MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player12MentalSkillList);
		SkillCategory player12AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player12AttackSkillList);
		SkillCategory player12DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player12DefenceSkillList);
		SkillCategory player12KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player12KickingSkillList);
		SkillCategory player12ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player12ContactSkillList);
		
		player12SkillCategoryList.add(player12StengthSkillsList); player12SkillCategoryList.add(player12MentalSkillsList); player12SkillCategoryList.add(player12AttackSkillsList);
		player12SkillCategoryList.add(player12DefenceSkillsList); player12SkillCategoryList.add(player12KickingSkillsList); player12SkillCategoryList.add(player12ContactSkillsList);
		
		/**
		 * Player 13
		 */
		ArrayList<Skill> player13PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player13MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player13AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player13DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player13KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player13ContactSkillList = new ArrayList<Skill>();
		
		Skill player13PhysicalSkill1 = new Skill("Speed", 0);
		Skill player13PhysicalSkill2 = new Skill("Strength", 0);
		Skill player13PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player13MentalSkill1 = new Skill("Decision Making", 0);
		Skill player13MentalSkill2 = new Skill("Positioning", 0);
		Skill player13MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player13AttackSkill1 = new Skill("Grip", 0);
		Skill player13AttackSkill2 = new Skill("Fending Off", 0);
		Skill player13AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player13DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player13DefenceSkill2 = new Skill("Interception", 0);
		Skill player13DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player13KickingSkill1 = new Skill("Punt", 0);
		Skill player13KickingSkill2 = new Skill("Drop", 0);
		Skill player13KickingSkill3 = new Skill("Place", 0);
		
		Skill player13ContactSkill1 = new Skill("Tackle", 0);
		Skill player13ContactSkill2 = new Skill("Scrum", 0);
		Skill player13ContactSkill3 = new Skill("Carrying", 0);
		
		player13PhysicalSkillList.add(player13PhysicalSkill1); player13PhysicalSkillList.add(player13PhysicalSkill2); player13PhysicalSkillList.add(player13PhysicalSkill3);
		player13MentalSkillList.add(player13MentalSkill1); player13MentalSkillList.add(player13MentalSkill2); player13MentalSkillList.add(player13MentalSkill3); 
		player13AttackSkillList.add(player13AttackSkill1); player13AttackSkillList.add(player13AttackSkill2); player13AttackSkillList.add(player13AttackSkill3);
		player13DefenceSkillList.add(player13DefenceSkill1); player13DefenceSkillList.add(player13DefenceSkill2); player13DefenceSkillList.add(player13DefenceSkill3);
		player13KickingSkillList.add(player13KickingSkill1); player13KickingSkillList.add(player13KickingSkill2); player13KickingSkillList.add(player13KickingSkill3);
		player13ContactSkillList.add(player13ContactSkill1); player13ContactSkillList.add(player13ContactSkill2); player13ContactSkillList.add(player13ContactSkill3);
		
		SkillCategory player13StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player13PhysicalSkillList);
		SkillCategory player13MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player13MentalSkillList);
		SkillCategory player13AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player13AttackSkillList);
		SkillCategory player13DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player13DefenceSkillList);
		SkillCategory player13KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player13KickingSkillList);
		SkillCategory player13ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player13ContactSkillList);
		
		player13SkillCategoryList.add(player13StengthSkillsList); player13SkillCategoryList.add(player13MentalSkillsList); player13SkillCategoryList.add(player13AttackSkillsList);
		player13SkillCategoryList.add(player13DefenceSkillsList); player13SkillCategoryList.add(player13KickingSkillsList); player13SkillCategoryList.add(player13ContactSkillsList);
		
		/**
		 * Player 14
		 */
		ArrayList<Skill> player14PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player14MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player14AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player14DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player14KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player14ContactSkillList = new ArrayList<Skill>();
		
		Skill player14PhysicalSkill1 = new Skill("Speed", 0);
		Skill player14PhysicalSkill2 = new Skill("Strength", 0);
		Skill player14PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player14MentalSkill1 = new Skill("Decision Making", 0);
		Skill player14MentalSkill2 = new Skill("Positioning", 0);
		Skill player14MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player14AttackSkill1 = new Skill("Grip", 0);
		Skill player14AttackSkill2 = new Skill("Fending Off", 0);
		Skill player14AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player14DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player14DefenceSkill2 = new Skill("Interception", 0);
		Skill player14DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player14KickingSkill1 = new Skill("Punt", 0);
		Skill player14KickingSkill2 = new Skill("Drop", 0);
		Skill player14KickingSkill3 = new Skill("Place", 0);
		
		Skill player14ContactSkill1 = new Skill("Tackle", 0);
		Skill player14ContactSkill2 = new Skill("Scrum", 0);
		Skill player14ContactSkill3 = new Skill("Carrying", 0);
		
		player14PhysicalSkillList.add(player14PhysicalSkill1); player14PhysicalSkillList.add(player14PhysicalSkill2); player14PhysicalSkillList.add(player14PhysicalSkill3);
		player14MentalSkillList.add(player14MentalSkill1); player14MentalSkillList.add(player14MentalSkill2); player14MentalSkillList.add(player14MentalSkill3); 
		player14AttackSkillList.add(player14AttackSkill1); player14AttackSkillList.add(player14AttackSkill2); player14AttackSkillList.add(player14AttackSkill3);
		player14DefenceSkillList.add(player14DefenceSkill1); player14DefenceSkillList.add(player14DefenceSkill2); player14DefenceSkillList.add(player14DefenceSkill3);
		player14KickingSkillList.add(player14KickingSkill1); player14KickingSkillList.add(player14KickingSkill2); player14KickingSkillList.add(player14KickingSkill3);
		player14ContactSkillList.add(player14ContactSkill1); player14ContactSkillList.add(player14ContactSkill2); player14ContactSkillList.add(player14ContactSkill3);
		
		SkillCategory player14StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player14PhysicalSkillList);
		SkillCategory player14MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player14MentalSkillList);
		SkillCategory player14AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player14AttackSkillList);
		SkillCategory player14DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player14DefenceSkillList);
		SkillCategory player14KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player14KickingSkillList);
		SkillCategory player14ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player14ContactSkillList);
		
		player14SkillCategoryList.add(player14StengthSkillsList); player14SkillCategoryList.add(player14MentalSkillsList); player14SkillCategoryList.add(player14AttackSkillsList);
		player14SkillCategoryList.add(player14DefenceSkillsList); player14SkillCategoryList.add(player14KickingSkillsList); player14SkillCategoryList.add(player14ContactSkillsList);
		
		/**
		 * Player 15
		 */
		ArrayList<Skill> player15PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player15MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player15AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player15DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player15KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player15ContactSkillList = new ArrayList<Skill>();
		
		Skill player15PhysicalSkill1 = new Skill("Speed", 0);
		Skill player15PhysicalSkill2 = new Skill("Strength", 0);
		Skill player15PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player15MentalSkill1 = new Skill("Decision Making", 0);
		Skill player15MentalSkill2 = new Skill("Positioning", 0);
		Skill player15MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player15AttackSkill1 = new Skill("Grip", 0);
		Skill player15AttackSkill2 = new Skill("Fending Off", 0);
		Skill player15AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player15DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player15DefenceSkill2 = new Skill("Interception", 0);
		Skill player15DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player15KickingSkill1 = new Skill("Punt", 0);
		Skill player15KickingSkill2 = new Skill("Drop", 0);
		Skill player15KickingSkill3 = new Skill("Place", 0);
		
		Skill player15ContactSkill1 = new Skill("Tackle", 0);
		Skill player15ContactSkill2 = new Skill("Scrum", 0);
		Skill player15ContactSkill3 = new Skill("Carrying", 0);
		
		player15PhysicalSkillList.add(player15PhysicalSkill1); player15PhysicalSkillList.add(player15PhysicalSkill2); player15PhysicalSkillList.add(player15PhysicalSkill3);
		player15MentalSkillList.add(player15MentalSkill1); player15MentalSkillList.add(player15MentalSkill2); player15MentalSkillList.add(player15MentalSkill3); 
		player15AttackSkillList.add(player15AttackSkill1); player15AttackSkillList.add(player15AttackSkill2); player15AttackSkillList.add(player15AttackSkill3);
		player15DefenceSkillList.add(player15DefenceSkill1); player15DefenceSkillList.add(player15DefenceSkill2); player15DefenceSkillList.add(player15DefenceSkill3);
		player15KickingSkillList.add(player15KickingSkill1); player15KickingSkillList.add(player15KickingSkill2); player15KickingSkillList.add(player15KickingSkill3);
		player15ContactSkillList.add(player15ContactSkill1); player15ContactSkillList.add(player15ContactSkill2); player15ContactSkillList.add(player15ContactSkill3);
		
		SkillCategory player15StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player15PhysicalSkillList);
		SkillCategory player15MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player15MentalSkillList);
		SkillCategory player15AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player15AttackSkillList);
		SkillCategory player15DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player15DefenceSkillList);
		SkillCategory player15KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player15KickingSkillList);
		SkillCategory player15ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player15ContactSkillList);
		
		player15SkillCategoryList.add(player15StengthSkillsList); player15SkillCategoryList.add(player15MentalSkillsList); player15SkillCategoryList.add(player15AttackSkillsList);
		player15SkillCategoryList.add(player15DefenceSkillsList); player15SkillCategoryList.add(player15KickingSkillsList); player15SkillCategoryList.add(player15ContactSkillsList);
		
		/**
		 * Player 16
		 */
		ArrayList<Skill> player16PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player16MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player16AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player16DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player16KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player16ContactSkillList = new ArrayList<Skill>();
		
		Skill player16PhysicalSkill1 = new Skill("Speed", 0);
		Skill player16PhysicalSkill2 = new Skill("Strength", 0);
		Skill player16PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player16MentalSkill1 = new Skill("Decision Making", 0);
		Skill player16MentalSkill2 = new Skill("Positioning", 0);
		Skill player16MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player16AttackSkill1 = new Skill("Grip", 0);
		Skill player16AttackSkill2 = new Skill("Fending Off", 0);
		Skill player16AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player16DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player16DefenceSkill2 = new Skill("Interception", 0);
		Skill player16DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player16KickingSkill1 = new Skill("Punt", 0);
		Skill player16KickingSkill2 = new Skill("Drop", 0);
		Skill player16KickingSkill3 = new Skill("Place", 0);
		
		Skill player16ContactSkill1 = new Skill("Tackle", 0);
		Skill player16ContactSkill2 = new Skill("Scrum", 0);
		Skill player16ContactSkill3 = new Skill("Carrying", 0);
		
		player16PhysicalSkillList.add(player16PhysicalSkill1); player16PhysicalSkillList.add(player16PhysicalSkill2); player16PhysicalSkillList.add(player16PhysicalSkill3);
		player16MentalSkillList.add(player16MentalSkill1); player16MentalSkillList.add(player16MentalSkill2); player16MentalSkillList.add(player16MentalSkill3); 
		player16AttackSkillList.add(player16AttackSkill1); player16AttackSkillList.add(player16AttackSkill2); player16AttackSkillList.add(player16AttackSkill3);
		player16DefenceSkillList.add(player16DefenceSkill1); player16DefenceSkillList.add(player16DefenceSkill2); player16DefenceSkillList.add(player16DefenceSkill3);
		player16KickingSkillList.add(player16KickingSkill1); player16KickingSkillList.add(player16KickingSkill2); player16KickingSkillList.add(player16KickingSkill3);
		player16ContactSkillList.add(player16ContactSkill1); player16ContactSkillList.add(player16ContactSkill2); player16ContactSkillList.add(player16ContactSkill3);
		
		SkillCategory player16StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player16PhysicalSkillList);
		SkillCategory player16MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player16MentalSkillList);
		SkillCategory player16AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player16AttackSkillList);
		SkillCategory player16DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player16DefenceSkillList);
		SkillCategory player16KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player16KickingSkillList);
		SkillCategory player16ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player16ContactSkillList);
		
		player16SkillCategoryList.add(player16StengthSkillsList); player16SkillCategoryList.add(player16MentalSkillsList); player16SkillCategoryList.add(player16AttackSkillsList);
		player16SkillCategoryList.add(player16DefenceSkillsList); player16SkillCategoryList.add(player16KickingSkillsList); player16SkillCategoryList.add(player16ContactSkillsList);
		
		/**
		 * Player 17
		 */
		ArrayList<Skill> player17PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player17MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player17AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player17DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player17KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player17ContactSkillList = new ArrayList<Skill>();
		
		Skill player17PhysicalSkill1 = new Skill("Speed", 0);
		Skill player17PhysicalSkill2 = new Skill("Strength", 0);
		Skill player17PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player17MentalSkill1 = new Skill("Decision Making", 0);
		Skill player17MentalSkill2 = new Skill("Positioning", 0);
		Skill player17MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player17AttackSkill1 = new Skill("Grip", 0);
		Skill player17AttackSkill2 = new Skill("Fending Off", 0);
		Skill player17AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player17DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player17DefenceSkill2 = new Skill("Interception", 0);
		Skill player17DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player17KickingSkill1 = new Skill("Punt", 0);
		Skill player17KickingSkill2 = new Skill("Drop", 0);
		Skill player17KickingSkill3 = new Skill("Place", 0);
		
		Skill player17ContactSkill1 = new Skill("Tackle", 0);
		Skill player17ContactSkill2 = new Skill("Scrum", 0);
		Skill player17ContactSkill3 = new Skill("Carrying", 0);
		
		player17PhysicalSkillList.add(player17PhysicalSkill1); player17PhysicalSkillList.add(player17PhysicalSkill2); player17PhysicalSkillList.add(player17PhysicalSkill3);
		player17MentalSkillList.add(player17MentalSkill1); player17MentalSkillList.add(player17MentalSkill2); player17MentalSkillList.add(player17MentalSkill3); 
		player17AttackSkillList.add(player17AttackSkill1); player17AttackSkillList.add(player17AttackSkill2); player17AttackSkillList.add(player17AttackSkill3);
		player17DefenceSkillList.add(player17DefenceSkill1); player17DefenceSkillList.add(player17DefenceSkill2); player17DefenceSkillList.add(player17DefenceSkill3);
		player17KickingSkillList.add(player17KickingSkill1); player17KickingSkillList.add(player17KickingSkill2); player17KickingSkillList.add(player17KickingSkill3);
		player17ContactSkillList.add(player17ContactSkill1); player17ContactSkillList.add(player17ContactSkill2); player17ContactSkillList.add(player17ContactSkill3);
		
		SkillCategory player17StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player17PhysicalSkillList);
		SkillCategory player17MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player17MentalSkillList);
		SkillCategory player17AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player17AttackSkillList);
		SkillCategory player17DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player17DefenceSkillList);
		SkillCategory player17KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player17KickingSkillList);
		SkillCategory player17ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player17ContactSkillList);
		
		player17SkillCategoryList.add(player17StengthSkillsList); player17SkillCategoryList.add(player17MentalSkillsList); player17SkillCategoryList.add(player17AttackSkillsList);
		player17SkillCategoryList.add(player17DefenceSkillsList); player17SkillCategoryList.add(player17KickingSkillsList); player17SkillCategoryList.add(player17ContactSkillsList);
		
		/**
		 * Player 18
		 */
		ArrayList<Skill> player18PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player18MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player18AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player18DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player18KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player18ContactSkillList = new ArrayList<Skill>();
		
		Skill player18PhysicalSkill1 = new Skill("Speed", 0);
		Skill player18PhysicalSkill2 = new Skill("Strength", 0);
		Skill player18PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player18MentalSkill1 = new Skill("Decision Making", 0);
		Skill player18MentalSkill2 = new Skill("Positioning", 0);
		Skill player18MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player18AttackSkill1 = new Skill("Grip", 0);
		Skill player18AttackSkill2 = new Skill("Fending Off", 0);
		Skill player18AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player18DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player18DefenceSkill2 = new Skill("Interception", 0);
		Skill player18DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player18KickingSkill1 = new Skill("Punt", 0);
		Skill player18KickingSkill2 = new Skill("Drop", 0);
		Skill player18KickingSkill3 = new Skill("Place", 0);
		
		Skill player18ContactSkill1 = new Skill("Tackle", 0);
		Skill player18ContactSkill2 = new Skill("Scrum", 0);
		Skill player18ContactSkill3 = new Skill("Carrying", 0);
		
		player18PhysicalSkillList.add(player18PhysicalSkill1); player18PhysicalSkillList.add(player18PhysicalSkill2); player18PhysicalSkillList.add(player18PhysicalSkill3);
		player18MentalSkillList.add(player18MentalSkill1); player18MentalSkillList.add(player18MentalSkill2); player18MentalSkillList.add(player18MentalSkill3); 
		player18AttackSkillList.add(player18AttackSkill1); player18AttackSkillList.add(player18AttackSkill2); player18AttackSkillList.add(player18AttackSkill3);
		player18DefenceSkillList.add(player18DefenceSkill1); player18DefenceSkillList.add(player18DefenceSkill2); player18DefenceSkillList.add(player18DefenceSkill3);
		player18KickingSkillList.add(player18KickingSkill1); player18KickingSkillList.add(player18KickingSkill2); player18KickingSkillList.add(player18KickingSkill3);
		player18ContactSkillList.add(player18ContactSkill1); player18ContactSkillList.add(player18ContactSkill2); player18ContactSkillList.add(player18ContactSkill3);
		
		SkillCategory player18StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player18PhysicalSkillList);
		SkillCategory player18MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player18MentalSkillList);
		SkillCategory player18AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player18AttackSkillList);
		SkillCategory player18DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player18DefenceSkillList);
		SkillCategory player18KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player18KickingSkillList);
		SkillCategory player18ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player18ContactSkillList);
		
		player18SkillCategoryList.add(player18StengthSkillsList); player18SkillCategoryList.add(player18MentalSkillsList); player18SkillCategoryList.add(player18AttackSkillsList);
		player18SkillCategoryList.add(player18DefenceSkillsList); player18SkillCategoryList.add(player18KickingSkillsList); player18SkillCategoryList.add(player18ContactSkillsList);
		
		/**
		 * Player 19
		 */
		ArrayList<Skill> player19PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player19MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player19AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player19DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player19KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player19ContactSkillList = new ArrayList<Skill>();
		
		Skill player19PhysicalSkill1 = new Skill("Speed", 0);
		Skill player19PhysicalSkill2 = new Skill("Strength", 0);
		Skill player19PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player19MentalSkill1 = new Skill("Decision Making", 0);
		Skill player19MentalSkill2 = new Skill("Positioning", 0);
		Skill player19MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player19AttackSkill1 = new Skill("Grip", 0);
		Skill player19AttackSkill2 = new Skill("Fending Off", 0);
		Skill player19AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player19DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player19DefenceSkill2 = new Skill("Interception", 0);
		Skill player19DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player19KickingSkill1 = new Skill("Punt", 0);
		Skill player19KickingSkill2 = new Skill("Drop", 0);
		Skill player19KickingSkill3 = new Skill("Place", 0);
		
		Skill player19ContactSkill1 = new Skill("Tackle", 0);
		Skill player19ContactSkill2 = new Skill("Scrum", 0);
		Skill player19ContactSkill3 = new Skill("Carrying", 0);
		
		player19PhysicalSkillList.add(player19PhysicalSkill1); player19PhysicalSkillList.add(player19PhysicalSkill2); player19PhysicalSkillList.add(player19PhysicalSkill3);
		player19MentalSkillList.add(player19MentalSkill1); player19MentalSkillList.add(player19MentalSkill2); player19MentalSkillList.add(player19MentalSkill3); 
		player19AttackSkillList.add(player19AttackSkill1); player19AttackSkillList.add(player19AttackSkill2); player19AttackSkillList.add(player19AttackSkill3);
		player19DefenceSkillList.add(player19DefenceSkill1); player19DefenceSkillList.add(player19DefenceSkill2); player19DefenceSkillList.add(player19DefenceSkill3);
		player19KickingSkillList.add(player19KickingSkill1); player19KickingSkillList.add(player19KickingSkill2); player19KickingSkillList.add(player19KickingSkill3);
		player19ContactSkillList.add(player19ContactSkill1); player19ContactSkillList.add(player19ContactSkill2); player19ContactSkillList.add(player19ContactSkill3);
		
		SkillCategory player19StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player19PhysicalSkillList);
		SkillCategory player19MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player19MentalSkillList);
		SkillCategory player19AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player19AttackSkillList);
		SkillCategory player19DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player19DefenceSkillList);
		SkillCategory player19KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player19KickingSkillList);
		SkillCategory player19ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player19ContactSkillList);
		
		player19SkillCategoryList.add(player19StengthSkillsList); player19SkillCategoryList.add(player19MentalSkillsList); player19SkillCategoryList.add(player19AttackSkillsList);
		player19SkillCategoryList.add(player19DefenceSkillsList); player19SkillCategoryList.add(player19KickingSkillsList); player19SkillCategoryList.add(player19ContactSkillsList);
		
		/**
		 * Player 20
		 */
		ArrayList<Skill> player20PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player20MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player20AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player20DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player20KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player20ContactSkillList = new ArrayList<Skill>();
		
		Skill player20PhysicalSkill1 = new Skill("Speed", 0);
		Skill player20PhysicalSkill2 = new Skill("Strength", 0);
		Skill player20PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player20MentalSkill1 = new Skill("Decision Making", 0);
		Skill player20MentalSkill2 = new Skill("Positioning", 0);
		Skill player20MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player20AttackSkill1 = new Skill("Grip", 0);
		Skill player20AttackSkill2 = new Skill("Fending Off", 0);
		Skill player20AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player20DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player20DefenceSkill2 = new Skill("Interception", 0);
		Skill player20DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player20KickingSkill1 = new Skill("Punt", 0);
		Skill player20KickingSkill2 = new Skill("Drop", 0);
		Skill player20KickingSkill3 = new Skill("Place", 0);
		
		Skill player20ContactSkill1 = new Skill("Tackle", 0);
		Skill player20ContactSkill2 = new Skill("Scrum", 0);
		Skill player20ContactSkill3 = new Skill("Carrying", 0);
		
		player20PhysicalSkillList.add(player20PhysicalSkill1); player20PhysicalSkillList.add(player20PhysicalSkill2); player20PhysicalSkillList.add(player20PhysicalSkill3);
		player20MentalSkillList.add(player20MentalSkill1); player20MentalSkillList.add(player20MentalSkill2); player20MentalSkillList.add(player20MentalSkill3); 
		player20AttackSkillList.add(player20AttackSkill1); player20AttackSkillList.add(player20AttackSkill2); player20AttackSkillList.add(player20AttackSkill3);
		player20DefenceSkillList.add(player20DefenceSkill1); player20DefenceSkillList.add(player20DefenceSkill2); player20DefenceSkillList.add(player20DefenceSkill3);
		player20KickingSkillList.add(player20KickingSkill1); player20KickingSkillList.add(player20KickingSkill2); player20KickingSkillList.add(player20KickingSkill3);
		player20ContactSkillList.add(player20ContactSkill1); player20ContactSkillList.add(player20ContactSkill2); player20ContactSkillList.add(player20ContactSkill3);
		
		SkillCategory player20StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player20PhysicalSkillList);
		SkillCategory player20MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player20MentalSkillList);
		SkillCategory player20AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player20AttackSkillList);
		SkillCategory player20DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player20DefenceSkillList);
		SkillCategory player20KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player20KickingSkillList);
		SkillCategory player20ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player20ContactSkillList);
		
		player20SkillCategoryList.add(player20StengthSkillsList); player20SkillCategoryList.add(player20MentalSkillsList); player20SkillCategoryList.add(player20AttackSkillsList);
		player20SkillCategoryList.add(player20DefenceSkillsList); player20SkillCategoryList.add(player20KickingSkillsList); player20SkillCategoryList.add(player20ContactSkillsList);
		
		/**
		 * Player 21
		 */
		ArrayList<Skill> player21PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player21MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player21AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player21DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player21KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player21ContactSkillList = new ArrayList<Skill>();
		
		Skill player21PhysicalSkill1 = new Skill("Speed", 0);
		Skill player21PhysicalSkill2 = new Skill("Strength", 0);
		Skill player21PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player21MentalSkill1 = new Skill("Decision Making", 0);
		Skill player21MentalSkill2 = new Skill("Positioning", 0);
		Skill player21MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player21AttackSkill1 = new Skill("Grip", 0);
		Skill player21AttackSkill2 = new Skill("Fending Off", 0);
		Skill player21AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player21DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player21DefenceSkill2 = new Skill("Interception", 0);
		Skill player21DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player21KickingSkill1 = new Skill("Punt", 0);
		Skill player21KickingSkill2 = new Skill("Drop", 0);
		Skill player21KickingSkill3 = new Skill("Place", 0);
		
		Skill player21ContactSkill1 = new Skill("Tackle", 0);
		Skill player21ContactSkill2 = new Skill("Scrum", 0);
		Skill player21ContactSkill3 = new Skill("Carrying", 0);
		
		player21PhysicalSkillList.add(player21PhysicalSkill1); player21PhysicalSkillList.add(player21PhysicalSkill2); player21PhysicalSkillList.add(player21PhysicalSkill3);
		player21MentalSkillList.add(player21MentalSkill1); player21MentalSkillList.add(player21MentalSkill2); player21MentalSkillList.add(player21MentalSkill3); 
		player21AttackSkillList.add(player21AttackSkill1); player21AttackSkillList.add(player21AttackSkill2); player21AttackSkillList.add(player21AttackSkill3);
		player21DefenceSkillList.add(player21DefenceSkill1); player21DefenceSkillList.add(player21DefenceSkill2); player21DefenceSkillList.add(player21DefenceSkill3);
		player21KickingSkillList.add(player21KickingSkill1); player21KickingSkillList.add(player21KickingSkill2); player21KickingSkillList.add(player21KickingSkill3);
		player21ContactSkillList.add(player21ContactSkill1); player21ContactSkillList.add(player21ContactSkill2); player21ContactSkillList.add(player21ContactSkill3);
		
		SkillCategory player21StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player21PhysicalSkillList);
		SkillCategory player21MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player21MentalSkillList);
		SkillCategory player21AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player21AttackSkillList);
		SkillCategory player21DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player21DefenceSkillList);
		SkillCategory player21KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player21KickingSkillList);
		SkillCategory player21ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player21ContactSkillList);
		
		player21SkillCategoryList.add(player21StengthSkillsList); player21SkillCategoryList.add(player21MentalSkillsList); player21SkillCategoryList.add(player21AttackSkillsList);
		player21SkillCategoryList.add(player21DefenceSkillsList); player21SkillCategoryList.add(player21KickingSkillsList); player21SkillCategoryList.add(player21ContactSkillsList);
		
		/**
		 * Player 22
		 */
		ArrayList<Skill> player22PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player22MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player22AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player22DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player22KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player22ContactSkillList = new ArrayList<Skill>();
		
		Skill player22PhysicalSkill1 = new Skill("Speed", 0);
		Skill player22PhysicalSkill2 = new Skill("Strength", 0);
		Skill player22PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player22MentalSkill1 = new Skill("Decision Making", 0);
		Skill player22MentalSkill2 = new Skill("Positioning", 0);
		Skill player22MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player22AttackSkill1 = new Skill("Grip", 0);
		Skill player22AttackSkill2 = new Skill("Fending Off", 0);
		Skill player22AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player22DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player22DefenceSkill2 = new Skill("Interception", 0);
		Skill player22DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player22KickingSkill1 = new Skill("Punt", 0);
		Skill player22KickingSkill2 = new Skill("Drop", 0);
		Skill player22KickingSkill3 = new Skill("Place", 0);
		
		Skill player22ContactSkill1 = new Skill("Tackle", 0);
		Skill player22ContactSkill2 = new Skill("Scrum", 0);
		Skill player22ContactSkill3 = new Skill("Carrying", 0);
		
		player22PhysicalSkillList.add(player22PhysicalSkill1); player22PhysicalSkillList.add(player22PhysicalSkill2); player22PhysicalSkillList.add(player22PhysicalSkill3);
		player22MentalSkillList.add(player22MentalSkill1); player22MentalSkillList.add(player22MentalSkill2); player22MentalSkillList.add(player22MentalSkill3); 
		player22AttackSkillList.add(player22AttackSkill1); player22AttackSkillList.add(player22AttackSkill2); player22AttackSkillList.add(player22AttackSkill3);
		player22DefenceSkillList.add(player22DefenceSkill1); player22DefenceSkillList.add(player22DefenceSkill2); player22DefenceSkillList.add(player22DefenceSkill3);
		player22KickingSkillList.add(player22KickingSkill1); player22KickingSkillList.add(player22KickingSkill2); player22KickingSkillList.add(player22KickingSkill3);
		player22ContactSkillList.add(player22ContactSkill1); player22ContactSkillList.add(player22ContactSkill2); player22ContactSkillList.add(player22ContactSkill3);
		
		SkillCategory player22StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player22PhysicalSkillList);
		SkillCategory player22MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player22MentalSkillList);
		SkillCategory player22AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player22AttackSkillList);
		SkillCategory player22DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player22DefenceSkillList);
		SkillCategory player22KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player22KickingSkillList);
		SkillCategory player22ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player22ContactSkillList);
		
		player22SkillCategoryList.add(player22StengthSkillsList); player22SkillCategoryList.add(player22MentalSkillsList); player22SkillCategoryList.add(player22AttackSkillsList);
		player22SkillCategoryList.add(player22DefenceSkillsList); player22SkillCategoryList.add(player22KickingSkillsList); player22SkillCategoryList.add(player22ContactSkillsList);
		
		
		/**
		 * Player 23
		 */
		ArrayList<Skill> player23PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player23MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player23AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player23DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player23KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player23ContactSkillList = new ArrayList<Skill>();
		
		Skill player23PhysicalSkill1 = new Skill("Speed", 0);
		Skill player23PhysicalSkill2 = new Skill("Strength", 0);
		Skill player23PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player23MentalSkill1 = new Skill("Decision Making", 0);
		Skill player23MentalSkill2 = new Skill("Positioning", 0);
		Skill player23MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player23AttackSkill1 = new Skill("Grip", 0);
		Skill player23AttackSkill2 = new Skill("Fending Off", 0);
		Skill player23AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player23DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player23DefenceSkill2 = new Skill("Interception", 0);
		Skill player23DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player23KickingSkill1 = new Skill("Punt", 0);
		Skill player23KickingSkill2 = new Skill("Drop", 0);
		Skill player23KickingSkill3 = new Skill("Place", 0);
		
		Skill player23ContactSkill1 = new Skill("Tackle", 0);
		Skill player23ContactSkill2 = new Skill("Scrum", 0);
		Skill player23ContactSkill3 = new Skill("Carrying", 0);
		
		player23PhysicalSkillList.add(player23PhysicalSkill1); player23PhysicalSkillList.add(player23PhysicalSkill2); player23PhysicalSkillList.add(player23PhysicalSkill3);
		player23MentalSkillList.add(player23MentalSkill1); player23MentalSkillList.add(player23MentalSkill2); player23MentalSkillList.add(player23MentalSkill3); 
		player23AttackSkillList.add(player23AttackSkill1); player23AttackSkillList.add(player23AttackSkill2); player23AttackSkillList.add(player23AttackSkill3);
		player23DefenceSkillList.add(player23DefenceSkill1); player23DefenceSkillList.add(player23DefenceSkill2); player23DefenceSkillList.add(player23DefenceSkill3);
		player23KickingSkillList.add(player23KickingSkill1); player23KickingSkillList.add(player23KickingSkill2); player23KickingSkillList.add(player23KickingSkill3);
		player23ContactSkillList.add(player23ContactSkill1); player23ContactSkillList.add(player23ContactSkill2); player23ContactSkillList.add(player23ContactSkill3);
		
		SkillCategory player23StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player23PhysicalSkillList);
		SkillCategory player23MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player23MentalSkillList);
		SkillCategory player23AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player23AttackSkillList);
		SkillCategory player23DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player23DefenceSkillList);
		SkillCategory player23KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player23KickingSkillList);
		SkillCategory player23ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player23ContactSkillList);
		
		player23SkillCategoryList.add(player23StengthSkillsList); player23SkillCategoryList.add(player23MentalSkillsList); player23SkillCategoryList.add(player23AttackSkillsList);
		player23SkillCategoryList.add(player23DefenceSkillsList); player23SkillCategoryList.add(player23KickingSkillsList); player23SkillCategoryList.add(player23ContactSkillsList);
		
		/**
		 * Player 24
		 */
		ArrayList<Skill> player24PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player24MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player24AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player24DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player24KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player24ContactSkillList = new ArrayList<Skill>();
		
		Skill player24PhysicalSkill1 = new Skill("Speed", 0);
		Skill player24PhysicalSkill2 = new Skill("Strength", 0);
		Skill player24PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player24MentalSkill1 = new Skill("Decision Making", 0);
		Skill player24MentalSkill2 = new Skill("Positioning", 0);
		Skill player24MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player24AttackSkill1 = new Skill("Grip", 0);
		Skill player24AttackSkill2 = new Skill("Fending Off", 0);
		Skill player24AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player24DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player24DefenceSkill2 = new Skill("Interception", 0);
		Skill player24DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player24KickingSkill1 = new Skill("Punt", 0);
		Skill player24KickingSkill2 = new Skill("Drop", 0);
		Skill player24KickingSkill3 = new Skill("Place", 0);
		
		Skill player24ContactSkill1 = new Skill("Tackle", 0);
		Skill player24ContactSkill2 = new Skill("Scrum", 0);
		Skill player24ContactSkill3 = new Skill("Carrying", 0);
		
		player24PhysicalSkillList.add(player24PhysicalSkill1); player24PhysicalSkillList.add(player24PhysicalSkill2); player24PhysicalSkillList.add(player24PhysicalSkill3);
		player24MentalSkillList.add(player24MentalSkill1); player24MentalSkillList.add(player24MentalSkill2); player24MentalSkillList.add(player24MentalSkill3); 
		player24AttackSkillList.add(player24AttackSkill1); player24AttackSkillList.add(player24AttackSkill2); player24AttackSkillList.add(player24AttackSkill3);
		player24DefenceSkillList.add(player24DefenceSkill1); player24DefenceSkillList.add(player24DefenceSkill2); player24DefenceSkillList.add(player24DefenceSkill3);
		player24KickingSkillList.add(player24KickingSkill1); player24KickingSkillList.add(player24KickingSkill2); player24KickingSkillList.add(player24KickingSkill3);
		player24ContactSkillList.add(player24ContactSkill1); player24ContactSkillList.add(player24ContactSkill2); player24ContactSkillList.add(player24ContactSkill3);
		
		SkillCategory player24StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player24PhysicalSkillList);
		SkillCategory player24MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player24MentalSkillList);
		SkillCategory player24AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player24AttackSkillList);
		SkillCategory player24DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player24DefenceSkillList);
		SkillCategory player24KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player24KickingSkillList);
		SkillCategory player24ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player24ContactSkillList);
		
		player24SkillCategoryList.add(player24StengthSkillsList); player24SkillCategoryList.add(player24MentalSkillsList); player24SkillCategoryList.add(player24AttackSkillsList);
		player24SkillCategoryList.add(player24DefenceSkillsList); player24SkillCategoryList.add(player24KickingSkillsList); player24SkillCategoryList.add(player24ContactSkillsList);
		
		
		/**
		 * Player 25
		 */
		ArrayList<Skill> player25PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player25MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player25AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player25DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player25KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player25ContactSkillList = new ArrayList<Skill>();
		
		Skill player25PhysicalSkill1 = new Skill("Speed", 0);
		Skill player25PhysicalSkill2 = new Skill("Strength", 0);
		Skill player25PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player25MentalSkill1 = new Skill("Decision Making", 0);
		Skill player25MentalSkill2 = new Skill("Positioning", 0);
		Skill player25MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player25AttackSkill1 = new Skill("Grip", 0);
		Skill player25AttackSkill2 = new Skill("Fending Off", 0);
		Skill player25AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player25DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player25DefenceSkill2 = new Skill("Interception", 0);
		Skill player25DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player25KickingSkill1 = new Skill("Punt", 0);
		Skill player25KickingSkill2 = new Skill("Drop", 0);
		Skill player25KickingSkill3 = new Skill("Place", 0);
		
		Skill player25ContactSkill1 = new Skill("Tackle", 0);
		Skill player25ContactSkill2 = new Skill("Scrum", 0);
		Skill player25ContactSkill3 = new Skill("Carrying", 0);
		
		player25PhysicalSkillList.add(player25PhysicalSkill1); player25PhysicalSkillList.add(player25PhysicalSkill2); player25PhysicalSkillList.add(player25PhysicalSkill3);
		player25MentalSkillList.add(player25MentalSkill1); player25MentalSkillList.add(player25MentalSkill2); player25MentalSkillList.add(player25MentalSkill3); 
		player25AttackSkillList.add(player25AttackSkill1); player25AttackSkillList.add(player25AttackSkill2); player25AttackSkillList.add(player25AttackSkill3);
		player25DefenceSkillList.add(player25DefenceSkill1); player25DefenceSkillList.add(player25DefenceSkill2); player25DefenceSkillList.add(player25DefenceSkill3);
		player25KickingSkillList.add(player25KickingSkill1); player25KickingSkillList.add(player25KickingSkill2); player25KickingSkillList.add(player25KickingSkill3);
		player25ContactSkillList.add(player25ContactSkill1); player25ContactSkillList.add(player25ContactSkill2); player25ContactSkillList.add(player25ContactSkill3);
		
		SkillCategory player25StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player25PhysicalSkillList);
		SkillCategory player25MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player25MentalSkillList);
		SkillCategory player25AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player25AttackSkillList);
		SkillCategory player25DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player25DefenceSkillList);
		SkillCategory player25KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player25KickingSkillList);
		SkillCategory player25ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player25ContactSkillList);
		
		player25SkillCategoryList.add(player25StengthSkillsList); player25SkillCategoryList.add(player25MentalSkillsList); player25SkillCategoryList.add(player25AttackSkillsList);
		player25SkillCategoryList.add(player25DefenceSkillsList); player25SkillCategoryList.add(player25KickingSkillsList); player25SkillCategoryList.add(player25ContactSkillsList);
		
		/**
		 * Player 26
		 */
		ArrayList<Skill> player26PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player26MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player26AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player26DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player26KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player26ContactSkillList = new ArrayList<Skill>();
		
		Skill player26PhysicalSkill1 = new Skill("Speed", 0);
		Skill player26PhysicalSkill2 = new Skill("Strength", 0);
		Skill player26PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player26MentalSkill1 = new Skill("Decision Making", 0);
		Skill player26MentalSkill2 = new Skill("Positioning", 0);
		Skill player26MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player26AttackSkill1 = new Skill("Grip", 0);
		Skill player26AttackSkill2 = new Skill("Fending Off", 0);
		Skill player26AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player26DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player26DefenceSkill2 = new Skill("Interception", 0);
		Skill player26DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player26KickingSkill1 = new Skill("Punt", 0);
		Skill player26KickingSkill2 = new Skill("Drop", 0);
		Skill player26KickingSkill3 = new Skill("Place", 0);
		
		Skill player26ContactSkill1 = new Skill("Tackle", 0);
		Skill player26ContactSkill2 = new Skill("Scrum", 0);
		Skill player26ContactSkill3 = new Skill("Carrying", 0);
		
		player26PhysicalSkillList.add(player26PhysicalSkill1); player26PhysicalSkillList.add(player26PhysicalSkill2); player26PhysicalSkillList.add(player26PhysicalSkill3);
		player26MentalSkillList.add(player26MentalSkill1); player26MentalSkillList.add(player26MentalSkill2); player26MentalSkillList.add(player26MentalSkill3); 
		player26AttackSkillList.add(player26AttackSkill1); player26AttackSkillList.add(player26AttackSkill2); player26AttackSkillList.add(player26AttackSkill3);
		player26DefenceSkillList.add(player26DefenceSkill1); player26DefenceSkillList.add(player26DefenceSkill2); player26DefenceSkillList.add(player26DefenceSkill3);
		player26KickingSkillList.add(player26KickingSkill1); player26KickingSkillList.add(player26KickingSkill2); player26KickingSkillList.add(player26KickingSkill3);
		player26ContactSkillList.add(player26ContactSkill1); player26ContactSkillList.add(player26ContactSkill2); player26ContactSkillList.add(player26ContactSkill3);
		
		SkillCategory player26StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player26PhysicalSkillList);
		SkillCategory player26MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player26MentalSkillList);
		SkillCategory player26AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player26AttackSkillList);
		SkillCategory player26DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player26DefenceSkillList);
		SkillCategory player26KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player26KickingSkillList);
		SkillCategory player26ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player26ContactSkillList);
		
		player26SkillCategoryList.add(player26StengthSkillsList); player26SkillCategoryList.add(player26MentalSkillsList); player26SkillCategoryList.add(player26AttackSkillsList);
		player26SkillCategoryList.add(player26DefenceSkillsList); player26SkillCategoryList.add(player26KickingSkillsList); player26SkillCategoryList.add(player26ContactSkillsList);
		
		/**
		 * Player 27
		 */
		ArrayList<Skill> player27PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player27MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player27AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player27DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player27KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player27ContactSkillList = new ArrayList<Skill>();
		
		Skill player27PhysicalSkill1 = new Skill("Speed", 0);
		Skill player27PhysicalSkill2 = new Skill("Strength", 0);
		Skill player27PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player27MentalSkill1 = new Skill("Decision Making", 0);
		Skill player27MentalSkill2 = new Skill("Positioning", 0);
		Skill player27MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player27AttackSkill1 = new Skill("Grip", 0);
		Skill player27AttackSkill2 = new Skill("Fending Off", 0);
		Skill player27AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player27DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player27DefenceSkill2 = new Skill("Interception", 0);
		Skill player27DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player27KickingSkill1 = new Skill("Punt", 0);
		Skill player27KickingSkill2 = new Skill("Drop", 0);
		Skill player27KickingSkill3 = new Skill("Place", 0);
		
		Skill player27ContactSkill1 = new Skill("Tackle", 0);
		Skill player27ContactSkill2 = new Skill("Scrum", 0);
		Skill player27ContactSkill3 = new Skill("Carrying", 0);
		
		player27PhysicalSkillList.add(player27PhysicalSkill1); player27PhysicalSkillList.add(player27PhysicalSkill2); player27PhysicalSkillList.add(player27PhysicalSkill3);
		player27MentalSkillList.add(player27MentalSkill1); player27MentalSkillList.add(player27MentalSkill2); player27MentalSkillList.add(player27MentalSkill3); 
		player27AttackSkillList.add(player27AttackSkill1); player27AttackSkillList.add(player27AttackSkill2); player27AttackSkillList.add(player27AttackSkill3);
		player27DefenceSkillList.add(player27DefenceSkill1); player27DefenceSkillList.add(player27DefenceSkill2); player27DefenceSkillList.add(player27DefenceSkill3);
		player27KickingSkillList.add(player27KickingSkill1); player27KickingSkillList.add(player27KickingSkill2); player27KickingSkillList.add(player27KickingSkill3);
		player27ContactSkillList.add(player27ContactSkill1); player27ContactSkillList.add(player27ContactSkill2); player27ContactSkillList.add(player27ContactSkill3);
		
		SkillCategory player27StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player27PhysicalSkillList);
		SkillCategory player27MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player27MentalSkillList);
		SkillCategory player27AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player27AttackSkillList);
		SkillCategory player27DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player27DefenceSkillList);
		SkillCategory player27KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player27KickingSkillList);
		SkillCategory player27ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player27ContactSkillList);
		
		player27SkillCategoryList.add(player27StengthSkillsList); player27SkillCategoryList.add(player27MentalSkillsList); player27SkillCategoryList.add(player27AttackSkillsList);
		player27SkillCategoryList.add(player27DefenceSkillsList); player27SkillCategoryList.add(player27KickingSkillsList); player27SkillCategoryList.add(player27ContactSkillsList);
		
		/**
		 * Player 28
		 */
		ArrayList<Skill> player28PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player28MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player28AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player28DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player28KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player28ContactSkillList = new ArrayList<Skill>();
		
		Skill player28PhysicalSkill1 = new Skill("Speed", 0);
		Skill player28PhysicalSkill2 = new Skill("Strength", 0);
		Skill player28PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player28MentalSkill1 = new Skill("Decision Making", 0);
		Skill player28MentalSkill2 = new Skill("Positioning", 0);
		Skill player28MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player28AttackSkill1 = new Skill("Grip", 0);
		Skill player28AttackSkill2 = new Skill("Fending Off", 0);
		Skill player28AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player28DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player28DefenceSkill2 = new Skill("Interception", 0);
		Skill player28DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player28KickingSkill1 = new Skill("Punt", 0);
		Skill player28KickingSkill2 = new Skill("Drop", 0);
		Skill player28KickingSkill3 = new Skill("Place", 0);
		
		Skill player28ContactSkill1 = new Skill("Tackle", 0);
		Skill player28ContactSkill2 = new Skill("Scrum", 0);
		Skill player28ContactSkill3 = new Skill("Carrying", 0);
		
		player28PhysicalSkillList.add(player28PhysicalSkill1); player28PhysicalSkillList.add(player28PhysicalSkill2); player28PhysicalSkillList.add(player28PhysicalSkill3);
		player28MentalSkillList.add(player28MentalSkill1); player28MentalSkillList.add(player28MentalSkill2); player28MentalSkillList.add(player28MentalSkill3); 
		player28AttackSkillList.add(player28AttackSkill1); player28AttackSkillList.add(player28AttackSkill2); player28AttackSkillList.add(player28AttackSkill3);
		player28DefenceSkillList.add(player28DefenceSkill1); player28DefenceSkillList.add(player28DefenceSkill2); player28DefenceSkillList.add(player28DefenceSkill3);
		player28KickingSkillList.add(player28KickingSkill1); player28KickingSkillList.add(player28KickingSkill2); player28KickingSkillList.add(player28KickingSkill3);
		player28ContactSkillList.add(player28ContactSkill1); player28ContactSkillList.add(player28ContactSkill2); player28ContactSkillList.add(player28ContactSkill3);
		
		SkillCategory player28StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player28PhysicalSkillList);
		SkillCategory player28MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player28MentalSkillList);
		SkillCategory player28AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player28AttackSkillList);
		SkillCategory player28DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player28DefenceSkillList);
		SkillCategory player28KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player28KickingSkillList);
		SkillCategory player28ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player28ContactSkillList);
		
		player28SkillCategoryList.add(player28StengthSkillsList); player28SkillCategoryList.add(player28MentalSkillsList); player28SkillCategoryList.add(player28AttackSkillsList);
		player28SkillCategoryList.add(player28DefenceSkillsList); player28SkillCategoryList.add(player28KickingSkillsList); player28SkillCategoryList.add(player28ContactSkillsList);
		
		/**
		 * Player 29
		 */
		ArrayList<Skill> player29PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player29MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player29AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player29DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player29KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player29ContactSkillList = new ArrayList<Skill>();
		
		Skill player29PhysicalSkill1 = new Skill("Speed", 0);
		Skill player29PhysicalSkill2 = new Skill("Strength", 0);
		Skill player29PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player29MentalSkill1 = new Skill("Decision Making", 0);
		Skill player29MentalSkill2 = new Skill("Positioning", 0);
		Skill player29MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player29AttackSkill1 = new Skill("Grip", 0);
		Skill player29AttackSkill2 = new Skill("Fending Off", 0);
		Skill player29AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player29DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player29DefenceSkill2 = new Skill("Interception", 0);
		Skill player29DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player29KickingSkill1 = new Skill("Punt", 0);
		Skill player29KickingSkill2 = new Skill("Drop", 0);
		Skill player29KickingSkill3 = new Skill("Place", 0);
		
		Skill player29ContactSkill1 = new Skill("Tackle", 0);
		Skill player29ContactSkill2 = new Skill("Scrum", 0);
		Skill player29ContactSkill3 = new Skill("Carrying", 0);
		
		player29PhysicalSkillList.add(player29PhysicalSkill1); player29PhysicalSkillList.add(player29PhysicalSkill2); player29PhysicalSkillList.add(player29PhysicalSkill3);
		player29MentalSkillList.add(player29MentalSkill1); player29MentalSkillList.add(player29MentalSkill2); player29MentalSkillList.add(player29MentalSkill3); 
		player29AttackSkillList.add(player29AttackSkill1); player29AttackSkillList.add(player29AttackSkill2); player29AttackSkillList.add(player29AttackSkill3);
		player29DefenceSkillList.add(player29DefenceSkill1); player29DefenceSkillList.add(player29DefenceSkill2); player29DefenceSkillList.add(player29DefenceSkill3);
		player29KickingSkillList.add(player29KickingSkill1); player29KickingSkillList.add(player29KickingSkill2); player29KickingSkillList.add(player29KickingSkill3);
		player29ContactSkillList.add(player29ContactSkill1); player29ContactSkillList.add(player29ContactSkill2); player29ContactSkillList.add(player29ContactSkill3);
		
		SkillCategory player29StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player29PhysicalSkillList);
		SkillCategory player29MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player29MentalSkillList);
		SkillCategory player29AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player29AttackSkillList);
		SkillCategory player29DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player29DefenceSkillList);
		SkillCategory player29KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player29KickingSkillList);
		SkillCategory player29ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player29ContactSkillList);
		
		player29SkillCategoryList.add(player29StengthSkillsList); player29SkillCategoryList.add(player29MentalSkillsList); player29SkillCategoryList.add(player29AttackSkillsList);
		player29SkillCategoryList.add(player29DefenceSkillsList); player29SkillCategoryList.add(player29KickingSkillsList); player29SkillCategoryList.add(player29ContactSkillsList);
		
		/**
		 * Player 30
		 */
		ArrayList<Skill> player30PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player30MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player30AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player30DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player30KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player30ContactSkillList = new ArrayList<Skill>();
		
		Skill player30PhysicalSkill1 = new Skill("Speed", 0);
		Skill player30PhysicalSkill2 = new Skill("Strength", 0);
		Skill player30PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player30MentalSkill1 = new Skill("Decision Making", 0);
		Skill player30MentalSkill2 = new Skill("Positioning", 0);
		Skill player30MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player30AttackSkill1 = new Skill("Grip", 0);
		Skill player30AttackSkill2 = new Skill("Fending Off", 0);
		Skill player30AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player30DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player30DefenceSkill2 = new Skill("Interception", 0);
		Skill player30DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player30KickingSkill1 = new Skill("Punt", 0);
		Skill player30KickingSkill2 = new Skill("Drop", 0);
		Skill player30KickingSkill3 = new Skill("Place", 0);
		
		Skill player30ContactSkill1 = new Skill("Tackle", 0);
		Skill player30ContactSkill2 = new Skill("Scrum", 0);
		Skill player30ContactSkill3 = new Skill("Carrying", 0);
		
		player30PhysicalSkillList.add(player30PhysicalSkill1); player30PhysicalSkillList.add(player30PhysicalSkill2); player30PhysicalSkillList.add(player30PhysicalSkill3);
		player30MentalSkillList.add(player30MentalSkill1); player30MentalSkillList.add(player30MentalSkill2); player30MentalSkillList.add(player30MentalSkill3); 
		player30AttackSkillList.add(player30AttackSkill1); player30AttackSkillList.add(player30AttackSkill2); player30AttackSkillList.add(player30AttackSkill3);
		player30DefenceSkillList.add(player30DefenceSkill1); player30DefenceSkillList.add(player30DefenceSkill2); player30DefenceSkillList.add(player30DefenceSkill3);
		player30KickingSkillList.add(player30KickingSkill1); player30KickingSkillList.add(player30KickingSkill2); player30KickingSkillList.add(player30KickingSkill3);
		player30ContactSkillList.add(player30ContactSkill1); player30ContactSkillList.add(player30ContactSkill2); player30ContactSkillList.add(player30ContactSkill3);
		
		SkillCategory player30StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player30PhysicalSkillList);
		SkillCategory player30MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player30MentalSkillList);
		SkillCategory player30AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player30AttackSkillList);
		SkillCategory player30DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player30DefenceSkillList);
		SkillCategory player30KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player30KickingSkillList);
		SkillCategory player30ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player30ContactSkillList);
		
		player30SkillCategoryList.add(player30StengthSkillsList); player30SkillCategoryList.add(player30MentalSkillsList); player30SkillCategoryList.add(player30AttackSkillsList);
		player30SkillCategoryList.add(player30DefenceSkillsList); player30SkillCategoryList.add(player30KickingSkillsList); player30SkillCategoryList.add(player30ContactSkillsList);
		
		/**
		 * Player 31
		 */
		ArrayList<Skill> player31PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player31MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player31AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player31DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player31KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player31ContactSkillList = new ArrayList<Skill>();
		
		Skill player31PhysicalSkill1 = new Skill("Speed", 0);
		Skill player31PhysicalSkill2 = new Skill("Strength", 0);
		Skill player31PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player31MentalSkill1 = new Skill("Decision Making", 0);
		Skill player31MentalSkill2 = new Skill("Positioning", 0);
		Skill player31MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player31AttackSkill1 = new Skill("Grip", 0);
		Skill player31AttackSkill2 = new Skill("Fending Off", 0);
		Skill player31AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player31DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player31DefenceSkill2 = new Skill("Interception", 0);
		Skill player31DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player31KickingSkill1 = new Skill("Punt", 0);
		Skill player31KickingSkill2 = new Skill("Drop", 0);
		Skill player31KickingSkill3 = new Skill("Place", 0);
		
		Skill player31ContactSkill1 = new Skill("Tackle", 0);
		Skill player31ContactSkill2 = new Skill("Scrum", 0);
		Skill player31ContactSkill3 = new Skill("Carrying", 0);
		
		player31PhysicalSkillList.add(player31PhysicalSkill1); player31PhysicalSkillList.add(player31PhysicalSkill2); player31PhysicalSkillList.add(player31PhysicalSkill3);
		player31MentalSkillList.add(player31MentalSkill1); player31MentalSkillList.add(player31MentalSkill2); player31MentalSkillList.add(player31MentalSkill3); 
		player31AttackSkillList.add(player31AttackSkill1); player31AttackSkillList.add(player31AttackSkill2); player31AttackSkillList.add(player31AttackSkill3);
		player31DefenceSkillList.add(player31DefenceSkill1); player31DefenceSkillList.add(player31DefenceSkill2); player31DefenceSkillList.add(player31DefenceSkill3);
		player31KickingSkillList.add(player31KickingSkill1); player31KickingSkillList.add(player31KickingSkill2); player31KickingSkillList.add(player31KickingSkill3);
		player31ContactSkillList.add(player31ContactSkill1); player31ContactSkillList.add(player31ContactSkill2); player31ContactSkillList.add(player31ContactSkill3);
		
		SkillCategory player31StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player31PhysicalSkillList);
		SkillCategory player31MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player31MentalSkillList);
		SkillCategory player31AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player31AttackSkillList);
		SkillCategory player31DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player31DefenceSkillList);
		SkillCategory player31KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player31KickingSkillList);
		SkillCategory player31ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player31ContactSkillList);
		
		player31SkillCategoryList.add(player31StengthSkillsList); player31SkillCategoryList.add(player31MentalSkillsList); player31SkillCategoryList.add(player31AttackSkillsList);
		player31SkillCategoryList.add(player31DefenceSkillsList); player31SkillCategoryList.add(player31KickingSkillsList); player31SkillCategoryList.add(player31ContactSkillsList);
		
		/**
		 * Player 32
		 */
		ArrayList<Skill> player32PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player32MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player32AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player32DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player32KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player32ContactSkillList = new ArrayList<Skill>();
		
		Skill player32PhysicalSkill1 = new Skill("Speed", 0);
		Skill player32PhysicalSkill2 = new Skill("Strength", 0);
		Skill player32PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player32MentalSkill1 = new Skill("Decision Making", 0);
		Skill player32MentalSkill2 = new Skill("Positioning", 0);
		Skill player32MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player32AttackSkill1 = new Skill("Grip", 0);
		Skill player32AttackSkill2 = new Skill("Fending Off", 0);
		Skill player32AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player32DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player32DefenceSkill2 = new Skill("Interception", 0);
		Skill player32DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player32KickingSkill1 = new Skill("Punt", 0);
		Skill player32KickingSkill2 = new Skill("Drop", 0);
		Skill player32KickingSkill3 = new Skill("Place", 0);
		
		Skill player32ContactSkill1 = new Skill("Tackle", 0);
		Skill player32ContactSkill2 = new Skill("Scrum", 0);
		Skill player32ContactSkill3 = new Skill("Carrying", 0);
		
		player32PhysicalSkillList.add(player32PhysicalSkill1); player32PhysicalSkillList.add(player32PhysicalSkill2); player32PhysicalSkillList.add(player32PhysicalSkill3);
		player32MentalSkillList.add(player32MentalSkill1); player32MentalSkillList.add(player32MentalSkill2); player32MentalSkillList.add(player32MentalSkill3); 
		player32AttackSkillList.add(player32AttackSkill1); player32AttackSkillList.add(player32AttackSkill2); player32AttackSkillList.add(player32AttackSkill3);
		player32DefenceSkillList.add(player32DefenceSkill1); player32DefenceSkillList.add(player32DefenceSkill2); player32DefenceSkillList.add(player32DefenceSkill3);
		player32KickingSkillList.add(player32KickingSkill1); player32KickingSkillList.add(player32KickingSkill2); player32KickingSkillList.add(player32KickingSkill3);
		player32ContactSkillList.add(player32ContactSkill1); player32ContactSkillList.add(player32ContactSkill2); player32ContactSkillList.add(player32ContactSkill3);
		
		SkillCategory player32StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player32PhysicalSkillList);
		SkillCategory player32MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player32MentalSkillList);
		SkillCategory player32AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player32AttackSkillList);
		SkillCategory player32DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player32DefenceSkillList);
		SkillCategory player32KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player32KickingSkillList);
		SkillCategory player32ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player32ContactSkillList);
		
		player32SkillCategoryList.add(player32StengthSkillsList); player32SkillCategoryList.add(player32MentalSkillsList); player32SkillCategoryList.add(player32AttackSkillsList);
		player32SkillCategoryList.add(player32DefenceSkillsList); player32SkillCategoryList.add(player32KickingSkillsList); player32SkillCategoryList.add(player32ContactSkillsList);
		
		/**
		 * Player 33
		 */
		ArrayList<Skill> player33PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player33MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player33AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player33DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player33KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player33ContactSkillList = new ArrayList<Skill>();
		
		Skill player33PhysicalSkill1 = new Skill("Speed", 0);
		Skill player33PhysicalSkill2 = new Skill("Strength", 0);
		Skill player33PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player33MentalSkill1 = new Skill("Decision Making", 0);
		Skill player33MentalSkill2 = new Skill("Positioning", 0);
		Skill player33MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player33AttackSkill1 = new Skill("Grip", 0);
		Skill player33AttackSkill2 = new Skill("Fending Off", 0);
		Skill player33AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player33DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player33DefenceSkill2 = new Skill("Interception", 0);
		Skill player33DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player33KickingSkill1 = new Skill("Punt", 0);
		Skill player33KickingSkill2 = new Skill("Drop", 0);
		Skill player33KickingSkill3 = new Skill("Place", 0);
		
		Skill player33ContactSkill1 = new Skill("Tackle", 0);
		Skill player33ContactSkill2 = new Skill("Scrum", 0);
		Skill player33ContactSkill3 = new Skill("Carrying", 0);
		
		player33PhysicalSkillList.add(player33PhysicalSkill1); player33PhysicalSkillList.add(player33PhysicalSkill2); player33PhysicalSkillList.add(player33PhysicalSkill3);
		player33MentalSkillList.add(player33MentalSkill1); player33MentalSkillList.add(player33MentalSkill2); player33MentalSkillList.add(player33MentalSkill3); 
		player33AttackSkillList.add(player33AttackSkill1); player33AttackSkillList.add(player33AttackSkill2); player33AttackSkillList.add(player33AttackSkill3);
		player33DefenceSkillList.add(player33DefenceSkill1); player33DefenceSkillList.add(player33DefenceSkill2); player33DefenceSkillList.add(player33DefenceSkill3);
		player33KickingSkillList.add(player33KickingSkill1); player33KickingSkillList.add(player33KickingSkill2); player33KickingSkillList.add(player33KickingSkill3);
		player33ContactSkillList.add(player33ContactSkill1); player33ContactSkillList.add(player33ContactSkill2); player33ContactSkillList.add(player33ContactSkill3);
		
		SkillCategory player33StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player33PhysicalSkillList);
		SkillCategory player33MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player33MentalSkillList);
		SkillCategory player33AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player33AttackSkillList);
		SkillCategory player33DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player33DefenceSkillList);
		SkillCategory player33KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player33KickingSkillList);
		SkillCategory player33ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player33ContactSkillList);
		
		player33SkillCategoryList.add(player33StengthSkillsList); player33SkillCategoryList.add(player33MentalSkillsList); player33SkillCategoryList.add(player33AttackSkillsList);
		player33SkillCategoryList.add(player33DefenceSkillsList); player33SkillCategoryList.add(player33KickingSkillsList); player33SkillCategoryList.add(player33ContactSkillsList);
		
		/**
		 * Player 34
		 */
		ArrayList<Skill> player34PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player34MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player34AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player34DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player34KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player34ContactSkillList = new ArrayList<Skill>();
		
		Skill player34PhysicalSkill1 = new Skill("Speed", 0);
		Skill player34PhysicalSkill2 = new Skill("Strength", 0);
		Skill player34PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player34MentalSkill1 = new Skill("Decision Making", 0);
		Skill player34MentalSkill2 = new Skill("Positioning", 0);
		Skill player34MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player34AttackSkill1 = new Skill("Grip", 0);
		Skill player34AttackSkill2 = new Skill("Fending Off", 0);
		Skill player34AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player34DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player34DefenceSkill2 = new Skill("Interception", 0);
		Skill player34DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player34KickingSkill1 = new Skill("Punt", 0);
		Skill player34KickingSkill2 = new Skill("Drop", 0);
		Skill player34KickingSkill3 = new Skill("Place", 0);
		
		Skill player34ContactSkill1 = new Skill("Tackle", 0);
		Skill player34ContactSkill2 = new Skill("Scrum", 0);
		Skill player34ContactSkill3 = new Skill("Carrying", 0);
		
		player34PhysicalSkillList.add(player34PhysicalSkill1); player34PhysicalSkillList.add(player34PhysicalSkill2); player34PhysicalSkillList.add(player34PhysicalSkill3);
		player34MentalSkillList.add(player34MentalSkill1); player34MentalSkillList.add(player34MentalSkill2); player34MentalSkillList.add(player34MentalSkill3); 
		player34AttackSkillList.add(player34AttackSkill1); player34AttackSkillList.add(player34AttackSkill2); player34AttackSkillList.add(player34AttackSkill3);
		player34DefenceSkillList.add(player34DefenceSkill1); player34DefenceSkillList.add(player34DefenceSkill2); player34DefenceSkillList.add(player34DefenceSkill3);
		player34KickingSkillList.add(player34KickingSkill1); player34KickingSkillList.add(player34KickingSkill2); player34KickingSkillList.add(player34KickingSkill3);
		player34ContactSkillList.add(player34ContactSkill1); player34ContactSkillList.add(player34ContactSkill2); player34ContactSkillList.add(player34ContactSkill3);
		
		SkillCategory player34StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player34PhysicalSkillList);
		SkillCategory player34MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player34MentalSkillList);
		SkillCategory player34AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player34AttackSkillList);
		SkillCategory player34DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player34DefenceSkillList);
		SkillCategory player34KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player34KickingSkillList);
		SkillCategory player34ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player34ContactSkillList);
		
		player34SkillCategoryList.add(player34StengthSkillsList); player34SkillCategoryList.add(player34MentalSkillsList); player34SkillCategoryList.add(player34AttackSkillsList);
		player34SkillCategoryList.add(player34DefenceSkillsList); player34SkillCategoryList.add(player34KickingSkillsList); player34SkillCategoryList.add(player34ContactSkillsList);
		
		/**
		 * Player 35
		 */
		ArrayList<Skill> player35PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player35MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player35AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player35DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player35KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player35ContactSkillList = new ArrayList<Skill>();
		
		Skill player35PhysicalSkill1 = new Skill("Speed", 0);
		Skill player35PhysicalSkill2 = new Skill("Strength", 0);
		Skill player35PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player35MentalSkill1 = new Skill("Decision Making", 0);
		Skill player35MentalSkill2 = new Skill("Positioning", 0);
		Skill player35MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player35AttackSkill1 = new Skill("Grip", 0);
		Skill player35AttackSkill2 = new Skill("Fending Off", 0);
		Skill player35AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player35DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player35DefenceSkill2 = new Skill("Interception", 0);
		Skill player35DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player35KickingSkill1 = new Skill("Punt", 0);
		Skill player35KickingSkill2 = new Skill("Drop", 0);
		Skill player35KickingSkill3 = new Skill("Place", 0);
		
		Skill player35ContactSkill1 = new Skill("Tackle", 0);
		Skill player35ContactSkill2 = new Skill("Scrum", 0);
		Skill player35ContactSkill3 = new Skill("Carrying", 0);
		
		player35PhysicalSkillList.add(player35PhysicalSkill1); player35PhysicalSkillList.add(player35PhysicalSkill2); player35PhysicalSkillList.add(player35PhysicalSkill3);
		player35MentalSkillList.add(player35MentalSkill1); player35MentalSkillList.add(player35MentalSkill2); player35MentalSkillList.add(player35MentalSkill3); 
		player35AttackSkillList.add(player35AttackSkill1); player35AttackSkillList.add(player35AttackSkill2); player35AttackSkillList.add(player35AttackSkill3);
		player35DefenceSkillList.add(player35DefenceSkill1); player35DefenceSkillList.add(player35DefenceSkill2); player35DefenceSkillList.add(player35DefenceSkill3);
		player35KickingSkillList.add(player35KickingSkill1); player35KickingSkillList.add(player35KickingSkill2); player35KickingSkillList.add(player35KickingSkill3);
		player35ContactSkillList.add(player35ContactSkill1); player35ContactSkillList.add(player35ContactSkill2); player35ContactSkillList.add(player35ContactSkill3);
		
		SkillCategory player35StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player35PhysicalSkillList);
		SkillCategory player35MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player35MentalSkillList);
		SkillCategory player35AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player35AttackSkillList);
		SkillCategory player35DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player35DefenceSkillList);
		SkillCategory player35KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player35KickingSkillList);
		SkillCategory player35ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player35ContactSkillList);
		
		player35SkillCategoryList.add(player35StengthSkillsList); player35SkillCategoryList.add(player35MentalSkillsList); player35SkillCategoryList.add(player35AttackSkillsList);
		player35SkillCategoryList.add(player35DefenceSkillsList); player35SkillCategoryList.add(player35KickingSkillsList); player35SkillCategoryList.add(player35ContactSkillsList);
		
		/**
		 * Player 36
		 */
		ArrayList<Skill> player36PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player36MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player36AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player36DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player36KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player36ContactSkillList = new ArrayList<Skill>();
		
		Skill player36PhysicalSkill1 = new Skill("Speed", 0);
		Skill player36PhysicalSkill2 = new Skill("Strength", 0);
		Skill player36PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player36MentalSkill1 = new Skill("Decision Making", 0);
		Skill player36MentalSkill2 = new Skill("Positioning", 0);
		Skill player36MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player36AttackSkill1 = new Skill("Grip", 0);
		Skill player36AttackSkill2 = new Skill("Fending Off", 0);
		Skill player36AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player36DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player36DefenceSkill2 = new Skill("Interception", 0);
		Skill player36DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player36KickingSkill1 = new Skill("Punt", 0);
		Skill player36KickingSkill2 = new Skill("Drop", 0);
		Skill player36KickingSkill3 = new Skill("Place", 0);
		
		Skill player36ContactSkill1 = new Skill("Tackle", 0);
		Skill player36ContactSkill2 = new Skill("Scrum", 0);
		Skill player36ContactSkill3 = new Skill("Carrying", 0);
		
		player36PhysicalSkillList.add(player36PhysicalSkill1); player36PhysicalSkillList.add(player36PhysicalSkill2); player36PhysicalSkillList.add(player36PhysicalSkill3);
		player36MentalSkillList.add(player36MentalSkill1); player36MentalSkillList.add(player36MentalSkill2); player36MentalSkillList.add(player36MentalSkill3); 
		player36AttackSkillList.add(player36AttackSkill1); player36AttackSkillList.add(player36AttackSkill2); player36AttackSkillList.add(player36AttackSkill3);
		player36DefenceSkillList.add(player36DefenceSkill1); player36DefenceSkillList.add(player36DefenceSkill2); player36DefenceSkillList.add(player36DefenceSkill3);
		player36KickingSkillList.add(player36KickingSkill1); player36KickingSkillList.add(player36KickingSkill2); player36KickingSkillList.add(player36KickingSkill3);
		player36ContactSkillList.add(player36ContactSkill1); player36ContactSkillList.add(player36ContactSkill2); player36ContactSkillList.add(player36ContactSkill3);
		
		SkillCategory player36StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player36PhysicalSkillList);
		SkillCategory player36MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player36MentalSkillList);
		SkillCategory player36AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player36AttackSkillList);
		SkillCategory player36DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player36DefenceSkillList);
		SkillCategory player36KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player36KickingSkillList);
		SkillCategory player36ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player36ContactSkillList);
		
		player36SkillCategoryList.add(player36StengthSkillsList); player36SkillCategoryList.add(player36MentalSkillsList); player36SkillCategoryList.add(player36AttackSkillsList);
		player36SkillCategoryList.add(player36DefenceSkillsList); player36SkillCategoryList.add(player36KickingSkillsList); player36SkillCategoryList.add(player36ContactSkillsList);
		
		/**
		 * Player 37
		 */
		ArrayList<Skill> player37PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player37MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player37AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player37DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player37KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player37ContactSkillList = new ArrayList<Skill>();
		
		Skill player37PhysicalSkill1 = new Skill("Speed", 0);
		Skill player37PhysicalSkill2 = new Skill("Strength", 0);
		Skill player37PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player37MentalSkill1 = new Skill("Decision Making", 0);
		Skill player37MentalSkill2 = new Skill("Positioning", 0);
		Skill player37MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player37AttackSkill1 = new Skill("Grip", 0);
		Skill player37AttackSkill2 = new Skill("Fending Off", 0);
		Skill player37AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player37DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player37DefenceSkill2 = new Skill("Interception", 0);
		Skill player37DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player37KickingSkill1 = new Skill("Punt", 0);
		Skill player37KickingSkill2 = new Skill("Drop", 0);
		Skill player37KickingSkill3 = new Skill("Place", 0);
		
		Skill player37ContactSkill1 = new Skill("Tackle", 0);
		Skill player37ContactSkill2 = new Skill("Scrum", 0);
		Skill player37ContactSkill3 = new Skill("Carrying", 0);
		
		player37PhysicalSkillList.add(player37PhysicalSkill1); player37PhysicalSkillList.add(player37PhysicalSkill2); player37PhysicalSkillList.add(player37PhysicalSkill3);
		player37MentalSkillList.add(player37MentalSkill1); player37MentalSkillList.add(player37MentalSkill2); player37MentalSkillList.add(player37MentalSkill3); 
		player37AttackSkillList.add(player37AttackSkill1); player37AttackSkillList.add(player37AttackSkill2); player37AttackSkillList.add(player37AttackSkill3);
		player37DefenceSkillList.add(player37DefenceSkill1); player37DefenceSkillList.add(player37DefenceSkill2); player37DefenceSkillList.add(player37DefenceSkill3);
		player37KickingSkillList.add(player37KickingSkill1); player37KickingSkillList.add(player37KickingSkill2); player37KickingSkillList.add(player37KickingSkill3);
		player37ContactSkillList.add(player37ContactSkill1); player37ContactSkillList.add(player37ContactSkill2); player37ContactSkillList.add(player37ContactSkill3);
		
		SkillCategory player37StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player37PhysicalSkillList);
		SkillCategory player37MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player37MentalSkillList);
		SkillCategory player37AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player37AttackSkillList);
		SkillCategory player37DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player37DefenceSkillList);
		SkillCategory player37KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player37KickingSkillList);
		SkillCategory player37ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player37ContactSkillList);
		
		player37SkillCategoryList.add(player37StengthSkillsList); player37SkillCategoryList.add(player37MentalSkillsList); player37SkillCategoryList.add(player37AttackSkillsList);
		player37SkillCategoryList.add(player37DefenceSkillsList); player37SkillCategoryList.add(player37KickingSkillsList); player37SkillCategoryList.add(player37ContactSkillsList);
		
		/**
		 * Player 38
		 */
		ArrayList<Skill> player38PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player38MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player38AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player38DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player38KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player38ContactSkillList = new ArrayList<Skill>();
		
		Skill player38PhysicalSkill1 = new Skill("Speed", 0);
		Skill player38PhysicalSkill2 = new Skill("Strength", 0);
		Skill player38PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player38MentalSkill1 = new Skill("Decision Making", 0);
		Skill player38MentalSkill2 = new Skill("Positioning", 0);
		Skill player38MentalSkill3 = new Skill("Knowledge", 0);
		
		Skill player38AttackSkill1 = new Skill("Grip", 0);
		Skill player38AttackSkill2 = new Skill("Fending Off", 0);
		Skill player38AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player38DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player38DefenceSkill2 = new Skill("Interception", 0);
		Skill player38DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player38KickingSkill1 = new Skill("Punt", 0);
		Skill player38KickingSkill2 = new Skill("Drop", 0);
		Skill player38KickingSkill3 = new Skill("Place", 0);
		
		Skill player38ContactSkill1 = new Skill("Tackle", 0);
		Skill player38ContactSkill2 = new Skill("Scrum", 0);
		Skill player38ContactSkill3 = new Skill("Carrying", 0);
		
		player38PhysicalSkillList.add(player38PhysicalSkill1); player38PhysicalSkillList.add(player38PhysicalSkill2); player38PhysicalSkillList.add(player38PhysicalSkill3);
		player38MentalSkillList.add(player38MentalSkill1); player38MentalSkillList.add(player38MentalSkill2); player38MentalSkillList.add(player38MentalSkill3); 
		player38AttackSkillList.add(player38AttackSkill1); player38AttackSkillList.add(player38AttackSkill2); player38AttackSkillList.add(player38AttackSkill3);
		player38DefenceSkillList.add(player38DefenceSkill1); player38DefenceSkillList.add(player38DefenceSkill2); player38DefenceSkillList.add(player38DefenceSkill3);
		player38KickingSkillList.add(player38KickingSkill1); player38KickingSkillList.add(player38KickingSkill2); player38KickingSkillList.add(player38KickingSkill3);
		player38ContactSkillList.add(player38ContactSkill1); player38ContactSkillList.add(player38ContactSkill2); player38ContactSkillList.add(player38ContactSkill3);
		
		SkillCategory player38StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player38PhysicalSkillList);
		SkillCategory player38MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player38MentalSkillList);
		SkillCategory player38AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player38AttackSkillList);
		SkillCategory player38DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player38DefenceSkillList);
		SkillCategory player38KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player38KickingSkillList);
		SkillCategory player38ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player38ContactSkillList);
		
		player38SkillCategoryList.add(player38StengthSkillsList); player38SkillCategoryList.add(player38MentalSkillsList); player38SkillCategoryList.add(player38AttackSkillsList);
		player38SkillCategoryList.add(player38DefenceSkillsList); player38SkillCategoryList.add(player38KickingSkillsList); player38SkillCategoryList.add(player38ContactSkillsList);
		
		/**
		 * Player 39
		 */
		ArrayList<Skill> player39PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player39MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player39AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player39DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player39KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player39ContactSkillList = new ArrayList<Skill>();
		
		Skill player39PhysicalSkill1 = new Skill("Speed", 0);
		Skill player39PhysicalSkill2 = new Skill("Strength", 0);
		Skill player39PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player39MentalSkill1 = new Skill("Decision Making", 0);
		Skill player39MentalSkill2 = new Skill("Positioning", 0);
		Skill player39MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player39AttackSkill1 = new Skill("Grip", 0);
		Skill player39AttackSkill2 = new Skill("Fending Off", 0);
		Skill player39AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player39DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player39DefenceSkill2 = new Skill("Interception", 0);
		Skill player39DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player39KickingSkill1 = new Skill("Punt", 0);
		Skill player39KickingSkill2 = new Skill("Drop", 0);
		Skill player39KickingSkill3 = new Skill("Place", 0);
		
		Skill player39ContactSkill1 = new Skill("Tackle", 0);
		Skill player39ContactSkill2 = new Skill("Scrum", 0);
		Skill player39ContactSkill3 = new Skill("Carrying", 0);
		
		player39PhysicalSkillList.add(player39PhysicalSkill1); player39PhysicalSkillList.add(player39PhysicalSkill2); player39PhysicalSkillList.add(player39PhysicalSkill3);
		player39MentalSkillList.add(player39MentalSkill1); player39MentalSkillList.add(player39MentalSkill2); player39MentalSkillList.add(player39MentalSkill3); 
		player39AttackSkillList.add(player39AttackSkill1); player39AttackSkillList.add(player39AttackSkill2); player39AttackSkillList.add(player39AttackSkill3);
		player39DefenceSkillList.add(player39DefenceSkill1); player39DefenceSkillList.add(player39DefenceSkill2); player39DefenceSkillList.add(player39DefenceSkill3);
		player39KickingSkillList.add(player39KickingSkill1); player39KickingSkillList.add(player39KickingSkill2); player39KickingSkillList.add(player39KickingSkill3);
		player39ContactSkillList.add(player39ContactSkill1); player39ContactSkillList.add(player39ContactSkill2); player39ContactSkillList.add(player39ContactSkill3);
		
		SkillCategory player39StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player39PhysicalSkillList);
		SkillCategory player39MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player39MentalSkillList);
		SkillCategory player39AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player39AttackSkillList);
		SkillCategory player39DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player39DefenceSkillList);
		SkillCategory player39KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player39KickingSkillList);
		SkillCategory player39ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player39ContactSkillList);
		
		player39SkillCategoryList.add(player39StengthSkillsList); player39SkillCategoryList.add(player39MentalSkillsList); player39SkillCategoryList.add(player39AttackSkillsList);
		player39SkillCategoryList.add(player39DefenceSkillsList); player39SkillCategoryList.add(player39KickingSkillsList); player39SkillCategoryList.add(player39ContactSkillsList);
		
		/**
		 * Player 40
		 */
		ArrayList<Skill> player40PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player40MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player40AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player40DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player40KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player40ContactSkillList = new ArrayList<Skill>();
		
		Skill player40PhysicalSkill1 = new Skill("Speed", 0);
		Skill player40PhysicalSkill2 = new Skill("Strength", 0);
		Skill player40PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player40MentalSkill1 = new Skill("Decision Making", 0);
		Skill player40MentalSkill2 = new Skill("Positioning", 0);
		Skill player40MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player40AttackSkill1 = new Skill("Grip", 0);
		Skill player40AttackSkill2 = new Skill("Fending Off", 0);
		Skill player40AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player40DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player40DefenceSkill2 = new Skill("Interception", 0);
		Skill player40DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player40KickingSkill1 = new Skill("Punt", 0);
		Skill player40KickingSkill2 = new Skill("Drop", 0);
		Skill player40KickingSkill3 = new Skill("Place", 0);
		
		Skill player40ContactSkill1 = new Skill("Tackle", 0);
		Skill player40ContactSkill2 = new Skill("Scrum", 0);
		Skill player40ContactSkill3 = new Skill("Carrying", 0);
		
		player40PhysicalSkillList.add(player40PhysicalSkill1); player40PhysicalSkillList.add(player40PhysicalSkill2); player40PhysicalSkillList.add(player40PhysicalSkill3);
		player40MentalSkillList.add(player40MentalSkill1); player40MentalSkillList.add(player40MentalSkill2); player40MentalSkillList.add(player40MentalSkill3); 
		player40AttackSkillList.add(player40AttackSkill1); player40AttackSkillList.add(player40AttackSkill2); player40AttackSkillList.add(player40AttackSkill3);
		player40DefenceSkillList.add(player40DefenceSkill1); player40DefenceSkillList.add(player40DefenceSkill2); player40DefenceSkillList.add(player40DefenceSkill3);
		player40KickingSkillList.add(player40KickingSkill1); player40KickingSkillList.add(player40KickingSkill2); player40KickingSkillList.add(player40KickingSkill3);
		player40ContactSkillList.add(player40ContactSkill1); player40ContactSkillList.add(player40ContactSkill2); player40ContactSkillList.add(player40ContactSkill3);
		
		SkillCategory player40StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player40PhysicalSkillList);
		SkillCategory player40MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player40MentalSkillList);
		SkillCategory player40AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player40AttackSkillList);
		SkillCategory player40DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player40DefenceSkillList);
		SkillCategory player40KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player40KickingSkillList);
		SkillCategory player40ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player40ContactSkillList);
		
		player40SkillCategoryList.add(player40StengthSkillsList); player40SkillCategoryList.add(player40MentalSkillsList); player40SkillCategoryList.add(player40AttackSkillsList);
		player40SkillCategoryList.add(player40DefenceSkillsList); player40SkillCategoryList.add(player40KickingSkillsList); player40SkillCategoryList.add(player40ContactSkillsList);
		
		/**
		 * Player 41
		 */
		ArrayList<Skill> player41PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player41MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player41AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player41DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player41KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player41ContactSkillList = new ArrayList<Skill>();
		
		Skill player41PhysicalSkill1 = new Skill("Speed", 0);
		Skill player41PhysicalSkill2 = new Skill("Strength", 0);
		Skill player41PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player41MentalSkill1 = new Skill("Decision Making", 0);
		Skill player41MentalSkill2 = new Skill("Positioning", 0);
		Skill player41MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player41AttackSkill1 = new Skill("Grip", 0);
		Skill player41AttackSkill2 = new Skill("Fending Off", 0);
		Skill player41AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player41DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player41DefenceSkill2 = new Skill("Interception", 0);
		Skill player41DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player41KickingSkill1 = new Skill("Punt", 0);
		Skill player41KickingSkill2 = new Skill("Drop", 0);
		Skill player41KickingSkill3 = new Skill("Place", 0);
		
		Skill player41ContactSkill1 = new Skill("Tackle", 0);
		Skill player41ContactSkill2 = new Skill("Scrum", 0);
		Skill player41ContactSkill3 = new Skill("Carrying", 0);
		
		player41PhysicalSkillList.add(player41PhysicalSkill1); player41PhysicalSkillList.add(player41PhysicalSkill2); player41PhysicalSkillList.add(player41PhysicalSkill3);
		player41MentalSkillList.add(player41MentalSkill1); player41MentalSkillList.add(player41MentalSkill2); player41MentalSkillList.add(player41MentalSkill3); 
		player41AttackSkillList.add(player41AttackSkill1); player41AttackSkillList.add(player41AttackSkill2); player41AttackSkillList.add(player41AttackSkill3);
		player41DefenceSkillList.add(player41DefenceSkill1); player41DefenceSkillList.add(player41DefenceSkill2); player41DefenceSkillList.add(player41DefenceSkill3);
		player41KickingSkillList.add(player41KickingSkill1); player41KickingSkillList.add(player41KickingSkill2); player41KickingSkillList.add(player41KickingSkill3);
		player41ContactSkillList.add(player41ContactSkill1); player41ContactSkillList.add(player41ContactSkill2); player41ContactSkillList.add(player41ContactSkill3);
		
		SkillCategory player41StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player41PhysicalSkillList);
		SkillCategory player41MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player41MentalSkillList);
		SkillCategory player41AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player41AttackSkillList);
		SkillCategory player41DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player41DefenceSkillList);
		SkillCategory player41KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player41KickingSkillList);
		SkillCategory player41ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player41ContactSkillList);
		
		player41SkillCategoryList.add(player41StengthSkillsList); player41SkillCategoryList.add(player41MentalSkillsList); player41SkillCategoryList.add(player41AttackSkillsList);
		player41SkillCategoryList.add(player41DefenceSkillsList); player41SkillCategoryList.add(player41KickingSkillsList); player41SkillCategoryList.add(player41ContactSkillsList);
		
		/**
		 * Player 42
		 */
		ArrayList<Skill> player42PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player42MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player42AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player42DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player42KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player42ContactSkillList = new ArrayList<Skill>();
		
		Skill player42PhysicalSkill1 = new Skill("Speed", 0);
		Skill player42PhysicalSkill2 = new Skill("Strength", 0);
		Skill player42PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player42MentalSkill1 = new Skill("Decision Making", 0);
		Skill player42MentalSkill2 = new Skill("Positioning", 0);
		Skill player42MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player42AttackSkill1 = new Skill("Grip", 0);
		Skill player42AttackSkill2 = new Skill("Fending Off", 0);
		Skill player42AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player42DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player42DefenceSkill2 = new Skill("Interception", 0);
		Skill player42DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player42KickingSkill1 = new Skill("Punt", 0);
		Skill player42KickingSkill2 = new Skill("Drop", 0);
		Skill player42KickingSkill3 = new Skill("Place", 0);
		
		Skill player42ContactSkill1 = new Skill("Tackle", 0);
		Skill player42ContactSkill2 = new Skill("Scrum", 0);
		Skill player42ContactSkill3 = new Skill("Carrying", 0);
		
		player42PhysicalSkillList.add(player42PhysicalSkill1); player42PhysicalSkillList.add(player42PhysicalSkill2); player42PhysicalSkillList.add(player42PhysicalSkill3);
		player42MentalSkillList.add(player42MentalSkill1); player42MentalSkillList.add(player42MentalSkill2); player42MentalSkillList.add(player42MentalSkill3); 
		player42AttackSkillList.add(player42AttackSkill1); player42AttackSkillList.add(player42AttackSkill2); player42AttackSkillList.add(player42AttackSkill3);
		player42DefenceSkillList.add(player42DefenceSkill1); player42DefenceSkillList.add(player42DefenceSkill2); player42DefenceSkillList.add(player42DefenceSkill3);
		player42KickingSkillList.add(player42KickingSkill1); player42KickingSkillList.add(player42KickingSkill2); player42KickingSkillList.add(player42KickingSkill3);
		player42ContactSkillList.add(player42ContactSkill1); player42ContactSkillList.add(player42ContactSkill2); player42ContactSkillList.add(player42ContactSkill3);
		
		SkillCategory player42StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player42PhysicalSkillList);
		SkillCategory player42MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player42MentalSkillList);
		SkillCategory player42AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player42AttackSkillList);
		SkillCategory player42DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player42DefenceSkillList);
		SkillCategory player42KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player42KickingSkillList);
		SkillCategory player42ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player42ContactSkillList);
		
		player42SkillCategoryList.add(player42StengthSkillsList); player42SkillCategoryList.add(player42MentalSkillsList); player42SkillCategoryList.add(player42AttackSkillsList);
		player42SkillCategoryList.add(player42DefenceSkillsList); player42SkillCategoryList.add(player42KickingSkillsList); player42SkillCategoryList.add(player42ContactSkillsList);
		
		/**
		 * Player 43
		 */
		ArrayList<Skill> player43PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player43MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player43AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player43DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player43KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player43ContactSkillList = new ArrayList<Skill>();
		
		Skill player43PhysicalSkill1 = new Skill("Speed", 0);
		Skill player43PhysicalSkill2 = new Skill("Strength", 0);
		Skill player43PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player43MentalSkill1 = new Skill("Decision Making", 0);
		Skill player43MentalSkill2 = new Skill("Positioning", 0);
		Skill player43MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player43AttackSkill1 = new Skill("Grip", 0);
		Skill player43AttackSkill2 = new Skill("Fending Off", 0);
		Skill player43AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player43DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player43DefenceSkill2 = new Skill("Interception", 0);
		Skill player43DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player43KickingSkill1 = new Skill("Punt", 0);
		Skill player43KickingSkill2 = new Skill("Drop", 0);
		Skill player43KickingSkill3 = new Skill("Place", 0);
		
		Skill player43ContactSkill1 = new Skill("Tackle", 0);
		Skill player43ContactSkill2 = new Skill("Scrum", 0);
		Skill player43ContactSkill3 = new Skill("Carrying", 0);
		
		player43PhysicalSkillList.add(player43PhysicalSkill1); player43PhysicalSkillList.add(player43PhysicalSkill2); player43PhysicalSkillList.add(player43PhysicalSkill3);
		player43MentalSkillList.add(player43MentalSkill1); player43MentalSkillList.add(player43MentalSkill2); player43MentalSkillList.add(player43MentalSkill3); 
		player43AttackSkillList.add(player43AttackSkill1); player43AttackSkillList.add(player43AttackSkill2); player43AttackSkillList.add(player43AttackSkill3);
		player43DefenceSkillList.add(player43DefenceSkill1); player43DefenceSkillList.add(player43DefenceSkill2); player43DefenceSkillList.add(player43DefenceSkill3);
		player43KickingSkillList.add(player43KickingSkill1); player43KickingSkillList.add(player43KickingSkill2); player43KickingSkillList.add(player43KickingSkill3);
		player43ContactSkillList.add(player43ContactSkill1); player43ContactSkillList.add(player43ContactSkill2); player43ContactSkillList.add(player43ContactSkill3);
		
		SkillCategory player43StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player43PhysicalSkillList);
		SkillCategory player43MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player43MentalSkillList);
		SkillCategory player43AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player43AttackSkillList);
		SkillCategory player43DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player43DefenceSkillList);
		SkillCategory player43KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player43KickingSkillList);
		SkillCategory player43ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player43ContactSkillList);
		
		player43SkillCategoryList.add(player43StengthSkillsList); player43SkillCategoryList.add(player43MentalSkillsList); player43SkillCategoryList.add(player43AttackSkillsList);
		player43SkillCategoryList.add(player43DefenceSkillsList); player43SkillCategoryList.add(player43KickingSkillsList); player43SkillCategoryList.add(player43ContactSkillsList);
		
		
		/**
		 * Player 44
		 */
		ArrayList<Skill> player44PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player44MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player44AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player44DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player44KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player44ContactSkillList = new ArrayList<Skill>();
		
		Skill player44PhysicalSkill1 = new Skill("Speed", 0);
		Skill player44PhysicalSkill2 = new Skill("Strength", 0);
		Skill player44PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player44MentalSkill1 = new Skill("Decision Making", 0);
		Skill player44MentalSkill2 = new Skill("Positioning", 0);
		Skill player44MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player44AttackSkill1 = new Skill("Grip", 0);
		Skill player44AttackSkill2 = new Skill("Fending Off", 0);
		Skill player44AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player44DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player44DefenceSkill2 = new Skill("Interception", 0);
		Skill player44DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player44KickingSkill1 = new Skill("Punt", 0);
		Skill player44KickingSkill2 = new Skill("Drop", 0);
		Skill player44KickingSkill3 = new Skill("Place", 0);
		
		Skill player44ContactSkill1 = new Skill("Tackle", 0);
		Skill player44ContactSkill2 = new Skill("Scrum", 0);
		Skill player44ContactSkill3 = new Skill("Carrying", 0);
		
		player44PhysicalSkillList.add(player44PhysicalSkill1); player44PhysicalSkillList.add(player44PhysicalSkill2); player44PhysicalSkillList.add(player44PhysicalSkill3);
		player44MentalSkillList.add(player44MentalSkill1); player44MentalSkillList.add(player44MentalSkill2); player44MentalSkillList.add(player44MentalSkill3); 
		player44AttackSkillList.add(player44AttackSkill1); player44AttackSkillList.add(player44AttackSkill2); player44AttackSkillList.add(player44AttackSkill3);
		player44DefenceSkillList.add(player44DefenceSkill1); player44DefenceSkillList.add(player44DefenceSkill2); player44DefenceSkillList.add(player44DefenceSkill3);
		player44KickingSkillList.add(player44KickingSkill1); player44KickingSkillList.add(player44KickingSkill2); player44KickingSkillList.add(player44KickingSkill3);
		player44ContactSkillList.add(player44ContactSkill1); player44ContactSkillList.add(player44ContactSkill2); player44ContactSkillList.add(player44ContactSkill3);
		
		SkillCategory player44StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player44PhysicalSkillList);
		SkillCategory player44MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player44MentalSkillList);
		SkillCategory player44AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player44AttackSkillList);
		SkillCategory player44DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player44DefenceSkillList);
		SkillCategory player44KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player44KickingSkillList);
		SkillCategory player44ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player44ContactSkillList);
		
		player44SkillCategoryList.add(player44StengthSkillsList); player44SkillCategoryList.add(player44MentalSkillsList); player44SkillCategoryList.add(player44AttackSkillsList);
		player44SkillCategoryList.add(player44DefenceSkillsList); player44SkillCategoryList.add(player44KickingSkillsList); player44SkillCategoryList.add(player44ContactSkillsList);
		
		/**
		 * Player 45
		 */
		ArrayList<Skill> player45PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player45MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player45AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player45DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player45KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player45ContactSkillList = new ArrayList<Skill>();
		
		Skill player45PhysicalSkill1 = new Skill("Speed", 0);
		Skill player45PhysicalSkill2 = new Skill("Strength", 0);
		Skill player45PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player45MentalSkill1 = new Skill("Decision Making", 0);
		Skill player45MentalSkill2 = new Skill("Positioning", 0);
		Skill player45MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player45AttackSkill1 = new Skill("Grip", 0);
		Skill player45AttackSkill2 = new Skill("Fending Off", 0);
		Skill player45AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player45DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player45DefenceSkill2 = new Skill("Interception", 0);
		Skill player45DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player45KickingSkill1 = new Skill("Punt", 0);
		Skill player45KickingSkill2 = new Skill("Drop", 0);
		Skill player45KickingSkill3 = new Skill("Place", 0);
		
		Skill player45ContactSkill1 = new Skill("Tackle", 0);
		Skill player45ContactSkill2 = new Skill("Scrum", 0);
		Skill player45ContactSkill3 = new Skill("Carrying", 0);
		
		player45PhysicalSkillList.add(player45PhysicalSkill1); player45PhysicalSkillList.add(player45PhysicalSkill2); player45PhysicalSkillList.add(player45PhysicalSkill3);
		player45MentalSkillList.add(player45MentalSkill1); player45MentalSkillList.add(player45MentalSkill2); player45MentalSkillList.add(player45MentalSkill3); 
		player45AttackSkillList.add(player45AttackSkill1); player45AttackSkillList.add(player45AttackSkill2); player45AttackSkillList.add(player45AttackSkill3);
		player45DefenceSkillList.add(player45DefenceSkill1); player45DefenceSkillList.add(player45DefenceSkill2); player45DefenceSkillList.add(player45DefenceSkill3);
		player45KickingSkillList.add(player45KickingSkill1); player45KickingSkillList.add(player45KickingSkill2); player45KickingSkillList.add(player45KickingSkill3);
		player45ContactSkillList.add(player45ContactSkill1); player45ContactSkillList.add(player45ContactSkill2); player45ContactSkillList.add(player45ContactSkill3);
		
		SkillCategory player45StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player45PhysicalSkillList);
		SkillCategory player45MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player45MentalSkillList);
		SkillCategory player45AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player45AttackSkillList);
		SkillCategory player45DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player45DefenceSkillList);
		SkillCategory player45KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player45KickingSkillList);
		SkillCategory player45ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player45ContactSkillList);
		
		player45SkillCategoryList.add(player45StengthSkillsList); player45SkillCategoryList.add(player45MentalSkillsList); player45SkillCategoryList.add(player45AttackSkillsList);
		player45SkillCategoryList.add(player45DefenceSkillsList); player45SkillCategoryList.add(player45KickingSkillsList); player45SkillCategoryList.add(player45ContactSkillsList);
		
		/**
		 * Player 46
		 */
		ArrayList<Skill> player46PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player46MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player46AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player46DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player46KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player46ContactSkillList = new ArrayList<Skill>();
		
		Skill player46PhysicalSkill1 = new Skill("Speed", 0);
		Skill player46PhysicalSkill2 = new Skill("Strength", 0);
		Skill player46PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player46MentalSkill1 = new Skill("Decision Making", 0);
		Skill player46MentalSkill2 = new Skill("Positioning", 0);
		Skill player46MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player46AttackSkill1 = new Skill("Grip", 0);
		Skill player46AttackSkill2 = new Skill("Fending Off", 0);
		Skill player46AttackSkill3 = new Skill("Realignment", 0);
		
		Skill player46DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player46DefenceSkill2 = new Skill("Interception", 0);
		Skill player46DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player46KickingSkill1 = new Skill("Punt", 0);
		Skill player46KickingSkill2 = new Skill("Drop", 0);
		Skill player46KickingSkill3 = new Skill("Place", 0);
		
		Skill player46ContactSkill1 = new Skill("Tackle", 0);
		Skill player46ContactSkill2 = new Skill("Scrum", 0);
		Skill player46ContactSkill3 = new Skill("Carrying", 0);
		
		player46PhysicalSkillList.add(player46PhysicalSkill1); player46PhysicalSkillList.add(player46PhysicalSkill2); player46PhysicalSkillList.add(player46PhysicalSkill3);
		player46MentalSkillList.add(player46MentalSkill1); player46MentalSkillList.add(player46MentalSkill2); player46MentalSkillList.add(player46MentalSkill3); 
		player46AttackSkillList.add(player46AttackSkill1); player46AttackSkillList.add(player46AttackSkill2); player46AttackSkillList.add(player46AttackSkill3);
		player46DefenceSkillList.add(player46DefenceSkill1); player46DefenceSkillList.add(player46DefenceSkill2); player46DefenceSkillList.add(player46DefenceSkill3);
		player46KickingSkillList.add(player46KickingSkill1); player46KickingSkillList.add(player46KickingSkill2); player46KickingSkillList.add(player46KickingSkill3);
		player46ContactSkillList.add(player46ContactSkill1); player46ContactSkillList.add(player46ContactSkill2); player46ContactSkillList.add(player46ContactSkill3);
		
		SkillCategory player46StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player46PhysicalSkillList);
		SkillCategory player46MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player46MentalSkillList);
		SkillCategory player46AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player46AttackSkillList);
		SkillCategory player46DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player46DefenceSkillList);
		SkillCategory player46KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player46KickingSkillList);
		SkillCategory player46ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player46ContactSkillList);
		
		player46SkillCategoryList.add(player46StengthSkillsList); player46SkillCategoryList.add(player46MentalSkillsList); player46SkillCategoryList.add(player46AttackSkillsList);
		player46SkillCategoryList.add(player46DefenceSkillsList); player46SkillCategoryList.add(player46KickingSkillsList); player46SkillCategoryList.add(player46ContactSkillsList);
		
		/**
		 * Player 47
		 */
		ArrayList<Skill> player47PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player47MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player47AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player47DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player47KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player47ContactSkillList = new ArrayList<Skill>();
		
		Skill player47PhysicalSkill1 = new Skill("Speed", 0);
		Skill player47PhysicalSkill2 = new Skill("Strength", 0);
		Skill player47PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player47MentalSkill1 = new Skill("Decision Making", 0);
		Skill player47MentalSkill2 = new Skill("Positioning", 0);
		Skill player47MentalSkill3 = new Skill("Knowledge", 0);
	
		Skill player47AttackSkill1 = new Skill("Grip", 0);
		Skill player47AttackSkill2 = new Skill("Fending Off", 0);
		Skill player47AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player47DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player47DefenceSkill2 = new Skill("Interception", 0);
		Skill player47DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player47KickingSkill1 = new Skill("Punt", 0);
		Skill player47KickingSkill2 = new Skill("Drop", 0);
		Skill player47KickingSkill3 = new Skill("Place", 0);
		
		Skill player47ContactSkill1 = new Skill("Tackle", 0);
		Skill player47ContactSkill2 = new Skill("Scrum", 0);
		Skill player47ContactSkill3 = new Skill("Carrying", 0);
		
		player47PhysicalSkillList.add(player47PhysicalSkill1); player47PhysicalSkillList.add(player47PhysicalSkill2); player47PhysicalSkillList.add(player47PhysicalSkill3);
		player47MentalSkillList.add(player47MentalSkill1); player47MentalSkillList.add(player47MentalSkill2); player47MentalSkillList.add(player47MentalSkill3); 
		player47AttackSkillList.add(player47AttackSkill1); player47AttackSkillList.add(player47AttackSkill2); player47AttackSkillList.add(player47AttackSkill3);
		player47DefenceSkillList.add(player47DefenceSkill1); player47DefenceSkillList.add(player47DefenceSkill2); player47DefenceSkillList.add(player47DefenceSkill3);
		player47KickingSkillList.add(player47KickingSkill1); player47KickingSkillList.add(player47KickingSkill2); player47KickingSkillList.add(player47KickingSkill3);
		player47ContactSkillList.add(player47ContactSkill1); player47ContactSkillList.add(player47ContactSkill2); player47ContactSkillList.add(player47ContactSkill3);
		
		SkillCategory player47StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player47PhysicalSkillList);
		SkillCategory player47MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player47MentalSkillList);
		SkillCategory player47AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player47AttackSkillList);
		SkillCategory player47DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player47DefenceSkillList);
		SkillCategory player47KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player47KickingSkillList);
		SkillCategory player47ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player47ContactSkillList);
		
		player47SkillCategoryList.add(player47StengthSkillsList); player47SkillCategoryList.add(player47MentalSkillsList); player47SkillCategoryList.add(player47AttackSkillsList);
		player47SkillCategoryList.add(player47DefenceSkillsList); player47SkillCategoryList.add(player47KickingSkillsList); player47SkillCategoryList.add(player47ContactSkillsList);
		
		/**
		 * Player 48
		 */
		ArrayList<Skill> player48PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player48MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player48AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player48DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player48KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player48ContactSkillList = new ArrayList<Skill>();
		
		Skill player48PhysicalSkill1 = new Skill("Speed", 0);
		Skill player48PhysicalSkill2 = new Skill("Strength", 0);
		Skill player48PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player48MentalSkill1 = new Skill("Decision Making", 0);
		Skill player48MentalSkill2 = new Skill("Positioning", 0);
		Skill player48MentalSkill3 = new Skill("Knowledge", 0);

		Skill player48AttackSkill1 = new Skill("Grip", 0);
		Skill player48AttackSkill2 = new Skill("Fending Off", 0);
		Skill player48AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player48DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player48DefenceSkill2 = new Skill("Interception", 0);
		Skill player48DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player48KickingSkill1 = new Skill("Punt", 0);
		Skill player48KickingSkill2 = new Skill("Drop", 0);
		Skill player48KickingSkill3 = new Skill("Place", 0);
		
		Skill player48ContactSkill1 = new Skill("Tackle", 0);
		Skill player48ContactSkill2 = new Skill("Scrum", 0);
		Skill player48ContactSkill3 = new Skill("Carrying", 0);
		
		player48PhysicalSkillList.add(player48PhysicalSkill1); player48PhysicalSkillList.add(player48PhysicalSkill2); player48PhysicalSkillList.add(player48PhysicalSkill3);
		player48MentalSkillList.add(player48MentalSkill1); player48MentalSkillList.add(player48MentalSkill2); player48MentalSkillList.add(player48MentalSkill3); 
		player48AttackSkillList.add(player48AttackSkill1); player48AttackSkillList.add(player48AttackSkill2); player48AttackSkillList.add(player48AttackSkill3);
		player48DefenceSkillList.add(player48DefenceSkill1); player48DefenceSkillList.add(player48DefenceSkill2); player48DefenceSkillList.add(player48DefenceSkill3);
		player48KickingSkillList.add(player48KickingSkill1); player48KickingSkillList.add(player48KickingSkill2); player48KickingSkillList.add(player48KickingSkill3);
		player48ContactSkillList.add(player48ContactSkill1); player48ContactSkillList.add(player48ContactSkill2); player48ContactSkillList.add(player48ContactSkill3);
		
		SkillCategory player48StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player48PhysicalSkillList);
		SkillCategory player48MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player48MentalSkillList);
		SkillCategory player48AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player48AttackSkillList);
		SkillCategory player48DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player48DefenceSkillList);
		SkillCategory player48KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player48KickingSkillList);
		SkillCategory player48ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player48ContactSkillList);
		
		player48SkillCategoryList.add(player48StengthSkillsList); player48SkillCategoryList.add(player48MentalSkillsList); player48SkillCategoryList.add(player48AttackSkillsList);
		player48SkillCategoryList.add(player48DefenceSkillsList); player48SkillCategoryList.add(player48KickingSkillsList); player48SkillCategoryList.add(player48ContactSkillsList);
		
		/**
		 * Player 49
		 */
		ArrayList<Skill> player49PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player49MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player49AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player49DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player49KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player49ContactSkillList = new ArrayList<Skill>();
		
		Skill player49PhysicalSkill1 = new Skill("Speed", 0);
		Skill player49PhysicalSkill2 = new Skill("Strength", 0);
		Skill player49PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player49MentalSkill1 = new Skill("Decision Making", 0);
		Skill player49MentalSkill2 = new Skill("Positioning", 0);
		Skill player49MentalSkill3 = new Skill("Knowledge", 0);

		Skill player49AttackSkill1 = new Skill("Grip", 0);
		Skill player49AttackSkill2 = new Skill("Fending Off", 0);
		Skill player49AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player49DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player49DefenceSkill2 = new Skill("Interception", 0);
		Skill player49DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player49KickingSkill1 = new Skill("Punt", 0);
		Skill player49KickingSkill2 = new Skill("Drop", 0);
		Skill player49KickingSkill3 = new Skill("Place", 0);
		
		Skill player49ContactSkill1 = new Skill("Tackle", 0);
		Skill player49ContactSkill2 = new Skill("Scrum", 0);
		Skill player49ContactSkill3 = new Skill("Carrying", 0);
		
		player49PhysicalSkillList.add(player49PhysicalSkill1); player49PhysicalSkillList.add(player49PhysicalSkill2); player49PhysicalSkillList.add(player49PhysicalSkill3);
		player49MentalSkillList.add(player49MentalSkill1); player49MentalSkillList.add(player49MentalSkill2); player49MentalSkillList.add(player49MentalSkill3); 
		player49AttackSkillList.add(player49AttackSkill1); player49AttackSkillList.add(player49AttackSkill2); player49AttackSkillList.add(player49AttackSkill3);
		player49DefenceSkillList.add(player49DefenceSkill1); player49DefenceSkillList.add(player49DefenceSkill2); player49DefenceSkillList.add(player49DefenceSkill3);
		player49KickingSkillList.add(player49KickingSkill1); player49KickingSkillList.add(player49KickingSkill2); player49KickingSkillList.add(player49KickingSkill3);
		player49ContactSkillList.add(player49ContactSkill1); player49ContactSkillList.add(player49ContactSkill2); player49ContactSkillList.add(player49ContactSkill3);
		
		SkillCategory player49StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player49PhysicalSkillList);
		SkillCategory player49MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player49MentalSkillList);
		SkillCategory player49AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player49AttackSkillList);
		SkillCategory player49DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player49DefenceSkillList);
		SkillCategory player49KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player49KickingSkillList);
		SkillCategory player49ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player49ContactSkillList);
		
		player49SkillCategoryList.add(player49StengthSkillsList); player49SkillCategoryList.add(player49MentalSkillsList); player49SkillCategoryList.add(player49AttackSkillsList);
		player49SkillCategoryList.add(player49DefenceSkillsList); player49SkillCategoryList.add(player49KickingSkillsList); player49SkillCategoryList.add(player49ContactSkillsList);
		
		/**
		 * Player 50
		 */
		ArrayList<Skill> player50PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player50MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player50AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player50DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player50KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player50ContactSkillList = new ArrayList<Skill>();
		
		Skill player50PhysicalSkill1 = new Skill("Speed", 0);
		Skill player50PhysicalSkill2 = new Skill("Strength", 0);
		Skill player50PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player50MentalSkill1 = new Skill("Decision Making", 0);
		Skill player50MentalSkill2 = new Skill("Positioning", 0);
		Skill player50MentalSkill3 = new Skill("Knowledge", 0);

		Skill player50AttackSkill1 = new Skill("Grip", 0);
		Skill player50AttackSkill2 = new Skill("Fending Off", 0);
		Skill player50AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player50DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player50DefenceSkill2 = new Skill("Interception", 0);
		Skill player50DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player50KickingSkill1 = new Skill("Punt", 0);
		Skill player50KickingSkill2 = new Skill("Drop", 0);
		Skill player50KickingSkill3 = new Skill("Place", 0);
		
		Skill player50ContactSkill1 = new Skill("Tackle", 0);
		Skill player50ContactSkill2 = new Skill("Scrum", 0);
		Skill player50ContactSkill3 = new Skill("Carrying", 0);
		
		player50PhysicalSkillList.add(player50PhysicalSkill1); player50PhysicalSkillList.add(player50PhysicalSkill2); player50PhysicalSkillList.add(player50PhysicalSkill3);
		player50MentalSkillList.add(player50MentalSkill1); player50MentalSkillList.add(player50MentalSkill2); player50MentalSkillList.add(player50MentalSkill3); 
		player50AttackSkillList.add(player50AttackSkill1); player50AttackSkillList.add(player50AttackSkill2); player50AttackSkillList.add(player50AttackSkill3);
		player50DefenceSkillList.add(player50DefenceSkill1); player50DefenceSkillList.add(player50DefenceSkill2); player50DefenceSkillList.add(player50DefenceSkill3);
		player50KickingSkillList.add(player50KickingSkill1); player50KickingSkillList.add(player50KickingSkill2); player50KickingSkillList.add(player50KickingSkill3);
		player50ContactSkillList.add(player50ContactSkill1); player50ContactSkillList.add(player50ContactSkill2); player50ContactSkillList.add(player50ContactSkill3);
		
		SkillCategory player50StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player50PhysicalSkillList);
		SkillCategory player50MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player50MentalSkillList);
		SkillCategory player50AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player50AttackSkillList);
		SkillCategory player50DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player50DefenceSkillList);
		SkillCategory player50KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player50KickingSkillList);
		SkillCategory player50ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player50ContactSkillList);
		
		player50SkillCategoryList.add(player50StengthSkillsList); player50SkillCategoryList.add(player50MentalSkillsList); player50SkillCategoryList.add(player50AttackSkillsList);
		player50SkillCategoryList.add(player50DefenceSkillsList); player50SkillCategoryList.add(player50KickingSkillsList); player50SkillCategoryList.add(player50ContactSkillsList);
		
		
		/**
		 * Player 51
		 */
		ArrayList<Skill> player51PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player51MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player51AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player51DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player51KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player51ContactSkillList = new ArrayList<Skill>();
		
		Skill player51PhysicalSkill1 = new Skill("Speed", 0);
		Skill player51PhysicalSkill2 = new Skill("Strength", 0);
		Skill player51PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player51MentalSkill1 = new Skill("Decision Making", 0);
		Skill player51MentalSkill2 = new Skill("Positioning", 0);
		Skill player51MentalSkill3 = new Skill("Knowledge", 0);

		Skill player51AttackSkill1 = new Skill("Grip", 0);
		Skill player51AttackSkill2 = new Skill("Fending Off", 0);
		Skill player51AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player51DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player51DefenceSkill2 = new Skill("Interception", 0);
		Skill player51DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player51KickingSkill1 = new Skill("Punt", 0);
		Skill player51KickingSkill2 = new Skill("Drop", 0);
		Skill player51KickingSkill3 = new Skill("Place", 0);
		
		Skill player51ContactSkill1 = new Skill("Tackle", 0);
		Skill player51ContactSkill2 = new Skill("Scrum", 0);
		Skill player51ContactSkill3 = new Skill("Carrying", 0);
		
		player51PhysicalSkillList.add(player51PhysicalSkill1); player51PhysicalSkillList.add(player51PhysicalSkill2); player51PhysicalSkillList.add(player51PhysicalSkill3);
		player51MentalSkillList.add(player51MentalSkill1); player51MentalSkillList.add(player51MentalSkill2); player51MentalSkillList.add(player51MentalSkill3); 
		player51AttackSkillList.add(player51AttackSkill1); player51AttackSkillList.add(player51AttackSkill2); player51AttackSkillList.add(player51AttackSkill3);
		player51DefenceSkillList.add(player51DefenceSkill1); player51DefenceSkillList.add(player51DefenceSkill2); player51DefenceSkillList.add(player51DefenceSkill3);
		player51KickingSkillList.add(player51KickingSkill1); player51KickingSkillList.add(player51KickingSkill2); player51KickingSkillList.add(player51KickingSkill3);
		player51ContactSkillList.add(player51ContactSkill1); player51ContactSkillList.add(player51ContactSkill2); player51ContactSkillList.add(player51ContactSkill3);
		
		SkillCategory player51StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player51PhysicalSkillList);
		SkillCategory player51MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player51MentalSkillList);
		SkillCategory player51AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player51AttackSkillList);
		SkillCategory player51DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player51DefenceSkillList);
		SkillCategory player51KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player51KickingSkillList);
		SkillCategory player51ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player51ContactSkillList);
		
		player51SkillCategoryList.add(player51StengthSkillsList); player51SkillCategoryList.add(player51MentalSkillsList); player51SkillCategoryList.add(player51AttackSkillsList);
		player51SkillCategoryList.add(player51DefenceSkillsList); player51SkillCategoryList.add(player51KickingSkillsList); player51SkillCategoryList.add(player51ContactSkillsList);
		
		/**
		 * Player 52
		 */
		ArrayList<Skill> player52PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player52MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player52AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player52DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player52KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player52ContactSkillList = new ArrayList<Skill>();
		
		Skill player52PhysicalSkill1 = new Skill("Speed", 0);
		Skill player52PhysicalSkill2 = new Skill("Strength", 0);
		Skill player52PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player52MentalSkill1 = new Skill("Decision Making", 0);
		Skill player52MentalSkill2 = new Skill("Positioning", 0);
		Skill player52MentalSkill3 = new Skill("Knowledge", 0);

		Skill player52AttackSkill1 = new Skill("Grip", 0);
		Skill player52AttackSkill2 = new Skill("Fending Off", 0);
		Skill player52AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player52DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player52DefenceSkill2 = new Skill("Interception", 0);
		Skill player52DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player52KickingSkill1 = new Skill("Punt", 0);
		Skill player52KickingSkill2 = new Skill("Drop", 0);
		Skill player52KickingSkill3 = new Skill("Place", 0);
		
		Skill player52ContactSkill1 = new Skill("Tackle", 0);
		Skill player52ContactSkill2 = new Skill("Scrum", 0);
		Skill player52ContactSkill3 = new Skill("Carrying", 0);
		
		player52PhysicalSkillList.add(player52PhysicalSkill1); player52PhysicalSkillList.add(player52PhysicalSkill2); player52PhysicalSkillList.add(player52PhysicalSkill3);
		player52MentalSkillList.add(player52MentalSkill1); player52MentalSkillList.add(player52MentalSkill2); player52MentalSkillList.add(player52MentalSkill3); 
		player52AttackSkillList.add(player52AttackSkill1); player52AttackSkillList.add(player52AttackSkill2); player52AttackSkillList.add(player52AttackSkill3);
		player52DefenceSkillList.add(player52DefenceSkill1); player52DefenceSkillList.add(player52DefenceSkill2); player52DefenceSkillList.add(player52DefenceSkill3);
		player52KickingSkillList.add(player52KickingSkill1); player52KickingSkillList.add(player52KickingSkill2); player52KickingSkillList.add(player52KickingSkill3);
		player52ContactSkillList.add(player52ContactSkill1); player52ContactSkillList.add(player52ContactSkill2); player52ContactSkillList.add(player52ContactSkill3);
		
		SkillCategory player52StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player52PhysicalSkillList);
		SkillCategory player52MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player52MentalSkillList);
		SkillCategory player52AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player52AttackSkillList);
		SkillCategory player52DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player52DefenceSkillList);
		SkillCategory player52KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player52KickingSkillList);
		SkillCategory player52ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player52ContactSkillList);
		
		player52SkillCategoryList.add(player52StengthSkillsList); player52SkillCategoryList.add(player52MentalSkillsList); player52SkillCategoryList.add(player52AttackSkillsList);
		player52SkillCategoryList.add(player52DefenceSkillsList); player52SkillCategoryList.add(player52KickingSkillsList); player52SkillCategoryList.add(player52ContactSkillsList);
		
		/**
		 * Player 53
		 */
		ArrayList<Skill> player53PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player53MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player53AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player53DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player53KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player53ContactSkillList = new ArrayList<Skill>();
		
		Skill player53PhysicalSkill1 = new Skill("Speed", 0);
		Skill player53PhysicalSkill2 = new Skill("Strength", 0);
		Skill player53PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player53MentalSkill1 = new Skill("Decision Making", 0);
		Skill player53MentalSkill2 = new Skill("Positioning", 0);
		Skill player53MentalSkill3 = new Skill("Knowledge", 0);

		Skill player53AttackSkill1 = new Skill("Grip", 0);
		Skill player53AttackSkill2 = new Skill("Fending Off", 0);
		Skill player53AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player53DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player53DefenceSkill2 = new Skill("Interception", 0);
		Skill player53DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player53KickingSkill1 = new Skill("Punt", 0);
		Skill player53KickingSkill2 = new Skill("Drop", 0);
		Skill player53KickingSkill3 = new Skill("Place", 0);
		
		Skill player53ContactSkill1 = new Skill("Tackle", 0);
		Skill player53ContactSkill2 = new Skill("Scrum", 0);
		Skill player53ContactSkill3 = new Skill("Carrying", 0);
		
		player53PhysicalSkillList.add(player53PhysicalSkill1); player53PhysicalSkillList.add(player53PhysicalSkill2); player53PhysicalSkillList.add(player53PhysicalSkill3);
		player53MentalSkillList.add(player53MentalSkill1); player53MentalSkillList.add(player53MentalSkill2); player53MentalSkillList.add(player53MentalSkill3); 
		player53AttackSkillList.add(player53AttackSkill1); player53AttackSkillList.add(player53AttackSkill2); player53AttackSkillList.add(player53AttackSkill3);
		player53DefenceSkillList.add(player53DefenceSkill1); player53DefenceSkillList.add(player53DefenceSkill2); player53DefenceSkillList.add(player53DefenceSkill3);
		player53KickingSkillList.add(player53KickingSkill1); player53KickingSkillList.add(player53KickingSkill2); player53KickingSkillList.add(player53KickingSkill3);
		player53ContactSkillList.add(player53ContactSkill1); player53ContactSkillList.add(player53ContactSkill2); player53ContactSkillList.add(player53ContactSkill3);
		
		SkillCategory player53StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player53PhysicalSkillList);
		SkillCategory player53MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player53MentalSkillList);
		SkillCategory player53AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player53AttackSkillList);
		SkillCategory player53DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player53DefenceSkillList);
		SkillCategory player53KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player53KickingSkillList);
		SkillCategory player53ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player53ContactSkillList);
		
		player53SkillCategoryList.add(player53StengthSkillsList); player53SkillCategoryList.add(player53MentalSkillsList); player53SkillCategoryList.add(player53AttackSkillsList);
		player53SkillCategoryList.add(player53DefenceSkillsList); player53SkillCategoryList.add(player53KickingSkillsList); player53SkillCategoryList.add(player53ContactSkillsList);
		
		/**
		 * Player 54
		 */
		ArrayList<Skill> player54PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player54MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player54AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player54DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player54KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player54ContactSkillList = new ArrayList<Skill>();
		
		Skill player54PhysicalSkill1 = new Skill("Speed", 0);
		Skill player54PhysicalSkill2 = new Skill("Strength", 0);
		Skill player54PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player54MentalSkill1 = new Skill("Decision Making", 0);
		Skill player54MentalSkill2 = new Skill("Positioning", 0);
		Skill player54MentalSkill3 = new Skill("Knowledge", 0);

		Skill player54AttackSkill1 = new Skill("Grip", 0);
		Skill player54AttackSkill2 = new Skill("Fending Off", 0);
		Skill player54AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player54DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player54DefenceSkill2 = new Skill("Interception", 0);
		Skill player54DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player54KickingSkill1 = new Skill("Punt", 0);
		Skill player54KickingSkill2 = new Skill("Drop", 0);
		Skill player54KickingSkill3 = new Skill("Place", 0);
		
		Skill player54ContactSkill1 = new Skill("Tackle", 0);
		Skill player54ContactSkill2 = new Skill("Scrum", 0);
		Skill player54ContactSkill3 = new Skill("Carrying", 0);
		
		player54PhysicalSkillList.add(player54PhysicalSkill1); player54PhysicalSkillList.add(player54PhysicalSkill2); player54PhysicalSkillList.add(player54PhysicalSkill3);
		player54MentalSkillList.add(player54MentalSkill1); player54MentalSkillList.add(player54MentalSkill2); player54MentalSkillList.add(player54MentalSkill3); 
		player54AttackSkillList.add(player54AttackSkill1); player54AttackSkillList.add(player54AttackSkill2); player54AttackSkillList.add(player54AttackSkill3);
		player54DefenceSkillList.add(player54DefenceSkill1); player54DefenceSkillList.add(player54DefenceSkill2); player54DefenceSkillList.add(player54DefenceSkill3);
		player54KickingSkillList.add(player54KickingSkill1); player54KickingSkillList.add(player54KickingSkill2); player54KickingSkillList.add(player54KickingSkill3);
		player54ContactSkillList.add(player54ContactSkill1); player54ContactSkillList.add(player54ContactSkill2); player54ContactSkillList.add(player54ContactSkill3);
		
		SkillCategory player54StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player54PhysicalSkillList);
		SkillCategory player54MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player54MentalSkillList);
		SkillCategory player54AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player54AttackSkillList);
		SkillCategory player54DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player54DefenceSkillList);
		SkillCategory player54KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player54KickingSkillList);
		SkillCategory player54ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player54ContactSkillList);
		
		player54SkillCategoryList.add(player54StengthSkillsList); player54SkillCategoryList.add(player54MentalSkillsList); player54SkillCategoryList.add(player54AttackSkillsList);
		player54SkillCategoryList.add(player54DefenceSkillsList); player54SkillCategoryList.add(player54KickingSkillsList); player54SkillCategoryList.add(player54ContactSkillsList);
		
		/**
		 * Player 55
		 */
		ArrayList<Skill> player55PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player55MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player55AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player55DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player55KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player55ContactSkillList = new ArrayList<Skill>();
		
		Skill player55PhysicalSkill1 = new Skill("Speed", 0);
		Skill player55PhysicalSkill2 = new Skill("Strength", 0);
		Skill player55PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player55MentalSkill1 = new Skill("Decision Making", 0);
		Skill player55MentalSkill2 = new Skill("Positioning", 0);
		Skill player55MentalSkill3 = new Skill("Knowledge", 0);

		Skill player55AttackSkill1 = new Skill("Grip", 0);
		Skill player55AttackSkill2 = new Skill("Fending Off", 0);
		Skill player55AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player55DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player55DefenceSkill2 = new Skill("Interception", 0);
		Skill player55DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player55KickingSkill1 = new Skill("Punt", 0);
		Skill player55KickingSkill2 = new Skill("Drop", 0);
		Skill player55KickingSkill3 = new Skill("Place", 0);
		
		Skill player55ContactSkill1 = new Skill("Tackle", 0);
		Skill player55ContactSkill2 = new Skill("Scrum", 0);
		Skill player55ContactSkill3 = new Skill("Carrying", 0);
		
		player55PhysicalSkillList.add(player55PhysicalSkill1); player55PhysicalSkillList.add(player55PhysicalSkill2); player55PhysicalSkillList.add(player55PhysicalSkill3);
		player55MentalSkillList.add(player55MentalSkill1); player55MentalSkillList.add(player55MentalSkill2); player55MentalSkillList.add(player55MentalSkill3); 
		player55AttackSkillList.add(player55AttackSkill1); player55AttackSkillList.add(player55AttackSkill2); player55AttackSkillList.add(player55AttackSkill3);
		player55DefenceSkillList.add(player55DefenceSkill1); player55DefenceSkillList.add(player55DefenceSkill2); player55DefenceSkillList.add(player55DefenceSkill3);
		player55KickingSkillList.add(player55KickingSkill1); player55KickingSkillList.add(player55KickingSkill2); player55KickingSkillList.add(player55KickingSkill3);
		player55ContactSkillList.add(player55ContactSkill1); player55ContactSkillList.add(player55ContactSkill2); player55ContactSkillList.add(player55ContactSkill3);
		
		SkillCategory player55StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player55PhysicalSkillList);
		SkillCategory player55MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player55MentalSkillList);
		SkillCategory player55AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player55AttackSkillList);
		SkillCategory player55DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player55DefenceSkillList);
		SkillCategory player55KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player55KickingSkillList);
		SkillCategory player55ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player55ContactSkillList);
		
		player55SkillCategoryList.add(player55StengthSkillsList); player55SkillCategoryList.add(player55MentalSkillsList); player55SkillCategoryList.add(player55AttackSkillsList);
		player55SkillCategoryList.add(player55DefenceSkillsList); player55SkillCategoryList.add(player55KickingSkillsList); player55SkillCategoryList.add(player55ContactSkillsList);
		
		/**
		 * Player 56
		 */
		ArrayList<Skill> player56PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player56MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player56AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player56DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player56KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player56ContactSkillList = new ArrayList<Skill>();
		
		Skill player56PhysicalSkill1 = new Skill("Speed", 0);
		Skill player56PhysicalSkill2 = new Skill("Strength", 0);
		Skill player56PhysicalSkill3 = new Skill("Stamina", 0);
		
		Skill player56MentalSkill1 = new Skill("Decision Making", 0);
		Skill player56MentalSkill2 = new Skill("Positioning", 0);
		Skill player56MentalSkill3 = new Skill("Knowledge", 0);

		Skill player56AttackSkill1 = new Skill("Grip", 0);
		Skill player56AttackSkill2 = new Skill("Fending Off", 0);
		Skill player56AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player56DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player56DefenceSkill2 = new Skill("Interception", 0);
		Skill player56DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player56KickingSkill1 = new Skill("Punt", 0);
		Skill player56KickingSkill2 = new Skill("Drop", 0);
		Skill player56KickingSkill3 = new Skill("Place", 0);
		
		Skill player56ContactSkill1 = new Skill("Tackle", 0);
		Skill player56ContactSkill2 = new Skill("Scrum", 0);
		Skill player56ContactSkill3 = new Skill("Carrying", 0);
		
		player56PhysicalSkillList.add(player56PhysicalSkill1); player56PhysicalSkillList.add(player56PhysicalSkill2); player56PhysicalSkillList.add(player56PhysicalSkill3);
		player56MentalSkillList.add(player56MentalSkill1); player56MentalSkillList.add(player56MentalSkill2); player56MentalSkillList.add(player56MentalSkill3); 
		player56AttackSkillList.add(player56AttackSkill1); player56AttackSkillList.add(player56AttackSkill2); player56AttackSkillList.add(player56AttackSkill3);
		player56DefenceSkillList.add(player56DefenceSkill1); player56DefenceSkillList.add(player56DefenceSkill2); player56DefenceSkillList.add(player56DefenceSkill3);
		player56KickingSkillList.add(player56KickingSkill1); player56KickingSkillList.add(player56KickingSkill2); player56KickingSkillList.add(player56KickingSkill3);
		player56ContactSkillList.add(player56ContactSkill1); player56ContactSkillList.add(player56ContactSkill2); player56ContactSkillList.add(player56ContactSkill3);
		
		SkillCategory player56StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player56PhysicalSkillList);
		SkillCategory player56MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player56MentalSkillList);
		SkillCategory player56AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player56AttackSkillList);
		SkillCategory player56DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player56DefenceSkillList);
		SkillCategory player56KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player56KickingSkillList);
		SkillCategory player56ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player56ContactSkillList);
		
		player56SkillCategoryList.add(player56StengthSkillsList); player56SkillCategoryList.add(player56MentalSkillsList); player56SkillCategoryList.add(player56AttackSkillsList);
		player56SkillCategoryList.add(player56DefenceSkillsList); player56SkillCategoryList.add(player56KickingSkillsList); player56SkillCategoryList.add(player56ContactSkillsList);
		
		/**
		 * Player 57
		 */
		ArrayList<Skill> player57PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player57MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player57AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player57DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player57KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player57ContactSkillList = new ArrayList<Skill>();
		
		Skill player57PhysicalSkill1 = new Skill("Speed", 0);
		Skill player57PhysicalSkill2 = new Skill("Strength", 0);
		Skill player57PhysicalSkill3 = new Skill("Stamina", 0);
	
		Skill player57MentalSkill1 = new Skill("Decision Making", 0);
		Skill player57MentalSkill2 = new Skill("Positioning", 0);
		Skill player57MentalSkill3 = new Skill("Knowledge", 0);

		Skill player57AttackSkill1 = new Skill("Grip", 0);
		Skill player57AttackSkill2 = new Skill("Fending Off", 0);
		Skill player57AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player57DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player57DefenceSkill2 = new Skill("Interception", 0);
		Skill player57DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player57KickingSkill1 = new Skill("Punt", 0);
		Skill player57KickingSkill2 = new Skill("Drop", 0);
		Skill player57KickingSkill3 = new Skill("Place", 0);
		
		Skill player57ContactSkill1 = new Skill("Tackle", 0);
		Skill player57ContactSkill2 = new Skill("Scrum", 0);
		Skill player57ContactSkill3 = new Skill("Carrying", 0);
		
		player57PhysicalSkillList.add(player57PhysicalSkill1); player57PhysicalSkillList.add(player57PhysicalSkill2); player57PhysicalSkillList.add(player57PhysicalSkill3);
		player57MentalSkillList.add(player57MentalSkill1); player57MentalSkillList.add(player57MentalSkill2); player57MentalSkillList.add(player57MentalSkill3); 
		player57AttackSkillList.add(player57AttackSkill1); player57AttackSkillList.add(player57AttackSkill2); player57AttackSkillList.add(player57AttackSkill3);
		player57DefenceSkillList.add(player57DefenceSkill1); player57DefenceSkillList.add(player57DefenceSkill2); player57DefenceSkillList.add(player57DefenceSkill3);
		player57KickingSkillList.add(player57KickingSkill1); player57KickingSkillList.add(player57KickingSkill2); player57KickingSkillList.add(player57KickingSkill3);
		player57ContactSkillList.add(player57ContactSkill1); player57ContactSkillList.add(player57ContactSkill2); player57ContactSkillList.add(player57ContactSkill3);
		
		SkillCategory player57StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player57PhysicalSkillList);
		SkillCategory player57MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player57MentalSkillList);
		SkillCategory player57AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player57AttackSkillList);
		SkillCategory player57DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player57DefenceSkillList);
		SkillCategory player57KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player57KickingSkillList);
		SkillCategory player57ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player57ContactSkillList);
		
		player57SkillCategoryList.add(player57StengthSkillsList); player57SkillCategoryList.add(player57MentalSkillsList); player57SkillCategoryList.add(player57AttackSkillsList);
		player57SkillCategoryList.add(player57DefenceSkillsList); player57SkillCategoryList.add(player57KickingSkillsList); player57SkillCategoryList.add(player57ContactSkillsList);
		
		/**
		 * Player 58
		 */
		ArrayList<Skill> player58PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player58MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player58AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player58DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player58KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player58ContactSkillList = new ArrayList<Skill>();
		
		Skill player58PhysicalSkill1 = new Skill("Speed", 0);
		Skill player58PhysicalSkill2 = new Skill("Strength", 0);
		Skill player58PhysicalSkill3 = new Skill("Stamina", 0);
	
		Skill player58MentalSkill1 = new Skill("Decision Making", 0);
		Skill player58MentalSkill2 = new Skill("Positioning", 0);
		Skill player58MentalSkill3 = new Skill("Knowledge", 0);

		Skill player58AttackSkill1 = new Skill("Grip", 0);
		Skill player58AttackSkill2 = new Skill("Fending Off", 0);
		Skill player58AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player58DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player58DefenceSkill2 = new Skill("Interception", 0);
		Skill player58DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player58KickingSkill1 = new Skill("Punt", 0);
		Skill player58KickingSkill2 = new Skill("Drop", 0);
		Skill player58KickingSkill3 = new Skill("Place", 0);
		
		Skill player58ContactSkill1 = new Skill("Tackle", 0);
		Skill player58ContactSkill2 = new Skill("Scrum", 0);
		Skill player58ContactSkill3 = new Skill("Carrying", 0);
		
		player58PhysicalSkillList.add(player58PhysicalSkill1); player58PhysicalSkillList.add(player58PhysicalSkill2); player58PhysicalSkillList.add(player58PhysicalSkill3);
		player58MentalSkillList.add(player58MentalSkill1); player58MentalSkillList.add(player58MentalSkill2); player58MentalSkillList.add(player58MentalSkill3); 
		player58AttackSkillList.add(player58AttackSkill1); player58AttackSkillList.add(player58AttackSkill2); player58AttackSkillList.add(player58AttackSkill3);
		player58DefenceSkillList.add(player58DefenceSkill1); player58DefenceSkillList.add(player58DefenceSkill2); player58DefenceSkillList.add(player58DefenceSkill3);
		player58KickingSkillList.add(player58KickingSkill1); player58KickingSkillList.add(player58KickingSkill2); player58KickingSkillList.add(player58KickingSkill3);
		player58ContactSkillList.add(player58ContactSkill1); player58ContactSkillList.add(player58ContactSkill2); player58ContactSkillList.add(player58ContactSkill3);
		
		SkillCategory player58StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player58PhysicalSkillList);
		SkillCategory player58MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player58MentalSkillList);
		SkillCategory player58AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player58AttackSkillList);
		SkillCategory player58DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player58DefenceSkillList);
		SkillCategory player58KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player58KickingSkillList);
		SkillCategory player58ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player58ContactSkillList);
		
		player58SkillCategoryList.add(player58StengthSkillsList); player58SkillCategoryList.add(player58MentalSkillsList); player58SkillCategoryList.add(player58AttackSkillsList);
		player58SkillCategoryList.add(player58DefenceSkillsList); player58SkillCategoryList.add(player58KickingSkillsList); player58SkillCategoryList.add(player58ContactSkillsList);
		
		/**
		 * Player 59
		 */
		ArrayList<Skill> player59PhysicalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player59MentalSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player59AttackSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player59DefenceSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player59KickingSkillList = new ArrayList<Skill>();
		ArrayList<Skill> player59ContactSkillList = new ArrayList<Skill>();
		
		Skill player59PhysicalSkill1 = new Skill("Speed", 0);
		Skill player59PhysicalSkill2 = new Skill("Strength", 0);
		Skill player59PhysicalSkill3 = new Skill("Stamina", 0);
	
		Skill player59MentalSkill1 = new Skill("Decision Making", 0);
		Skill player59MentalSkill2 = new Skill("Positioning", 0);
		Skill player59MentalSkill3 = new Skill("Knowledge", 0);

		Skill player59AttackSkill1 = new Skill("Grip", 0);
		Skill player59AttackSkill2 = new Skill("Fending Off", 0);
		Skill player59AttackSkill3 = new Skill("Realignment", 0);
	
		Skill player59DefenceSkill1 = new Skill("Commuinication", 0);
		Skill player59DefenceSkill2 = new Skill("Interception", 0);
		Skill player59DefenceSkill3 = new Skill("Protection", 0);
	
		Skill player59KickingSkill1 = new Skill("Punt", 0);
		Skill player59KickingSkill2 = new Skill("Drop", 0);
		Skill player59KickingSkill3 = new Skill("Place", 0);
		
		Skill player59ContactSkill1 = new Skill("Tackle", 0);
		Skill player59ContactSkill2 = new Skill("Scrum", 0);
		Skill player59ContactSkill3 = new Skill("Carrying", 0);
		
		player59PhysicalSkillList.add(player59PhysicalSkill1); player59PhysicalSkillList.add(player59PhysicalSkill2); player59PhysicalSkillList.add(player59PhysicalSkill3);
		player59MentalSkillList.add(player59MentalSkill1); player59MentalSkillList.add(player59MentalSkill2); player59MentalSkillList.add(player59MentalSkill3); 
		player59AttackSkillList.add(player59AttackSkill1); player59AttackSkillList.add(player59AttackSkill2); player59AttackSkillList.add(player59AttackSkill3);
		player59DefenceSkillList.add(player59DefenceSkill1); player59DefenceSkillList.add(player59DefenceSkill2); player59DefenceSkillList.add(player59DefenceSkill3);
		player59KickingSkillList.add(player59KickingSkill1); player59KickingSkillList.add(player59KickingSkill2); player59KickingSkillList.add(player59KickingSkill3);
		player59ContactSkillList.add(player59ContactSkill1); player59ContactSkillList.add(player59ContactSkill2); player59ContactSkillList.add(player59ContactSkill3);
		
		SkillCategory player59StengthSkillsList = new SkillCategory("Physical", "Skills to do with Physical attributes.", player59PhysicalSkillList);
		SkillCategory player59MentalSkillsList = new SkillCategory("Mental", "Skills to do with Mental attributes.", player59MentalSkillList);
		SkillCategory player59AttackSkillsList = new SkillCategory("Attack", "Skills to do with Attack Drills.", player59AttackSkillList);
		SkillCategory player59DefenceSkillsList = new SkillCategory("Defence", "Skills to do with Defence Drills..", player59DefenceSkillList);
		SkillCategory player59KickingSkillsList = new SkillCategory("Kicking", "Skills to do with Kicking Drills.", player59KickingSkillList);
		SkillCategory player59ContactSkillsList = new SkillCategory("Contact", "Skills to do with Contact Drills.", player59ContactSkillList);
		
		player59SkillCategoryList.add(player59StengthSkillsList); player59SkillCategoryList.add(player59MentalSkillsList); player59SkillCategoryList.add(player59AttackSkillsList);
		player59SkillCategoryList.add(player59DefenceSkillsList); player59SkillCategoryList.add(player59KickingSkillsList); player59SkillCategoryList.add(player59ContactSkillsList);
		/**
		 * Data prepopulation for players
		 */
		
		/**
		 * 	Player Date Of Birth Pre Population.
		 */
		
		/**
		 * Squad 1 Date of Birth pre population.
		 */
		Date playerDate0 = null; String playerDateString0 = "02/01/2003";
		Date playerDate1 = null; String playerDateString1 = "06/02/2003";
		Date playerDate2 = null; String playerDateString2 = "11/04/2003";
		Date playerDate3 = null; String playerDateString3 = "17/04/2003";
		Date playerDate4 = null; String playerDateString4 = "22/03/2003";
		Date playerDate5 = null; String playerDateString5 = "16/01/2003";
		Date playerDate6 = null; String playerDateString6 = "22/02/2003";
		Date playerDate7 = null; String playerDateString7 = "05/02/2003";
		Date playerDate8 = null; String playerDateString8 = "12/01/2003";
		Date playerDate9 = null; String playerDateString9 = "15/02/2003";
		Date playerDate10 = null; String playerDateString10 = "12/04/2003";
		Date playerDate11 = null; String playerDateString11 = "18/02/2003";
		Date playerDate12 = null; String playerDateString12 = "16/01/2003";
		Date playerDate13 = null; String playerDateString13 = "08/01/2003";
		Date playerDate14 = null; String playerDateString14 = "13/02/2003";
		Date playerDate15 = null; String playerDateString15 = "19/01/2003";
		Date playerDate16 = null; String playerDateString16 = "16/03/2003";
		Date playerDate17 = null; String playerDateString17 = "05/01/2003";
		Date playerDate18 = null; String playerDateString18 = "08/04/2003";
		Date playerDate19 = null; String playerDateString19 = "06/01/2003";
		 
		/**
		 * Squad 2 Date of Birth pre population.
		 */
		Date playerDate20 = null; String playerDateString20 = "16/07/1998";
		Date playerDate21 = null; String playerDateString21 = "12/12/1998";
		Date playerDate22 = null; String playerDateString22 = "19/09/1998";
		Date playerDate23 = null; String playerDateString23 = "16/08/1998";
		Date playerDate24 = null; String playerDateString24 = "05/11/1998";
		Date playerDate25 = null; String playerDateString25 = "07/10/1998";
		Date playerDate26 = null; String playerDateString26 = "02/01/1998";
		Date playerDate27 = null; String playerDateString27 = "07/05/1998";
		Date playerDate28 = null; String playerDateString28 = "08/03/1998";
		Date playerDate29 = null; String playerDateString29 = "19/06/1998";
		Date playerDate30 = null; String playerDateString30 = "17/03/1998";
		Date playerDate31 = null; String playerDateString31 = "13/08/1998";
		Date playerDate32 = null; String playerDateString32 = "27/07/1998";
		Date playerDate33 = null; String playerDateString33 = "14/01/1998";
		Date playerDate34 = null; String playerDateString34 = "03/06/1998";
		Date playerDate35 = null; String playerDateString35 = "07/11/1998";
		Date playerDate36 = null; String playerDateString36 = "22/07/1998";
		Date playerDate37 = null; String playerDateString37 = "26/10/1998";
		Date playerDate38 = null; String playerDateString38 = "25/12/1998";
		Date playerDate39 = null; String playerDateString39 = "21/08/1998";
		
		/**
		 * Squad 3 Date of Birth pre population.
		 */
		Date playerDate40 = null; String playerDateString40 = "13/10/2014";
		Date playerDate41 = null; String playerDateString41 = "16/11/2014";
		Date playerDate42 = null; String playerDateString42 = "01/12/2014";
		Date playerDate43 = null; String playerDateString43 = "25/05/2014";
		Date playerDate44 = null; String playerDateString44 = "13/02/2014";
		Date playerDate45 = null; String playerDateString45 = "18/08/2014";
		Date playerDate46 = null; String playerDateString46 = "11/06/2014";
		Date playerDate47 = null; String playerDateString47 = "07/03/2014";
		Date playerDate48 = null; String playerDateString48 = "05/07/2014";
		Date playerDate49 = null; String playerDateString49 = "03/09/2014";
		Date playerDate50 = null; String playerDateString50 = "14/10/2014";
		Date playerDate51 = null; String playerDateString51 = "17/04/2014";
		Date playerDate52 = null; String playerDateString52 = "04/11/2014";
		Date playerDate53 = null; String playerDateString53 = "25/07/2014";
		Date playerDate54 = null; String playerDateString54 = "27/02/2014";
		Date playerDate55 = null; String playerDateString55 = "21/07/2014";
		Date playerDate56 = null; String playerDateString56 = "24/04/2014";
		Date playerDate57 = null; String playerDateString57 = "05/02/2014";
		Date playerDate58 = null; String playerDateString58 = "08/01/2014";
		Date playerDate59 = null; String playerDateString59 = "04/02/2014";
		
		try {
			playerDate0 = dateFormat.parse(playerDateString0);
			playerDate1 = dateFormat.parse(playerDateString1);
			playerDate2 = dateFormat.parse(playerDateString2);
			playerDate3 = dateFormat.parse(playerDateString3);
			playerDate4 = dateFormat.parse(playerDateString4);
			playerDate5 = dateFormat.parse(playerDateString5);
			playerDate6 = dateFormat.parse(playerDateString6);
			playerDate7 = dateFormat.parse(playerDateString7);
			playerDate8 = dateFormat.parse(playerDateString8);
			playerDate9 = dateFormat.parse(playerDateString9);
			playerDate10 = dateFormat.parse(playerDateString10);
			playerDate11 = dateFormat.parse(playerDateString11);
			playerDate12 = dateFormat.parse(playerDateString12);
			playerDate13 = dateFormat.parse(playerDateString13);
			playerDate14 = dateFormat.parse(playerDateString14);
			playerDate15 = dateFormat.parse(playerDateString15);
			playerDate16 = dateFormat.parse(playerDateString16);
			playerDate17 = dateFormat.parse(playerDateString17);
			playerDate18 = dateFormat.parse(playerDateString18);
			playerDate19 = dateFormat.parse(playerDateString19);
			playerDate20 = dateFormat.parse(playerDateString20);
			playerDate21 = dateFormat.parse(playerDateString21);
			playerDate22 = dateFormat.parse(playerDateString22);
			playerDate23 = dateFormat.parse(playerDateString23);
			playerDate24 = dateFormat.parse(playerDateString24);
			playerDate25 = dateFormat.parse(playerDateString25);
			playerDate26 = dateFormat.parse(playerDateString26);
			playerDate27 = dateFormat.parse(playerDateString27);
			playerDate28 = dateFormat.parse(playerDateString28);
			playerDate29 = dateFormat.parse(playerDateString29);
			playerDate30 = dateFormat.parse(playerDateString30);
			playerDate31 = dateFormat.parse(playerDateString31);
			playerDate32 = dateFormat.parse(playerDateString32);
			playerDate33 = dateFormat.parse(playerDateString33);
			playerDate34 = dateFormat.parse(playerDateString34);
			playerDate35 = dateFormat.parse(playerDateString35);
			playerDate36 = dateFormat.parse(playerDateString36);
			playerDate37 = dateFormat.parse(playerDateString37);
			playerDate38 = dateFormat.parse(playerDateString38);
			playerDate39 = dateFormat.parse(playerDateString39);
			playerDate40 = dateFormat.parse(playerDateString40);
			playerDate41 = dateFormat.parse(playerDateString41);
			playerDate42 = dateFormat.parse(playerDateString42);
			playerDate43 = dateFormat.parse(playerDateString43);
			playerDate44 = dateFormat.parse(playerDateString44);
			playerDate45 = dateFormat.parse(playerDateString45);
			playerDate46 = dateFormat.parse(playerDateString46);
			playerDate47 = dateFormat.parse(playerDateString47);
			playerDate48 = dateFormat.parse(playerDateString48);
			playerDate49 = dateFormat.parse(playerDateString49);
			playerDate50 = dateFormat.parse(playerDateString50);
			playerDate51 = dateFormat.parse(playerDateString51);
			playerDate52 = dateFormat.parse(playerDateString52);
			playerDate53 = dateFormat.parse(playerDateString53);
			playerDate54 = dateFormat.parse(playerDateString54);
			playerDate55 = dateFormat.parse(playerDateString55);
			playerDate56 = dateFormat.parse(playerDateString56);
			playerDate57 = dateFormat.parse(playerDateString57);
			playerDate58 = dateFormat.parse(playerDateString58);
			playerDate59 = dateFormat.parse(playerDateString59);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		/**
		 * Squad 1 Players
		 */
		
		
		Player Player0 = new Player("MFJ0VW90", "Cairn", "Macleod", "Boyle", "cairnboyle@gmail.com", "07737156340", "0", "Player St.", "Reedham", "NR13 5XY", playerDate0, "827643", "Loose Head Prop", "Ronan Boyle", "07083368097", player0SkillCategoryList);
		Player Player1 = new Player("L6JOWIV2", "Boyd", "Jones", "Bruce", "boydbruce@gmail.com", "07837259226", "1", "Player St.", "Reedham", "NR13 5XY", playerDate1, "621477", "Hooker", "Lucie Bruce", "07786188185", player1SkillCategoryList);
		Player Player2 = new Player("BJM2G8VY", "Elliott", "Reilly", "Murphy", "elliottmurphy@gmail.com", "07826420391", "2", "Player St.", "Reedham", "NR13 5XY", playerDate2, "610550", "Tight Head Prop", "Kimberley Murphy", "07813986068", player2SkillCategoryList);
		Player Player3 = new Player("EAR0TNUZ", "Arran", "Wilson", "Black", "arranblack@gmail.com", "07911578867", "3", "Player St.", "Reedham", "NR13 5XY", playerDate3, "070322", "Left Lock", "Ella Black", "07981028670", player3SkillCategoryList);
		Player Player4 = new Player("6CNEAJBY", "Murdo", "Russell", "Hay", "murdohay@gmail.com", "07859051290", "4", "Player St.", "Reedham", "NR13 5XY", playerDate4, "113285", "Right Lock", "Erin Hay", "07774626902", player4SkillCategoryList);
		Player Player5 = new Player("AVO073JY", "Jay", "Wright", "McKay", "jaymcKay@gmail.com", "07927983788", "5", "Player St.", "Reedham", "NR13 5XY", playerDate5, "538378", "Blind Side Flanker", "Kiara McKay", "07800372908", player5SkillCategoryList);
		Player Player6 = new Player("N7RRNHF3", "Ruairidh", "Bell", "Simpson", "ruairidhsimpson@gmail.com", "07777899912", "6", "Player St.", "Reedham", "NR13 5XY", playerDate6, "274299", "Open Side Flanker", "Karolina Simpson", "07903392781", player6SkillCategoryList);
		Player Player7 = new Player("MOXDOG0U", "Oliwier", "Ritchie", "Hughes", "oliwierhughes@gmail.com", "07927509233", "7", "Player St.", "Reedham", "NR13 5XY", playerDate7, "787043", "Number 8", "Lydia Hughes", "07706787075", player7SkillCategoryList);
		Player Player8 = new Player("UN421R8Q", "Hayden", "Moore", "Gordon", "haydengordon@gmail.com", "07948343765", "8", "Player St.", "Reedham", "NR13 5XY", playerDate8, "586443", "Scrum Half", "Erica Gordon", "07726642183", player8SkillCategoryList);
		Player Player9 = new Player("64TFLY1P", "Farhan", "Cunningham", "Robertson", "farhanrobertson@gmail.com", "07777023523", "9", "Player St.", "Reedham", "NR13 5XY", playerDate9, "105443", "Stand Off", "Faryl Robertson", "07808087501", player9SkillCategoryList);
		Player Player10 = new Player("80P89A7O", "Haris", "Allan", "Kennedy", "hariskennedy@gmail.com", "07737156340", "10", "Player St.", "Reedham", "NR13 5XY", playerDate10, "570007", "Left Wing", "Jodie Kennedy", "07728423366", player10SkillCategoryList);
		Player Player11 = new Player("L4VQ3K28", "Maksymilian", "Wood", "Crawford", "maksymiliancrawford@gmail.com", "07988025985", "11", "Player St.", "Reedham", "NR13 5XY", playerDate11, "481727", "Inside Centre", "Miya Crawford", "07840646483", player11SkillCategoryList);
		Player Player12 = new Player("9Z1542I7", "Mac", "Findlay", "Munro", "macmunro@gmail.com", "07956849876", "12", "Player St.", "Reedham", "NR13 5XY", playerDate12, "322887", "Outside Centre", "Kaelyn Munro", "07955706022", player12SkillCategoryList);
		Player Player13 = new Player("FFBZ2BPV", "Benjamin", "Robertson", "McLean", "benjaminmcLean@gmail.com", "07004207809", "13", "Player St.", "Reedham", "NR13 5XY", playerDate13, "215788", "Right Wing", "Adele McLean", "07832054027", player13SkillCategoryList);
		Player Player14 = new Player("P7Q8ZS1T", "Marley", "Wilson", "Aitken", "marleyaitken@gmail.com", "07761613003", "14", "Player St.", "Reedham", "NR13 5XY", playerDate14, "268631", "Full Back", "Elle Aitken", "07709051879", player14SkillCategoryList);
		Player Player15 = new Player("4YOO89BD", "Fletcher", "Anderson", "Wallace", "fletcherwallace@gmail.com", "07856894064", "15", "Player St.", "Reedham", "NR13 5XY", playerDate15, "696194", "Hooker", "Ailey Wallace", "07701921822", player15SkillCategoryList);
		Player Player16 = new Player("4AX66LOE", "Innes", "Marshall", "Crawford", "innescrawford@gmail.com", "07728733544", "16", "Player St.", "Reedham", "NR13 5XY", playerDate16, "844963", "Number 8", "Bonnie Crawford", "07717868285", player16SkillCategoryList);
		Player Player17 = new Player("MXCU0B6E", "Murdo", "Stewart", "Murray", "murdomurray@gmail.com", "07782055100", "17", "Player St.", "Reedham", "NR13 5XY", playerDate17, "455826", "Inside Centre", "Lori Murray", "07006672365", player17SkillCategoryList);
		Player Player18 = new Player("34YZ7F9K", "Nicolas ", "Millar", "Simpson", "nicolassimpson@gmail.com", "07046306514", "18", "Player St.", "Reedham", "NR13 5XY", playerDate18, "247644", "Tight Head Prop", "Tia Simpson", "07718419827", player18SkillCategoryList);
		Player Player19 = new Player("3XXPXF6P", "Michal", "Thompson", "Crawford", "michalcrawford@gmail.com", "07927594887", "19", "Player St.", "Reedham", "NR13 5XY", playerDate19, "763993", "Full Back", "Sofia Crawford", "07908604136", player19SkillCategoryList);
		
		
		/**
		 * Squad 2 Players
		 */
		
		
		Player Player20 = new Player("ETII7ZSO", "Lucas", "Wallace", "Fleming", "lucasfleming@gmail.com", "07959476486", "20", "Player St.", "Reedham", "NR13 5XY", playerDate20, "316841", "Loose Head Prop", "Lauren Fleming", "07871067489", player20SkillCategoryList);
		Player Player21 = new Player("N54AUMPA", "Hugo", "Gordon", "Miller", "hugomiller@gmail.com", "07742222712", "21", "Player St.", "Reedham", "NR13 5XY", playerDate21, "645707", "Hooker", "Weronika Miller", "07038611482", player21SkillCategoryList);
		Player Player22 = new Player("SJ7VN2W9", "Luis", "Wood", "Stewart", "luisstewart@gmail.com", "07826420391", "22", "Player St.", "Reedham", "NR13 5XY", playerDate22, "744711", "Tight Head Prop", "Aleksandra Stewart", "07048726866", player22SkillCategoryList);
		Player Player23 = new Player("R239Y1UB", "Jared", "Anderson", "Robertson", "jaredrobertson@gmail.com", "07949049260", "23", "Player St.", "Reedham", "NR13 5XY", playerDate23, "096321", "Left Lock", "Tyler Robertson", "07981028670", player23SkillCategoryList);
		Player Player24 = new Player("1579GYSH", "Jason ", "Maclean", "McIntyre", "jasonmcIntyre@gmail.com", "07859051290", "24", "Player St.", "Reedham", "NR13 5XY", playerDate24, "108014", "Right Lock", "Catherine McIntyre", "07932973434", player24SkillCategoryList);
		Player Player25 = new Player("5R4A2I3Y", "Lucas", "Thompson", "Mackenzie", "lucasmackenzie@gmail.com", "07876189868", "25", "Player St.", "Reedham", "NR13 5XY", playerDate25, "373205", "Blind Side Flanker", "Kirstie Mackenzie", "07932201724", player25SkillCategoryList);
		Player Player26 = new Player("73JWKRPC", "Brandon", "Millar", "Allan", "brandonallan@gmail.com", "07941172607", "26", "Player St.", "Reedham", "NR13 5XY", playerDate26, "344067", "Open Side Flanker", "Karolina Allan", "07936508451", player26SkillCategoryList);
		Player Player27 = new Player("D5NYJ580", "Ryan", "Smith", "Douglas", "ryandouglas@gmail.com", "07836611672", "27", "Player St.", "Reedham", "NR13 5XY", playerDate27, "995588", "Number 8", "Millie Douglas", "07744751959", player27SkillCategoryList);
		Player Player28 = new Player("2291X8ZB", "Faizan", "Aitken", "Reid", "faizanreid@gmail.com", "07076236267", "28", "Player St.", "Reedham", "NR13 5XY", playerDate28, "817387", "Scrum Half", "Riley Reid", "07726569505", player28SkillCategoryList);
		Player Player29 = new Player("WK9PGDJI", "Angus", "Cameron", "Simpson", "angussimpson@gmail.com", "07088372034", "29", "Player St.", "Reedham", "NR13 5XY", playerDate29, "818539", "Stand Off", "Nina Simpson", "07917350372", player29SkillCategoryList);
		Player Player30 = new Player("5ACI1USF", "Daryl", "MacDonald", "Boyle", "darylboyle@gmail.com", "07986734403", "30", "Player St.", "Reedham", "NR13 5XY", playerDate30, "920539", "Left Wing", "Allie Boyle", "07001714577", player30SkillCategoryList);
		Player Player31 = new Player("B0JH42NX", "Oran", "Grant", "Watson", "oranwatson@gmail.com", "07779374961", "31", "Player St.", "Reedham", "NR13 5XY", playerDate31, "290765", "Inside Centre", "Sky Watson", "07730552117", player31SkillCategoryList);
		Player Player32 = new Player("T80I6P21", "Rayyan", "Reilly", "Fraser", "rayyanfraser@gmail.com", "07083896214", "32", "Player St.", "Reedham", "NR13 5XY", playerDate32, "805797", "Outside Centre", "Aleeza Fraser", "07785929936", player32SkillCategoryList);
		Player Player33 = new Player("OS1FS7UD", "Ty", "Stewart", "Hamilton", "tyhamilton@gmail.com", "07700418760", "33", "Player St.", "Reedham", "NR13 5XY", playerDate33, "992358", "Right Wing", "Rhiannon Hamilton", "07916891855", player33SkillCategoryList);
		Player Player34 = new Player("IC06M8V3", "Lewis", "McKenzie", "Alexander", "lewisalexander@gmail.com", "07929958990", "34", "Player St.", "Reedham", "NR13 5XY", playerDate34, "961583", "Full Back", "Carys Alexander", "07043168692", player34SkillCategoryList);
		Player Player35 = new Player("7Z80VHAH", "Noah", "McKay", "McLean", "noahmcLean@gmail.com", "07965646550", "35", "Player St.", "Reedham", "NR13 5XY", playerDate35, "864286", "Hooker", "Kiara McLean", "07964316471", player35SkillCategoryList);
		Player Player36 = new Player("86EM0TVJ", "Kody", "Reid", "Gray", "kodygray@gmail.com", "07082157343", "36", "Player St.", "Reedham", "NR13 5XY", playerDate36, "331542", "Number 8", "Mairi Gray", "07759653780", player36SkillCategoryList);
		Player Player37 = new Player("I2P6PLDE", "Stewart", "Craig", "Murphy", "stewartmurphy@gmail.com", "07078823389", "37", "Player St.", "Reedham", "NR13 5XY", playerDate37, "117230", "Inside Centre", "Natalie Murphy", "07076527290", player37SkillCategoryList);
		Player Player38 = new Player("BSHZIB6K", "Emmanuel ", "White", "Cunningham", "emmanuelcunningham@gmail.com", "07915905813", "38", "Player St.", "Reedham", "NR13 5XY", playerDate38, "295760", "Tight Head Prop", "Constance Cunningham", "07073646842", player38SkillCategoryList);
		Player Player39 = new Player("P566IRER", "Archibald", "Kelly", "Mitchell", "archibaldmitchell@gmail.com", "07756897032", "39", "Player St.", "Reedham", "NR13 5XY", playerDate39, "422692", "Full Back", "Alison Mitchell", "07836679315", player39SkillCategoryList);
		
		
		/**
		 * Squad 3 Players
		 */
		
		
		JuniorPlayer Player40 = new JuniorPlayer("2ZE57D45", "Shane", "Gordon", "Hill", "shanehill@gmail.com", "07871093437", "40", "Player St.", "Reedham", "NR13 5XY", playerDate40, "836756", "Loose Head Prop", "Charley Hill", "07873013544", player40SkillCategoryList, "Charley Hill", "07873013544");
		JuniorPlayer Player41 = new JuniorPlayer("FSA4IVKU", "Douglas ", "Fleming", "Macleod", "douglasmacleod@gmail.com", "07827155557", "41", "Player St.", "Reedham", "NR13 5XY", playerDate41, "403009", "Hooker", "Naomi Macleod", "07769884578", player41SkillCategoryList, "Naomi Macleod", "07769884578");
		JuniorPlayer Player42 = new JuniorPlayer("M32WJIWZ", "Darragh", "Campbell", "Marshall", "darraghmarshall@gmail.com", "07930486708", "42", "Player St.", "Reedham", "NR13 5XY", playerDate42, "622835", "Tight Head Prop", "Kira Marshall", "07050965934", player42SkillCategoryList, "Kira Marshall", "07050965934");
		JuniorPlayer Player43 = new JuniorPlayer("VZHFP8TA", "Graham", "Moore", "Mitchell", "grahammitchell@gmail.com", "07040938944", "43", "Player St.", "Reedham", "NR13 5XY", playerDate43, "494084", "Left Lock", "Harriet Mitchell", "07813536172", player43SkillCategoryList, "Harriet Mitchell", "07813536172");
		JuniorPlayer Player44 = new JuniorPlayer("423COG7D", "Calan", "Fleming", "McIntyre", "calanmcIntyre@gmail.com", "07001110935", "44", "Player St.", "Reedham", "NR13 5XY", playerDate44, "407820", "Right Lock", "Sophia McIntyre", "07764551512", player44SkillCategoryList, "Sophia McIntyre", "07764551512");
		JuniorPlayer Player45 = new JuniorPlayer("8VG31PQU", "Lennon", "Murray", "Donaldson", "lennondonaldson@gmail.com", "07779095990", "45", "Player St.", "Reedham", "NR13 5XY", playerDate45, "428267", "Blind Side Flanker", "Katelyn Donaldson", "07069681619", player45SkillCategoryList, "Katelyn Donaldson", "07069681619");
		JuniorPlayer Player46 = new JuniorPlayer("6NQXS7WE", "Jamie", "Simpson", "McMillan", "jamiemcmillan@gmail.com", "07817606298", "46", "Player St.", "Reedham", "NR13 5XY", playerDate46, "066260", "Open Side Flanker", "Madeline McMillan", "07849455870", player46SkillCategoryList, "Madeline McMillan", "07849455870");
		JuniorPlayer Player47 = new JuniorPlayer("PGV13QYX", "Brooklyn", "Gray", "Alexander", "brooklynalexander@gmail.com", "07036670940", "47", "Player St.", "Reedham", "NR13 5XY", playerDate47, "030317", "Number 8", "Lena Alexander", "07060631404", player47SkillCategoryList, "Lena Alexander", "07060631404");
		JuniorPlayer Player48 = new JuniorPlayer("7A7A6RUW", "Travis", "McLean", "Donaldson", "travisdonaldson@gmail.com", "07839502333", "48", "Player St.", "Reedham", "NR13 5XY", playerDate48, "052470", "Scrum Half", "Elsa Donaldson", "07810016051", player48SkillCategoryList, "Elsa Donaldson", "07810016051");
		JuniorPlayer Player49 = new JuniorPlayer("GK8V8GKS", "Jayden", "Mitchell", "Boyle", "jaydenboyle@gmail.com", "07079554286", "49", "Player St.", "Reedham", "NR13 5XY", playerDate49, "759716", "Stand Off", "Beatrice Boyle", "07823825007", player49SkillCategoryList, "Beatrice Boyle", "07823825007");
		JuniorPlayer Player50 = new JuniorPlayer("FHFL2SR6", "Derek", "Taylor", "Martin", "derekmartin@gmail.com", "07034229481", "50", "Player St.", "Reedham", "NR13 5XY", playerDate50, "365096", "Left Wing", "Cerys Martin", "07085623483", player50SkillCategoryList, "Cerys Martin", "07085623483");
		JuniorPlayer Player51 = new JuniorPlayer("3TEFI2BG", "Charley", "Taylor", "Wright", "charleywright@gmail.com", "07748788261", "51", "Player St.", "Reedham", "NR13 5XY", playerDate51, "542655", "Inside Centre", "Rachael Wright", "07865789615", player51SkillCategoryList, "Rachael Wright", "07865789615");
		JuniorPlayer Player52 = new JuniorPlayer("N27UHWAZ", "Cailean", "Fleming", "McKay", "caileanmckay@gmail.com", "07921456624", "52", "Player St.", "Reedham", "NR13 5XY", playerDate52, "322887", "Outside Centre", "McKenzie McKay", "07941353224", player52SkillCategoryList, "McKenzie McKay", "07941353224");
		JuniorPlayer Player53 = new JuniorPlayer("S1IX0RV0", "Harry", "Ritchie", "Wright", "harrywright@gmail.com", "07714822654", "53", "Player St.", "Reedham", "NR13 5XY", playerDate53, "866885", "Right Wing", "Lana Wright", "07761293293", player53SkillCategoryList, "Lana Wright", "07761293293");
		JuniorPlayer Player54 = new JuniorPlayer("7CZUDATD", "Roddy", "Murphy", "Cameron", "roddycameron@gmail.com", "07874323431", "54", "Player St.", "Reedham", "NR13 5XY", playerDate54, "329217", "Full Back", "Tyler Cameron", "07841676139", player54SkillCategoryList, "Tyler Cameron", "07841676139");
		JuniorPlayer Player55 = new JuniorPlayer("G26C09DC", "Sandy", "Ross", "Davidson", "sandydavidson@gmail.com", "07769041585", "55", "Player St.", "Reedham", "NR13 5XY", playerDate55, "572009", "Hooker", "Chanel Davidson", "07005589992", player55SkillCategoryList, "Chanel Davidson", "07005589992");
		JuniorPlayer Player56 = new JuniorPlayer("T2UHY6JX", "Hamza", "Kerr", "Kelly", "hamzakelly@gmail.com", "07970715443", "56", "Player St.", "Reedham", "NR13 5XY", playerDate56, "201565", "Number 8", "Kaitlin Kelly", "07917248876", player56SkillCategoryList, "Kaitlin Kelly", "07917248876");
		JuniorPlayer Player57 = new JuniorPlayer("X8AWFFEL", "Troy", "Boyle", "Russell", "troyrussell@gmail.com", "07889752638", "57", "Player St.", "Reedham", "NR13 5XY", playerDate57, "270623", "Inside Centre", "Ella Russell", "07084613874", player57SkillCategoryList, "Ella Russell", "07084613874");
		JuniorPlayer Player58 = new JuniorPlayer("JZPMON5J", "Alfie", "Grant", "Wood", "alfiewood@gmail.com", "07038905425", "58", "Player St.", "Reedham", "NR13 5XY", playerDate58, "816303", "Tight Head Prop", "Amy Wood", "07729042060", player58SkillCategoryList, "Amy Wood", "07729042060");
		JuniorPlayer Player59 = new JuniorPlayer("IVCQF518", "Logan", "Graham", "Sinclair", "logansinclair@gmail.com", "07733646085", "59", "Player St.", "Reedham", "NR13 5XY", playerDate59, "115258", "Full Back", "Sadie Sinclair", "07784648877", player59SkillCategoryList, "Sadie Sinclair", "07784648877");
		
		/**
		 * Data Prepopulation for Squad's.
		 */
		
		ArrayList<Player> playerList1 = new ArrayList<Player>();
		ArrayList<Player> playerList2 = new ArrayList<Player>();
		ArrayList<Player> playerList3 = new ArrayList<Player>();
		
		playerList1.add(Player0); playerList2.add(Player20); playerList3.add(Player40); 
		playerList1.add(Player1); playerList2.add(Player21); playerList3.add(Player41); 
		playerList1.add(Player2); playerList2.add(Player22); playerList3.add(Player42); 
		playerList1.add(Player3); playerList2.add(Player23); playerList3.add(Player43); 
		playerList1.add(Player4); playerList2.add(Player24); playerList3.add(Player44); 
		playerList1.add(Player5); playerList2.add(Player25); playerList3.add(Player45); 
		playerList1.add(Player6); playerList2.add(Player26); playerList3.add(Player46); 
		playerList1.add(Player7); playerList2.add(Player27); playerList3.add(Player47); 
		playerList1.add(Player8); playerList2.add(Player28); playerList3.add(Player48); 
		playerList1.add(Player9); playerList2.add(Player29); playerList3.add(Player49); 
		playerList1.add(Player10); playerList2.add(Player30); playerList3.add(Player50); 
		playerList1.add(Player11); playerList2.add(Player31); playerList3.add(Player51); 
		playerList1.add(Player12); playerList2.add(Player32); playerList3.add(Player52); 
		playerList1.add(Player13); playerList2.add(Player33); playerList3.add(Player53); 
		playerList1.add(Player14); playerList2.add(Player34); playerList3.add(Player54); 
		playerList1.add(Player15); playerList2.add(Player35); playerList3.add(Player55); 
		playerList1.add(Player16); playerList2.add(Player36); playerList3.add(Player56); 
		playerList1.add(Player17); playerList2.add(Player37); playerList3.add(Player57); 
		playerList1.add(Player18); playerList2.add(Player38); playerList3.add(Player58); 
		playerList1.add(Player19); playerList2.add(Player39); playerList3.add(Player59); 
		
		Squad Squad1 = new Squad("H26YZA99", "U18 Squad 1", "U18", playerList1);
		Squad Squad2 = new Squad("OKYHF5GS", "Senior Squad 1", "Senior", playerList2);
		Squad Squad3 = new Squad("8ABTY625", "6 - 8 Squad 1", "6 - 8", playerList3);
		
		squadData.add(Squad1);
		squadData.add(Squad2);
		squadData.add(Squad3);
		
		saveData();
	}

	/**
	 * Gets the current coachData list and returns it.
	 * @return the coachData
	 */
	public ArrayList<Coach> getCoachData() {
		return coachData;
	}

	/**
	 * Gets the coachData list parameter passed in and sets it to this instances coachData list.
	 * @param coachData the coachData to set
	 */
	public void setCoachData(ArrayList<Coach> coachData) {
		this.coachData = coachData;
	}

	/**
	 * Gets the current squadData list and returns it.
	 * @return the squadData
	 */
	public ArrayList<Squad> getSquadData() {
		return squadData;
	}


	/**
	 * Gets the squadData list parameter passed in and sets it to this instances squadData list.
	 * @param squadData the squadData to set
	 */
	public void setSquadData(ArrayList<Squad> squadData) {
		this.squadData = squadData;
	}
}