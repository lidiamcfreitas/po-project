/** @version $Id: CreateUser.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.user;

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
 * §2.3.1.
 */
public class CreateUser extends Command<Manager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public CreateUser(Manager receiver) {
		super(MenuEntry.CREATE_USER, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		//FIXME: implement command
		String username="";
		String name="";
		try{
		System.out.println(Message.nameRequest());
		BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
		name = stdin.readLine();
		System.out.println(Message.usernameRequest());
		username = stdin.readLine();
		_receiver.createUser(username,name);
		}
		catch(UserExistsE e){
		  throw new UserExistsException(username);
		}
		catch(EntryExistsE e){
		  throw new EntryExistsException(name);
		}
	}
}
