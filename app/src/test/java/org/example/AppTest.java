package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
    void testAddTask(){
      var list = new TodoList();
      list.add("Buy groceries");
      ArrayList<String> all = list.all();
      assertEquals(1, all.size());
      assertTrue(all.contains("Buy groceries"));
  }

  @Test
    void testIncompleteFilter(){
      var list = new TodoList();
      list.add("Task 1");
      list.add("Task 2");
      list.complete("Task 1");

      ArrayList<String> incomplete = list.incomplete();

      assertEquals(1, incomplete.size());
      assertTrue(incomplete.contains("Task 2"));
      assertFalse(incomplete.contains("Task 1"));
  }

  @Test
    void completeFilter(){
      var list = new TodoList();
      list.add("Workout");
      list.complete("Workout");

      ArrayList<String> completed = list.complete();
      assertEquals(1, completed.size());
      assertTrue(completed.contains("Workout"));
  }

  @Test
    void testClearList(){
      var list = new TodoList();
      list.add("Workout");
      list.complete("Workout");
      list.clear();
      ArrayList<String> all = list.all();
      assertEquals(0, all.size());
  }

  @Test
    void testCompleteNonExistingTask(){
      var list = new TodoList();
      list.complete("Ghost Task");
  }

  @Test
  void testNonExistingTaskToSetComplete(){
    var list = new TodoList();
    list.complete("some non existing task");
  }

  @Test
  void testIsInsideList(){
    var list = new TodoList();
    list.add("Actual Task");
    boolean isInside = list.isInsideList("Actual Task");
    assertEquals(true, isInside);
    isInside = list.isInsideList("Ghost Task");
    assertEquals(false, isInside);
  }

  @Test
  void testEmptyAndNullTasks(){
    var list = new TodoList();
    list.add("");
    list.add(null);
    ArrayList<String> all = list.all();
    assertEquals(0, all.size());
  }
}
