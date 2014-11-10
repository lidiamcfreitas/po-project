/** @version $Id: ChangeName.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.client;

import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Client;

/**
 * Command for changing a client's name.
 */
public class ChangeName extends Command<Client> {

	/**
	 * @param receiver
	 *            the client executing the command.
	 */
	public ChangeName(Client receiver) {
		super(MenuEntry.CHANGE_NAME, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		// TODO  (alunos)
	}
}

// $Log: ChangeName.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//