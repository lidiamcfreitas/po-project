/** @version $Id: ShowSpecificSavingsAccount.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;
import java.util.List;

import bank.BankAccount;
import bank.SavingsAccount;

/**
 * Class for showing a specific savings account.
 */
public class ShowSpecificSavingsAccount extends Command<BankAccount> {

	/**
	 * @param receiver
	 *            the target bank account
	 */
	public ShowSpecificSavingsAccount(BankAccount receiver) {
		super(MenuEntry.SHOW_SAVINGS_ACCOUNT, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestSavingsAccountId());
		List<SavingsAccount> accounts = _receiver.getSavingsAccounts();
		if (accounts != null) {
			for (SavingsAccount account : accounts) {
				if (account.getId() == id) {
					bank.textui.savingsaccount.MenuBuilder.menuFor(account);
					return;
				}
			}
		}
		IO.println(Message.errorShowingSavingsAccount());
	}
}

// $Log: ShowSpecificSavingsAccount.java,v $
// Revision 1.2 2011/09/25 14:49:28 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//