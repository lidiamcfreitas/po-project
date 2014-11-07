public class Entry{
	private String _name;
	private String _permission;
	private User _owner;
    private int _size;
	
	public Entry (String name, String permission, User owner){
		_name=name;
		_permission=permission;
		_owner=owner;
	}
	public String getName(){
		return _name;
	}
	public String getPermission(){
		return _permission;
	}
	public User getOwner(){
		return _owner;
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
	public void setOwner(User owner){
		_owner=owner;
	}
    
    public void setPermission(int size){
		_size=size;
	}

}
