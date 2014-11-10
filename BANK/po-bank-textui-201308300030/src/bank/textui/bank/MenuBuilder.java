/** @version $Id: MenuBuilder.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import bank.Bank;

/**
 * Menu builder for bank instances.
 */
public class MenuBuilder {

	/**
	 * @param bank
	 */
	public static void menuFor(Bank bank) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new CreateClient(bank),
				new CreateAccount(bank),
				new ShowClients(bank),
				new ShowAccounts(bank),
				new OpenClientMenu(bank),
				new OpenAccountMenu(bank) });
		menu.open();
	}
	
}

// $Log: MenuBuilder.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//