/** @version $Id: Message.java,v 1.2 2011/09/25 14:49:11 david Exp $ */
package bank.textui.bank;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return string prompting for a client's id.
	 */
	public static String requestClientId() {
		return "Identificador do titular: ";
	}

	/**
	 * @param clientId
	 * @return string communication an error.
	 */
	public static String noSuchClient(int clientId) {
		return "Não existe nenhum titular com o número " + clientId + ".";
	}

	/**
	 * @param error
	 * @return the string describing an exception concerning an unknown client
	 *         id.
	 */
	public static final String errorShowingClient(String error) {
		return "Mostrar Titular: " + error;
	}

	/**
	 * @return prompt for name.
	 */
	public static String requestClientName() {
		return "Nome do titular: ";
	}

	/**
	 * @param clientId
	 * @return string describing client creation success.
	 */
	public static String createdClient(int clientId) {
		return "Titular criado: " + clientId;
	}

	/**
	 * @param error
	 * @return the string describing an exception concerning an unknown client
	 *         id.
	 */
	public static final String errorCreatingClient(String error) {
		return "Erro na criação de titular: " + error;
	}

	/**
	 * @return prompt for initial account balance.
	 */
	public static final String requestInitialBalance() {
		return "Saldo inicial? ";
	}

	/**
	 * @param accountId
	 * @return account creation message
	 */
	public static final String accountCreated(int accountId) {
		return "Conta criada: " + accountId;
	}

	/**
	 * @param error
	 *            error description
	 * @return error string
	 */
	public static final String errorCreatingAccount(String error) {
		return "Erro na criação de conta: " + error;
	}

	/**
	 * @return prompt for account id.
	 */
	public static final String requestAccountId() {
		return "Número de conta? ";
	}

	/**
	 * @param accountId
	 * @return error string
	 */
	public static final String errorSelectingAccount(int accountId) {
		return "Não existe uma conta com o número " + accountId;
	}

	/**
	 * @param error
	 *            error description
	 * @return error string
	 */
	public static final String errorShowingAccount(String error) {
		return "Mostrar Conta: " + error;
	}

	/**
	 * @param account
	 * @param amount
	 * @return error string
	 */
	public static final String errorRemovingAccount(int account, double amount) {
		return "Não é possível remover a conta " + account + ": saldo é " + amount;
	}
}

// $Log: Message.java,v $
// Revision 1.2 2011/09/25 14:49:11 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//