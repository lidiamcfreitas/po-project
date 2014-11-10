/** @version $Id: NegativeDepositUIException.java,v 1.1 2011/09/25 14:49:09 david Exp $ */
package bank.textui.bankaccount;

import ist.po.ui.DialogException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class NegativeDepositUIException extends DialogException {

	/** Serial number. */
	private static final long serialVersionUID = 4928801929604037903L;

	/** Value. */
	private double _amount;

	/**
	 * @param amount
	 */
	public NegativeDepositUIException(double amount) {
		_amount = amount;
	}

	/**
	 * @see ist.po.ui.DialogException#getMessage()
	 */
	@Override
	public String getMessage() {
		return Message.invalidNegativeAmountDeposit(_amount);
	}

}

// $Log: NegativeDepositUIException.java,v $
// Revision 1.1 2011/09/25 14:49:09 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//