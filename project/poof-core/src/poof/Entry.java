import java.io.Serializable;

public abstract class Entry implements Comparable<Entry>, Serializable{
	private String _name;
	private String _permission;
	private String _ownerName;
   
	
	public Entry (String name, String permission, String ownerName){
		_name=name;
		_permission=permission;
		_ownerName=ownerName;
	}
    
	public String getName() { return _name; }
	
    public String getPermission() { return _permission; }
    
	public String getOwnerName() { return _ownerName; }

    
    
	public void setName(String name) { _name=name; }
    
	public void setPermission(String permission) { _permission=permission; }
    
	public void setOwnerName(String ownerName) { _ownerName=ownerName; }

    public abstract int getSize();


    public int compareTo(Entry e){ // needed to list the entries
        return getName().compareTo(e.getName());
    }
    

}
