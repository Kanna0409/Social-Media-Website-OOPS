package com.backend;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
public class Search extends User{
    public static synchronized ConcurrentHashMap<String, Node> searchprofile(String name){
    ConcurrentHashMap<String,Node> matchedprofiles = new ConcurrentHashMap<>();
    List<String> k = new ArrayList<>(map.keySet());
    List<Node> values = new ArrayList<>(map.values());
    Node temp;
    for (int i=0;i<values.size();i++){
        temp = values.get(i);
        if (temp.displayname().equals(name)){
            matchedprofiles.put(k.get(i),temp);
        }
    }
    return matchedprofiles;
    }
}
