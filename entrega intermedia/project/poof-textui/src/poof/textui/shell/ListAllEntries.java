/** @version $Id: ListAllEntries.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.Manager;
import poof.textui.*;
import poof.*;
import java.util.List;
/**
 * §2.2.1.
 */
public class ListAllEntries extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ListAllEntries(Manager receiver) {
		super(MenuEntry.LS, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		
		List<String> l = _receiver.listEntries();
		for (int i=0;i<l.size();i++)
		    System.out.println(l.get(i));
		
	}

}
