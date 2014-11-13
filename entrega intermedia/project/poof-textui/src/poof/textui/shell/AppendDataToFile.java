/** @version $Id: AppendDataToFile.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.*;
import poof.textui.*;
import java.io.*;

/**
 * §2.2.8.
 */
public class AppendDataToFile extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public AppendDataToFile(Manager receiver) {
		super(MenuEntry.APPEND, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		String text="";
		String fname="";
		try{
		BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
		System.out.println(Message.fileRequest());
		fname = stdin.readLine();
		System.out.println(Message.textRequest());
		text = stdin.readLine();
		_receiver.writeFile(fname,text);
		}
		catch(EntryUnknownE e){
		  throw new EntryUnknownException(fname);
		}
		catch(IsNotFileE e){
		  throw new IsNotFileException(fname);
		}
		catch(AccessDeniedE e){
		  throw new AccessDeniedException(_receiver.getLoggedIn().getUsername());
		 }
		
	}

}
