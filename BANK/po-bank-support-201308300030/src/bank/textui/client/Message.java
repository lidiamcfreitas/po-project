/** @version $Id: Message.java,v 1.2 2011/09/25 14:49:11 david Exp $ */
package bank.textui.client;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for name
	 */
	public static final String requestName() {
		return "Nome? ";
	}
}

// $Log: Message.java,v $
// Revision 1.2 2011/09/25 14:49:11 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//