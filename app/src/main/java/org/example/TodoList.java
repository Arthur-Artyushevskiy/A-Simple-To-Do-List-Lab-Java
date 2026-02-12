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

 void add(String task){
     if(task.isEmpty() || task == null){
         System.out.println("Your task is empty! No task is added to the list.");
         return;
     }
     list.put(task, false);
 }

 void complete(String task){
     if(isInsideList(task)){
         list.replace(task, true);
     }
     else{
         System.out.println("The task " + task + " does not exist, therefore can not make it complete!");
         
     }
 }

 boolean isInsideList(String task){
     for(Map.Entry<String, Boolean> entry : list.entrySet()){
         String key = entry.getKey();
         if(task.equals(key)) return true;
     }
 return false;
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
