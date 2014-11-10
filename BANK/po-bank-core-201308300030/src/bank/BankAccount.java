/** @version $Id: BankAccount.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the relationship between a bank and its clients: an
 * account belongs to one or more clients; each account has one demand account
 * and 0 (zero) or more savings accounts.
 */
public class BankAccount implements Comparable<BankAccount>, Serializable {
	/** Serial number. */
	private static final long serialVersionUID = 201010181458L;

	/** This account's number. */
	private int _id;

	/** The demand account associated with this account. */
	private DemandAccount _demandAccount;

	/** The list of savings accounts associated with this account. */
	private List<SavingsAccount> _savingsAccounts;

	/** The clients in this account. */
	private List<Client> _clients;

	/**
	 * @param id
	 *            account number.
	 * @param amount
	 *            initial amount for the demand account.
	 */
	public BankAccount(int id, double amount) {
		_id = id;
		_demandAccount = new DemandAccount(amount);
		_savingsAccounts = new ArrayList<SavingsAccount>();
		_clients = new ArrayList<Client>();
	}

	/**
	 * @return the account number.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * Compares the number of this account with the number of the account passed
	 * as argument. This method may be used when sorting accounts.
	 * 
	 * @param account
	 *            account to be compared with the current one
	 * @return -1, if the account number is lower than the other account's; 0,
	 *         if the account numbers are the same; 1, if the account number is
	 *         greater than the other account's.
	 * @see java.lang.Comparable
	 */
	@Override
	public int compareTo(BankAccount account) {
		int number = account.getId();
		return (_id < number ? -1 : (_id == number ? 0 : 1));
	}

	/**
	 * Tests whether two accounts are equal. Two accounts are considered equal
	 * when they have the same account number.
	 * 
	 * @param obj
	 *            object to be compared (probably, but not necessarily, another
	 *            account).
	 * @return true, if the two object have the same number; false, otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof BankAccount) && ((BankAccount) obj).getId() == _id;
	}

	/**
	 * Makes a deposit in the demand account.
	 * 
	 * @param amount
	 *            the amount to be deposited.
	 * @throws InvalidDepositException
	 *             if it is not possible to make the deposit.
	 * @throws NegativeAmountException
	 *             if the amount is not positive.
	 */
	public void deposit(double amount) throws InvalidDepositException, NegativeAmountException {
		_demandAccount.deposit(amount);
	}

	/**
	 * Performs a withdrawal.
	 * 
	 * @param amount
	 *            the amount to be withdrawn.
	 * @throws InvalidWithdrawalException
	 *             if it is not possible to withdraw the intended amount.
	 * @throws NegativeAmountException
	 *             if the amount is not positive.
	 * @throws BalanceTooLowException
	 */
	public void withdraw(double amount) throws InvalidWithdrawalException, NegativeAmountException,
			BalanceTooLowException {
		_demandAccount.withdraw(amount);
	}

	/**
	 * @return the amount in the demand account.
	 */
	public double getDemandAccountBalance() {
		return _demandAccount.getBalance();
	}

	/**
	 * Returns the total balance for the account. This balance includes the
	 * demand account balance and the balances of all the savings accounts.. The
	 * following implementation uses an implicit iterator, but the same actions
	 * could be performed using an explicit one.
	 * 
	 * @return the account balance.
	 */
	public double getBalance() {
		double total = getDemandAccountBalance();
		for (SavingsAccount sa : _savingsAccounts)
			total += sa.getBalance();
		return 0;
	}

	/**
	 * @return a list with the clients in the account.
	 */
	public List<Client> getClients() {
		return _clients;
	}

	/**
	 * Returns the savings accounts associated with the bank account.
	 * 
	 * @return a list of savings deposits or null (if there are no savings
	 *         deposits.
	 */
	public List<SavingsAccount> getSavingsAccounts() {
		return Collections.unmodifiableList(_savingsAccounts);
	}

	/**
	 * Remove a given savings account.
	 * 
	 * @param account
	 *            the savings account to be removed.
	 * @return true if the account owns this savings account.
	 */
	public final boolean removeSavingsAccount(SavingsAccount account) {
		return _savingsAccounts.remove(account);
	}

	/**
	 * Add a given savings account to the holdings.
	 * 
	 * @param account
	 *            the new savings account.
	 */
	public final void addSavingsAccount(SavingsAccount account) {
		_savingsAccounts.add(account);
	}

	/**
	 * @param client
	 *            the client to be added.
	 */
	public void addClient(Client client) {
		_clients.add(client);
	}

	/**
	 * Verifies whether an account can be removed. An account can be removed
	 * only when its total balance is 0 (zero).
	 * 
	 * @return true, if the account can be removed; false, otherwise.
	 */
	public final boolean canBeRemoved() {
		return getBalance() == 0;
	}

	/**
	 * String representation of the account: presents the account number and the
	 * total balance.
	 * 
	 * @return a string representation of the account.
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "<account number='" + _id + "' balance='" + getBalance() + "'/>";
	}

}

// $Log: BankAccount.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//