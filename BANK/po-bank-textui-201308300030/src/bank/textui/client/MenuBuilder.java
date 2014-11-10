/** @version $Id: MenuBuilder.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.client;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import bank.Client;

/**
 * Menu builder for clients. 
 */
public abstract class MenuBuilder {

	/**
	 * @param client
	 */
	public static void menuFor(Client client) {
		Menu menu = new Menu(MenuEntry.TITLE,
				new Command<?>[] { new ChangeName(client) });
		menu.open();
	}

}

// $Log: MenuBuilder.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//