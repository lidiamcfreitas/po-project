/** @version $Id: InvalidDateException.java,v 1.2 2011/09/25 14:49:11 david Exp $ */
package bank.textui.bank;

import ist.po.ui.DialogException;

/**
 * User interface exception for presenting bad dates.
 */
@SuppressWarnings("nls")
public class InvalidDateException extends DialogException {

	/** Serial number. */
	private static final long serialVersionUID = 4928801929604037903L;

	/** The invalid date. */
	private int _date;

	/**
	 * @param date
	 */
	public InvalidDateException(int date) {
		_date = date;
	}

	/**
	 * @see ist.po.ui.DialogException#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Data inválida: " + _date;
	}

}

// $Log: InvalidDateException.java,v $
// Revision 1.2 2011/09/25 14:49:11 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//