/** @version $Id: DemandAccount.java,v 1.2 2011/09/25 14:47:43 david Exp $ */
package bank;

/**
 * Demand accounts allow withdrawals that do not exceed the current balance.
 * Demand accounts have 0% (zero) interest rates.
 */
public class DemandAccount extends DepositAccount {
	/** Serial number. */
	private static final long serialVersionUID = 201010181458L;

	/**
	 * @param amount
	 *            the initial balance.
	 */
	public DemandAccount(double amount) {
		super(0.0d, amount);
	}

	/**
	 * Add the given amount to the current balance (if the amount is positive).
	 * 
	 * @param amount
	 *            the amount to be deposited.
	 * @throws NegativeAmountException
	 *             if the amount is not positive.
	 */
	@Override
	public void deposit(double amount) throws NegativeAmountException {
		if (amount <= 0)
			throw new NegativeAmountException(amount);
		_balance += amount;
	}

	/**
	 * Withdraw a given amount: the balance must be grater or equal to the
	 * amount to be withdrawn.
	 * 
	 * @param amount
	 *            the amount to be withdrawn.
	 * @throws NegativeAmountException
	 * @throws BalanceTooLowException
	 */
	@Override
	public void withdraw(double amount) throws NegativeAmountException, BalanceTooLowException {
		if (amount <= 0)
			throw new NegativeAmountException(amount);
		if (_balance < amount)
			throw new BalanceTooLowException(_balance, amount);
		_balance -= amount;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "<demand-account initial='" + _initialDate + "' balance='" + _balance + "'/>";
	}

}

// $Log: DemandAccount.java,v $
// Revision 1.2 2011/09/25 14:47:43 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//