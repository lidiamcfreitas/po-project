package poof;

import java.io.Serializable;


public class User implements Comparable<User>, Serializable{
    private String _username;
    private String _name;
    private Directory _mainDir;
    
    public User(String username, String name, Directory mainDir){
        _username = username;
        _name=name;
        _mainDir=mainDir;
    }
    
    public String getUsername() { return _username; }
    
    public String getName() { return _name; }
    
    public Directory getDirectory() { return _mainDir; }
    
    public void setUsername(String username) { _username = username; }
    
    public void setName(String name) { _name = name; }
    
    public void setDirectory(Directory mainDir) { _mainDir = mainDir; }
    
    public int compareTo(User user){ // needed to list the entries
        return getUsername().compareTo(user.getUsername());
    }
    
}
