package poof;

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
    private Directory _home;
    
    public FileSystem() throws EntryExistsE {

        _FSDir = new Directory("/", "-", "root");
        _FSDir.putFather(_FSDir);
        
        _home = new Directory("home", "-", "root");
        _home.putFather(_FSDir);
        _FSDir.putEntry(_home);
        
        
        Directory _rootDir = new Directory("root", "-", "root");
        _rootDir.putFather(_home);
        _home.putEntry(_rootDir);
        
        User _root = new User("root", "Super User", _rootDir);
        _users.put(_root.getUsername(), _root);
            
        
        
    }
    

    
    public void createUser(String username,String name) throws UserExistsE, EntryExistsE{
       
        if (_users.get(username) != null)
            throw new UserExistsE(); // entry already exists
        
        else {
            Directory dir=new Directory(username,"-",username);
            dir.putFather(_home);

            _home.putEntry(dir);
            
            User u = new User(username,name,dir);
            _users.put(u.getUsername(), u);
        }
    }
    
    public User getUser(String name) throws UserUnknownE{
        if (_users.get(name)==null){
            throw new UserUnknownE();
        } else {
            return _users.get(name);
        }
    }
    
    public List<String> listUsers() throws EntryUnknownE,FileNotFoundException {
        
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
    
    public List<String> listEntry (String ename, Directory workDir) throws IsNotDirectoryE, EntryUnknownE{
		if (workDir.getEntry(ename) instanceof Directory)
          		  return ( (Directory) workDir.getEntry(ename) ).listEntry();
		else
			throw new IsNotDirectoryE();
    }
    
    
    
    
    public void removeEntry(String name, Directory workDir, User loggedIn) throws EntryUnknownE, IllegalRemovalE, AccessDeniedE {
        
	if (name=="."||name=="..")
		throw new IllegalRemovalE();
        
    Entry e = workDir.getEntry(name);
    String logged = loggedIn.getUsername();
        
    if (canRemoveEntry(e, logged)){
        workDir.removeEntry(name);
    }
	else
	   throw new AccessDeniedE();
    }
    
    public String getPath(Directory workDir) throws EntryUnknownE { return workDir.getPath(); }
        
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
    public Directory changeWorkDir(String dname,Directory workDir) throws IsNotDirectoryE,EntryUnknownE{
		Entry e = workDir.getEntry(dname);
		if (dname==".")
			return workDir;
		else if (e instanceof Directory)
			return (Directory)e;
		else
			throw new IsNotDirectoryE();
	}
    
   public void createFile(String fname,String permission, Directory workDir, User loggedIn) throws IOException, AccessDeniedE, EntryExistsE{
	if (workDir.getPermission() == "w" || workDir.getOwnerName()== loggedIn.getUsername() || loggedIn.getUsername()=="root"){
		File f= new File(fname, permission, loggedIn.getUsername(), workDir.getName() );
		workDir.putEntry(f);
       }
	else
		throw new  AccessDeniedE();
	
   }
   public void createDir(String dname,String permission, Directory workDir, User loggedIn) throws AccessDeniedE,EntryExistsE{
	if (workDir.getPermission() == "w" || workDir.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername() == "root"){
		Directory d= new Directory(dname,permission, loggedIn.getUsername() );
		workDir.putEntry(d);
		d.putEntry(workDir);
	}
	else
		throw new AccessDeniedE();
   }
   
   public void writeFile(String fname, String text,Directory workDir, User loggedIn) throws IOException, FileNotFoundException, EntryUnknownE,IsNotFileE,AccessDeniedE{
       
       Entry e = workDir.getEntry(fname);
       
       if (e  instanceof File){
           if (workDir.getPermission() == "w" || workDir.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername() == "root")
               ((File) e).writeFile(text);
           else
               throw new AccessDeniedE();
   			
       }
       else
           throw new IsNotFileE();
   }
   
   public List<String> seeFile(String fname,Directory workDir) throws IOException, EntryUnknownE,IsNotFileE{
	Entry e = workDir.getEntry(fname);
	if (e  instanceof File)
		return ((File) e).seeFile();
	else
		throw new IsNotFileE();
   }
	
   public void changePermission(String ename, String perm, Directory workDir, User loggedIn) throws EntryUnknownE, AccessDeniedE{
	Entry e= workDir.getEntry(ename);
	if (e.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername()=="root")
		e.setPermission(perm);
	else
		throw new AccessDeniedE();
   }	
   
   public void changeOwner(String ename, String username, Directory workDir, User loggedIn) throws EntryUnknownE, AccessDeniedE,UserUnknownE{
       
	Entry e = workDir.getEntry(ename);
    User newOwner = getUser(username); // throws exception if doesnt exist
       
    if (e.getOwnerName() == loggedIn.getUsername() || loggedIn.getUsername()=="root")
        e.setOwnerName(username);
    else
        throw new AccessDeniedE();
   }
    
    
    
    // MAIN TO TEST THINGS - REMOVE AFTER USAGE
    public static void main(String[] args) throws IllegalRemovalE, EntryExistsE, EntryUnknownE, Exception{
        
        FileSystem f1 = new FileSystem();
        f1.printUsers();
        f1.printEntries(f1.getDirectory());
        
        f1.createUser("lidiamcfreitas", "Lidia Freitas");
        f1.printUsers();
        
        f1.printEntries((Directory) f1.getHome().getEntry("root"));
        System.out.println("______");
        f1.printEntries(f1.getDirectory());
        
        System.out.println("____________________");
        f1.createFile("ficheiro","-", (Directory) f1.getHome().getEntry("lidiamcfreitas"), f1.getUser("lidiamcfreitas"));
        f1.createFile("jficheiro","-", (Directory) f1.getHome().getEntry("lidiamcfreitas"), f1.getUser("lidiamcfreitas"));
        f1.printEntries((Directory) f1.getHome().getEntry("lidiamcfreitas"));
        f1.writeFile("ficheiro", " a lidia e fixe",(Directory) f1.getHome().getEntry("lidiamcfreitas"), f1.getUser("lidiamcfreitas"));
    }
    
    public void printUsers() throws Exception{
        for (String u : listUsers()){
            System.out.println(u);}
    }
    
    public void printEntries(Directory dir) throws Exception{
        for (String u : dir.listEntry()){
            System.out.println(u);}
    }
    
    public Directory getDirectory() { return _FSDir; }
    
    public Directory getHome() { return _home; }

}
