/** @version $Id: ShowAccountClients.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.BankAccount;

/**
 * Command for showing all the clients in an account.
 */
public class ShowAccountClients extends Command<BankAccount> {
	/**
	 * @param receiver
	 *            the account executing the command.
	 */
	public ShowAccountClients(BankAccount receiver) {
		super(MenuEntry.SHOW_ACCOUNT_CLIENTS, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(_receiver.getClients().toString());
	}
}

// $Log: ShowAccountClients.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//