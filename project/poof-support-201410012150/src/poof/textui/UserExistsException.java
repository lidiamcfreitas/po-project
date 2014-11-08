package poof.textui;

import ist.po.ui.DialogException;

/**
 * Thrown when an attempt is made to create a duplicate user.
 */
public class UserExistsException extends DialogException {
	/** Class serial number (serialization). */
	private static final long serialVersionUID = 201408261552L;

	/** Invalid user name. */
	private final String _username;

	/**
	 * @param username
	 */
	public UserExistsException(String username) {
		_username = username;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O utilizador '" + _username + "' já existe.";
	}
}
