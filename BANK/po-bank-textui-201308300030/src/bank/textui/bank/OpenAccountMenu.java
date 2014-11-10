/** @version $Id: OpenAccountMenu.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;
import bank.BankAccount;

/**
 * Command for opening a specific account's menu.
 */
public class OpenAccountMenu extends Command<Bank> {
	/**
	 * @param receiver
	 *            the target bank
	 */
	public OpenAccountMenu(Bank receiver) {
		super(false, MenuEntry.ACCOUNT_MENU, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestAccountId());
		BankAccount account = _receiver.getAccount(id);
		if (account == null)
			IO.println(Message.errorSelectingAccount(id));
		else
			bank.textui.bankaccount.MenuBuilder.menuFor(account, _receiver);
	}
}

// $Log: OpenAccountMenu.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//