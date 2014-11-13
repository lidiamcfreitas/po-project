/** @version $Id: ChangeEntryPermissions.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;

/**
 * §2.2.10.
 */
public class ChangeEntryPermissions extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ChangeEntryPermissions(Manager receiver) {
		super(MenuEntry.CHMOD, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}

}
