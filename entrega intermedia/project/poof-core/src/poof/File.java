package poof;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class File extends Entry implements Serializable{
	private String _dirName;
	private int _size;
	private List<String> _cont;

	public File(String name,String permission,String ownerName, String dirName) {
		super(name,permission,ownerName);
		_dirName=dirName;
		_size = 0;
		_cont = new ArrayList<String>();
    }

	public int getSize() { return _size; }
    
	public String getDirName() { return _dirName; }

	public void setDirName(String dirName){ _dirName=dirName; }
    
   	public void setSize( int size ) { _size = size; }
    
	public List<String> seeFile() {
	    return _cont;
    }

	public void writeFile(String text) {

        setSize(getSize() + text.length()); // size update
        _cont.add(text);
    }
}
