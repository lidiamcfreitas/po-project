import java.io.*;

public class File extends Entry{
	private String _dirName;
	private int _size;

	public File(String name,String permission,String ownerName, String dirName){
		super(name,permission,ownerName);
		_dirName=dirName;
		_size = 0;

		try {
			BufferedWriter out = new BufferedWriter( new FileWriter(getName() + ".txt"));
			out.close();}
	        catch (Exception e) {}
	}

	public String getDirName() { return _dirName; }

	public int getSize() { return _size; }

	public void setDirName(String dirName){ _dirName=dirName; }
    
   	public void setSize( int size ) { _size = size; }
    
	public void seeFile(){
		try{
			BufferedReader in = new BufferedReader( new FileReader(getName()+".txt") );
			String s;
			while ( (s=in.readLine() )!=null)
				System.out.println(s);
			in.close();}
			 catch (Exception e) {}
		}

	public void writeFile(String text){
		try{
			setSize(getSize() + text.length()); // size update
			PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter(getName()+".txt")));
			out.println(text);
			out.close();}
		 catch (Exception e) {}
	}
}
