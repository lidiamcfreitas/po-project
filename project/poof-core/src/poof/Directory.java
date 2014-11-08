import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Collections;
import java.util.ArrayList;
import java.io.Serializable;

public class Directory extends Entry implements Serializable{
    
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
    
    public List<Entry> getEntries(){
        List<Entry> list = new LinkedList<Entry>();
        list.addAll(_entries.values());
        Collections.sort(list);
        
        return list;
    }
    
    public void putEntry(Entry e) throws EntryExistsException{
        
        if (_entries.get(e.getName()) != null)
            throw new EntryExistsException(); // entry already exists
        
        else {
            _entries.put(e.getName(), e);
        }
    }
    
    public void putFather(Entry e) throws EntryExistsException{
        
        if (_entries.get(e.getName()) != null)
            throw new EntryExistsException(); // entry already exists
        
        else {
            _entries.put("..", e);
        }
    }
    
    public Directory getFather() throws EntryUnknownException { return (Directory) getEntry(".."); }
    
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
        int size = 16;
        for (Map.Entry<String,Entry> entry : _entries.entrySet()) {
            if (entry.getValue().getName() != "..")
                size +=  8 + entry.getValue().getSize();
        }
        return size;
    }
    
    public List<String> listEntry(){

        List<Entry> list = getEntries();
        
        List<String> res = new ArrayList<String>();
        String s;
        
        s = "d " + getPermission() + " " + getOwnerName() + " " + getSize() + " .";
        
        res.add(s);
        
        for( Entry e : list){
            
            if(e instanceof Directory)
                s="d " + e.getPermission() + " " + e.getOwnerName() + " " + e.getSize() + " " + e.getName();
            else
                s = "- " + e.getPermission() + " " + e.getOwnerName() + " " + e.getSize() + " " + e.getName();
            
            res.add(s);
            
        }
        return res;
    }
    
    public String getPath() throws EntryUnknownException{
        if (this==getFather()){
            return "/" + getName();
        } else {
            return getFather().getPath() + "/" + getName();
        }
        
    }
    

    
}
