/** @version $Id: ShowAllSavingsAccounts.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.List;

import bank.BankAccount;
import bank.SavingsAccount;

/**
 * This class represents a command for showing all the savings accounts.
 */
public class ShowAllSavingsAccounts extends Command<BankAccount> {

	/**
	 * @param receiver
	 *            the target account.
	 */
	public ShowAllSavingsAccounts(BankAccount receiver) {
		super(MenuEntry.SHOW_ALL_SAVINGS_ACCOUNTS, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		List<SavingsAccount> accounts = _receiver.getSavingsAccounts();
		if (accounts != null)
			IO.println(accounts.toString());
		else
			IO.println(Message.errorShowingSavingsAccounts());
	}
}

// $Log: ShowAllSavingsAccounts.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//