
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	
	/**
	 * The name of the bank.
	 */
	private String name;
	
	/**
	 * The account holders of the bank.
	 */
	private ArrayList<User> users;
	
	/**
	 * The accounts of the bank.
	 */
	private ArrayList<Account> accounts;
	
	/**
	 * Create a new Bank object with empty lists of users and accounts.
	 */
	public Bank(String name) {
		
		this.name = name;
		
		// init users and accounts
		users = new ArrayList<User>();
		accounts = new ArrayList<Account>();
		
	}
	
	/**
	 * Generate a new universally unique ID for a user.
	 * @return	the uuid
	 */
	public String getNewUserUUID() {
		
		// inits
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		// continue looping until we get a unique ID
		do {
			
			// generate the number
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
	}
	
	/**
	 * Generate a new universally unique ID for an account.
	 * @return	the uuid
	 */
	public String getNewAccountUUID() {
		
		// inits
		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique = false;
		
		// continue looping until we get a unique ID
		do {
			
			// generate the number
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
				
	}

	/**
	 * Create a new user of the bank.
	 * @param firstName	the user's first name
	 * @param lastName	the user's last name
	 * @param pin				the user's pin
	 * @return					the new User object
	 */
	public User addUser(String firstName, String lastName, String pin) {
		
		// create a new User object and add it to our list
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		// create a savings account for the user and add it to our list
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		
		return newUser;
		
	}
	
	/**
	 * Add an existing account for a particular User.
	 * @param newAccount	the account
	 */
	public void addAccount(Account newAccount) {
		this.accounts.add(newAccount);
	}
	
	/**
	 * Get the User object associated with a particular userID and pin, if they
	 * are valid.
	 * @param userID	the user UUID to log in
	 * @param pin		the associate pin of the user
	 * @return			the User object, if login is successfull, or null, if 
	 * 					it is not
	 */
	public User userLogin(String userID, String pin) {
		
		// search through list of users
		for (User u : this.users) {
			
			// if we find the user, and the pin is correct, return User object
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		
		// if we haven't found the user or have an incorrect pin, return null
		return null;
		
	}
	
	/**
	 * Get the name of the bank.
	 * @return	the name
	 */
	public String getName() {
		return this.name;
	}

}
