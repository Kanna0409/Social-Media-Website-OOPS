package com.backend;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public class Node{
    public String name;
    public String bio;
    public String profilePath;
    public final CopyOnWriteArrayList<String> posts; 
    public final CopyOnWriteArrayList<String> friends; 
    public final int id;
    Node(int id, String name, String bio, String profilePath){
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.profilePath = profilePath;
        this.posts = new CopyOnWriteArrayList<>();  
        this.friends = new CopyOnWriteArrayList<>(); 
    }
    public int getId() {
        return this.id; 
    }
    public String displayname(){
        return this.name;
    }
    public void updatename(String name){
        this.name = name;
    }
    public String displaybio(){
        return this.bio;
    }
    public void updatebio(String bio){
        this.bio = bio;
    }
    public String displayprofilepic(){
        return this.profilePath;
    }
    public void updateprofilepic(String profilePath){
        this.profilePath = profilePath;
    }
    public List<String> displayposts(){
        return this.posts; 
    }
    public void updatepost(String pathPost){
        this.posts.add(pathPost);
    }
    public List<String> displayfriends(){
        return new ArrayList<>(this.friends); 
    }
    public void addfriend(String userName){
        this.friends.add(userName);
    }
    public List<String> getfriends() {
        return friends;
    }
}

