/** @version $Id: CreateUser.java,v 1.1 2014/10/01 22:45:55 david Exp $ */
package poof.textui.user;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes

/**
 * §2.3.1.
 */
public class CreateUser extends Command<FIXME> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public CreateUser(FIXME /*FIXME: add receiver declaration: type must agree with the above*/) {
		super(MenuEntry.CREATE_USER, FIXME /*FIXME: receiver argument*/);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}
}
