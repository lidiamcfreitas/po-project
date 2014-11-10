/** @version $Id: MenuEntry.java,v 1.2 2011/09/25 14:49:11 david Exp $ */
package bank.textui.bank;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public final class MenuEntry {
	/** Menu title. */
	public static final String TITLE = "Operações Banco";

	/** Create account. */
	public static final String CREATE_ACCOUNT = "Criar Conta";

	/** Create client. */
	public static final String CREATE_CLIENT = "Criar Titular";

	/** Menu for accounts. */
	public static final String ACCOUNT_MENU = "Menu Conta";

	/** Show all accounts. */
	public static final String SHOW_ACCOUNTS = "Mostrar Contas";

	/** Menu for clients. */
	public static final String CLIENT_MENU = "Menu Titular";

	/** Show all clients. */
	public static final String SHOW_ACCOUNT_CLIENTS = "Mostrar Titulares";
}

// $Log: MenuEntry.java,v $
// Revision 1.2 2011/09/25 14:49:11 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//