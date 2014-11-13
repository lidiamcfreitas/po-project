/** @version $Id: Open.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
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
public class Open extends Command<Manager> {

	/**
	 * @param receiver
	 */
	public Open(Manager receiver ) {
		super(MenuEntry.OPEN, receiver );
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}

}
