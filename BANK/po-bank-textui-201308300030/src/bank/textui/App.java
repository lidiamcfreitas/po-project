/** @version $Id: App.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui;

import static ist.po.ui.Dialog.IO;
import bank.Bank;

/**
 * This is a sample client for bank classes. It uses a text-based user
 * interface.
 */
public class App {
	/**
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		Bank myBank;
		if (args.length == 1) {
			myBank = new Bank(args[0]);
		} else {
			IO.println("Número de argumentos inválido.");
			return;
		}
		bank.textui.bank.MenuBuilder.menuFor(myBank);
		IO.closeDown();
	}

}

// $Log: App.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//
