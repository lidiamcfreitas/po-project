/** @version $Id: MenuBuilder.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.savingsaccount;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import bank.SavingsAccount;

/**
 * Menu builder for savings accounts.
 */
public abstract class MenuBuilder {

	/**
	 * @param account
	 */
	public static void menuFor(SavingsAccount account) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new ShowBalance(account),
				new Close(account)
				});
		menu.open();
	}

}

// $Log: MenuBuilder.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//