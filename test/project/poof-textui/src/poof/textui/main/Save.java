/** @version $Id: Save.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public Save(Manager receiver ) {
		super(MenuEntry.SAVE, receiver, new ValidityPredicate<Manager>(receiver){
            public boolean isValid() { return _receiver.hasFS(); }
        });
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
	}
}
