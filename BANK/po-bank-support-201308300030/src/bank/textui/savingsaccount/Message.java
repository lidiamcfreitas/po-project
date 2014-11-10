/** @version $Id: Message.java,v 1.2 2011/09/25 14:49:10 david Exp $ */
package bank.textui.savingsaccount;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @param balance
	 * @return string showing the account's balance
	 */
	public static final String showBalance(double balance) {
		return "Saldo corrente: " + balance;
	}
}

// $Log: Message.java,v $
// Revision 1.2 2011/09/25 14:49:10 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//