public class Entry implements Comparable<Entry>{
	private String _name;
	private String _permission;
	private String _ownerName;
    private int _size;
	
	public Entry (String name, String permission, String ownerName, int size){
		_name=name;
		_permission=permission;
		_ownerName=ownerName;
        _size = size;
	}
	public String getName(){
		return _name;
	}
	public String getPermission(){
		return _permission;
	}
	public String getOwnerName(){
		return _ownerName;
	}
    public int getSize(){
		return _size;
	}
    
	public void setName(String name){
		_name=name;
	}
	public void setPermission(String permission){
		_permission=permission;
	}
	public void setOwnerName(String ownerName){
		_ownerName=ownerName;
	}
    
    public void setPermission(int size){
		_size=size;
	}

    public int compareTo(Entry e){
        return getName().compareTo(e.getName());
    }
}
