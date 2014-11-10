/** @version $Id: MenuBuilder.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import ist.po.ui.Command;
import ist.po.ui.Menu;
import bank.Bank;
import bank.BankAccount;

/**
 * Menu builder for bank accounts.
 */
public abstract class MenuBuilder {

	/**
	 * @param bankAccount 
	 * @param bank
	 */
	public static void menuFor(BankAccount bankAccount, Bank bank) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new Deposit(bankAccount),
				new Withdraw(bankAccount),
				new ShowBalance(bankAccount, false),
				new ShowBalance(bankAccount, true),
				new ShowAccountClients(bankAccount),
				new CreateSavingsAccount(bankAccount),
				new ShowAllSavingsAccounts(bankAccount),
				new ShowSpecificSavingsAccount(bankAccount),
				new RemoveAccount(bankAccount, bank) });
		menu.open();
	}

}

// $Log: MenuBuilder.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//