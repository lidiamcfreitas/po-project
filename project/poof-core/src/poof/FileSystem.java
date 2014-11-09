import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileSystem implements Serializable{
    
    private Map<String, User> _users = new TreeMap<String, User>();
    private Directory _FSDir;
    
    public FileSystem() throws EntryExistsException{
        
        _FSDir = new Directory("home", "-", "root");
        _FSDir.putFather(_FSDir);
        Directory _rootDir = new Directory("root", "-", "root");
        _rootDir.putFather(_FSDir);
        _FSDir.putEntry(_rootDir);
        
        User _root = new User("root", "Super User", _rootDir);
        _users.put(_root.getUsername(), _root);
        
    }
    
    //REMOVE
    
    public Directory getDirectory() { return _FSDir; }
    
    public void createUser(String username,String name) throws UserExistsException, EntryExistsException{
       
        if (_users.get(username) != null)
            throw new UserExistsException(); // entry already exists
        
        else {
            Directory dir=new Directory(username,"-",username);
            dir.putFather(_FSDir);

            _FSDir.putEntry(dir);
            
            User u = new User(username,name,dir);
            _users.put(u.getUsername(), u);
        }
    }
    
    public User getUser(String name) throws UserUnknownException{
        if (_users.get(name)==null){
            throw new UserUnknownException();
        } else {
            return _users.get(name);
        }
    }
    
    public List<String> listUsers() throws EntryUnknownException,FileNotFoundException {
        
        List<User> list = new LinkedList<User>();
        list.addAll(_users.values());
        Collections.sort(list);
        
        List<String> res = new ArrayList<String>();
        String s;
        
        for( User user : list){
            s = user.getUsername() + ":" + user.getName() + ":" + user.getDirectory().getPath();
            res.add(s);
        }
    
        return res;
        
    }
    
    public List<String> listEntries(Directory workDir){
        return workDir.listEntry();
    }
    
    public List<String> listEntry (String ename, Directory workDir) throws IsNotDirectoryException, EntryUnknownException{
		if (workDir.getEntry(ename) instanceof Directory)
          		  return ( (Directory) workDir.getEntry(ename) ).listEntry();
		else
			throw new IsNotDirectoryException();
    }
    
    
    
    
    public void removeEntry(String name, Directory workDir, User loggedIn) throws EntryUnknownException, IllegalRemovalException, AccessDeniedException {
        
	if (name=="."||name=="..")
		throw new IllegalRemovalException();
        
    Entry e = workDir.getEntry(name);
    String logged = loggedIn.getUsername();
        
    if (canRemoveEntry(e, logged)){
        workDir.removeEntry(name);
    }
	else
	   throw new AccessDeniedException();
    }
    
    public String getPath(Directory workDir) throws EntryUnknownException { return workDir.getPath(); }
        
    public boolean canRemoveEntry(Entry e, String logged){
        
        boolean res=true;
        if (logged=="root")
            return true;

        if ( e instanceof File){
            if (e.getPermission() == "w" || e.getOwnerName() == logged ) 
                return true;
            return false;
        } else {
            
            if (e.getPermission() == "w" || e.getOwnerName() == logged) {
                
                for( Entry subEntry : ( (Directory) e ).getEntries())
                    res= res && canRemoveEntry(subEntry, logged);
                return res;
            }
            return false;
        }

                
        }
    public Directory changeWorkDir(String dname,Directory workDir) throws IsNotDirectoryException,EntryUnknownException{
		Entry e = workDir.getEntry(dname);
		if (dname==".")
			return workDir;
		else if (e instanceof Directory)
			return (Directory)e;
		else
			throw new IsNotDirectoryException();
	}
    
   public void createFile(String fname,String permission, Directory workDir, User loggedIn) throws IOException, AccessDeniedException, EntryExistsException{
	if (workDir.getPermission() == "w" || workDir.getOwnerName()== loggedIn.getUsername() || loggedIn.getUsername()=="root"){
		File f= new File(fname, permission, loggedIn.getUsername(), workDir.getName() );
		workDir.putEntry(f);
       }
	else
		throw new  AccessDeniedException();
	
   }
   public void createDir(String dname,String permission, Directory workDir, User loggedIn) throws AccessDeniedException,EntryExistsException{
	if (workDir.getPermission() == "w" || workDir.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername() == "root"){
		Directory d= new Directory(dname,permission, loggedIn.getUsername() );
		workDir.putEntry(d);
		d.putEntry(workDir);
	}
	else
		throw new AccessDeniedException();
   }
   
   public void writeFile(String fname, String text,Directory workDir, User loggedIn) throws IOException, FileNotFoundException, EntryUnknownException,IsNotFileException,AccessDeniedException{
       
       Entry e = workDir.getEntry(fname);
       
       if (e  instanceof File){
           if (workDir.getPermission() == "w" || workDir.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername() == "root")
               ((File) e).writeFile(text);
           else
               throw new AccessDeniedException();
   			
       }
       else
           throw new IsNotFileException();
   }
   
   public List<String> seeFile(String fname,Directory workDir) throws IOException, EntryUnknownException,IsNotFileException{
	Entry e = workDir.getEntry(fname);
	if (e  instanceof File)
		return ((File) e).seeFile();
	else
		throw new IsNotFileException();
   }
	
   public void changePermission(String ename, String perm, Directory workDir, User loggedIn) throws EntryUnknownException, AccessDeniedException{
	Entry e= workDir.getEntry(ename);
	if (e.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername()=="root")
		e.setPermission(perm);
	else
		throw new AccessDeniedException();
   }	
   
   public void changeOwner(String ename, String username, Directory workDir, User loggedIn) throws EntryUnknownException, AccessDeniedException,UserUnknownException{
       
	Entry e = workDir.getEntry(ename);
    User newOwner = getUser(username); // throws exception if doesnt exist
       
    if (e.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername()=="root")
        e.setOwnerName(username);
    else
        throw new AccessDeniedException();
   }
    
    
    
    // MAIN TO TEST THINGS - REMOVE AFTER USAGE
    public static void main(String[] args) throws IllegalRemovalException, EntryExistsException, EntryUnknownException, Exception{
        
        FileSystem f1 = new FileSystem();
        f1.printUsers();
        f1.printEntries(f1.getDirectory());
        
        f1.createUser("lidiamcfreitas", "Lidia Freitas");
        f1.printUsers();
        
        f1.printEntries((Directory) f1.getDirectory().getEntry("root"));
        f1.printEntries(f1.getDirectory());
        
        System.out.println("____________________");
        f1.createFile("ficheiro","-", (Directory) f1.getDirectory().getEntry("lidiamcfreitas"), f1.getUser("lidiamcfreitas"));
        f1.printEntries((Directory) f1.getDirectory().getEntry("lidiamcfreitas"));
        f1.writeFile("ficheiro", " a lidia e fixe",(Directory) f1.getDirectory().getEntry("lidiamcfreitas"), f1.getUser("lidiamcfreitas"));
    }
    
    public void printUsers() throws Exception{
        for (String u : listUsers()){
            System.out.println(u);}
    }
    
    public void printEntries(Directory dir) throws Exception{
        for (String u : dir.listEntry()){
            System.out.println(u);}
    }

}
