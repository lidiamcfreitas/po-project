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
    
    public Entry getEntry(String name) throws EntryUnknownException{
        
        if (_entries.get(name) == null)
            throw new EntryUnknownException(); // entry doesnt exist
        else
            return _entries.get(name);
        
    }
    
    public void putEntry(Entry e) throws EntryExistsException{
        
        if (_entries.get(e.getName()) != null)
            throw new EntryExistsException(); // entry already exists
        
        else {
            _entries.put(e.getName(), e);
        }
    }
    
    public void removeEntry(String name) throws EntryUnknownException, IllegalRemovalException {
        
        if (_entries.get(name) == null)
            throw new EntryUnknownException(); // entry doesnt exist

        else if ( name == "." || name == ".." )
            throw new IllegalRemovalException();  // cant delete itself or father directory
        
        else {
           _entries.remove(_entries.get(name));
        }
        
    }
    
    public int getSize() {
        int size = 0;
        for (Map.Entry<String,Entry> entry : _entries.entrySet()) {
            size +=  8 + entry.getValue().getSize();
        }
        return size;
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
            
            System.out.println(e.getPermission() + " " + e.getOwnerName() + " " + e.getSize() + " " + e.getName());
        }
    }
    
}
