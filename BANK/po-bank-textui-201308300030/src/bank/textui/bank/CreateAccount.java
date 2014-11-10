/** @version $Id: CreateAccount.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bank;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;
import bank.BankAccount;

/**
 * Class for representing account creation.
 */
public class CreateAccount extends Command<Bank> {
	/**
	 * @param bank
	 *            the target bank
	 */
	public CreateAccount(Bank bank) {
		super(false, MenuEntry.CREATE_ACCOUNT, bank);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute()  throws DialogException, IOException {
		double amount = IO.readFloat(Message.requestInitialBalance());
		BankAccount account = _receiver.createAccount(amount);
		IO.println(Message.accountCreated(account.getId()));
	}
}

// $Log: CreateAccount.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//