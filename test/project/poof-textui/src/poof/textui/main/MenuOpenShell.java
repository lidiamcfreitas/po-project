/** @version $Id: MenuOpenShell.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;

/**
 * Open shell menu.
 */
public class MenuOpenShell extends Command<Manager> /* FIXME: select core type for receiver */ {

	/**
	 * @param receiver
	 */
	public MenuOpenShell(Manager receiver) {
		super(MenuEntry.MENU_SHELL, receiver, new ValidityPredicate<Manager>(receiver){
            public boolean isValid() { return _receiver.hasFS(); }
        });
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() {
		poof.textui.shell.MenuBuilder.menuFor(_receiver);
	}

}
