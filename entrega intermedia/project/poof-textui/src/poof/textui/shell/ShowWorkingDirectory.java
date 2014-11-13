/** @version $Id: ShowWorkingDirectory.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.textui.*;
import poof.*;
import java.util.List;
/**
 * §2.2.7.
 */
public class ShowWorkingDirectory extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ShowWorkingDirectory(Manager receiver) {
		super(MenuEntry.PWD, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		try{
		_receiver.getPath();
		}
		catch(EntryUnknownE e){
		    throw new EntryUnknownException(_receiver.getLoggedIn().getDirectory().getName());}
		  

	}

}
