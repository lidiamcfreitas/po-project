/** @version $Id: Shell.java,v 1.3 2014/11/13 19:03:28 ist179019 Exp $ */
package poof.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.Manager;
import poof.FSE;
import java.io.*;
/**
 * Class that starts the application's textual interface.
 */
public class Shell {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

        Manager m = new Manager();
        

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
            
		try{
		m.openFromTextData(datafile);
		}
		catch (Exception e){}
		
		}
		poof.textui.main.MenuBuilder.menuFor(m);
		IO.closeDown();
	}

}
