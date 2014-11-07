import java.io.*;

public class File extends Entry{
	private String _dirName;
	
	public File(String name,String permission,String ownerName,int size, String dirName){
        
        super(name,permission,ownerName, size);
        _dirName=dirName;
        
		try {
        
        BufferedWriter out = new BufferedWriter( new FileWriter(getName() + ".txt"));
        
        out.close();
            
        } catch (Exception e) {}
	}
	public String getDirName(){
		return _dirName;
	}
	public void setDirName(String dirName){
		_dirName=dirName; 
	}
	public void seeFile(){
        try {
		BufferedReader in = new BufferedReader( new FileReader(getName()+".txt") );
		String s;
		while ( (s=in.readLine() )!=null)
			System.out.println(s);
		in.close();
        } catch (Exception e) {}
	}
	public void writeFile(String text){
        try {
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter(getName()+".txt")));
		out.println(text);
		out.close();
            
        } catch (Exception e) {}
	}

}
