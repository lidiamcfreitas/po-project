/** @version $Id: OpenClientMenu.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;
import bank.Client;

/**
 * Class for opening a client's menu.
 */
public class OpenClientMenu extends Command<Bank> {
	/**
	 * @param receiver
	 *            the bank executing the command.
	 */
	public OpenClientMenu(Bank receiver) {
		super(false, MenuEntry.CLIENT_MENU, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestClientId());
		Client client = _receiver.getClient(id);
		if (client == null)
			IO.println(Message.noSuchClient(id));
		else
			bank.textui.client.MenuBuilder.menuFor(client);
	}
}

// $Log: OpenClientMenu.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//