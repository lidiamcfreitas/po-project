/** @version $Id: ShowBalance.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.BankAccount;

/**
 * Class representing a command for showing the balance of an account.
 */
public class ShowBalance extends Command<BankAccount> {

	/** If true show the total balance. */
	private boolean _showTotalBalance = false;

	/**
	 * @param receiver
	 *            the target bank account.
	 * @param showTotalBalance
	 *            if true, show the total balance; otherwise, show only the
	 *            demand account's balance.
	 */
	public ShowBalance(BankAccount receiver, boolean showTotalBalance) {
		super(showTotalBalance ? Message.titleTotalBalance() : Message.titleDemandBalance(),
				receiver);
		_showTotalBalance = showTotalBalance;
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(_showTotalBalance ? Message.showTotalBalance(_receiver.getBalance()) : Message
				.showDemandBalance(_receiver.getDemandAccountBalance()));
	}
}

// $Log: ShowBalance.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//