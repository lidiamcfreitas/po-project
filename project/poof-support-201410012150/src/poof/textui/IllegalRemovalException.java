package poof.textui;

import ist.po.ui.DialogException;

/**
 * Thrown when an attempt is made to remove "." or ".."
 */
public class IllegalRemovalException extends DialogException {
	/** Class serial number (serialization). */
	private static final long serialVersionUID = 201408261552L;

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "Não é possível remover as entradas \".\" e \"..\".";
	}
}
