/** @version $Id: ListAllUsers.java,v 1.2 2014/11/11 10:25:19 ist178559 Exp $ */
package poof.textui.user;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
/**
 * §2.3.2.
 */
public class ListAllUsers extends Command<Manager> {
	/**
	 * @param receiver
	 */
	public ListAllUsers(Manager receiver) {
		super(MenuEntry.LIST_USERS, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException  {
		//FIXME: implement command
	}
}
