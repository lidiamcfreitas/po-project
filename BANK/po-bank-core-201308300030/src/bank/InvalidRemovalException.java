/** @version $Id: InvalidRemovalException.java,v 1.2 2011/09/25 14:47:43 david Exp $ */
package bank;

/**
 * Exception for unsuccessful removal operations.
 */
public class InvalidRemovalException extends BankException {
	/** Serial number. */
	private static final long serialVersionUID = 201010181631L;

	/** The account */
	private final int _account;

	/** The amount in the account */
	private final double _amount;

	/**
	 * @param account
	 * @param amount
	 */
	public InvalidRemovalException(int account, double amount) {
		_account = account;
		_amount = amount;
	}

	/**
	 * @return the account
	 */
	public int getAccount() {
		return _account;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return _amount;
	}
}

// $Log: InvalidRemovalException.java,v $
// Revision 1.2 2011/09/25 14:47:43 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//
