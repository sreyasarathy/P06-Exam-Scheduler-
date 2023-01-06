//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Exam Scheduler Tester 
// Course: CS 300 Spring 2022
//
// Author: Sreya Sarathy 
// Email: sarathy2@wisc.edu
// Lecturer: Professor Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * The class tests the implementation of the course class, 
 * ExamScheduler, ExamSchedulerTester, 
 * Room and Schedule classes 
 */

public class ExamSchedulerTester {

  /**
   * The implementation of the course class 
   * and its methods are checked 
   *
   * @return false if tests fail, true if tests pass
   */
	
  public static boolean testCourse() {

    Course c1 = new Course("Math", 20);
    
    c1.toString();
    
    System.out.println("Course's first test passed");

    try {
    	
      Course c2 = new Course(null, 10);
      
      //  test case did not pass so an exception should have been thrown
      
      return false;
      
    } catch (NullPointerException e) {
    	
      System.out.println("Course's second test passed");
      
    }


    try {
    	
      Course c3 = new Course("English", -1);
      
      //  test case did not pass so an exception should have been thrown 
      
      return false;
      
    } catch (IllegalArgumentException e) {
    	
      System.out.println("Course's third test passed");
      
    }

    if (c1.getName().equals("Math")) {
    	
      System.out.println("Course's fourth test passed");
      
    } else {
    	
      return false;
      
    }

    if (c1.getNumStudents() == 20) {
    	
      System.out.println("Course's fifth test passed");
      
    } else {
    	
      return false;
      
    }

    return true;
  }

  /**
   * Checks the implementation of the Room class and its methods
   *
   * @return false if tests fail, true if tests pass
   */
  
  public static boolean testRoom() {
	  
    Room r1 = new Room("B1228", 20);
    

    if (!(r1.getLocation().equals("B1228"))) {
    	
      System.out.println("Room's first test failed");
      
      return false;
      
    }

    if (!(r1.getCapacity() == 20)) {
    	
      System.out.println("Room's second test failed");
      
      return false;
      
    }

    System.out.println("R1 Original Capacity: " + r1.getCapacity());
    
    r1 = r1.reduceCapacity(10);
    
    System.out.println("R1 AFTER reduceCapacity() by 10: " + r1.getCapacity());
    

    try {
    	
      r1.reduceCapacity(100);
      
      // shows that test case did not pass so an exception should have been thrown  
      
      return false;
      
    } catch (IllegalArgumentException e) {
    	
      System.out.println("Room's third test passed");
      
    }
    
    return true;
    
  }

  /**
   * Checks whether implementation of the Schedule class accessor methods 
   * work or not 
   *
   * @return
   */
  
  public static boolean testScheduleAccessors() {
	  
    Room e1 = new Room("A", 10);
    
    Room e2 = new Room("B", 30);
    
    Room e3 = new Room("C", 50);
    
    Room e4 = new Room("D", 70);

    Room[] roomsTest = {e1, e2, e3, e4};

    Course z1 = new Course("HISTORY", 10);
    
    Course z2 = new Course("FRENCH", 30);
    
    Course z3 = new Course("ENGLISH", 25);
    
    Course z4 = new Course("SPANISH", 50);

    Course[] coursesTest = {z1, z2, z3, z4};


    Schedule sTest1 = new Schedule(roomsTest, coursesTest);

    if (!sTest1.isComplete()) {
    	
      System.out.println("Schedule's 8th test passed");
      
    } else {
    	
      return false;
      
    }

    return true;
  }

  /**
   * Checks if the implementation of the assignCourse method works or not 
   *
   * @return true if testers pass, false otherwise
   */
  
  public static boolean testAssignCourse() {
	  
    Room r1 = new Room("A", 20);
    
    Room r2 = new Room("B", 30);
    
    Room r3 = new Room("C", 25);
    
    Room r4 = new Room("D", 50);

    Room[] roomsTest1 = {r1, r2, r3, r4};

    Course c1 = new Course("HISTORY", 20);
    
    Course c2 = new Course("FRENCH", 30);
    
    Course c3 = new Course("ENGLISH", 25);
    
    Course c4 = new Course("SPANISH", 50);

    Course[] coursesTest1 = {c1, c2, c3, c4};

    Schedule sTest = new Schedule(roomsTest1, coursesTest1);

    sTest = sTest.assignCourse(1, 3);

    try {
    	
      sTest = sTest.assignCourse(2, 1);
      
      return false;
      
    } catch (IllegalArgumentException e) {
    	
      System.out.println("The Schedule's 1st test passed!");
      
    }

    try {
    	
      sTest = sTest.assignCourse(2, 3);
      
      return false;
      
    } catch (IllegalArgumentException e) {
    	
      System.out.println("The Schedule's 2nd test passed!");
      
    }


    sTest = sTest.assignCourse(1, 2);


    System.out.println(sTest.toString());


    try {
    	
      sTest.assignCourse(-1, 0);
      
      return false;
      
    } catch (IndexOutOfBoundsException e) {
    	
      System.out.println("The Schedule's 3rd test passed!");
    }

    try {
    	
      sTest.assignCourse(50, 0);
      
      return false;
      
    } catch (IndexOutOfBoundsException e) {
    	
      System.out.println("The Schedule's 4th test passed!");
      
    }

    try {
    	
      sTest.assignCourse(1, -20);
      
      return false;
      
    } catch (IndexOutOfBoundsException e) {
    	
      System.out.println("The Schedule's 5th test passed!");
      
    }

    try {
    	
      sTest.assignCourse(10, 50);
      
      return false;
      
    } catch (IndexOutOfBoundsException e) {
    	
      System.out.println("The Schedule's 6th test passed!");
      
    }


    try {
    	
      sTest.assignCourse(20, 2);
      
      return false;
      
    } catch (IllegalArgumentException e) {
    	
      System.out.println("The Schedule's 7th test passed!");
      
    }

    return true;
    
  }
  
  public static void main(String[] args) {
	  
    if (testCourse() && testRoom() && testScheduleAccessors() && testAssignCourse()) {
    	
      System.out.println("Congratulations, All the tests have been passed!");
      
    } else {
    	
      if (!testCourse()) {
    	  
        System.out.println("TESTCOURSE() FAILED");
        
      } else {
    	  
        System.out.println("TESTCOURSE() PASSED");
        
      }

      if (!testRoom()) {
    	  
        System.out.println("TESTROOM() FAILED");
        
      } else {
    	  
        System.out.println("TESTROOM() PASSED");
        
      }

      if (!testScheduleAccessors()) {
    	  
        System.out.println("TESTSCHEDULEACCESSORS() FAILED");
        
      } else {
    	  
        System.out.println("TESTSCHEDULEACCESSORS() PASSED");
        
      }

      if (!testAssignCourse()) {
    	  
        System.out.println("TESTASSIGNCOURSE() FAILED");
        
      } else {
    	  
        System.out.println("TESTASSIGNCOURSE() PASSED");
        
      }
      
    }

  }

}