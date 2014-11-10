/** @version $Id: Message.java,v 1.2 2011/09/25 14:49:09 david Exp $ */
package bank.textui.bankaccount;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {
	/**
	 * @param balance
	 * @return string describing the demand balance of the accounts
	 */
	public static final String showDemandBalance(double balance) {
		return "Saldo corrente: " + balance;
	}

	/**
	 * @param balance
	 * @return string describing the total balance of the accounts
	 */
	public static final String showTotalBalance(double balance) {
		return "Saldo total: " + balance;
	}

	/**
	 * @return title for menu entry for getting the demand balance.
	 */
	public static final String titleDemandBalance() {
		return "Saldo Corrente";
	}

	/**
	 * @return title for menu entry for getting the total balance.
	 */
	public static final String titleTotalBalance() {
		return "Saldo Total";
	}

	/**
	 * @return error string
	 */
	public static final String errorShowingSavingsAccounts() {
		return "A conta não tem contas poupança";
	}

	/**
	 * @return prompt for a savings account id.
	 */
	public static final String requestSavingsAccountId() {
		return "Número da conta poupança: ";
	}

	/**
	 * @return error string
	 */
	public static final String errorShowingSavingsAccount() {
		return "Não existe nenhuma conta poupança com o identificador indicado";
	}

	/**
	 * @return prompt for amount
	 */
	public static final String requestAmount() {
		return "Valor? ";
	}

	/**
	 * @return interest rate
	 */
	public static final String requestRate() {
		return "Taxa? ";
	}

	/**
	 * @return request time period for savings account
	 */
	public static final String requestTime() {
		return "Prazo? ";
	}

	/**
	 * @return invalid deposit message
	 */
	public static final String invalidDeposit() {
		return "Depósito inválido";
	}

	/**
	 * @param amount
	 *            invalid negative amount
	 * @return invalid deposit message
	 */
	public static String invalidNegativeAmountDeposit(double amount) {
		return "Depósito inválido: tentativa de depositar " + amount;
	}

	/**
	 * @return invalid withdrawal message
	 */
	public static String invalidWithdrawal() {
		return "Levantamento inválido";
	}

	/**
	 * @param amount
	 *            invalid negative amount
	 * @return invalid withdrawal message
	 */
	public static String invalidNegativeAmountWithdrawal(double amount) {
		return "Levantamento inválido: tentativa de levantar " + amount;
	}

	/**
	 * @param balance
	 * @param amount
	 * @return invalid withdrawal message
	 */
	public static String notEnoughBalance(double balance, double amount) {
		return "Levantamento inválido: tentativa de levantar " + amount + " (saldo " + balance
				+ ")";
	}

}

// $Log: Message.java,v $
// Revision 1.2 2011/09/25 14:49:09 david
// New version of the bank application. The textui version has been updated
// and now uses exceptions as a bridge to convey to the menu class errors
// in operations.
//