package poof.textui;

import ist.po.ui.DialogException;

/**
 * Thrown when an attempt is made to use an unknown username.
 */
public class UserUnknownException extends DialogException {
	/** Class serial number (serialization). */
	private static final long serialVersionUID = 201408261552L;

	/** Invalid user name. */
	private final String _username;

	/**
	 * @param username
	 */
	public UserUnknownException(String username) {
		_username = username;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O utilizador '" + _username + "' não existe.";
	}
}
