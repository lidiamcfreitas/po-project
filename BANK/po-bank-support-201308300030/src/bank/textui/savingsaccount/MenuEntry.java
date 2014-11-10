/** @version $Id: MenuEntry.java,v 1.2 2011/09/25 14:49:11 david Exp $ */
package bank.textui.savingsaccount;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public final class MenuEntry {
	/** Menu title. */
	public static final String TITLE = "Operações Contas Poupança";

	/** Close savings account. */
	public static final String CLOSE = "Fechar";

	/** Show savings account balance. */
	public static final String SHOW_BALANCE = "Mostrar Saldo";

}

// $Log: MenuEntry.java,v $
// Revision 1.2 2011/09/25 14:49:11 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//