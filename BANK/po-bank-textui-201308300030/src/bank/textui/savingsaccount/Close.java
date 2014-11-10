/** @version $Id: Close.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.savingsaccount;

import ist.po.ui.Command;
import bank.SavingsAccount;

/**
 * Command for closing a savings account
 */
public class Close extends Command<SavingsAccount> {

	/**
	 * @param receiver
	 *            the target savings account
	 */
	public Close(SavingsAccount receiver) {
		super(true, MenuEntry.CLOSE, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() {
		_receiver.close();
	}
}

// $Log: Close.java,v $
// Revision 1.2 2011/09/25 14:49:28 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//