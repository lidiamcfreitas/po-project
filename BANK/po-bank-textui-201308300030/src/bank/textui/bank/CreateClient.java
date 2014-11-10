/** @version $Id: CreateClient.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;
import bank.Client;

/**
 * Command for creating a new client.
 */
public class CreateClient extends Command<Bank> {
	/**
	 * @param receiver
	 *            the bank for the new client.
	 */
	public CreateClient(Bank receiver) {
		super(false, MenuEntry.CREATE_CLIENT, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		String name = IO.readString(Message.requestClientName());
		int id = IO.readInteger(Message.requestClientId());
		Client client = _receiver.createClient(name, id);
		IO.println(Message.createdClient(client.getId()));
	}
}

// $Log: CreateClient.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//