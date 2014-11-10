/** @version $Id: RemoveAccount.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.Bank;
import bank.BankAccount;
import bank.InvalidRemovalException;

/**
 * This class represents the removal of a bank account. If successful, the
 * control should return to the previous menu.
 */
public class RemoveAccount extends Command<BankAccount> {
	/** The bank owning the account. */
	Bank _bank;

	/**
	 * @param receiver
	 *            the target account.
	 * @param bank
	 *            the bank the account belongs to.
	 */
	public RemoveAccount(BankAccount receiver, Bank bank) {
		super(true, MenuEntry.REMOVE_ACCOUNT, receiver);
		_bank = bank;
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		try {
			_bank.removeAccount(_receiver);
		} catch (InvalidRemovalException e) {
			throw new InvalidRemovalUIException(e.getAccount(), e.getAmount());
		}
	}
}

// $Log: RemoveAccount.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//