import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Collections;


public class Directory extends Entry{
    
    private Map<String, Entry> _entries = new TreeMap<String, Entry>();
    
    
    public Directory(String name, String permission, String ownerName){
        super(name, permission, ownerName);
    }
    
    public Entry getEntry(String name) throws EntryUnkownException{
        
        if (_entries.get(name) == null)
            throw EntryUnkownException; // entry doesnt exist
        
        else
            return _entries.get(name);
        
    }
    
    public void putEntry(Entry e) throws EntryExistsException{
        
        if (_entries.get(name) != null)
            throw EntryExistsException; // entry already exists
        
        else {
            _entries.put(e.getName(), e);
            // setSize(_entries.size()*8); // update size
        }
    }
    
    public void removeEntry(String name) throws EntryUnkownException, IllegalRemovalException {
        
        if (_entries.get(name) == null)
            throw EntryUnkownException; // entry doesnt exist
        
        else if ( name == "." || name == ".." )
            throw IllegalRemovalException;  // cant delete itself or father directory
        
        else {
            _entries.remove(_entries.get(name));
            // setSize(_entries.size()*8); // update size
        }
        
    }
    
    public void listEntry(){

        List<Entry> list = new LinkedList<Entry>();
        list.addAll(_entries.values());
        Collections.sort(list);
        
        for( Entry e : list){
            
            if(e instanceof Directory)
                System.out.printf("d ");
            
            else
                System.out.printf("- ");
            
            System.out.println(e.getPermission() + " " + e.getName() + " " + e.getSize() + " " + e.getName());
        }
    }
    
}