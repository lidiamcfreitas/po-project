/** @version $Id: Save.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
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
import java.io.*;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public Save(Manager receiver ) {
		super(MenuEntry.SAVE, receiver, new ValidityPredicate<Manager>(receiver){
            public boolean isValid() { return _receiver.hasFS() && _receiver.hasLoggedIn(); }
        });
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		
		if (_receiver.getWhereToSave()==""){
		    String fname="";
		    System.out.println(Message.newSaveAs() );
		    BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
		    fname=stdin.readLine();
		    _receiver.save(fname);
		 }
		 else
		      _receiver.save(_receiver.getWhereToSave());
		
		
	}
}
