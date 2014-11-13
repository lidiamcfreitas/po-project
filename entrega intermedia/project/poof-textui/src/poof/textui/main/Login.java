/** @version $Id: Login.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes

import poof.Manager;
import poof.UserUnknownE;

import poof.Manager;
import poof.textui.*;
import poof.*;
import java.io.*;

/**
 * §2.1.2.
 */
public class Login extends Command<Manager> {

	/**
	 * @param receiver
	 */
	public Login(Manager receiver) {
		super(MenuEntry.LOGIN, receiver, new ValidityPredicate<Manager>(receiver){
            public boolean isValid() { return _receiver.hasFS(); }
        });
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
        
		//FIXME: implement command
		String user="";
		try{
		System.out.println(Message.usernameRequest() );
		BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
		user=stdin.readLine();
		_receiver.login(user);
		}
		catch( UserUnknownE e){
		  throw new UserUnknownException(user);
		 }
		
	}
}
