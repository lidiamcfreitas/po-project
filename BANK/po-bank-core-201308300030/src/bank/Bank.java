/** @version $Id: Bank.java,v 1.2 2011/09/25 14:47:43 david Exp $ */
package bank;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Banks have clients and accounts. New clients can open new accounts or join
 * existing accounts.
 */
public class Bank implements Serializable {
	/** Serial number. */
	private static final long serialVersionUID = 201010181458L;

	/** Bank name. */
	private String _name;

	/** Clients. */
	private Map<Integer, Client> _clients = new HashMap<Integer, Client>();

	/** Bank accounts. */
	private Map<Integer, BankAccount> _accounts = new HashMap<Integer, BankAccount>();

	/** Account counter. */
	private int _accountNumber = 0;

	/**
	 * @param name
	 *            bank name.
	 */
	public Bank(String name) {
		_name = name;
	}

	/**
	 * @return the name of the bank.
	 */
	public final String getName() {
		return _name;
	}

	/**
	 * @return true, when two banks have the same name; false, otherwise.
	 */
	@Override
	public final boolean equals(Object o) {
		return o instanceof Bank && _name.equals(((Bank) o).getName());
	}

	/**
	 * Create and register account.
	 * 
	 * @param amount
	 *            initial balance for the account.
	 * 
	 * @return the new account.
	 */
	public BankAccount createAccount(double amount) {
		BankAccount account = new BankAccount(_accountNumber++, amount);
		_accounts.put(account.getId(), account);
		return account;
	}

	/**
	 * Remove an account. An account can only be removed if its total balance is
	 * zero. If it is not possible to remove an account, an exception is thrown.
	 * 
	 * @param account
	 *            the account to be removed.
	 * @throws InvalidRemovalException
	 */
	public final void removeAccount(BankAccount account) throws InvalidRemovalException {
		if (account.canBeRemoved())
			_accounts.remove(account.getId());
		else
			throw new InvalidRemovalException(account.getId(), account.getBalance());
	}

	/**
	 * Get the account with the given number.
	 * 
	 * @param id
	 *            the account number.
	 * 
	 * @return the account or null if the number does not correspond to a valid
	 *         account.
	 */
	public final BankAccount getAccount(int id) {
		return _accounts.get(id);
	}

	/**
	 * @return all the accounts as an unmodifiable collection.
	 */
	public Collection<BankAccount> getAccounts() {
		return Collections.unmodifiableCollection(_accounts.values());
	}

	/**
	 * Create and register a client.
	 * 
	 * @param name
	 *            the client's name.
	 * @param id
	 *            the client's id.
	 * 
	 * @return the new client.
	 */
	public Client createClient(String name, int id) {
		Client client = new Client(id, name);
		_clients.put(id, client);
		return client;
	}

	/**
	 * Remove a client.
	 * 
	 * @param id
	 *            the client's id.
	 * 
	 * @return true, if the client was removed; false, otherwise.
	 */
	public final boolean removeClient(int id) {
		Client client = getClient(id);
		if (client != null) {
			_clients.remove(id);
			return true;
		}
		return false;
	}

	/**
	 * @return all clients as an unmodifiable collection.
	 */
	public Collection<Client> getClients() {
		return Collections.unmodifiableCollection(_clients.values());
	}

	/**
	 * Get the client with the given id.
	 * 
	 * @param id
	 *            the client's id.
	 * 
	 * @return the client or null if the number does not correspond to a valid
	 *         client.
	 */
	public Client getClient(int id) {
		return _clients.get(id);
	}

}

// $Log: Bank.java,v $
// Revision 1.2 2011/09/25 14:47:43 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//