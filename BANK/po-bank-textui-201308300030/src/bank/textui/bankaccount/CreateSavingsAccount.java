/** @version $Id: CreateSavingsAccount.java,v 1.2 2011/09/25 14:49:28 david Exp $ */
package bank.textui.bankaccount;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import bank.BalanceTooLowException;
import bank.BankAccount;
import bank.InvalidWithdrawalException;
import bank.NegativeAmountException;
import bank.SavingsAccount;

/**
 * Class for creating a savings account.
 */
public class CreateSavingsAccount extends Command<BankAccount> {

	/**
	 * @param receiver
	 *            the target bank account.
	 */
	public CreateSavingsAccount(BankAccount receiver) {
		super(MenuEntry.CREATE_SAVINGS_ACCOUNT, receiver);
	}

	/**
	 * @see ist.po.ui.Command#execute()
	 */
	@Override
	public final void execute() throws DialogException, IOException {
		try {
			float amount = IO.readFloat(Message.requestAmount());
			_receiver.withdraw(amount);
			float rate = IO.readFloat(Message.requestRate());
			int time = IO.readInteger(Message.requestTime());
			SavingsAccount account = new SavingsAccount(amount, rate, time, _receiver);
		} catch (InvalidWithdrawalException e) {
			throw new InvalidWithdrawalUIException(Message.invalidWithdrawal());
		} catch (NegativeAmountException e) {
			throw new NegativeDepositUIException(e.getAmount());
		} catch (BalanceTooLowException e) {
			throw new NoBalanceWithdrawalUIException(e.getBalance(), e.getAmount());
		}
	}
}

// $Log: CreateSavingsAccount.java,v $
// Revision 1.2  2011/09/25 14:49:28  david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//