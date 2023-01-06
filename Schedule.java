//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Schedule 
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


import java.util.Arrays;

/**
 * This particular class is an object to maintain the current draft schedule
 */

public class Schedule {
	
  private Room[] rooms;
  
  private Course[] courses;
  
  private int[] assignments;
  

/**
 * This constructor initializes the rooms and courses arrays to the provided 
 * values and creates an assignments array of the correct length 
 * where all values are -1, indicating that the corresponding course 
 * has not yet been assigned a room 
 */ 
  
  public Schedule(Room[] rooms, Course[] courses) {
	  
    this.rooms = rooms;
    
    this.courses = courses;
    
    this.assignments = new int[courses.length];
    
    for (int a = 0; a < assignments.length; a++) {
    	
      this.assignments[a] = -1;
      
    }
    
  }
  
/**
  * This constructor is a private constructor.
  * It initializes the rooms and courses arrays to the 
  * provided values and assignments to the provided assignments array. 
  */ 
  
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
	  
    this.rooms = rooms;
    
    this.courses = courses;
    
    this.assignments = assignments;
    
  }
 
/**
  * The method getNumRooms() returns the number of rooms available 
  * in this schedule
  */ 
  
  public int getNumRooms() {
	  
    return this.rooms.length;
    
  }
  
/**
 * The method getRoom returns the room object at the given index in the rooms array 
 * It throws an IndexOutOfBoundsException with a descriptive error message 
 * if the given index is invalid 
 */ 

  public Room getRoom(int index) {
	  
    try {
    	
      return this.rooms[index];
      
    } catch (IndexOutOfBoundsException e) {
    	
      throw new IndexOutOfBoundsException("This particular index does not exist");
      
    }
    
  }
  
/**
 * The method getNumCourses returns the number of courses in this schedule
 */ 
  
  public int getNumCourses() {
	  
    return this.courses.length;
    
  }
/**
 * The method getCourse returns the course object at the given index in the courses array. 
 * It throws an IndexOutofBoundsException with a descriptive error message if the given index
 * is invalid 
 */
  
  public Course getCourse(int index) {
	  
    try {
    	
      return this.courses[index];
      
    } catch (IndexOutOfBoundsException e) {
    	
      throw new IndexOutOfBoundsException("This particular index does not exist");
      
    }
    
  }
  
/**
 * The method isAssigned() returns true if and only if the course at the given index has been assigned a room
 * Otherwise it returns, false
 */
  
  public boolean isAssigned(int index) {
	  
    return this.assignments[index] != -1;
    
  }
  
/**
 * The method getAssignment() returns the room object assigned to the course at the given index.
 * It throws an IllegalArgumentException if the course has not been assigned to a room or an 
 * IndexOutOfBoundsException with an error message if the given course index is invalid 
 */  
  
  
  public Room getAssignment(int index) {
	  
    try {
    	
      if (this.assignments[index] == -1) {
    	  
        throw new IllegalArgumentException("This course has not been assigned to a room");
        
      }
      
      return this.rooms[this.assignments[index]];
      
    } catch (IndexOutOfBoundsException e) {
    	
      throw new IndexOutOfBoundsException("This particular index does not exist");
      
    }
    
  }
  
/**
 * The method isComplete() returns true if and only if all courses have been assigned to rooms; false
 * otherwise
 */
  
  public boolean isComplete() {
	  
    for (int a = 0; a < assignments.length; a++) {
    	
      if (this.assignments[a] == -1) {
    	  
        return false;
        
      }
      
    }
    
    return true;
    
  }
  
/**
 * assignCourse() returns a NEW schedule object with the course at the first argument index 
 * assigned to the room at the second argument index. An IndexOutOfBoundsException with 
 * a descriptive error message if the given course or room index is invalid, 
 * or an IllegalArgumentException with a descriptive error message if the given course 
 * has already been assigned a room, or if the room does not have sufficient capacity 
 *
 */  

  public Schedule assignCourse(int index1, int index2) {
	  
    try {
    	
      if (isAssigned(index1)
    		  
          || this.rooms[index2].getCapacity() < this.courses[index1].getNumStudents()) {
    	  
        throw new IllegalArgumentException(
        		
            "This course has been assigned to a room or doesnt have sufficient capacity");
        
      }
      
      Room[] newRooms = Arrays.copyOf(this.rooms, rooms.length);
      
      Course[] newCourses = Arrays.copyOf(this.courses, courses.length);
      
      int[] newAssignments = Arrays.copyOf(this.assignments, assignments.length);
      
      newAssignments[index1] = index2;
      
      newRooms[index2] = newRooms[index2].reduceCapacity(courses[index1].getNumStudents());
      
      return new Schedule(newRooms, newCourses, newAssignments);
      
    } catch (IndexOutOfBoundsException e) {
    	
      throw new IndexOutOfBoundsException("This particular index does not exist");
      
    }
    
  }

  
  public String toString() {
	  
    String stringRepresentation = "{";
    
    for (int a = 0; a < courses.length; a++) {
    	
      if (assignments[a] == -1) {
    	  
        stringRepresentation +=
        		
            this.courses[a].getName() + ": Unassigned, ";
        
      }else {
    	  
        stringRepresentation +=
        		
            this.courses[a].getName() + ": " + this.rooms[assignments[a]].getLocation() + ", ";
        
      }
      
    }
    
    stringRepresentation =
    		
        stringRepresentation.substring(0, stringRepresentation.lastIndexOf(", "));
    
    return stringRepresentation + "}";
    
  }

}