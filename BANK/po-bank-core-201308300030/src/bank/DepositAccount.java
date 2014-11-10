/** @version $Id: DepositAccount.java,v 1.2 2011/09/25 14:47:43 david Exp $ */
package bank;

import java.io.Serializable;

/**
 * This is an abstract class representing a deposit account. Subclasses refine
 * this class in accordance with the type of service provided by the bank. In
 * its most abstract form, a deposit account keeps track of the account's
 * balance, interest rate, deposit date and a deposit number. This number
 * uniquely identifies deposit accounts.
 */
public abstract class DepositAccount implements Serializable {
	/** Serial number. */
	private static final long serialVersionUID = 201010151622L;

	/** The shared counter for numbering deposit accounts. */
	private static int _nextId = 0;

	/** The deposit account balance. */
	protected double _balance;

	/** The deposit account's creation date. */
	protected long _initialDate;

	/** The deposit account id. */
	protected int _id;

	/** The deposit account's interest rate. */
	protected double _rate;

	/**
	 * Initialize a deposit account with a given interest rate and a given
	 * initial amount. The number is taken from the internal shared counter
	 * _nextNumber. The date is set to the current day.
	 * 
	 * @param rate
	 *            the deposit account interest rate.
	 * @param amount
	 *            the deposit account's initial balance.
	 */
	public DepositAccount(double rate, double amount) {
		_balance = amount;
		_id = _nextId++;
		_rate = rate;
		_initialDate = Calendar.getCalendar().today();
	}

	/**
	 * @param amount
	 *            the amount to be deposited.
	 * @throws InvalidDepositException
	 *             if it not possible to perform the deposit.
	 * @throws NegativeAmountException
	 *             if the amount is not positive.
	 */
	abstract public void deposit(double amount) throws InvalidDepositException,
			NegativeAmountException;

	/**
	 * @param amount
	 *            the amount to be withdrawn.
	 * @throws InvalidWithdrawalException
	 *             if the withdrawal is not possible.
	 * @throws NegativeAmountException
	 *             if the amount is not positive.
	 * @throws BalanceTooLowException
	 */
	public abstract void withdraw(double amount) throws InvalidWithdrawalException,
			NegativeAmountException, BalanceTooLowException;

	/**
	 * Returns the current balance.
	 * 
	 * @return the current balance.
	 */
	public double getBalance() {
		return _balance;
	}

	/**
	 * @return the date of the deposit.
	 */
	final public long getInitialDate() {
		return _initialDate;
	}

	/**
	 * @return the deposit account id
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * Two deposit accounts are equal if their numbers are the same.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(Object depacc) {
		return depacc instanceof DepositAccount && ((DepositAccount) depacc).getId() == _id;
	}

}

// $Log: DepositAccount.java,v $
// Revision 1.2 2011/09/25 14:47:43 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//