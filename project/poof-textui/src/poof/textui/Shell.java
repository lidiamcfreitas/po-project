/** @version $Id: Shell.java,v 1.1 2014/10/01 22:45:51 david Exp $ */
package poof.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

// FIXME: import project-specific classes

/**
 * Class that starts the application's textual interface.
 */
public class Shell {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// FIXME: create and initialize core objects

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
			// FIXME: import text data file
		}
		poof.textui.main.MenuBuilder.menuFor(FIXME /*FIXME: core object (receiver) argument*/);
		IO.closeDown();
	}

}
