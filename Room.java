//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Room 
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

/**
 * This particular class is a container for room related information
 */
public class Room {
	
  private String location;
  
  private int capacity;
  
/**
  * This constructor initializes the data fields to the values of the arguments. 
  * If the provided integer is negative (<0) then IllegalArgumentException is thrown 
  * This is thrown with a an error message which is "Capacity to reduce is more than the 
  * actual capacity"
  * 
  */
  
  public Room(String location, int capacity){
	  
    this.location = location;
    
    this.capacity = capacity;
    
  }
  
  
/**
  * The method getLocation() returns the location of the room 
  */
  
  public String getLocation() {
	  
    return this.location;
    
  }
  
/**
  * The method getCapacity() returns the capacity of the room 
  */
  
  public int getCapacity() {
	  
    return this.capacity;
    
  }
  
  
/**
  * The method reduceCapacity returns a NEW room object with the same location as this one but 
  * with a capacity less than this one's by the argument's amount. 
  * If the argument is greater than the given Room's capacity then an IllegalArgumentException is thrown 
  * with the message " The Capacity to reduce is more than the actual capacity"
  * 
  */
  
  
  public Room reduceCapacity(int capacity) {
	  
    if(capacity > this.capacity) {
    	
      throw new IllegalArgumentException("The capacity to reduce is more than the actual capacity");
      
    }
    
    return new Room(this.location, this.capacity - capacity);
    
  }
  
}