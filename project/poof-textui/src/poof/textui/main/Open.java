/** @version $Id: Open.java,v 1.1 2014/10/01 22:45:53 david Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;

/**
 * Open existing file.
 */
public class Open extends Command<Manager> /* FIXME: select core type for receiver */ {

	/**
	 * @param receiver
	 */
	public Open(Manager receiver /*FIXME: add receiver declaration: type must agree with the above*/) {
		super(MenuEntry.OPEN, receiver /*FIXME: receiver argument*/);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}

}
