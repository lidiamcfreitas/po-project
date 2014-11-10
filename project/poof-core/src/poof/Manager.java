import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.List;

import java.io.Serializable;

public class Manager implements Serializable {

    private FileSystem _activeFS;
    
    private User _loggedIn;
    
    private Directory _workDir;
    
    private String _whereToSave = "";
    
    private boolean _change = false;
    
    public Manager() {}
    
    public void create() throws EntryExistsException, UserUnknownException{
        _activeFS = new FileSystem();
        _loggedIn = _activeFS.getUser("root");
        _change = true;
        _whereToSave = "";
        _workDir = _loggedIn.getDirectory();
    }
    
    public void open(String fname) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ObjectInputStream ois = new ObjectInputStream( new BufferedInputStream( new FileInputStream(fname)));
        
        _activeFS = (FileSystem) ois.readObject();
        _loggedIn = (User) ois.readObject();
        
        _whereToSave = fname;
        
        ois.close();
        
    }
    
    public void openFromTextData(String fname) throws FileNotFoundException, IOException, ClassNotFoundException, UserExistsException, EntryExistsException, UserUnknownException, AccessDeniedException, IsNotDirectoryException, EntryUnknownException, IsNotFileException{
        
        BufferedReader in = new BufferedReader( new FileReader(fname));
        String s;
        
        Directory _upDir;
        String[] _vector1;
        String[] _vector2;
        
        while ( (s=in.readLine() )!=null ){
            
           _vector1 = s.split("\\|");
            
            switch (_vector1[0]){
                    
                    case "USER":
                        createUser(_vector1[1], _vector1[2]);
                        break;
                    
                    case "DIRECTORY":
                        _workDir = _activeFS.getDirectory();
                        login(_vector1[2]);
                        _vector2 = _vector1[1].split("/");
                    
                        for (int i=0;i<_vector2.length - 1;i++){
                            try{
                                createDir(_vector2[i], "-");
                            
                            } catch (EntryExistsException e){}
                        
                            changeWorkDir(_vector2[i]);
                        }
                        try {
                            if (_vector1[3]=="private")
                                createDir(_vector2[_vector2.length - 1], "-");
                            else
                                createDir(_vector2[_vector2.length - 1], "w");
                        
                        
                        } catch (EntryExistsException e) {}
                    
                    
                    break;
                    
                    case "FILE":
                        _workDir = _activeFS.getDirectory();
                        login(_vector1[2]);
                        _vector2 = _vector1[1].split("/");
                    
                        for (int i=0;i<_vector2.length - 1;i++){
                            try{
                                createDir(_vector2[i], "-");
                            
                            } catch (EntryExistsException e){}
                        
                            changeWorkDir(_vector2[i]);
                        }
                        try {
                            if (_vector1[3]=="private")
                                createFile(_vector2[_vector2.length - 1], "-");
                            else
                                createFile(_vector2[_vector2.length - 1], "w");
                            
                            writeFile(_vector2[_vector2.length - 1], _vector1[4]);
                        
                        } catch (EntryExistsException e) {}
                    
                    break;
            }
        }
        
        in.close();
        
    }
    
    public String getWhereToSave(){
        return _whereToSave;
    }
    
    public void setWhereToSave(String s){
         _whereToSave=s;
    }
    
    public void save(String fname) throws FileNotFoundException, IOException{
        
        ObjectOutputStream oos = new ObjectOutputStream ( new BufferedOutputStream(new FileOutputStream(fname)));
        oos.writeObject(_activeFS);
        oos.writeObject(_loggedIn);
        
        oos.close();
        
        _change = false;
        
    }
    
    
    public void login(String username)  throws UserUnknownException{
        _loggedIn = _activeFS.getUser(username);
        _change = true;
    }
    
    public void createUser(String username, String name) throws UserExistsException, EntryExistsException{
        _activeFS.createUser(username, name);
        _change = true;
    }
    
    public List<String> listUsers() throws EntryUnknownException,FileNotFoundException {
    
        return _activeFS.listUsers();
    }
    
    public List<String> listEntries(){
        return _activeFS.listEntries(_workDir);
    }
    
     public List<String> listEntry (String ename) throws IsNotDirectoryException, EntryUnknownException{
         return _activeFS.listEntry(ename, _workDir);
     }
    
    public void removeEntry(String name) throws EntryUnknownException, IllegalRemovalException, AccessDeniedException {
        
        _activeFS.removeEntry(name, _workDir, _loggedIn);
        _change = true;
        
    }
    
    public void changeWorkDir(String dname) throws IsNotDirectoryException,EntryUnknownException{
        
        _workDir =  _activeFS.changeWorkDir(dname, _workDir);
    }
    
    public void createFile(String fname,String permission) throws IOException, AccessDeniedException, EntryExistsException{
     
        _activeFS.createFile(fname, permission, _workDir, _loggedIn);
        _change = true;
    }
    
    public void createDir(String dname,String permission) throws AccessDeniedException,EntryExistsException{

        _activeFS.createDir(dname, permission, _workDir, _loggedIn);
        _change = true;
    }
    
    public String getPath() throws EntryUnknownException { return _activeFS.getPath(_workDir); }
    
    public void writeFile(String fname, String text) throws IOException, FileNotFoundException, EntryUnknownException,IsNotFileException,AccessDeniedException{
        _activeFS.writeFile(fname, text, _workDir, _loggedIn);
        _change = true;
    }
    
    public List<String> seeFile(String fname) throws IOException, EntryUnknownException,IsNotFileException{
        return _activeFS.seeFile(fname, _workDir);
    }
    
    public void changePermission(String ename, String perm) throws EntryUnknownException, AccessDeniedException{
        _activeFS.changePermission(ename, perm, _workDir, _loggedIn);
        _change = true;
    }
    
    public void changeOwner(String ename, String username) throws EntryUnknownException, AccessDeniedException,UserUnknownException{
        _activeFS.changeOwner(ename, username, _workDir, _loggedIn);
        _change = true;
    }
    
    public boolean changedFile() { return _change; }

}