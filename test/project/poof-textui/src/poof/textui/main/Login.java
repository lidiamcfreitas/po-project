/** @version $Id: Login.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes

import poof.Manager;
import poof.UserUnknownE;

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
        
        /*String username = IO.readString(Message.usernameRequest());
        try {
        _receiver.login(username);
            
        } catch (UserUnknownE e) {
            throw new UserUnknownException(username);
        }*/
        
		//FIXME: implement command
	}
}
