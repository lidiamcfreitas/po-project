/** @version $Id: NegativeAmountException.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

/**
 * Exception for negative amounts.
 */
public class NegativeAmountException extends BankException {
	/** Serial number. */
	private static final long serialVersionUID = 201010181631L;

	/** Invalid amount */
	private final double _amount;

	/**
	 * @param amount
	 */
	public NegativeAmountException(double amount) {
		_amount = amount;
	}

	/**
	 * @return the negative amount
	 */
	public double getAmount() {
		return _amount;
	}
}

// $Log: NegativeAmountException.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//