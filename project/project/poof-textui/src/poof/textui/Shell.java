/** @version $Id: Shell.java,v 1.2 2014/11/11 10:25:18 ist178559 Exp $ */
package poof.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.FSE;
/**
 * Class that starts the application's textual interface.
 */
public class Shell {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        Manager manager = new Manager();

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
            
            //manager.create();
            //manager.openFromTextData(datafile);
            
		}
		poof.textui.main.MenuBuilder.menuFor(manager);
		IO.closeDown();
	}

}
