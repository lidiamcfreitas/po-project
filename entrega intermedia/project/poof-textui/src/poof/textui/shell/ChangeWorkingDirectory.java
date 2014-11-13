/** @version $Id: ChangeWorkingDirectory.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
/**
 * §2.2.4.
 */
public class ChangeWorkingDirectory extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ChangeWorkingDirectory(Manager receiver) {
		super(MenuEntry.CD, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}

}
