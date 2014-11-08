/** @version $Id: MenuBuilder.java,v 1.1 2014/10/01 22:45:52 david Exp $ */
package poof.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;

// FIXME: import project-specific classes

/**
 * Menu builder.
 */
public abstract class MenuBuilder {

	/**
	 * @param receiver
	 */
	public static void menuFor(FIXME /*FIXME: receiver declaration */) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new New(FIXME /*FIXME: receiver argument*/),
				new Open(FIXME /*FIXME: receiver argument*/),
				new Save(FIXME /*FIXME: receiver argument*/),
				new Login(FIXME /*FIXME: receiver argument*/),
				new MenuOpenShell(FIXME /*FIXME: receiver argument*/),
				new MenuOpenUserManagement(FIXME /*FIXME: receiver argument*/)
		});
		menu.open();
	}

}
