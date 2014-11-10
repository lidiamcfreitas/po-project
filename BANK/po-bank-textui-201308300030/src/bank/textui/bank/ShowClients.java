/** @version $Id: ShowClients.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;

/**
 * Command for showing all clients.
 */
public class ShowClients extends Command<Bank> {
	/**
	 * @param receiver
	 *            the bank executing the command.
	 */
	public ShowClients(Bank receiver) {
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

// $Log: ShowClients.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//