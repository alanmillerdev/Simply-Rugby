package simplyRugby;

/**
 * <H1> Class - Controller</H1>
 * 
 * This class is to be used to control the application. 
 * This class will contain all of the main functionality required for the software to preform its functions.
 * This class is responsible for opening different GUI views and passing them the data that they require for their functions.
 * 
 * 
 * @author Alan Miller
 * @since 06/04/2021
 * @version 1.0
 *
 */

/**
 * Imports the Java ArrayList utility that is used throughout different functions required by the system.
 */
import java.util.ArrayList;
/**
 * Imports the Java Iterator utility that is used in the login process to iterate through the coaches. 
 */
import java.util.Iterator;
/**
 * Imports the Java Swing Table DefaultTableModel that is used throughout the program to display the different data via tables.
 */
import javax.swing.table.DefaultTableModel;
/**
 * Imports all of the BCrypt functions, BCrypt is a password hashing function that will be used during the login process. 
 * BCrypt includes functionality for hashing, salting and checking hashed passwords.
 * You can find out more about it in it's part of the Java Doc.
 */
import BCrypt.*;

/**
 * <p>
 * Controller class that will be passed around the application.
 * Views will be able to call functions from the controller upon actions.
 *
 */

public class Controller {

	/**
	 * simplyRugbyModel variable responsible for holding the information about the Model that is connected to the system.
	 */
	private Model simplyRugbyModel;
	/**
	 * splashScreen variable responsible for holding the instance of the Splash Screen used on software start.
	 */
	private SplashScreen splashScreen;
	
