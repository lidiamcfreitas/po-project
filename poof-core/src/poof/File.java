import java.io.*;

public class File extends Entry{
	private String _dirName;
	
	public File(String name,String permission,User owner,String dirName){
		try {
            
        super(name,permission,owner);
		_dirName=dirName;
        
        BufferedWriter out = new BufferedWriter( new FileWriter( new FileWriter(getName() + ".txt")));
        
        out.close();
            
        } catch (Exception e) {}
	}
	public String getDirName(){
		return _dirName;
	}
	public void setDirName(String DirName){
		_dirName=dirName; 
	}
	public void seeFile(){
		BufferedReader in = new BufferedReader( new FileReader(getName()+".txt") );
		String s;
		while ( (s=in.readline() )!=null)	
			System.out.println(s);
		in.close();
	}
	public void writeFile(String text){
        try {
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter(getName()+".txt")));
		out.println(text);
		out.close();
            
        } catch (Exception e) {}
	}



}
