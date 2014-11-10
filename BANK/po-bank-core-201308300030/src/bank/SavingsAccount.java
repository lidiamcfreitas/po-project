/** @version $Id: SavingsAccount.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

/**
 * Class for savings accounts. Savings accounts have a minimum time period.
 */
public class SavingsAccount extends DepositAccount {
	/** Serial number. */
	private static final long serialVersionUID = 201010181458L;

	/** The account's time period. */
	private int _time;

	/** The bank account associated with this savings account. */
	private BankAccount _account;

	/**
	 * @param amount
	 *            the initial balance.
	 * @param rate
	 *            the account's interest rate.
	 * @param time
	 *            the account's time period.
	 * @param account
	 *            the associated bank account.
	 */
	public SavingsAccount(double amount, double rate, int time, BankAccount account) {
		super(rate, amount);
		_time = time;
		_account = account;
		_account.addSavingsAccount(this);
	}

	/**
	 * @return the account's time period.
	 */
	final public int getTime() {
		return _time;
	}

	/**
	 * Close savings account. The balance of the account is added to the bank
	 * account associated with the savings account (which is then removed from
	 * the list of savings accounts). This method considers interest only after
	 * the time associated with the savings account has finished (otherwise,
	 * only the initial balance is deposited in the bank account).
	 */
	public void close() {
		try {
			if (Calendar.getCalendar().daysSince(_initialDate) >= _time)
				_account.deposit(_balance * (1 + _rate));
			else
				_account.deposit(_balance);
		} catch (InvalidDepositException e) {
			// never happens
		} catch (NegativeAmountException e) {
			// never happens: _balance is never negative.
		}
	}

	/**
	 * Savings accounts can only be initialized: they cannot be the object of
	 * deposit operations.
	 * 
	 * @param amount
	 *            the amount to be deposited (ignored).
	 * @throws InvalidDepositException
	 *             since it is not possible to make deposits in savings
	 *             accounts.
	 */
	@Override
	public void deposit(double amount) throws InvalidDepositException {
		throw new InvalidDepositException();
	}

	/**
	 * Withdrawals cannot be performed on savings accounts.
	 * 
	 * @param amount
	 *            the amount to be withdrawn (ignored).
	 * @throws InvalidWithdrawalException
	 *             since it is not possible to perform withdrawals from savings
	 *             accounts.
	 */
	@Override
	public void withdraw(double amount) throws InvalidWithdrawalException {
		throw new InvalidWithdrawalException();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "<savings-account initial='" + _initialDate + "' timelimit='" + _time
				+ "' balance='" + _balance + "'/>";
	}

}

// $Log: SavingsAccount.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//