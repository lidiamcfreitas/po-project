
public class User{

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
    
    public static void main(String[] args){
        
        Directory d = new Directory("directorio 1", "w", "Jose", 0);
        User s = new User(d.getOwnerName(), "Jose Silva", d);
        
        File f = new File("ficheiro 1", "w", "Jose", 0, d.getName());
        d.putEntry(f);
        d.listEntry();
    }
    
}