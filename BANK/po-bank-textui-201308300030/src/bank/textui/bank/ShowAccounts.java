/** @version $Id: ShowAccounts.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;

/**
 * Show all the accounts in the bank.
 */
public class ShowAccounts extends Command<Bank> {
	/**
	 * @param receiver
	 *            the bank.
	 */
	public ShowAccounts(Bank receiver) {
		super(MenuEntry.SHOW_ACCOUNTS, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(_receiver.getAccounts().toString());
	}
}

/*
 * $Log: ShowAccounts.java,v $
 * Revision 1.2  2011/09/25 14:49:28  david
 * New version of the bank application. The textui version has been updated
 * and now uses exceptions as a bridge to convey to the menu class errors
 * in operations.
 *
 * 
 */
