package org.example;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.LinkedHashMap;

public class TodoList {
 private LinkedHashMap<String, Boolean> list;

 TodoList(){
   list = new LinkedHashMap<>();
 }

 void add(String name){
     if(name.isEmpty() || name == null){
         System.out.println("Your task is empty! No task is added to the list.");
         return;
     }
     list.put(name, false);
 }

 void complete(String name){
     if(!list.isEmpty()){
         list.replace(name, true);
     }
     else{
         System.out.println("Error: Your List is Empty. Can't set a non-existing task as complete!");
     }
 }

 ArrayList<String> all(){
     System.out.println("List of Tasks:");
     ArrayList<String> allList = new ArrayList<>();
     for(Map.Entry<String, Boolean> entry : list.entrySet()){
        String key = entry.getKey();
        allList.add(key);
        System.out.println(key);

     }
  return allList;
 }

ArrayList<String> complete(){
    System.out.println("List of Completed Tasks:");
    ArrayList<String> completeList = new ArrayList<>();

    if(list.size() == 0){
        System.out.println("Your list is empty! Nothing is printed out.");
        return completeList;
    }

    for(Map.Entry<String, Boolean> entry : list.entrySet()){
        String key = entry.getKey();
        Boolean isComplete = entry.getValue();

        if(isComplete){
            completeList.add(key);
            System.out.println(key);
        }
    }
    return completeList;
}

 ArrayList<String> incomplete(){
     System.out.println("List of Incompleted Tasks:");
     ArrayList<String> incompleteList = new ArrayList<>();
     for(Map.Entry<String, Boolean> entry : list.entrySet()){
         String key = entry.getKey();
         Boolean isComplete = entry.getValue();

         if(!isComplete){
             incompleteList.add(key);
             System.out.println(key);
         }
     }
    return incompleteList;
 }

 void clear(){
     list.clear();
 }



}
