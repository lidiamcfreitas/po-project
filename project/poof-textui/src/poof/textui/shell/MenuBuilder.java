/** @version $Id: MenuBuilder.java,v 1.1 2014/10/01 22:45:54 david Exp $ */
package poof.textui.shell;

import ist.po.ui.Command;
import ist.po.ui.Menu;

// FIXME: import project-specific classes

/**
 * Menu builder for shell operations.
 */
public class MenuBuilder {

	/**
	 * @param receiver
	 */
	public static void menuFor(FIXME /*FIXME: receiver declaration*/) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new ListAllEntries(FIXME /*FIXME: receiver argument*/),
				new ListEntry(FIXME /*FIXME: receiver argument*/),
				new RemoveEntry(FIXME /*FIXME: receiver argument*/),
				new ChangeWorkingDirectory(FIXME /*FIXME: receiver argument*/),
				new CreateFile(FIXME /*FIXME: receiver argument*/),
				new CreateDirectory(FIXME /*FIXME: receiver argument*/),
				new ShowWorkingDirectory(FIXME /*FIXME: receiver argument*/),
				new AppendDataToFile(FIXME /*FIXME: receiver argument*/),
				new ShowFileData(FIXME /*FIXME: receiver argument*/),
				new ChangeEntryPermissions(FIXME /*FIXME: receiver argument*/),
				new ChangeOwner(FIXME /*FIXME: receiver argument*/),
				});
		menu.open();
	}

}
