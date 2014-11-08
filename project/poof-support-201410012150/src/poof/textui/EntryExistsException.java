package poof.textui;

import ist.po.ui.DialogException;

/**
 * Thrown when an attempt is made to create a duplicate entry.
 */
public class EntryExistsException extends DialogException {
	/** Class serial number (serialization). */
	private static final long serialVersionUID = 201408261552L;

	/** Invalid entry name. */
	private final String _entryName;

	/**
	 * @param entryName
	 */
	public EntryExistsException(String entryName) {
		_entryName = entryName;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A entrada '" + _entryName + "' já existe.";
	}
}
