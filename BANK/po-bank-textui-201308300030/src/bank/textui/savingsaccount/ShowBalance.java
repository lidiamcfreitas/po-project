/** @version $Id: ShowBalance.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.savingsaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import bank.SavingsAccount;

/**
 * Command for showing a savings account balance
 */
public class ShowBalance extends Command<SavingsAccount> {

	/**
	 * @param receiver
	 *            the target savings account
	 */
	public ShowBalance(SavingsAccount receiver) {
		super(MenuEntry.SHOW_BALANCE, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() {
		IO.println(Message.showBalance(_receiver.getBalance()));
	}
}

// $Log: ShowBalance.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//