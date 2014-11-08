/** @version $Id: ChangeWorkingDirectory.java,v 1.1 2014/10/01 22:45:54 david Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes

/**
 * §2.2.4.
 */
public class ChangeWorkingDirectory extends Command<FIXME> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ChangeWorkingDirectory(FIXME /*FIXME: add receiver declaration: type must agree with the above*/) {
		super(MenuEntry.CD, FIXME /*FIXME: receiver argument*/);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}

}
