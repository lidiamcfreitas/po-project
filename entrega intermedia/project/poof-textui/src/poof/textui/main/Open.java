/** @version $Id: Open.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;
import java.io.*;

// FIXME: import project-specific classes
import poof.Manager;
import poof.textui.*;
import poof.*;
/**
 * Open existing file.
 */
public class Open extends Command<Manager> {

	/**
	 * @param receiver
	 */
	public Open(Manager receiver ) {
		super(MenuEntry.OPEN, receiver );
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		//FIXME: implement command
		try{
		String fname="";
		System.out.println(Message.openFile() );
		BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
		fname=stdin.readLine();
		_receiver.open(fname);
		}
		catch( IOException | ClassNotFoundException e){
		  System.out.println(Message.fileNotFound() );
		 }
		
	}

}