package com.backend;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
public class User{
    public static List<Signup> users = new CopyOnWriteArrayList<>();
    public static ConcurrentHashMap<String,Node> map = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String,String> loggedinusers = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer,String> idstousernames = new ConcurrentHashMap<>();
    public static int count = 0;
    public static String loginusername = null; 
    public static synchronized boolean registeruser(String username,String password){
        for (int i=0;i<users.size();i++){
            Signup usr = users.get(i);
            if (usr.getusername().equals(username)){
                 return false;
            }
         }
        users.add(new Signup(username,password));
        return true;
    }
    public static synchronized boolean login(String username,String password,String sessionId){
        for (int i=0;i<users.size();i++){
            Signup usr = users.get(i);
            if (usr.getusername().equals(username)){
                if (usr.getpassword().equals(password)){
                    loggedinusers.put(sessionId,username);
                    return true;
                } 
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public static synchronized String Getloggedinusername(String sessionId){
        return loggedinusers.get(sessionId); 
    }
    public static synchronized void updateprofile(String name,String bio,String profilepath,String usrname){
    if (usrname!=null){
        if (map.get(usrname)!=null){
            map.get(usrname).updatename(name);
            map.get(usrname).updatebio(bio);
            map.get(usrname).updateprofilepic(profilepath);
        } 
        else{
            Node value1 = new Node(count,name,bio,profilepath);
            idstousernames.put(count,usrname);
            count=count+1;
            map.put(usrname,value1);
        }
      }
    }
    public static synchronized void addposts(String pathpost,String usrname){
            if (usrname!=null){
                if (map.get(usrname)!=null){
                    map.get(usrname).updatepost(pathpost);
                    map.put(usrname,map.get(usrname));
                }
            }
       }

    public static String Displayname(String usrname){
        if(usrname!=null){
            if(map.get(usrname)!=null){
                return map.get(usrname).displayname();
            }
        }
        return null;
    }
    public static String Displaybio(String usrname){
        if(usrname!=null){
            if(map.get(usrname)!=null){
                return map.get(usrname).displaybio();
            }
        }
        return null;
    }
    public static String Displayprofilepic(String usrname){
        if(usrname!=null){
            if(map.get(usrname)!=null){
                return map.get(usrname).displayprofilepic();
            }
        }
        return null;
    }
    public static List<String> Displayposts(String usrname){
        if(usrname!=null){
            if(map.get(usrname)!=null){
                return map.get(usrname).displayposts();
            }
        }
        return null;
    }
}

