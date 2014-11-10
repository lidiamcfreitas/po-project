/** @version $Id: Withdraw.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.BalanceTooLowException;
import bank.BankAccount;
import bank.InvalidWithdrawalException;
import bank.NegativeAmountException;

/**
 * This class represents a withdrawal command.
 */
public class Withdraw extends Command<BankAccount> {

	/**
	 * @param receiver
	 *            the target account
	 */
	public Withdraw(BankAccount receiver) {
		super(MenuEntry.WITHDRAW, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		try {
			float amount = IO.readFloat(Message.requestAmount());
			_receiver.withdraw(amount);
		} catch (InvalidWithdrawalException e) {
			throw new InvalidWithdrawalUIException(e.getMessage());
		} catch (NegativeAmountException e) {
			throw new NegativeWithdrawalUIException(e.getAmount());
		} catch (BalanceTooLowException e) {
			throw new NoBalanceWithdrawalUIException(e.getBalance(), e.getAmount());
		}
	}
}

// $Log: Withdraw.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//