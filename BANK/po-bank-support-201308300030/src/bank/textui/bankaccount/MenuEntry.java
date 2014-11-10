/** @version $Id: MenuEntry.java,v 1.2 2011/09/25 14:49:10 david Exp $ */
package bank.textui.bankaccount;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public class MenuEntry {

	/** Menu title. */
	public static final String TITLE = "Operações Conta";

	/**
	 * Create a savings account in a bank account.
	 */
	public static final String CREATE_SAVINGS_ACCOUNT = "Adicionar conta poupança";

	/**
	 * Entry for removing accounts.
	 */
	public static final String REMOVE_ACCOUNT = "Remover Conta";

	/**
	 * Entry for showing clients.
	 */
	public static final String SHOW_ACCOUNT_CLIENTS = "Mostrar Titulares";

	/**
	 * Entry for showing all savings accounts.
	 */
	public static final String SHOW_ALL_SAVINGS_ACCOUNTS = "Mostrar contas poupança";

	/**
	 * Entry for showing a specific savings account.
	 */
	public static final String SHOW_SAVINGS_ACCOUNT = "Ver conta poupança";

	/**
	 * Entry for making deposits.
	 */
	public static final String DEPOSIT = "Depositar";

	/**
	 * Entry for making withdrawals.
	 */
	public static final String WITHDRAW = "Levantar";
}

// $Log: MenuEntry.java,v $
// Revision 1.2 2011/09/25 14:49:10 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//