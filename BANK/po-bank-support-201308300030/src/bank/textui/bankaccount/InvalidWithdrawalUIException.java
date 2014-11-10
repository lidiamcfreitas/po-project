/** @version $Id: InvalidWithdrawalUIException.java,v 1.1 2011/09/25 14:49:10 david Exp $ */
package bank.textui.bankaccount;

import ist.po.ui.DialogException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidWithdrawalUIException extends DialogException {

	/** Serial number. */
	private static final long serialVersionUID = 4928801929604037903L;

	/** Error message. */
	private String _message;

	/**
	 * @param message
	 */
	public InvalidWithdrawalUIException(String message) {
		_message = message;
	}

	/**
	 * @see ist.po.ui.DialogException#getMessage()
	 */
	@Override
	public String getMessage() {
		return _message;
	}

}

// $Log: InvalidWithdrawalUIException.java,v $
// Revision 1.1 2011/09/25 14:49:10 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//