import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;

public class FileSystem implements Serializable{
    
    private Map<String, User> _users = new TreeMap<String, User>();
    private Directory _FSDir;
    
    public FileSystem() throws EntryExistsException {
        
        Directory _FSDir = new Directory("home", "-", "root");
        _FSDir.putFather(_FSDir);
        Directory _rootDir = new Directory("root", "-", "root");
        _rootDir.putFather(_FSDir);
        _FSDir.putEntry(_rootDir);
        
        User _root = new User("root", "Super User", _rootDir);
        _users.put(_root.getUsername(), _root);
        
    }
    
    public void createUser(String username,String name) throws UserExistsException, EntryExistsException{
       
        if (_users.get(username) != null)
            throw new UserExistsException(); // entry already exists
        
        else {
            Directory dir=new Directory(username,"-",username);
            dir.putFather(_FSDir);
            _FSDir.putEntry(dir);
            
            User u= new User(username,name,dir);
            _users.put(u.getUsername(), u);
        }
    }
    
    public List<String> listUsers() throws EntryUnknownException {
        
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
    
    public List<String> listEntry (String ename, Directory workDir) throws EntryUnknownException{
            return ( (Directory) workDir.getEntry(ename) ).listEntry();
    }
    
    
    
    
    public void removeEntry(String name, Directory workDir, User loggedIn) throws EntryUnknownException, IllegalRemovalException {
        
        Entry e = workDir.getEntry(name);
        String ownerName = loggedIn.getName();
        
        if (canRemoveEntry(e, ownerName)){
            workDir.removeEntry(name);
        }
    }
    
    public String getPath(Directory workDir) throws EntryUnknownException {
        return workDir.getPath();
    }
        
    public boolean canRemoveEntry(Entry e, String ownerName){
        
        boolean res=true;
        if ( e instanceof File){
            if (e.getPermission() == "w" || e.getOwnerName() == ownerName)
                return true;
            return false;
        } else {
            
            if (e.getPermission() == "w" || e.getOwnerName() == ownerName) {
                
                for( Entry subEntry : ( (Directory) e ).getEntries())
                    res= res && canRemoveEntry(subEntry, ownerName);
                return res;
            }
            return false;
        }

                
        }
    
    
}