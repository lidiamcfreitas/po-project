/** @version $Id: Client.java,v 1.2 2011/09/25 14:47:43 david Exp $ */
package bank;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Information about bank clients: each client is identified by a number. Note
 * that this class is not comparable.
 */
public class Client implements Serializable {
	/** Serial number. */
	private static final long serialVersionUID = 201010151622L;

	/**
	 * NUMBER_COMPARATOR is an instance of an inner class that implements a
	 * client comparator defining a comparison method for clients based on their
	 * ids.
	 * 
	 * It would probably be better to have a static method for accessing this
	 * object.
	 * 
	 * @see java.util.Comparator
	 */
	public static final Comparator<Client> NUMBER_COMPARATOR = new Comparator<Client>() {

		/**
		 * Compare two clients by id.
		 * 
		 * @param client1
		 *            client 1
		 * @param client2
		 *            client 2
		 * @return -1 if h1.id < h2.id; 0 if h1.id = h2.id; 1 if h1.id >h2.id.
		 */
		@Override
		public int compare(Client client1, Client client2) {
			int id1 = client1.getId();
			int id2 = client2.getId();
			return (id1 < id2 ? -1 : (id1 == id2 ? 0 : 1));
		}

	}; // NUMBER_COMPARATOR

	/**
	 * NAME_COMPARATOR is an instance of an inner class that implements a client
	 * comparator defining a comparison method for clients based on their names.
	 * 
	 * It would probably be better to have a static method for accessing this
	 * object.
	 * 
	 * @see java.util.Comparator
	 */
	public static final Comparator<Client> NAME_COMPARATOR = new Comparator<Client>() {

		/**
		 * Compare two clients by name (lexicographically and ignoring case).
		 * 
		 * @param client1
		 *            client 1
		 * @param client2
		 *            client 2
		 * @return -1 if h1.name comes before h2.name; 0 if h1.name is the same
		 *         as h2.name; 1 if h1.name comes after h2.name.
		 */
		@Override
		public int compare(Client client1, Client client2) {
			String name1 = client1.getName();
			String name2 = client2.getName();
			return name1.compareToIgnoreCase(name2);
		}

	}; // NAME_COMPARATOR

	/** The client's id. */
	private int _id;

	/** The client's name. */
	private String _name;

	/**
	 * @param id
	 *            the client's id.
	 * @param name
	 *            the client's name.
	 */
	public Client(int id, String name) {
		_id = id;
		_name = name;
	}

	/**
	 * @return the client's id.
	 */
	public int getId() {
		return _id;
	}

	/**
	 * @return the client's name.
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param name
	 *            the client's new name.
	 */
	public final void setName(String name) {
		_name = name;
	}

	/**
	 * Two clients are considered equal if they have the same id.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object client) {
		return client instanceof Client && ((Client) client).getId() == _id;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	@SuppressWarnings("nls")
	public String toString() {
		return "<client name='" + _name + "' id='" + _id + "'/>";
	}

}

// $Log: Client.java,v $
// Revision 1.2 2011/09/25 14:47:43 david
// Updated version of the bank application. The core classes are as before (no
// changes).
//
