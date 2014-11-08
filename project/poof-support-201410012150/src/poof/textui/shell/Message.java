package poof.textui.shell;

/**
 * Messages for shell menu interactions.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return string with prompt for name.
	 */
	public static final String nameRequest() {
		return "Indique o nome da entrada: ";
	}

	/**
	 * @return string with prompt for file name.
	 */
	public static String fileRequest() {
		return "Indique o nome do ficheiro: ";
	}

	/**
	 * @return string with prompt for directory name.
	 */
	public static String directoryRequest() {
		return "Indique o nome do directório: ";
	}

	/**
	 * @return string with prompt for content.
	 */
	public static final String textRequest() {
		return "Insira a linha de texto a acrescentar ao ficheiro: ";
	}

	/**
	 * @return string confirming that access is public/private.
	 */
	public static final String publicAccess() {
		return "Acesso público para a entrada? (s/n) ";
	}

	/**
	 * @return string with prompt for username.
	 */
	public static final String usernameRequest() {
		return "Identificador do utilizador: ";
	}

}