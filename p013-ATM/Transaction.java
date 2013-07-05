
import java.util.Date;

public class Transaction {
	
	/**
	 * The amount of this transaction.
	 */
	private double amount;
	
	/**
	 * The time and date of this transaction.
	 */
	private Date timestamp;
	
	/**
	 * A memo for this transaction.
	 */
	private String memo;
	
	/**
	 * The account in which the transaction was performed.
	 */
	private Account inAccount;
	
	/**
	 * Create a new transaction.
	 * @param amount		the dollar amount transacted
	 * @param inAccount	the account the transaction belongs to
	 */
	public Transaction(double amount, Account inAccount) {
		
		this.amount = amount;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
		
	}
	
	/**
	 * Create a new transaction with a memo.
	 * @param amount	the dollar amount transacted
	 * @param memo		the memo for the transaction
	 * @param inAccount	the account the transaction belongs to
	 */
	public Transaction(double amount, String memo, Account inAccount) {
		
		// call the single-arg constructor first
		this(amount, inAccount);
		
		this.memo = memo;
		
	}
	
	/**
	 * Get the transaction amount.
	 * @return	the amount of the transaction
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Get a string summarizing the transaction
	 * @return the summary string
	 */
	public String getSummaryLine() {
		
		if (this.amount >= 0) {
			return String.format("%s, $%.02f : %s", 
					this.timestamp.toString(), this.amount, this.memo);
		} else {
			return String.format("%s, $(%.02f) : %s", 
					this.timestamp.toString(), -this.amount, this.memo);
		}
	}

}
