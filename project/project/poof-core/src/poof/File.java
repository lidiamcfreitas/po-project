package poof;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class File extends Entry implements Serializable{
	private String _dirName;
	private int _size;

	public File(String name,String permission,String ownerName, String dirName) throws IOException {
		super(name,permission,ownerName);
		_dirName=dirName;
		_size = 0;

        BufferedWriter out = new BufferedWriter( new FileWriter(getName() + ".txt"));
        out.close();
    }

	public int getSize() { return _size; }
    
    public String getDirName() { return _dirName; }

	public void setDirName(String dirName){ _dirName=dirName; }
    
   	public void setSize( int size ) { _size = size; }
    
	public List<String> seeFile() throws IOException, FileNotFoundException{

        BufferedReader in = new BufferedReader( new FileReader(getName()+".txt") );
        String s;
	List<String> list= new ArrayList<String>();
        while ( (s=in.readLine() )!=null)
            list.add(s);
        in.close();
	return list;
    }

	public void writeFile(String text) throws FileNotFoundException, IOException {

        setSize(getSize() + text.length()); // size update
        PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter(getName()+".txt")));
        out.println(text);
        out.close();
    }
}
