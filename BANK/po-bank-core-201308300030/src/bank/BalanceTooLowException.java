/** @version $Id: BalanceTooLowException.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

/**
 * Balance is lower than amount being withdrawn.
 */
public class BalanceTooLowException extends BankException {
	/** Serial number. */
	private static final long serialVersionUID = 201010181631L;

	/** Current balance */
	private final double _balance;

	/** Invalid amount */
	private final double _amount;

	/**
	 * @param balance
	 *            the balance
	 * @param amount
	 *            the invalid amount
	 */
	public BalanceTooLowException(double balance, double amount) {
		_balance = balance;
		_amount = amount;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return _balance;
	}

	/**
	 * @return the invalid amount
	 */
	public double getAmount() {
		return _amount;
	}
}

// $Log: BalanceTooLowException.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//