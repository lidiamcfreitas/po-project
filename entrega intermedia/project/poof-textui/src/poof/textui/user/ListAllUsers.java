/** @version $Id: ListAllUsers.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.user;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;
import java.util.List;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.*;
import poof.textui.*;
import java.io.FileNotFoundException;
/**
 * §2.3.2.
 */
public class ListAllUsers extends Command<Manager> {
	/**
	 * @param receiver
	 */
	public ListAllUsers(Manager receiver) {
		super(MenuEntry.LIST_USERS, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException  {
		//FIXME: implement command
		try{
		List<String> l = _receiver.listUsers();
		 for (int i=0;i< l.size();i++)
		    System.out.println(l.get(i) );}
		catch (EntryUnknownE e){
		  throw new EntryUnknownException("erro");
		}
		
	}
}
