/** @version $Id: MenuOpenUserManagement.java,v 1.1 2014/10/01 22:45:53 david Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;

/**
 * Open user management menu.
 */
public class MenuOpenUserManagement extends Command<Manager> /* FIXME: select core type for receiver */ {

	/**
	 * @param receiver
	 */
	public MenuOpenUserManagement(Manager receiver /*FIXME: add receiver declaration: type must agree with the above*/) {
		super(MenuEntry.MENU_USER_MGT, receiver /*FIXME: receiver argument*/, FIXME /*FIXME: validity argument*/);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() {
		poof.textui.user.MenuBuilder.menuFor(FIXME /*FIXME: receiver argument*/);
	}

}
