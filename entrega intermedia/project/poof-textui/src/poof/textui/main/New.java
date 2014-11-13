/** @version $Id: New.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.textui.*;
import poof.*;

/**
 * Open a new file.
 */
public class New extends Command<Manager> {

	/**
	 * @param receiver
	 */
	public New(Manager receiver) {
		super(MenuEntry.NEW, receiver );
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		try{
		_receiver.create();
		
		}
		catch(EntryExistsE e){
		    throw new EntryExistsException("/ ou home ou root");
		 }
		 catch(UserUnknownE e){
		    throw new UserExistsException("root");
		  }
	}

}
