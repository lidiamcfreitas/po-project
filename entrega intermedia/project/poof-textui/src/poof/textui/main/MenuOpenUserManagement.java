/** @version $Id: MenuOpenUserManagement.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
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
	public MenuOpenUserManagement(Manager receiver) {
		super(MenuEntry.MENU_USER_MGT, receiver , new ValidityPredicate<Manager>(receiver){
            public boolean isValid() { return _receiver.hasFS() && _receiver.hasLoggedIn(); }
        });
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() {
		poof.textui.user.MenuBuilder.menuFor(_receiver);
	}

}
