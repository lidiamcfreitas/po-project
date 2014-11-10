/** @version $Id: NoBalanceWithdrawalUIException.java,v 1.1 2011/09/25 14:49:10 david Exp $ */
package bank.textui.bankaccount;

import ist.po.ui.DialogException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class NoBalanceWithdrawalUIException extends DialogException {

	/** Serial number. */
	private static final long serialVersionUID = 4928801929604037903L;

	/** Balance. */
	private double _balance;

	/** Amount. */
	private double _amount;

	/**
	 * @param balance
	 * @param amount
	 */
	public NoBalanceWithdrawalUIException(double balance, double amount) {
		_balance = balance;
		_amount = amount;
	}

	/**
	 * @see ist.po.ui.DialogException#getMessage()
	 */
	@Override
	public String getMessage() {
		return Message.notEnoughBalance(_balance, _amount);
	}

}

// $Log: NoBalanceWithdrawalUIException.java,v $
// Revision 1.1 2011/09/25 14:49:10 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//