	/**
	 * <p>
	 * First Instance of the Controller that will be loaded on software start.
	 * <br>
	 * Is used to load the initial start up sequence of the software.
	 * <br>
	 * This includes loading the splash screen and updating the value of the loading bar.
	 */
	public Controller()
	{
		/**
		 * Creates and stores a new instance of the Model for use throughout the controller.
		 */
		simplyRugbyModel = new Model();
		/**
		 * Creates and stores a new SplashScreen that is displayed to the user.
		 */
		splashScreen = new SplashScreen();
		/**
		 * Sets the splash screen to visible.
		 */
		splashScreen.setVisible(true);
		/**
		 * For loop that is responsible for updating the value of the progress bar on the SplashScreen view.
		 */
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SplashScreen.splashProgressBar.setValue(i);
			SplashScreen.splashProgressBar.setStringPainted(true);
		}
		/**
		 * Model is then used to load the data into the system.
		 */
		simplyRugbyModel.loadData();
		/**
		 * Splash screen is disposed of and the login screen is then displayed to the user.
		 */
		splashScreen.dispose();
		displayLogin();
		
	}
	
	/**
	 * <p>
	 * Display login method.
	 * <br>
	 * This method is used to display a new instance of the login screen.
	 * <br>
	 * This method is used during startup and is also used in the logout method.
	 */
	protected void displayLogin()
	{
		/**
		 * Declares loginScreen that holds an instance of the LoginScreen.
		 */
		LoginScreen loginScreen;
		
		/**
		 * Passes the controller to the loginScreen view that allows it to be called within the view.
		 * The view is then set to visible.
		 */
		loginScreen = new LoginScreen(this);
		loginScreen.setVisible(true);
		
	}
	
	/**
	 * @param coach is passed to display squad menu to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display menu method
	 * <br>
	 * This method is used to display a new instance of the menu screen.
	 * <br>
	 * This method is used throughout the system to display the menu.
	 * <br>
	 * For example when the "Return to Menu" button is clicked.
	 */
	protected void displayMenu(Coach coach)
	{
		/**
		 * Declares menuScreen that holds an instance of the MenuScreen.
		 */
		MenuScreen menuScreen;
		
		/**
		 * <p>
		 * Passes the coach object and the controller to the menuScreen view.
		 * This allows the view to access data from the coach record such as their name for the welcome message.
		 * The controller is also passed to the view to allow for calling of methods from within the controller.
		 * The view is then set to visible.
		 */
		menuScreen = new MenuScreen(coach, this);
		menuScreen.setVisible(true);
		
	}
	
	/**
	 * @param coach is passed to display profile to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display profile method.
	 * <br>
	 * This method is used to display a new instance of the profile screen.
	 * <br>
	 * Since the Coach information is required in this page, their information is passed along with the controller.
	 * <br>
	 * This allows data reading straight from the Coach Object and function calling from the controller.
	 * 
	 */
	protected void displayProfile(Coach coach)
	{
		/**
		 * Declares profileScreen that holds an instance of the ProfileScreen.
		 */
		ProfileScreen profileScreen;
		/**
		 * Passes the coach object and the controller to the profileScreen view.
		 * This allows the view to access data from the coach record such as their memberID for displaying it on the page. 
		 * The controller is also passed to the view to allow for calling of methods from within the controller.
		 * The view is then set to visible.
		 */
		profileScreen = new ProfileScreen(coach, this);
		profileScreen.setVisible(true);	
	}
	
	/**
	 * 
	 * @param coach is passed to display squad view to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display squad view method.
	 * <br>
	 * This method is used to display a new instance of the squad view screen.
	 * <br>
	 * Since the Coach information is required in this page, their information is passed along with the squad and controller.
	 * <br>
	 * This allows data reading straight from the Coach Object, Squad Object and function calling from the controller.
	 * <br>
	 * In this page, the data from the squad will be displayed. For that reason we make the process simple, by parameter passing the squad object.
	 */
	
	protected void displaySquadView(Coach coach)
	{
		/**
		 * Declares squadViewScreen that holds an instance of the ViewSquadScreen.
		 */
		ViewSquadScreen squadViewScreen;
		
		/**
		 * <p>
		 * Passes the coach object and the controller to the viewSquad screen.
		 * The view is then set to visible.
		 * The squad view is passed the coach, squad and the controller data.
		 * This allows for easy data reading and for method calling from the view.
		 * In this method, while constructing the new screen, the controller makes use of other functions that will find the squad data then return it for the constructor to use.
		 * The coach data and the controller are passed as normal and the view is set to be visible.
		 */
		squadViewScreen = new ViewSquadScreen(coach, findSquad(coach), this);
		squadViewScreen.setVisible(true);
	}
	
	/**
	 * 
	 * @param coach is passed to display player view to be used as a easy way to grab data for display in the view.
	 * @param playerMemberID is passed to the display player view to be used as a way to find data for the player easily. 
	 * <p>
	 * Display player view method.
	 * <br>
	 * This method is used to display a new instance of the player view screen.
	 * <br>
	 * Since this view requires player information, the method first needs to obtain that information.
	 * <br>
	 * This is done by using the findSpecificPlayerInformation method. 
	 * <br>
	 * This method returns a player object after being given the player member ID and the squad that they are a part of.
	 * <br>
	 * Once this information is found it is passed to the view constructor.
	 * 
	 */
	protected void displayViewPlayer(Coach coach, String playerMemberID)
	{
		
		/**
		 * Calls the findSpecificPlayerInformation method and stores the returned player object in the currentPlayer variable.
		 */
		Player currentPlayer = findSpecificPlayerInformation(playerMemberID, findSquad(coach));
		
		/**
		 * Declares squadViewScreen that holds an instance of the ViewPlayerScreen.
		 */
		
		ViewPlayerScreen viewPlayerScreen;
		/**
		 * <p>
		 * Passes the coach object, the currentPlayer object and the controller to the view player screen constructor
		 * The view is then set to visible.
		 */
		viewPlayerScreen = new ViewPlayerScreen(coach, currentPlayer, this);
		viewPlayerScreen.setVisible(true);
	}
	
	/**
	 * 
	 * @param coach is passed to display player view to be used as a easy way to grab data for display in the view.
	 * @param player is passed to display player view to be used as a easy way to grab data for display in the view.
	 * <p>
	 * Display player view method.
	 * <br>
	 * This method is used to display a new instance of the player edit screen.
	 * <br>
	 * Since this view requires player information, the method first needs to obtain that information.
	 * <br>
	 * As the data already exists in the view, the data is passed from the view to the displayEditPlayer method for use in the next constructor.
	 * 
	 */
	
	protected void displayEditPlayer(Coach coach, Player player)
	{
		
		/**
		 * Declares editPlayerScreen that holds an instance of the EditPlayerScreen.
		 */
		EditPlayerScreen editPlayerScreen;
		
		/**
		 * <p>
		 * Passes the coach object, the currentPlayer object and the controller to the edit player screen constructor
		 * The view is then set to visible.
		 */
		
		editPlayerScreen = new EditPlayerScreen(coach, player, this);
		editPlayerScreen.setVisible(true);
		
	}
	
	/**
	 * 
	 * @return is used to define if the save has taken place successfully or not.
	 * <p>
	 * Request Save Method.
	 * <br>
	 * This method is used to interact with the Model.
	 * <br>
	 * Upon calling of this method a save will be attempted within the model.
	 * <br>
	 * If the data is saved successfully the function will return true.
	 */
	
	protected boolean requestSave()
	{
		/**
		 * <p>
		 * Calls the saveData method from the Model.
		 */
		simplyRugbyModel.saveData();
		
		return true;
	}
	
	/**
	 * 
	 * @param username is the value entered by the user, this is passed to the method by the view.
	 * @param password is the value entered by the user, this is passed to the method by the view.
	 * @return true or false, determined by the authentication that takes place.
	 * <p>
	 * Authenticate User uses methods from the BCrypt import to preform checks on the password inputed by the user.
	 * <br>
	 * The checkpw method is passed the inputed password from the user and the current stored hashed password.
	 * <br>
	 * BCrypt then checks the passwords to make sure they match.
	 * <br>
	 * If they match, retVal is set to True and the user will be logged in.
	 * <br>
	 * If they do not match, retVal is set to False and the user will be displayed an error message.
	 * 
	 */
	
	protected boolean authenticateUser(String username, String password)
	{
		/**
		 * retVal holds the value that will be returned to where the method was called from.
		 * Will be used to display the menu screen to the user or to show an error message to the user.
		 */
		boolean retVal = false;
		
		/**
		 * Declaring coachList as a list of coaches. 
		 * coachList is an arrayList that holds Coach Objects. The variable requests data from the Model.
		 */
		ArrayList<Coach> coachList = simplyRugbyModel.getCoachData();
		
		/**
		 * Declaring coachIt as an iterator of coachList.
		 * coachIt is an Iterator is used to loop through the list of coaches. 
		 */
		Iterator<Coach> coachIt = coachList.iterator();
		
		/**
		 * While loop that is used to check if the coach has inputed the correct authentication information.
		 */
		while(coachIt.hasNext() == true)
		{
			/**
			 * Declaring currentUser as the current coach that the loop is looping through.
			 * This allows for clearer code in the checking process.
			 */
			Coach currentUser = coachIt.next();
			
			/**
			 * If statement that is used to check the users login information.
			 * If the passed in username and password from the view match the information that is stored within the currentUser object,
			 * the retVal will be set to true and the menu screen will be displayed to the user.
			 * If the information does not match, the retVal will be returned as false, prompting an error message to be displayed by the view.
			 * 
			 */
			if (currentUser.getUsername().equals(username) && BCrypt.checkpw(password, currentUser.getPassword()))
			{
				
				/**
				 * setting the retVal to true which prompts the closure of the login view.
				 * The menu screen is then opened and is passed the currentUser Coach Object and "this" controller.
				 * The loop then breaks, which stops the checks.
				 */
				retVal = true;
				MenuScreen menu = new MenuScreen(currentUser, this);
				menu.setVisible(true);
				break;
			}
		}
		return retVal;
	}
	
	/**
	 * 
	 * @param currentPassword holds the users input of the coaches current password.
	 * @param newPassword holds the new password value as a string that is to be salted and hashed.
	 * @param currentUser holds the current coach object, this allows for easy saving of the updated password.
	 * @return is a boolean value that will display a success or error message depending on the outcome of the password check.
	 * <p>
	 * The change password method is a quality of life feature added to allow the coaches to change their pre populated passwords to whatever they would like.
	 * <br>
	 * The change password method makes use of BCrypt once again for checking if the saved password matches the inputed password by the coach.
	 * <br>
	 * If the data matches, the setPassword method is called for the currentUser Coach Object.
	 * <br>
	 * Once the new password has been set, a save is forced and retVal is set to true, this will display a success message to the user upon return to the view.
	 */
	
	protected boolean changePassword(String currentPassword, String newPassword, Coach currentUser)
	{
		/**
		 * Declares retVal and sets it's value to false, meaning if the password cannot be updated due to the currentPassword being incorrect.
		 */
		boolean retVal = false;
		
		/**
		 * If statement that checks if the password inputed by the user matches the hashed password in the Coach Object.
		 * If the password matches, the new password is hashed and salted using BCrypt then set as the new password in the coach object.
		 * Save is forced and retVal is set to True and returned.
		 */
		if (BCrypt.checkpw(currentPassword, currentUser.getPassword()))
		{
			currentUser.setPassword((BCrypt.hashpw(newPassword, BCrypt.gensalt())));
			simplyRugbyModel.saveData();
			retVal = true;
		}

		return retVal;
	}
	
	/**
	 * 
	 * @param currentUser holds a object of the current coach that is signed in, it is passed to the method from the view.
	 * @return returns the squad object that is attached to the Coach that was passed in.
	 * <p>
	 * Find squad is used to find the squad object that is attached to the coach.
	 * <br>
	 * This happens by getting information from the Coach object about the squad that they coach, this information being the squadID.
	 * <br>
	 * Once this information has been stored, the Method fetches the all of the squad data from the model and stores it in the squadList variable.
	 * <br>
	 * The method then uses an iterator to loop through all of the squads in the list until it finds the squad with the ID that matches the Coaches coachesSquadID.
	 * <br>
	 * Once it has been found, the loop breaks and the squad is returned.
	 */
	protected Squad findSquad(Coach currentUser)
	{
		/**
		 * Declaring the currentSquad variable.
		 */
		Squad currentSquad = null;
		
		/**
		 * Declaring the SquadID variable as the passed in Coaches "CoachesSquadID".
		 */
		String squadID = currentUser.getCoachesSquadID();
		
		/**
		 * Declaring the squadList variable and setting it to the squadData from the Model.
		 */
		ArrayList<Squad> squadList = simplyRugbyModel.getSquadData();
		
		/**
		 * Declaring the squadIt Iterator.
		 */
		Iterator<Squad> squadIt = squadList.iterator();
		
		/**
		 * While loop that uses the squadIt Iterator to loop through the squadList to find the Squad Data attached to the coach.
		 */
		while(squadIt.hasNext() == true)
		{
			/**
			 * Setting currentSquad to the current loop value.
			 */
			currentSquad = squadIt.next();
			
			/**
			 * If statement that checks if the currentSquad ID matches the ID of the coaches SquadID. 
			 * If so, the loop breaks and the currentSquad is returned.
			 */
			if (currentSquad.getSquadID().equals(squadID))
			{
				break;
			}
		}
		return currentSquad;
	}
	
	/**
	 * 
	 * @param playerMemberID passes the player member ID from the view to the method. This holds the Identification number of the player that information needs to be found for.
	 * @param squad passes the squad object from the view to the method. This holds the whole Squad Object. This allows for the method to search through the squad for the specific player information.
	 * @return player object is returned either as a null value, or with the player data included for handling by the view.
	 * <p>
	 * Find Specific Player Information is a method that will be used to obtain data to populate the view player screen as well as the edit player screen.
	 * <br>
	 * Firstly, the retVal will be Declared and set to null awaiting a player object later, then all of the player information will be fetched using the findAllPlayerInformation method. It will then be stored in the playerInformation Player Object List.
	 * <br>
	 * The player information is then looped through to check for the selected player.
	 * <br>
	 * Upon finding this player, the retVal will be updated to the found player object and the loop will be broken to allow the data to be returned as fast as possible.
	 * <br>
	 * The player object is then returned.
	 */
	
	protected Player findSpecificPlayerInformation(String playerMemberID, Squad squad)
	{
		
		/**
		 * Declaring the retVal as a null Player.
		 */
		Player retVal = null;
		
		/**
		 * Declaring and initialising the playerInformation variable as the returned value from the findAllPlayerInformation method.
		 */
		ArrayList<Player> playerInformation = findAllPlayerInformation(squad);
		
		/**
		 * for loops through all of the player information
		 */
		for (Player p: playerInformation)
		{
			/**
			 * if the current player that is in the loop's memberID equals the memberID of the player that is being looked for the 
			 * retVal will be set to that player and the loop will be broken allowing for instant return of the data.
			 */
			 if (p.getMemberID().equals(playerMemberID))
			 {
				retVal = p;
				break;
			 }
		}
		
		return retVal;
		
	}
	
	/**
	 * 
	 * @param squad is passed in via the method call arguments. This variable contains the Squad Object that contains the list of players that are to be extracted.
	 * @return retVal is returned. This will contain an arrayList of all players that are in the squad.
	 * <p>
	 * findAllPlayerInformation is used to construct an arrayList of all the players that are a part of the passed in squad.
	 * <br>
	 * Since the squad object is passed in, all that needs to be called is the getter for the player list that is a part of the squad.
	 * <br>
	 * The retVal is set to the value obtained by the getter. Once this has been complete, the array list is then returned.
	 */
	
	public ArrayList<Player> findAllPlayerInformation(Squad squad)
	{
		/**
		 * Declares and Initialises the retVal variable that contains an arrayList of player objects.
		 * The value of retVal is set using a getter for player list that is apart of the squad class.
		 */
		ArrayList<Player> retVal = squad.getPlayerList();
		
		/**
		 * retVal is then returned.
		 */
		return retVal;

	}
	
	/**
	 * 
	 * @param playerObj is the player object that is passed in to allow for skill extraction.
	 * @return retVal is returned, this contains a list of all player skills. 
	 * <p>
	 * findAllPlayerSkills Method.
	 * <br>
	 * The first step that this method does is it creates a new array list called retVal, this stores an arrayList of Strings that contains the name of the skill categories.
	 * <br>
	 * The passed in playerObj is then stored in the currentPlayer variable that is used to extract the skill category names from.
	 * <br>
	 * A loop then loops through the player object and extracts the skill category name and stores it in the retVal arrayList.
	 *<br>
	 *Once this process has complete, the value is returned.
	 */
	protected ArrayList<String> findAllPlayerSkills(Player playerObj)
	{
		
		/**
		 * Declares and initialises the retVal variable as a new String Array List.
		 */
		ArrayList<String> retVal = new ArrayList<String>();
		
		/**
		 * Declares and initialises the currentPlayer variable as the passed in playerObj.
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * Loops through the skill categories of the currentPlayer variable by using the getPlayerSkills method that is a part of the player class.
		 */
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			/**
			 * Adds the name of the skill category to the retVal list.
			 */
			retVal.add(sc.getCategoryName());
		}
		
		/**
		 * Returns the array list.
		 */
		return retVal;
		
	}
	
	/**
	 * 
	 * @param squadObj is the squadObj that is passed in to allow for extraction of player information.
	 * @return retVal in this case is a Model for the table uses to display players that are apart of a squad.
	 * <p>
	 * displaySquadPlayers Method.
	 * <br>
	 * The first step in this method is setting the passed in squad object, to a more descriptive name, in this case, currentSquad.
	 * <br>
	 * Next, the DefaultTableModel "model" is defined as a new DefaultTableModel and as part of that Next, the DefaultTableModel "model" is defined as a new DefaultTableModel and as part of that model an override is used to set all of the cells to uneditable.  
	 * <br>
	 * Once this has happened, data can start to be added to the model. To start this process, the player information is obtained and stored in an ArrayList called "players".
	 * To get this information, a method call is made to the findAllPlayerInformation method. The method is passed the squad information that it requires.
	 * The required data will then be returned by the called method and stored in the players arrayList.
	 * <br>
	 * Columns are then added to the model that will allow the start of data population. The rows that are added are as follows.  
	 * <br>
	 * Player Member ID, Player Name, Position and Overall Rating
	 * <br>
	 * Next, the method will loop through all of the players apart of the arrayList. During this process the average of all of their skills is calculated.
	 * <br>
	 * This is done by storing the combined value of all of their individual skills and storing the count of these skills. Once that process has taken place.
	 * The overall skill variable will contain the averaged integer value of their skills.
	 * <br>
	 * This data is then added to the model as a row along with the Player Member ID etc.
	 * <br>
	 * Once all players have been added to the model, the model will be returned as retVal.
	 */
	protected DefaultTableModel displaySquadPlayers(Squad squadObj)
	{
		/**
		 * Declares and Initialises the currentSquad variable, that stores the passed in value, squadObj.
		 */
		Squad currentSquad = squadObj;
		
		/**
		 * Declares and Initialises the model variable that stores a new instance of the DefaultTableModel
		 */
		DefaultTableModel model = new DefaultTableModel() {
			
			/**
			 * Overrides the cell Editability. Sets all cell editable values to false.
			 */
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		/**
		 * Declares and Initialises the players variable that holds the returned value of the findAllPlayerInformation method.
		 */
		ArrayList<Player> players = findAllPlayerInformation(currentSquad);

		/**
		 * Uses the addColumn method to add the required columns to the model.
		 */
		model.addColumn("Player Member ID"); 
		model.addColumn("Player Name"); 
		model.addColumn("Position"); 
		model.addColumn("Overall Rating");
		
		/**
		 * Loop responsible for adding rows to the model.
		 */
		
		for (Player p : players)
		{
			
			/**
			 * Declares and initialises the overallSkill count variable and sets it to 0. This means each loop the value will reset. This variable is responsible for storing the total
			 * value of all skills.
			 */
			int overallSkill = 0;
			/**
			 * Declares and initialises the skillCount count variable and sets it to 0. This means each loop the value will reset. This variable is responsible for storing the count
			 * of all skills.
			 */
			int skillCount = 0;
			
			/**
			 * Declares and initialises the skillCategories variable as the currentLoop variable getPlayerSkills. This will get the current Players skills and store them in this list.
			 */
			ArrayList<SkillCategory> skillCategories = p.getPlayerSkills();
			
			/**
			 * For loop that calculates how many skills the player has and the overallSkill value.
			 */
			for (SkillCategory sc : skillCategories)
			{
				/**
				 * Declares and initialises the skill Variable that stores the list of all the skills within the current "sc" or skill Category.
				 */
				ArrayList<Skill> skill = sc.getCategorySkillList();
				
				/**
				 * For each of the skills in the skill list, the "s" or skill rating will be added to the overall skill variable and the count will be increased by one.
				 */
				for (Skill s: skill)
				{
					/**
					 * Adding the current skill value to the overallSkill variable and adding one to the count.
					 */
					overallSkill += s.getRating();
					skillCount += 1;
				}
				
			}
			
			/**
			 * Calculates the average of the players skills and outputs them as the overallSkill variable to be displayed in the model.
			 */
			
			overallSkill = overallSkill / skillCount;
			
			/**
			 * Calls the addRow method to add a new row to the model.
			 */
			model.addRow(new Object[]{p.getMemberID(), p.getFirstName() + " " + p.getLastName(), p.getPosition(), overallSkill});
			
		}
		
		/**
		 * Once the process is complete, the model is returned.
		 */
		return model;

	}
	
	/**
	 * 
	 * @param playerObj is a Player Object that contains all of the player information that is needed for the displayPlayerSkills method.
	 * @return retVal in this case is a Model for the table to display player skills.
	 * <p>
	 * displayPlayerSkills Method.
	 * <br>
	 * The displayPlayerSkills method is used to build a model that is responsible for displaying the passed in Player Object's skills.
	 * <br>
	 * The first step in this method, is declaring the retVal which in this case is a DefaultTableModel.
	 * <br>
	 * Next, the override is used to set all of the cells to uneditable.
	 * <br>
	 * Once that has occurred, the passed in player object is set to the currentPlayer variable.
	 * <br>
	 * Columns are then added to the model. These Columns include:
	 * <br>
	 * Skill Cateogry, Skill Name and Rating
	 * <br>
	 * Next, the currentSkillName and currentSkillRating variables are declared and initialised to their null values.
	 * <br>
	 * A loop then loops through all of the player skills and adds them to the model.
	 * <br>
	 * Once complete the retVal model is returned.
	 */
	
	protected DefaultTableModel displayPlayerSkills(Player playerObj)
	{
		
		/**
		 * Declares and Initialises the model variable that stores a new instance of the DefaultTableModel
		 */
		
		DefaultTableModel retVal = new DefaultTableModel(){
			
			/**
			 * Overrides the cell Editability. Sets all cell editable values to false.
			 */
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
		};
		
		/**
		 * Declares and initialises the currentPlayer Player Object Variable as the passed in playerObj,
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * The columns are then added to the model.
		 */
		retVal.addColumn("Skill Category");
		retVal.addColumn("Skill Name");
		retVal.addColumn("Rating");
		
		/**
		 * Loops through all of the skill categories attached to the currentPlayer variable.
		 */
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			/**
			 * Stores all of the skills that are apart of the current category in a ArrayList called skill.
			 */
			ArrayList<Skill> skill = sc.getCategorySkillList();
				
			/**
			 * Declares and initialises the currentSkillName String variable to null. Which will reset it each time a skill needs to be added to the model.
			 */
			String currentSkillName = null;
			/**
			 * Declares and initialises the currentSkillRating integer variable to 0. Which will reset it each time a skill needs to be added to the model.
			 */
			int currentSkillRating = 0;
			
			/**
			 * Loops through all of the skills that are a part of the ArrayList "skill".
			 */
			for (Skill s: skill)
			{
				/**
				 * Adds a new row to the Model containing information about the current looped skill.
				 */
				currentSkillName = s.getSkillName();
				currentSkillRating = s.getRating();
				retVal.addRow(new Object[]{sc.getCategoryName(), currentSkillName , currentSkillRating});
			}
			
		}
		
		/**
		 * Once all operations are complete the model will be returned.
		 */
		return retVal;
		
	}
	
	/**
	 * 
	 * @param playerObj is a Player Object that contains all of the player information that is needed for the getSkillCategoryNote method.
	 * @param categoryName is a String that contains the name of the category to view the note of.
	 * @return retVal stores the value of the category note. This will be returned once found.
	 * <p>
	 * getSkillCategoryNote Method.
	 * <br>
	 * This method starts off by declaring and initialising the currentPlayer variable to the passed in playerObj. Then Declaring and initialising the retVal variable.
	 * <br>
	 * Then, the players skill categories are looped through to check for the category that we are looking for.
	 * <br>
	 * If a category is found that matches the name of our passed in categoryName variable. The loop will be broken and the retVal will be set to the current skill category note.
	 * <br>
	 * retVal is then returned.
	 */
	
	protected String getSkillCategoryNote(Player playerObj, String categoryName)
	{
		/**
		 * Declares and Initialises the Player variable currentPlayer that will store the passed in playerObj variable.
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * Declares and initialises the retVal variable.
		 */
		String retVal = null;
		
		/**
		 * Loops through the currentPlayers skillCategories.
		 */
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			/**
			 * if the skillCategoryName equals the name that we are looking for the loop will be broken and the retVal will be set to the note that we are looking for.
			 */
			if (sc.getCategoryName().equals(categoryName))
			{
				retVal = sc.getCategoryNotes();
				break;
			}
			
		}
		
		/**
		 * Returns retVal that contains the note.
		 */
		return retVal;
		
	}
	
	/**
	 * 
	 * @param playerObj is a Player Object that contains the playerObj to add the skill category to.
	 * @param categoryName is a string variable that contains the name of the new category.
	 * @param categoryNote is a string variable that contains the note of the new category.
	 * @return retVal is a true or false value determined by the outcome of the method.
	 * <p>
	 * addSkillCategory Method.
	 * <br>
	 * This method starts of by declaring and initialising the variables that will be used in the method. This includes retVal which is a boolean and currentPlayer which holds the 
	 * player object that has been passed in and the placeholderList variable which holds an empty ArrayList variable to give to the skill Category while it has no skills.
	 * <br>
	 * A Try Catch is then used to catch any exceptions that may occur during the following processes.
	 * <br>
	 * The method then fetches the currentPlayers category skill list and it creates the new category inputting the categoryName, categoryNote and placeholderList from the passed 
	 * in values and the values that have been generated as part of the method.
	 * <br>
	 * The method will then loop through all of the other skill categories. 
	 * <br>
	 * During this process a check will be performed to check if any of the pre existing skill categories have the same name as the new one.
	 * If this is the case, the loop will break and retVal will be set to false.
	 * <br>
	 * The last step of the method is to check if the retVal variable is set to false, if this is the case the category will not be added to the system, if this is the case
	 * an error message will be displayed to the user.
	 * <br>
	 * retVal will then be returned to the view.
	 */
	protected boolean addSkillCategory(Player playerObj, String categoryName, String categoryNote)
	{
		
		/**
		 * Declares and initialises the retVal variable as true.
		 */
		boolean retVal = true;
		
		/**
		 * Declares and initialises the currentPlayer variable as the passed in playerObj variable.
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * Declares and initialises placeholderList as a new ArrayList.
		 */
		ArrayList<Skill> placeholderList = new ArrayList<Skill>();

		/**
		 * Opens a new try catch for catching any unexpected exceptions.
		 */
		try {
			
			/**
			 * Declares and initialises the currentSkillCategoryList as the list of skill categories of the currentPlayer.
			 */
			ArrayList<SkillCategory> currentSkillCategoryList = currentPlayer.getPlayerSkills();
			
			/**
			 * Declares and initialises newCategory as a new Skill Category. 
			 * The new category is populated with information using the passed in variables from the view and by the placeholderList that was just created.
			 */
			SkillCategory newCategory = new SkillCategory(categoryName, categoryNote , placeholderList);
			
			/**
			 * For loop that loops through each of the skill categories connected to our currentPlayer.
			 */
			for (SkillCategory sc: currentSkillCategoryList)
			{
				/**
				 * If any of the existing skill category names equal the new skill category name the loop will break and set retVal to false.
				 */
				if(sc.getCategoryName().toLowerCase().equals(newCategory.getCategoryName().toLowerCase()))
				{
					/**
					 * Catches the duplicate name by setting the retVal to false and breaking the loop.
					 */
					retVal = false;
					break;
				}
					
			}
			
			/**
			 * if the retVal is equal to false, do nothing
			 * else add the new skill category to the players skill category list and set retVal to true.
			 */
			if (retVal == false)
			{
				
			} else 
			{
				currentSkillCategoryList.add(newCategory);
				
				retVal = true;
			}
			
			}
			catch(Exception e) {
				
			}
		
		/**
		 * Returns retVal to the view.
		 */
		return retVal;
		
	}
		
	/**
	 * 
	 * @param playerObj contains the passed in player object that will be used to add the skill.
	 * @param categoryNameInput contains the name of the skillCategory that the skill will be added to.
	 * @param skillNameInput contains the name of the new skill that has been passed in by the view.
	 * @param skillRatingInput contains the rating of the new skill that has been passed in by the view.
	 * @return retVal which contains a true or false value that is used by the view to display error or success messages.
	 * <p>
	 * addSkill Method.
	 * <br>
	 * The first action of this method is that it takes the values from the parameters and stores them locally in the newName, newRating, categoryName and currentPlayer variables.
	 * retVal is also initialised and declared here.
	 * <br>
	 * A try catch is then opened to catch any unexpected errors that could occur during the following process.
	 * <br>
	 * Next, the currentSkillCategoryList is declared and initialised as well as the newSkill object that now contains the new skill information.
	 * <br>
	 * Next, A loop is started to loop through the SkillCategories connected to the player. Once the skill category is found another loop is started. 
	 * Within this loop a check is performed to make sure that the skill is a duplicate.
	 * <br>
	 * If the skill name is a duplicate then, the loop will break and set retVal to false.
	 * <br>
	 * The retVal is then checked to determine the final output of the method, if the retVal is set to false then nothing will happen here, however on the view an error message will be displayed
	 * once the value is returned.
	 * If the retVal is true, the new skill will be added to the category.
	 * <p>
	 * retVal is then returned, this will prompt either a success message or error message on the view.
	 */
	
	public boolean addSkill(Player playerObj, String categoryNameInput, String skillNameInput, int skillRatingInput)
	{
		
		/**
		 * Declares and initialises the retVal variable as true.
		 */
		boolean retVal = true;
		
		/**
		 * Declares and initialises the newName variable as the passed in skillNameInput. 
		 */
		String newName = skillNameInput;
		
		/**
		 * Declares and initialises the skillRating variable as the passed in skillRatingInput. 
		 */
		int newRating = skillRatingInput;
		
		/**
		 * Declares and initialises the categoryName variable as the passed in categoryNameInput. 
		 */
		String categoryName = categoryNameInput;
		
		/**
		 * Declares and initialises the playerObj variable as the passed in playerObj. 
		 */
		Player currentPlayer = playerObj;

		/**
		 * Opens a new try catch for catching any unexpected exceptions.
		 */
		try {
			
			/**
			 * Declares and initialises the currentSkillCategoryList as the list of skill categories of the currentPlayer.
			 */
			ArrayList<SkillCategory> currentSkillCategoryList = currentPlayer.getPlayerSkills();
			
			/**
			 * Declares and Initialises the newSkill variable.
			 */
			Skill newSkill = new Skill(newName, newRating);
			
			/**
			 * for loop that loops through the Players skill categories to find the category that matches the categoryName selected during the adding process.
			 */
			for (SkillCategory sc: currentSkillCategoryList)
			{
				/*
				 * Converts both of the values to lower case to match the characters.
				 * If the category is found.
				 */
				if(sc.getCategoryName().toLowerCase().equals(categoryName.toLowerCase()))
				{
					
					/*
					 * currentSkillList is declared and initialised to hold the current list of skills within the category.
					 */
					ArrayList<Skill> currentSkillList = sc.getCategorySkillList();
					
					/*
					 * A check is then performed to check if the skill already exists within the category.
					 */
					for (Skill s: currentSkillList)
					{
						/*
						 * if the skill name is a duplicate retVal is set to false and the loop breaks, allowing for the next check to take place.
						 */
						
						if (s.getSkillName().toLowerCase().equals(newName.toLowerCase()))
						{
							retVal = false;
							break;
						}

					}
					
					/**
					 * If retVal is set to false, nothing happens
					 * If retVal is set to true, the skill is added to the user.
					 */
					if (retVal == false)
					{
					} else 
					{
						
						currentSkillList.add(newSkill);
						
						retVal = true;
					}
					
				}
				
			}
		
			}
			catch(Exception e) {
			  //  Block of code to handle errors
			}
		
		/**
		 * retVal is returned to the view for message handling.
		 */
		return retVal;
		
	}
	
	/**
	 * 
	 * @param playerObj contains the player object that the skill note is being updated in.
	 * @param categoryName contains the string value for the category name.
	 * @param newValue contains the string value that holds the new value for the category note.
	 * @return retVal which is used to display a success message or error message on the view.
	 * <p>
	 * editCategoryNote method.
	 * <br>
	 * The first action of the method is getting the passed in values and setting them to local variables, those variables are as follows:
	 * <br>
	 * retVal, currentPlayer, nameOfCategory, newNoteValue
	 * <br>
	 * The method then loops through the currentPlayers skill categories to find the category that is to be updated. 
	 * <br>
	 * Once found, the setter from the Skill Category class is used to set the new value of the attribute. During this process the loop is also stopped and retVal is set to True.
	 * <br>
	 * RetVal is then returned to the view for success message or error message handling.
	 */
	
	protected boolean editCategoryNote(Player playerObj, String categoryName, String newValue)
	{
		
		/**
		 * retVal is declared and initialised as false.
		 */
		boolean retVal = false;
		
		/**
		 * Declares and initialises currentPlayer as the passed in player object.
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * Declares and initialises the nameOfCategory variable as the passed in categoryName string.
		 */
		String nameOfCategory = categoryName;
		
		/**
		 * Declares and initialises the newNoteValue variable as the passed in newValue string.
		 */
		String newNoteValue = newValue;
		
		/**
		 * Loops through the currentPlayers skill categories
		 */
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			
			/**
			 * If the skill category names match
			 * The value of the category note is updated, retVal is set to true and the loop breaks.
			 */
			if (sc.getCategoryName().equals(nameOfCategory))
			{
				sc.setCategoryNotes(newNoteValue);
				retVal = true;
				break;
			}

		}
		
		/**
		 * Returns retVal to be used in success and error messaging within the view.
		 */
		return retVal;

	}
	
	/**
	 * 
	 * @param playerObj is a Player Object that is passed to the method. It holds the Player Object that contains the skill that is to be updated.
	 * @param categoryName is a string value that is passed to the method. It holds the name of the category that contains the skill that needs to be updated.
	 * @param skillName is a string value that is passed to the method. It holds the name of the skill that needs to be updated.
	 * @param newValueInput is an integer value that is passed to the method. It holds the updated value for the rating.
	 * @return retVal is a boolean value that is returned for use by the view for displaying success or error messages.
	 * <p>
	 * editSkillRating Method.
	 * <br>
	 * Firstly, the method declares and initialises required variables this includes the passed in values named as follows:
	 * <br>
	 * currentPlayer, nameOfCategory, nameOfSkill and newValue.
	 * <br>
	 * The method then loops through the currentPlayers skill categories searching for category name equal to nameOfCategory variable.
	 * <br>
	 * Once found the method then loops through the players skills to search for the skill name equal to nameOfSkill variable.
	 * <br>
	 * Once found the skill rating is updated using the setter for skill rating from the skill class.
	 * <br>
	 * retVal then returns true that will prompt a success message on the view.
	 */
	
	protected boolean editSkillRating(Player playerObj, String categoryName, String skillName, int newValueInput)
	{
		
		/**
		 * Declares and initialises the retVal to false.
		 */
		boolean retVal = false;
		
		/**
		 * Declares and initialises the currentPlayer player object to the passed in player object value.
		 */
		Player currentPlayer = playerObj;
		
		/**
		 * Declares and initialises the nameOfCategory string to the passed in categoryName string value.
		 */
		String nameOfCategory = categoryName;
		
		/**
		 * Declares and initialises the nameOfSkill string to the passed in skillName string value.
		 */
		String nameOfSkill = skillName;
		
		/**
		 * Declares and initialises the newValue integer to the passed in newValueInput integer value.
		 */
		int newValue = newValueInput;
		
		/**
		 * Loops through the current players skill categories.
		 */
		for (SkillCategory sc : currentPlayer.getPlayerSkills())
		{
			/**
			 * If the current skill category name is equal to the name of the category that is being searched for.
			 */
			if (sc.getCategoryName().equals(nameOfCategory))
			{
				/**
				 * Declares and Initialises the skills ArrayList that is used to store the skills that are a part of the current category.
				 */
				ArrayList<Skill> skills = sc.getCategorySkillList();
				
				/**
				 * Loops through the new skills array list.
				 */
				for (Skill s: skills)
				{
					
					/**
					 * If the skillName is equal to the name of the skill that is being searched for the rating is updated 
					 * by using the setter for rating that is apart of the skill class.
					 */
					if (s.getSkillName().equals(nameOfSkill))
					{
						/**
						 * Sets the rating to the new value.
						 * Sets retVal to true.
						 */
						s.setRating(newValue);
						retVal = true;
						
					}
					
				}
				
			}
			
		}
		
		/**
		 * Returns retVal for use in the view for displaying success or error messages.
		 */
		return retVal;
	}
}