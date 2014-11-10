/** @version $Id: BankException.java,v 1.2 2011/09/25 14:47:44 david Exp $ */
package bank;

/**
 * Basic exception class for bank operations. Should not be instantiated
 * directly (thus, the abstract qualifier).
 */
public abstract class BankException extends Exception {
	/** Serial number. */
	private static final long serialVersionUID = 201010181631L;

}

// $Log: BankException.java,v $
// Revision 1.2 2011/09/25 14:47:44 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//