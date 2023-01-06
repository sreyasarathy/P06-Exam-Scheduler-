//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Course 
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
 * This particular class is a container for course related information
 */

public class Course {
	
  private String name;
  
  private int numStudents;
  
  
/**
 * The constructor initializes the data fields to the values of the arguments. 
 * If the provided integer is negative (<0), an IllegalArgumentException is thrown with a message
 */
  
  public Course(String name, int numStudents){
	  
    this.name = name;
    
    this.numStudents = numStudents;
    
  }
  
/**
 * This particular method getName returns the name of this course
 */
 
  public String getName() {
	  
    return this.name;
    
  }
  
/**
  * This particular method getNumStudents returns the number of students enrolled in this course
  */
  
  public int getNumStudents() {
	  
    return this.numStudents;
    
  }
  
}